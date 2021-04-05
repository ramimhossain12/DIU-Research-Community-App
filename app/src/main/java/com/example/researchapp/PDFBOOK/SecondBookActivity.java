package com.example.researchapp.PDFBOOK;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.researchapp.R;
import com.github.barteksc.pdfviewer.PDFView;

public class SecondBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_book);

        PDFView pdfView = findViewById(R.id.pdf_view);

        pdfView.fromAsset("bkq.pdf").load();
    }
}