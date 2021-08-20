package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signupc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupc);
        EditText w = findViewById(R.id.edit7);
        EditText r = findViewById(R.id.edit8);
        EditText i = findViewById(R.id.edit9);
        EditText y = findViewById(R.id.edit10);






        Button p = findViewById(R.id.button34);
        p.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                String u = w.getText().toString();
                String p = r.getText().toString();
                String l = i.getText().toString();
                String e = y.getText().toString();





                if (TextUtils.isEmpty(u)) {
                    w.setError("Enter Employeeid");
                    //Toast.makeText(getApplicationContext(), "enter name", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(p)) {
                    r.setError("Enter name");
                    //Toast.makeText(getApplicationContext(), "enter name", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(l)) {
                    i.setError("Enter phone no ");
                    //Toast.makeText(getApplicationContext(), "enter name", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(e)) {
                    y.setError("Enter doj");
                    //Toast.makeText(getApplicationContext(), "enter name", Toast.LENGTH_SHORT).show();
                }


if(l.length()!=10)
{
    i.setError("invalid phone no");
}
                if (!TextUtils.isEmpty(u)&&!TextUtils.isEmpty(p)&&!TextUtils.isEmpty(l)&&!TextUtils.isEmpty(e)) {
                    //Toast.makeText(getApplicationContext(), "Account Created Successfully", Toast.LENGTH_SHORT).show();
                    //Snackbar.make(view, "Account Created Successfully", Snackbar.LENGTH_LONG).show();
                    FirebaseDatabase J;
                    DatabaseReference x;

                    J = FirebaseDatabase.getInstance();
                    x = J.getReference("signup");
                    ak1 i = new ak1(u, p,l,e);
                    // x.setValue(Gender);
                    x.child(p).setValue(i);


                }
            }
        });

    }
}

