package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Home extends AppCompatActivity {
    private static int Splash_Time_OUT = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ImageView image = (ImageView)findViewById(R.id.imageView);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.move);
        image.startAnimation(animation1);

//this is function

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent j = new Intent(Home.this, MainActivity.class);
                startActivity(j);
                finish();

            }
        }, Splash_Time_OUT);
    }


}






