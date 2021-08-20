package com.example.myapplication;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.parser.Table;


import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class giveticket extends AppCompatActivity {
    Button closeButton;
    public static String e;
     Random r= new Random();
     int randomNumber=r.nextInt(10000);
     String n=String.valueOf(randomNumber);
   EditText editText,editText1,editText2,editText3,editText4,editText5;
    Table table;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giveticket);
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        builder.detectFileUriExposure();
        editText = (EditText) findViewById(R.id.edit15);
        editText1 = (EditText) findViewById(R.id.edit16);
        editText2 = (EditText) findViewById(R.id.edit17);
        editText3 = (EditText) findViewById(R.id.edit18);
        editText4 = (EditText) findViewById(R.id.edit19);
        closeButton = (Button) findViewById(R.id.gener);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String up = editText.getText().toString();
                String u = editText1.getText().toString();
                String p = editText2.getText().toString();
                String l = editText3.getText().toString();
                 e = editText4.getText().toString();


                if (TextUtils.isEmpty(up)) {
                    editText.setError("Enter Destination");
                    //Toast.makeText(getApplicationContext(), "enter name", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(u)) {
                    editText1.setError("Enter From");
                    //Toast.makeText(getApplicationContext(), "enter name", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(p)) {
                    editText2.setError("Enter select Date ");
                    //Toast.makeText(getApplicationContext(), "enter name", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(l)) {
                    editText3.setError("Time");
                    //Toast.makeText(getApplicationContext(), "enter name", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(e)) {
                    editText4.setError("price");
                    //Toast.makeText(getApplicationContext(), "enter name", Toast.LENGTH_SHORT).show();
                }

                if (!TextUtils.isEmpty(u)) {
                    //Toast.makeText(getApplicationContext(), "Account Created Successfully", Toast.LENGTH_SHORT).show();
                    //Snackbar.make(view, "Account Created Successfully", Snackbar.LENGTH_LONG).show();
                    FirebaseDatabase J;
                    DatabaseReference x;

                    J = FirebaseDatabase.getInstance();
                    x = J.getReference("generate");
                    ak2 i = new ak2(up,u, p, l, e, n);
                    // x.setValue(Gender);
                    x.child(p).setValue(i);

                }




                //Uncomment the below code to Set the message and title from the strings.xml file
                //createPdf(editText.getText().toString(),editText1.getText().toString(),editText2.getText().toString(),editText3.getText().toString(),editText4.getText().toString(),editText5.getText().toString());


            }

        });

        Button bn = (Button) findViewById(R.id.generat);
        bn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                createPdf(editText.getText().toString(), editText1.getText().toString(), editText2.getText().toString(), editText3.getText().toString(), editText4.getText().toString(),String.valueOf(randomNumber));
            }
        });
    }
            private void createPdf(String sometext, String pome, String somes, String Somi, String y,String n){
        // create a new document
        PdfDocument document = new PdfDocument();
        // crate a page description
        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(300, 600, 1).create();
        // start a page
        PdfDocument.Page page = document.startPage(pageInfo);
        Canvas canvas = page.getCanvas();
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setColor(Color.BLACK);
        String uu="Ticket id:"+n;
        String mmm="Destination:"+sometext;
        String nn="\nFrom:"+somes;
        String hhh="\nSelect Date:"+Somi;
        String vv="\nTime:"+pome;
        String kk="\nPrice:"+y;

        canvas.drawText(uu,80, 80, paint);
        canvas.drawText(mmm,80, 100, paint);
        canvas.drawText(nn,80, 120, paint);
        canvas.drawText(hhh,200, 120, paint);
        canvas.drawText(vv,80, 140, paint);
        canvas.drawText(kk,200, 140, paint);
paint.setColor(Color.BLUE);
        canvas.drawRect(100,100,100,100,paint);




        //canvas.drawt
        // finish the page
        document.finishPage(page);
// draw text on the graphics object of the page
        // Create Page 2

        // write the document content
        String directory_path = getExternalFilesDir(null).getAbsolutePath().toString() + "/mypdf/";
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        String targetPdf = directory_path+"ticket.pdf";
        File filePath = new File(targetPdf);
        try {
            document.writeTo(new FileOutputStream(filePath));
            Toast.makeText(this, "Done", Toast.LENGTH_LONG).show();

        } catch (IOException e) {
            Log.e("main", "error "+e.toString());
            Toast.makeText(this, "Something wrong: " + e.toString(),  Toast.LENGTH_LONG).show();
        }
Uri uri=Uri.fromFile(filePath);
        Intent m=new Intent();
        m.setAction(Intent.ACTION_SEND);
        m.putExtra(Intent.EXTRA_STREAM,uri);
        m.setType("application/pdf");
        startActivity(Intent.createChooser(m,"share"));

        // close the document
        document.close();

    }
}