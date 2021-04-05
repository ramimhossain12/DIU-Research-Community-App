package com.example.researchapp.User;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.researchapp.R;

public class JournalActivity extends AppCompatActivity {


    private WebView webView;

    private ProgressBar progressBarjornal;

   private ProgressDialog progressDialog ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal);


        progressBarjornal = findViewById(R.id.progjornalID);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading Please Wait......");


        progressBarjornal.setMax(100);
        webView = findViewById(R.id.wb);



        webView.loadUrl("https://sciencex.wpninjathemes.com/journal-articles/");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());


        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                progressBarjornal.setVisibility(View.VISIBLE);
                progressBarjornal.setProgress(newProgress);
                setTitle("Journal Articles");
                progressDialog.show();
                if (newProgress ==100){
                progressBarjornal.setVisibility(View.GONE);
                setTitle(view.getTitle());
                progressDialog.dismiss();
                }
                super.onProgressChanged(view, newProgress);




            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
            }

            @Override
            public void onReceivedIcon(WebView view, Bitmap icon) {
                super.onReceivedIcon(view, icon);
            }
        });
    }
}