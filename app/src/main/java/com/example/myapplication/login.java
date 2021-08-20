package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

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
                EditText i = findViewById(R.id.edit13);
                EditText p = findViewById(R.id.edit14);


                String o = i.getText().toString();
                String e = p.getText().toString();
                if (TextUtils.isEmpty(o)) {
                    i.setError("Enter Name");

                    //Toast.makeText(getApplicationContext(), "enter name", Toast.LENGTH_SHORT).show();
                }


                if (TextUtils.isEmpty(e)) {
                    p.setError("Enter mobileno");
                    //Toast.makeText(getApplicationContext(), "enter name", Toast.LENGTH_SHORT).show();
                } else {

                    final String g = i.getText().toString().trim();
                    final String y = p.getText().toString().trim();
                    final FirebaseDatabase h = FirebaseDatabase.getInstance();
                    DatabaseReference m = FirebaseDatabase.getInstance().getReference("signup");
                    Query j = m.orderByChild("name").equalTo(g);
                    j.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()) {
                                String p = dataSnapshot.child(g).child("phoneno").getValue(String.class);
                                if (!p.equals(y)) {
                                    Toast.makeText(login.this, "wrong phoneno or Name", Toast.LENGTH_SHORT).show();
                                    //Snackbar.make(v,"wrong",Snackbar.LENGTH_LONG).show();


                                } else {

                                    startActivity(new Intent(login.this, conductorpanel.class));
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
        Button n = findViewById(R.id.face1);
        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent N = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/"));
                startActivity(N);
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
