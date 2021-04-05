package com.example.researchapp.User;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.researchapp.R;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class NoteActivity extends AppCompatActivity implements  View.OnClickListener {

    //    Button
    private EditText editText;
    private Button savebutton,exitButton;
    private android.app.AlertDialog.Builder alertDialogBuilder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);




//find the button
        editText = findViewById(R.id.editTextID);
        savebutton = findViewById(R.id.saveButtonID);
        exitButton = findViewById(R.id.buttonID);
        exitButton.setOnClickListener(this);


//on clickListener
        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String text = editText.getText().toString();

                if(text!=null){


                    writeToFile(text);




                }else{
                    Toast.makeText(getApplicationContext(),"Please enter some data",Toast.LENGTH_SHORT).show();
                }
            }
        });

        readfFromFile();


    }








    public  void writeToFile(String text){


        try {
            FileOutputStream fileOutputStream = openFileOutput("Note.text", Context.MODE_PRIVATE);
            try {
                fileOutputStream.write(text.getBytes());
                fileOutputStream.close();
                Toast.makeText(getApplicationContext(),"  Note saved ",Toast.LENGTH_SHORT).show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
    public  void readfFromFile(){

        try {
            FileInputStream fileInputStream = openFileInput("Note.text");

            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line ;
            StringBuffer stringBuffer = new StringBuffer();
            while ((line = bufferedReader.readLine())!=null){

                stringBuffer.append(line+"\n");
            }

            editText.setText(stringBuffer.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    //back button click
    @Override
    public void onBackPressed() {

        androidx.appcompat.app.AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want Exit ?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        NoteActivity.super.onBackPressed();
                    }
                })

                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();


    }


    // alertdilog

    @Override
    public void onClick(View v) {

        alertDialogBuilder = new android.app.AlertDialog.Builder(NoteActivity.this);
        alertDialogBuilder.setTitle(R.string.title_Text);

        alertDialogBuilder.setMessage(R.string.message_Text);

        alertDialogBuilder.setIcon(R.drawable.pic);

        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.cancel();

            }
        });


        alertDialogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(NoteActivity.this,"You have clicked on cancel button",Toast.LENGTH_SHORT).show();

            }
        });

        android.app.AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }
}

