package com.example.researchapp.Department;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.researchapp.R;

public class AllButtonActivity extends AppCompatActivity {

    private Button cse,eee,pharmacy,civil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_button);

        cse = findViewById(R.id.csebtn_upload);
        eee = findViewById(R.id.eeebtn_upload);
        civil = findViewById(R.id.civilbtn_upload);
        pharmacy = findViewById(R.id.pharmacybtn_upload);


        cse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(AllButtonActivity.this,CSEUploadActivity.class);
                startActivity(in);
            }
        });

        eee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(AllButtonActivity.this,EeeUploadActivity.class);
                startActivity(in);
            }
        });

        civil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(AllButtonActivity.this,CivilUploadActivity.class);
                startActivity(in);
            }
        });

        pharmacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(AllButtonActivity.this,PharmactUploadActivity.class);
                startActivity(in);
            }
        });
    }
}