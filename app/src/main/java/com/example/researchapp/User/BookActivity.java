package com.example.researchapp.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.researchapp.PDFBOOK.FirstBookActivity;
import com.example.researchapp.PDFBOOK.SecondBookActivity;
import com.example.researchapp.PDFBOOK.ThirdBookActivity;
import com.example.researchapp.R;

public class BookActivity extends AppCompatActivity {

    ImageView imageView1, imageView2, imageView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);


        imageView1 = findViewById(R.id.image1);
        imageView2 = findViewById(R.id.image2);
        imageView3 = findViewById(R.id.image3);



        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(BookActivity.this, FirstBookActivity.class);
                startActivity(in);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(BookActivity.this, SecondBookActivity.class);
                startActivity(in);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(BookActivity.this, ThirdBookActivity.class);
                startActivity(in);
            }
        });
    }
}