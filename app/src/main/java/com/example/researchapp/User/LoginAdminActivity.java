package com.example.researchapp.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.researchapp.R;
import com.example.researchapp.ResearchUserActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginAdminActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int RC_SIGN_IN = 101;
    private EditText signInEmailEditText, signInPasswordEditText;
    private TextView signUpTextView,restpass;
    private Button signInButton;

    private ProgressBar progressBar;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle(" Login Page");
        setContentView(R.layout.activity_login_admin);
        mAuth = FirebaseAuth.getInstance();


        signInEmailEditText = findViewById(R.id.signInEmailEditTextID);
        signInPasswordEditText = findViewById(R.id.signInpasswordEditTextID);

        signUpTextView = findViewById(R.id.signUpTextViewID);
        signInButton = findViewById(R.id.signInButtonID);
        progressBar = findViewById(R.id.progressbarID);
        restpass = findViewById(R.id.resetpassID);


        signUpTextView.setOnClickListener(this);
        signInButton.setOnClickListener(this);
        restpass.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.signInButtonID:

                userLogin();
                break;

            case R.id.signUpTextViewID:

                Intent intent = new Intent(getApplicationContext(), SiignUpActivity.class);
                startActivity(intent);
                break;
            case R.id.resetpassID:

                Intent i = new Intent(LoginAdminActivity.this,ResetPasswordActivity.class);
                startActivity(i);
                break;
        }
    }

    private void userLogin() {

        String email = signInEmailEditText.getText().toString().trim();
        String password = signInPasswordEditText.getText().toString().trim();

        //checking the validity of the email
        if (email.isEmpty()) {
            signInEmailEditText.setError("Enter an email address");
            signInEmailEditText.requestFocus();
            return;
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            signInEmailEditText.setError("Enter a valid email address");
            signInEmailEditText.requestFocus();
            return;
        }

        //checking the validity of the password
        if (email.isEmpty()) {
            signInPasswordEditText.setError("Enter a password");
            signInPasswordEditText.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    finish();
                    Intent in = new Intent(LoginAdminActivity.this,ResearchUserActivity.class);
                    in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(in);
                } else {

                    Toast.makeText(getApplicationContext(), "Login Unsuccessful", Toast.LENGTH_LONG).show();

                }
            }
        });

    }
}