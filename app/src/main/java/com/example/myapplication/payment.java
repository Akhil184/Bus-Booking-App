package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

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
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class payment extends AppCompatActivity {
    String GOOGLE_PAY_PACKAGE_NAME = "com.google.android.apps.nbu.paisa.user";
    int GOOGLE_PAY_REQUEST_CODE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        EditText i = findViewById(R.id.name);
        EditText j = findViewById(R.id.upi);
        EditText k = findViewById(R.id.amount);
        EditText l = findViewById(R.id.note);
        String jk=i.getText().toString();
        String jh=j.getText().toString();
        String jn=k.getText().toString();
        String jm=l.getText().toString();
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        builder.detectFileUriExposure();
        Button n = findViewById(R.id.pay);
        Button npp = findViewById(R.id.payg);
        TextView bbi=findViewById(R.id.text);
        //final int UPI_PAYMENT = 0;
        npp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
if(!TextUtils.isEmpty(i.getText().toString().trim()) && !TextUtils.isEmpty(j.getText().toString().trim()) && !TextUtils.isEmpty(k.getText().toString().trim()) && !TextUtils.isEmpty(l.getText().toString().trim()) )
                    createPdf(barcode.scantext.getText().toString());
else
    bbi.setText("first do payment");
                }

        });
        //final int UPI_PAYMENT = 0;
        n.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(i.getText().toString().trim())) {
                    Toast.makeText(payment.this, " Name is invalid", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(j.getText().toString().trim())) {
                    Toast.makeText(payment.this, " UPI ID is invalid", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(k.getText().toString().trim())) {
                    Toast.makeText(payment.this, " Amount is invalid", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(l.getText().toString().trim())) {
                    Toast.makeText(payment.this, " Note is invalid", Toast.LENGTH_SHORT).show();
                } else {
                    pausing(i.getText().toString(), j.getText().toString(),
                            k.getText().toString(), l.getText().toString());

                }
            }
        });
    }


    void pausing(String r, String q, String s, String e) {
        Log.e("main ", "name " + r + "--up--" + q + "--" + s + "--" + e);

        Uri uri = Uri.parse("upi://pay").buildUpon()


                .appendQueryParameter("pa", q)       // virtual ID
                .appendQueryParameter("pn", r)          // name
                //.appendQueryParameter("mc", "your-merchant-code")          // optional
                //.appendQueryParameter("tr", "your-transaction-ref-id")     // optional
                .appendQueryParameter("tn", e)       // any note about payment
                .appendQueryParameter("am", s)           // amount
                .appendQueryParameter("cu", "INR")                         // currency
                //.appendQueryParameter("url", "your-transaction-url")       // optional
                .build();
        Intent upiPayIntent = new Intent(Intent.ACTION_VIEW);
        upiPayIntent.setData(uri);
        upiPayIntent.setPackage(GOOGLE_PAY_PACKAGE_NAME);
        startActivityForResult(upiPayIntent, GOOGLE_PAY_REQUEST_CODE);
        //Intent chooser = Intent.createChooser(upiPayIntent, "pay with");
                  /* if (null != chooser.resolveActivity(getPackageManager())) {
                       startActivityForResult(chooser, UPI_PAYMENT);
                   } else {
                       Toast.makeText(payment.this, "No UPI app found, please install one to continue", Toast.LENGTH_SHORT).show();
                   }*/
    }


    private void createPdf(String bbb){
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
        String uu="Ticket id:"+bbb;


        canvas.drawText(uu,80, 80, paint);

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
