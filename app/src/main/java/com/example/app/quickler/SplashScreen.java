package com.example.app.quickler;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH= 3000;
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

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent= new Intent(SplashScreen.this,MainActivity.class);
                SplashScreen.this.startActivity(intent);
                SplashScreen.this.finish();
            }
        },SPLASH_DISPLAY_LENGTH);
    }
}
