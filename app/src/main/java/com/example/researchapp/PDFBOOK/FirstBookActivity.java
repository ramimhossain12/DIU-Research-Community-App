package com.example.researchapp.PDFBOOK;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.researchapp.R;
import com.github.barteksc.pdfviewer.PDFView;

public class FirstBookActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_book);

        PDFView pdfView = findViewById(R.id.pdf_view);

        pdfView.fromAsset("test.pdf").load();
    }
}