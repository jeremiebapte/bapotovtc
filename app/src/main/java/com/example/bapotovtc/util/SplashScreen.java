package com.example.bapotovtc.util;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bapotovtc.R;

public class SplashScreen extends AppCompatActivity {

    Animation topAnim, bottomAnim;
    ImageView image;
    TextView logo, slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

            topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
            bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

            image = findViewById(R.id.imageView);
            logo = findViewById(R.id.textView);
            slogan = findViewById(R.id.textView2);

            image.setAnimation(topAnim);
            logo.setAnimation(bottomAnim);
            slogan.setAnimation(bottomAnim);

            Runnable runnable = () -> {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();


            };


            new Handler().postDelayed(runnable, 10000);


        }
    }
