package com.example.cecs453project1;

import androidx.appcompat.app.AppCompatActivity;
import com.example.project1.Data;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SignupActivity extends AppCompatActivity {
    private EditText txtUser, txtPass, txtRePass, txtEmail, txtPhone;
    private Button btnSignUp;

    private Data database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        database = new Data();

        String emailFormat[] = {"@gmail.com", "@yahoo.com", "@student.csulb.edu", "@hotmail.com", "@aol.com"};
        String phoneFormat = "562-123-4567";
        txtUser = findViewById(R.id.txtSignupUsername);
        txtPass = findViewById(R.id.txtSignupPassword);
        txtRePass = findViewById(R.id.txtSignupRetype);
        txtEmail = findViewById(R.id.txtSignupEmail);
        txtPhone = findViewById(R.id.txtSignupPhone);

        btnSignUp = findViewById(R.id.btnSignupSignMeUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = txtUser.getText().toString();
                String pass = txtPass.getText().toString();
                String rPass = txtRePass.getText().toString();
                if(database.CheckUsername(user)){ // true = username exists already, false = new username
                    Toast.makeText(getApplicationContext(), "Username Taken Already", Toast.LENGTH_SHORT).show();
                }

                if(!pass.equals(rPass)){ // Password and Repassword are not the same
                    Toast.makeText(getApplicationContext(), "Password and Re-Typed Password aren't the same", Toast.LENGTH_SHORT).show();
                }



            }
        });
    }
}