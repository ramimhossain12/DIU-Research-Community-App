package com.example.researchapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.researchapp.Department.AllButtonActivity;
import com.example.researchapp.Department.AllRetriveButtonActivity;
import com.example.researchapp.Department.CSERetriveActivity;
import com.example.researchapp.Department.CSEUploadActivity;
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


    CardView researupload,publication,jornal, confran, note,barcode,book,cse ,cseretrive;
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
         cse = findViewById(R.id.cse);
         cseretrive = findViewById(R.id.cseretrive);

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
                Intent o = new Intent(ResearchUserActivity.this, AllButtonActivity.class);
                startActivity(o);
            }
        });


        publication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent p = new Intent(ResearchUserActivity.this, AllRetriveButtonActivity.class);
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

        cse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResearchUserActivity.this, CSEUploadActivity.class);
                startActivity(intent);
            }
        });

        cseretrive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResearchUserActivity.this, CSERetriveActivity.class);
                startActivity(intent);
            }
        });




    }

    //menu item find

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }



    //menu item selected
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (item.getItemId() == R.id.ShareId) {

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/type");
            String subject = "Note_Book app";
            String body = "This app  is very useful .\n com.example.researchapp";
            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            intent.putExtra(Intent.EXTRA_TEXT, body);
            startActivity(Intent.createChooser(intent, "share with"));


        } else if (item.getItemId() == R.id.feedbackID) {
            Intent intent = new Intent(getApplicationContext(), DeveloperFeedbackActivity.class);
            startActivity(intent);


        } else if (id == R.id.aboutId) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);




        }
        else  if (id == R.id.notificanId){
            Intent intent = new Intent(this, NotificationActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}