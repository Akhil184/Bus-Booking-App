package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class conductorpanel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conductorpanel);
        Button M = (Button) findViewById(R.id.contin);

        RadioGroup n = (RadioGroup)findViewById(R.id.radio);

        M.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                switch (n.getCheckedRadioButtonId()) {
                    case R.id.radioButton7:

                        Intent intent = new Intent(conductorpanel.this, giveticket.class);
                        startActivity(intent);
                        break;

                    case R.id.radioButton8:

                        Intent inten = new Intent(conductorpanel.this, ticketcheck.class);
                        startActivity(inten);
                        break;

                    case R.id.radioButton9:

                        Intent intp = new Intent(conductorpanel.this, documentation.class);
                        startActivity(intp);
                        break;

                    case R.id.radioButton10:

                        Intent intek = new Intent(conductorpanel.this, seat.class);
                        startActivity(intek);
                        break;

                }


            }
        });

    }
}