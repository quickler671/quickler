package com.example.app.quickler;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class SplashScreen extends AppCompatActivity {

    ImageView imageView;
    AnimationDrawable anim;

    LinearLayout layout;
    Animation myanim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        imageView = findViewById(R.id.applogo);
        imageView.setBackgroundResource(R.drawable.logo_anim);
        layout = findViewById(R.id.linearlayout);
        myanim = AnimationUtils.loadAnimation(this,R.anim.fadein);
        anim = (AnimationDrawable) imageView.getBackground();

        layout.startAnimation(myanim);
        anim.start();
    }
}
