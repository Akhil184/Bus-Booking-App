package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class ticketcheck extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticketcheck);
        Button o = findViewById(R.id.gk);
        o.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText i = findViewById(R.id.edit66);

                EditText im = findViewById(R.id.edit67);
                String o = i.getText().toString();
                String p = im.getText().toString();

                if (TextUtils.isEmpty(o)) {
                    i.setError("Enter Ticketid");


                }
                if(TextUtils.isEmpty(p))
                {
                    im.setError("Enter Date");
                }
                else {
                    final String g = i.getText().toString().trim();
                    final String gm = im.getText().toString().trim();
                    final FirebaseDatabase h = FirebaseDatabase.getInstance();
                    DatabaseReference m = FirebaseDatabase.getInstance().getReference("generate");
                    Query j = m.orderByChild("date").equalTo(gm);
                    j.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()) {
                                String p = dataSnapshot.child(gm).child("randomno").getValue(String.class);
                                if (!p.equals(g)) {
                                    Toast.makeText(ticketcheck.this, "invalid ticket id", Toast.LENGTH_SHORT).show();
                                } else {

                                    Toast.makeText(ticketcheck.this, " correct ticket id", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });
    }
}














