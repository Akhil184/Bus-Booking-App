package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class userpanel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userpanel);

        Button M = (Button) findViewById(R.id.continu);

                RadioGroup n = (RadioGroup)findViewById(R.id.radio);

                M.setOnClickListener(new View.OnClickListener() {


                    @Override
                    public void onClick(View v) {
                        switch (n.getCheckedRadioButtonId()) {
                            case R.id.radioButton5:

                                Intent intent = new Intent(userpanel.this, barcode.class);
                                startActivity(intent);
                                break;

                            case R.id.radioButton6:

                                Intent inten = new Intent(userpanel.this, MainActivity4.class);
                                startActivity(inten);
                                break;

                    }


            }
        });

    }
}
