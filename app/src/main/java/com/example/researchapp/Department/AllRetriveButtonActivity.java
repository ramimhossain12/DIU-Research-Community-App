package com.example.researchapp.Department;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.researchapp.R;

public class AllRetriveButtonActivity extends AppCompatActivity {
    private Button csere, eeere,civilre,pharre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_retrive_button);

        csere = findViewById(R.id.csebtn_retrive);
        eeere = findViewById(R.id.eeebtn_retrive);
        civilre = findViewById(R.id.civilbtn_retrive);
        pharre = findViewById(R.id.pharmacybtn_retrive);


        csere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AllRetriveButtonActivity.this,CSERetriveActivity.class);
                startActivity(i);
            }
        });


    }
}