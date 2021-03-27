package com.example.researchapp.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.researchapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPasswordActivity extends AppCompatActivity {

    private EditText passwordEmail;
    private Button resetPassword;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().setTitle("Reset Page");
        getSupportActionBar().setIcon(R.drawable.lock);
        setContentView(R.layout.activity_reset_password);


        passwordEmail = findViewById(R.id.etpasswordEmailID);
        resetPassword = findViewById(R.id.btnpasswordResetID);
        firebaseAuth = FirebaseAuth.getInstance();


        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String useremail = passwordEmail.getText().toString().trim();

                if (useremail.equals("")){
                    Toast.makeText(ResetPasswordActivity.this,"Please enter your registered email ID",Toast.LENGTH_SHORT).show();

                }
                else {
                    firebaseAuth.sendPasswordResetEmail(useremail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(ResetPasswordActivity.this,"Password reset email sent !",Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity( new Intent(ResetPasswordActivity.this,LoginAdminActivity.class));
                            }
                            else
                            {
                                Toast.makeText(ResetPasswordActivity.this,"Error in sending password reset email ",Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }

            }
        });
    }
}