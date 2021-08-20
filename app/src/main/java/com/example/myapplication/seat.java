package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class seat extends AppCompatActivity {
   public static int kl;
   int o,p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat);
        EditText bb = findViewById(R.id.edit6699);
        EditText bbj = findViewById(R.id.edit6777);
String ol=bb.getText().toString();
        String e=bbj.getText().toString();


        //int finalValue = Integer.parseInt(o);
       // int h = Integer.parseInt(p);
        if (TextUtils.isEmpty(ol)) {
            bb.setError("Enter Total seat");

            //Toast.makeText(getApplicationContext(), "enter name", Toast.LENGTH_SHORT).show();
        }


        if (TextUtils.isEmpty(e)) {
            bbj.setError("Enter seats booked");
            //Toast.makeText(getApplicationContext(), "enter name", Toast.LENGTH_SHORT).show();
        }

        Button opp = findViewById(R.id.gkll);
        opp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                 o = Integer.parseInt(bbj.getText().toString());
                 p = Integer.parseInt(bb.getText().toString());
                kl = p-o;

                startActivity(new Intent(seat.this, Main3Activity.class));
            }

        });
    }
}









