package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    String gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        EditText w = findViewById(R.id.edit1);
        EditText r = findViewById(R.id.edit2);
        EditText i = findViewById(R.id.edit3);
        EditText y = findViewById(R.id.edit4);
        EditText k = findViewById(R.id.edit5);
        EditText a = findViewById(R.id.edit6);
        String n = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        RadioButton x=findViewById(R.id.radioButton);
        RadioButton q=findViewById(R.id.radioButton3);


        RadioGroup nk = (RadioGroup) findViewById(R.id.radio1);
        nk.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch (i) {
                    case R.id.radioButton:

                        gender="male";
                        break;

                    case R.id.radioButton3:

                        gender="female";
                        break;



                }
            }
        });

        Button p = findViewById(R.id.button56);
        p.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                String u = w.getText().toString();
                String p = r.getText().toString();
                String l = i.getText().toString();
                String e = y.getText().toString();
                String m = k.getText().toString();
                String h = a.getText().toString();

                String rr=x.getText().toString();
                String rf=q.getText().toString();




                if (TextUtils.isEmpty(u)) {
                    w.setError("Enter Email");
                    //Toast.makeText(getApplicationContext(), "enter name", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(p)) {
                    r.setError("Enter name");
                    //Toast.makeText(getApplicationContext(), "enter name", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(l)) {
                    i.setError("Enter Adhar card no ");
                    //Toast.makeText(getApplicationContext(), "enter name", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(e)) {
                    y.setError("Enter phoneno");
                    //Toast.makeText(getApplicationContext(), "enter name", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(m)) {
                    k.setError("Enter Address");
                    //Toast.makeText(getApplicationContext(), "enter name", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(h)) {
                    a.setError("Enter DOB");
                    //Toast.makeText(getApplicationContext(), "enter name", Toast.LENGTH_SHORT).show();
                }

if(l.length()!=12)
{
    i.setError("invalid Adhar card no ");
}
                if(e.length()!=10)
                {
                    y.setError("invalid phone no ");
                }





                if (!w.getText().toString().trim().matches(n) && !TextUtils.isEmpty(u)) {
                    Snackbar.make(view, "invalid email id", Snackbar.LENGTH_LONG).show();
                    //y.setText("l");
                }
                if (!TextUtils.isEmpty(u)) {
                    //Toast.makeText(getApplicationContext(), "Account Created Successfully", Toast.LENGTH_SHORT).show();
                    //Snackbar.make(view, "Account Created Successfully", Snackbar.LENGTH_LONG).show();
                    FirebaseDatabase J;
                    DatabaseReference x;

                    J = FirebaseDatabase.getInstance();
                    x = J.getReference("akhil");
                   ak i = new ak(u, p,l,e,m,h,gender);
                   // x.setValue(Gender);
                    x.child(p).setValue(i);


                }
            }
        });

    }
}