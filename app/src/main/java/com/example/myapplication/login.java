package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class login extends AppCompatActivity implements View.OnClickListener{
    private ImageButton btRegister;
    private TextView tvLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btRegister  = findViewById(R.id.btRegister);
        tvLogin     = findViewById(R.id.tvLogin1);
        btRegister.setOnClickListener(this);
        Button o=findViewById(R.id.login);
        o.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), login.class);
                startActivity(intent);
            }

        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        if (v==btRegister){
            Intent intent   = new Intent(login.this,signupc.class);
            Pair[] pairs    = new Pair[1];
            pairs[0] = new Pair<View,String>(tvLogin,"tvLogin");
            ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(login.this,pairs);
            startActivity(intent,activityOptions.toBundle());
        }
    }

}
