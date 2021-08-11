package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class searchbus extends AppCompatActivity {
    Button search_buses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_searchbus);
        search_buses = findViewById(R.id.search_buses);
        search_buses.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity4.class);
            startActivity(intent);
        });
    }
}
