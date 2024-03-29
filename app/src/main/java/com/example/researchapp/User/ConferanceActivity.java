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

public class ConferanceActivity extends AppCompatActivity {

    private WebView webView1;

    private ProgressBar progressBarconfer;

    private ProgressDialog progressDialog ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conferance);

        progressBarconfer = findViewById(R.id.progconferID);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading Please Wait......");



        webView1.loadUrl("https://sciencex.wpninjathemes.com/conferences-and-talks/");
        webView1.getSettings().setJavaScriptEnabled(true);
        webView1.setWebChromeClient(new WebChromeClient());
        webView1.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                progressBarconfer.setVisibility(View.VISIBLE);
                progressBarconfer.setProgress(newProgress);

                progressDialog.show();
                if (newProgress ==100){
                    progressBarconfer.setVisibility(View.GONE);
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