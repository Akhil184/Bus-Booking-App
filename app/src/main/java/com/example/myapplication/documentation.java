package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class documentation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documentation);
        Button p = findViewById(R.id.save);
        p.setOnClickListener(new View.OnClickListener() {
            EditText w = findViewById(R.id.edit203);
            EditText r = findViewById(R.id.edit506);
            EditText i = findViewById(R.id.edit456);
            EditText y = findViewById(R.id.edit566);


            @Override
            public void onClick(View view) {
                String u = w.getText().toString();
                String p = r.getText().toString();
                String l = i.getText().toString();
                String e = y.getText().toString();





                if (TextUtils.isEmpty(u)) {
                    w.setError("Enter Destination");
                    //Toast.makeText(getApplicationContext(), "enter name", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(p)) {
                    r.setError("Enter From");
                    //Toast.makeText(getApplicationContext(), "enter name", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(l)) {
                    i.setError("Enter Date ");
                    //Toast.makeText(getApplicationContext(), "enter name", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(e)) {
                    y.setError("Enter Time");
                    //Toast.makeText(getApplicationContext(), "enter name", Toast.LENGTH_SHORT).show();
                }









                if (!TextUtils.isEmpty(u)) {
                    //Toast.makeText(getApplicationContext(), "Account Created Successfully", Toast.LENGTH_SHORT).show();
                    //Snackbar.make(view, "Account Created Successfully", Snackbar.LENGTH_LONG).show();
                    FirebaseDatabase J;
                    DatabaseReference x;

                    J = FirebaseDatabase.getInstance();
                    x = J.getReference("document");
                    ak3 i = new ak3(u, p,l,e);
                    // x.setValue(Gender);
                    x.child(p).setValue(i);


                }
            }
        });

    }
    }
