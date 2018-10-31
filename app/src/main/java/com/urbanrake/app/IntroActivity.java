package com.urbanrake.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Window;
import android.view.WindowManager;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;
import com.github.paolorotolo.appintro.model.SliderPage;


public class IntroActivity extends AppIntro {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window w = getWindow(); // in Activity's onCreate() for instance
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        SliderPage sliderPage1 = new SliderPage();
        sliderPage1.setTitle("Access \nGardens and Rooftops");
        sliderPage1.setDescription("Find a Garden or a Rooftop Near You. \nGrow your own healthy vegetables.");
        sliderPage1.setImageDrawable(R.drawable.image1);

        sliderPage1.setBgColor(getResources().getColor(R.color.colorPrimary1));

        addSlide(AppIntroFragment.newInstance(sliderPage1));

        SliderPage sliderPage2 = new SliderPage();
        sliderPage2.setTitle("Empower Communities");
        sliderPage2.setDescription("Host your land and grow your seed, to raise awareness and knowledge, to empower communities to live sustainable healthy lives.");
        sliderPage2.setImageDrawable(R.drawable.image2);
        sliderPage2.setBgColor(getResources().getColor(R.color.colorPrimary2));
        addSlide(AppIntroFragment.newInstance(sliderPage2));

        SliderPage sliderPage3 = new SliderPage();
        sliderPage3.setTitle("Make Extra Money");
        sliderPage3.setDescription("Whether you are hosting your land or raking your farm, Urbanrake allows you to earn extra money for a great cause! ");
        sliderPage3.setImageDrawable(R.drawable.image3);
        sliderPage3.setBgColor(getResources().getColor(R.color.colorPrimary3));
        addSlide(AppIntroFragment.newInstance(sliderPage3));


    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        SharedPreferences.Editor editor = getSharedPreferences("Urbanrake2017", 0).edit();
        editor.putBoolean("Firstime", true);

        editor.apply();
        startActivity(new Intent(IntroActivity.this, HomeActivity.class));
        overridePendingTransition(R.anim.fade_in_fast, R.anim.fade_out_medium);
        finish();
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        SharedPreferences.Editor editor = getSharedPreferences("Urbanrake2017", 0).edit();
        editor.putBoolean("Firstime", true);

        editor.apply();
        startActivity(new Intent(IntroActivity.this, HomeActivity.class));
        overridePendingTransition(R.anim.fade_in_fast, R.anim.fade_out_medium);
        finish();
    }
}
