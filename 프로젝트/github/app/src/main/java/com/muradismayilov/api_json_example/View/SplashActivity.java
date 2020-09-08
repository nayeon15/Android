package com.muradismayilov.api_json_example.View;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;
import com.muradismayilov.api_json_example.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        startLoading();
        LottieAnimationView animationView = findViewById(R.id.animationView);
        setUpAnimation(animationView);
    }

    private void startLoading() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, 3000);
    }

    private void setUpAnimation(LottieAnimationView animationView) {
        // 재생할 애니메이션 넣어준다.
        animationView.setAnimation("github-logo.json");
        // 시작
        animationView.playAnimation();
    }
}