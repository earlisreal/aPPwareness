package com.example.eteam.appwearness;

import android.graphics.Color;
import android.os.Bundle;
import com.github.paolorotolo.appintro.AppIntro;

public class Intro extends AppIntro {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addSlide(new HomeFragment());
        setBarColor(Color.parseColor("#3F51B5"));
        setSeparatorColor(Color.parseColor("#2196F3"));
        showStatusBar(true);
        showSkipButton(false);
        setVibrate(true);
        setVibrateIntensity(30);
        setFadeAnimation();
        askForPermissions(new String[]{"android.permission.CAMERA"}, 1);
    }

    public void onSkipPressed() {
    }

    public void onNextPressed() {
    }

    public void onDonePressed() {
        finish();
    }

    public void onSlideChanged() {
    }
}
