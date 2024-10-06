package com.example.assignmen_2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.util.Log;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private ActivityResultLauncher<Intent> activityResultLauncher;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("SplashActivity", "onCreate called");
        setContentView(R.layout.activity_splash);

        activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            String returnedData = data.getStringExtra("result_key");
                        }
                    }
                });

        ImageView logo = findViewById(R.id.logo);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.translate_and_scale);
        logo.startAnimation(anim);

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            activityResultLauncher.launch(intent);
            finish();
        }, 6000);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("SplashActivity", "onStart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("SplashActivity", "onResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("SplashActivity", "onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("SplashActivity", "onStop called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("SplashActivity", "onDestroy called");
    }

}
