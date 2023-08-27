package com.example.ycfelix.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.multidex.MultiDex;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreemActivity extends AppCompatActivity {
    private ImageView appLogo, pattern1, pattern2;
    private TextView appSlogan, poweredBy, developerDepository;

    //Other Variables
    private Animation topAnimation, bottomAnimation, startAnimation, endAnimation;
    private SharedPreferences onBoardingPreference;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screem);
        MultiDex.install(SplashScreemActivity.this);

        MultiDex.install(this);
        // new CheckInternetConnection(this).checkConnection();
        Long tsLong = System.currentTimeMillis() / 1000;


        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().setStatusBarColor(getColor(R.color.colorBackground));
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        initViews();
        initAnimation();
    }

    private void initViews() {
        //Initialize Views
        appLogo = findViewById(R.id.app_logo);
        pattern1 = findViewById(R.id.pattern1);
        pattern2 = findViewById(R.id.pattern2);
        appSlogan = findViewById(R.id.app_slogan);
        poweredBy = findViewById(R.id.powered_by);
        developerDepository = findViewById(R.id.developer_depository);
    }

    private void initAnimation() {
        //Initialize Animations
        topAnimation = AnimationUtils.loadAnimation(SplashScreemActivity.this, R.anim.splash_top_animation);
        bottomAnimation = AnimationUtils.loadAnimation(SplashScreemActivity.this, R.anim.splash_bottom_animation);
        startAnimation = AnimationUtils.loadAnimation(SplashScreemActivity.this, R.anim.splash_start_animation);
        endAnimation = AnimationUtils.loadAnimation(SplashScreemActivity.this, R.anim.splash_end_animation);
    }

    @Override
    protected void onStart() {
        super.onStart();
        int SPLASH_TIMER = 3000;

        //Set Preferences
        onBoardingPreference = getSharedPreferences("onBoardingPreference", MODE_PRIVATE);
        final boolean isFirstTime = onBoardingPreference.getBoolean("firstTime", true);

        //Set Animation To Views
        appLogo.setAnimation(topAnimation);
        pattern1.setAnimation(startAnimation);
        pattern2.setAnimation(endAnimation);
        appSlogan.setAnimation(bottomAnimation);
        poweredBy.setAnimation(bottomAnimation);
        developerDepository.setAnimation(bottomAnimation);

        new Handler().postDelayed(() -> {

            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
            finish();
        }, SPLASH_TIMER);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}