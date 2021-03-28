package com.example.researchapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.researchapp.User.BarcodeActivity;
import com.example.researchapp.User.BookActivity;
import com.example.researchapp.User.ConferanceActivity;
import com.example.researchapp.User.JournalActivity;
import com.example.researchapp.User.NoteActivity;

import java.util.ArrayList;
import java.util.List;

public class ResearchUserActivity extends AppCompatActivity {

    //image slider
    ImageSlider imageSlider;


    CardView researupload,publication,jornal, confran, note,barcode,book;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Dash_Board");
        setContentView(R.layout.activity_research_user);


         //find card view

         book = findViewById(R.id.bookID);
         researupload = findViewById(R.id.ResearchUploadID);
         publication = findViewById(R.id.publicationResearchID);
         jornal = findViewById(R.id.jornalarticaleID);
         confran = findViewById(R.id.confranceID);
         note = findViewById(R.id.noteID);
         barcode = findViewById(R.id.barcode);

        //for image slider.............
        imageSlider = findViewById(R.id.slider1);
        List<SlideModel> slideModels=new ArrayList<>();

        slideModels.add(new SlideModel("https://images.pexels.com/photos/2280571/pexels-photo-2280571.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=750&w=1260","Holding Laboratory"));
        slideModels.add(new SlideModel("https://images.pexels.com/photos/590016/pexels-photo-590016.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500","Research "));
        slideModels.add(new SlideModel("https://images.pexels.com/photos/327882/pexels-photo-327882.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500","Research"));
        slideModels.add(new SlideModel("https://images.pexels.com/photos/3183170/pexels-photo-3183170.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500", "Research"));
        slideModels.add(new SlideModel ("https://images.pexels.com/photos/356040/pexels-photo-356040.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500", "Research"));
        slideModels.add(new SlideModel ("https://images.pexels.com/photos/212286/pexels-photo-212286.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500", "Research Plan"));

        imageSlider.setImageList(slideModels,true);

        researupload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent o = new Intent(ResearchUserActivity.this,UploadFileActivity.class);
                startActivity(o);
            }
        });


        publication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent p = new Intent(ResearchUserActivity.this,RetriveFileActivity.class);
                startActivity(p);
            }
        });

        jornal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(ResearchUserActivity.this, JournalActivity.class);
               startActivity(intent);
            }
        });


        confran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResearchUserActivity.this,ConferanceActivity.class);
                startActivity(intent);
            }
        });

        note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResearchUserActivity.this, NoteActivity.class);
                startActivity(intent);
            }
        });

        barcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResearchUserActivity.this, BarcodeActivity.class);
                startActivity(intent);
            }
        });
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResearchUserActivity.this, BookActivity.class);
                startActivity(intent);
            }
        });

    }
}