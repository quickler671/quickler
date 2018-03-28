package com.example.app.quickler;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {

    ImageView imageView;
    AnimationDrawable anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        imageView = findViewById(R.id.applogo);
        imageView.setBackgroundResource(R.drawable.logo_anim);

        anim = (AnimationDrawable) imageView.getBackground();
        anim.start();
    }
}
