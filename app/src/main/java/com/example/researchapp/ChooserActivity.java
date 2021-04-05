package com.example.researchapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.example.researchapp.User.LoginAdminActivity;

public class ChooserActivity extends AppCompatActivity {
    private RadioButton optaion1, optaion2;

    private LottieAnimationView lottieAnimationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooser);

        //find button.......
        optaion1 = findViewById(R.id.option1);
        optaion2 = findViewById(R.id.option2);
        lottieAnimationView = findViewById(R.id.submitID);

        //set on click listener........
        lottieAnimationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (optaion1.isChecked()) {

                    Intent i = new Intent(ChooserActivity.this, ResearchAdminActivity.class);
                    startActivity(i);
                } else if (optaion2.isChecked()) {

                    Intent io = new Intent(ChooserActivity.this,LoginAdminActivity.class);

                    startActivity(io);

                }
            }
        });

    }
}