package com.example.assignmen_2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TaskInputFragment extends Fragment {

    private EditText taskNameEditText;
    private EditText taskDescriptionEditText;
    private Button saveButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("TaskInputFragment", "onCreate called");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("TaskInputFragment", "onCreateView called");

        View view = inflater.inflate(R.layout.fragment_task_input, container, false);

        taskNameEditText = view.findViewById(R.id.task_name);
        taskDescriptionEditText = view.findViewById(R.id.task_description);
        saveButton = view.findViewById(R.id.save_button);

        saveButton.setOnClickListener(v -> saveTask());

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("TaskInputFragment", "onStart called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("TaskInputFragment", "onResume called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("TaskInputFragment", "onPause called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("TaskInputFragment", "onStop called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("TaskInputFragment", "onDestroy called");
    }



    private void saveTask() {
        String taskName = taskNameEditText.getText().toString();
        String taskDescription = taskDescriptionEditText.getText().toString();

        if (!taskName.isEmpty() && !taskDescription.isEmpty()) {
            MainActivity mainActivity = (MainActivity) getActivity();
            if (mainActivity != null) {
                mainActivity.addTask(taskName, taskDescription);
                requireActivity().getSupportFragmentManager().popBackStack();
            }
        }
    }
}
