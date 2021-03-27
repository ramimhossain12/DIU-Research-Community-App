package com.example.researchapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class ResearchUserActivity extends AppCompatActivity {

    //image slider
    ImageSlider imageSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Dash_Board");
        setContentView(R.layout.activity_research_user);


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
    }
}