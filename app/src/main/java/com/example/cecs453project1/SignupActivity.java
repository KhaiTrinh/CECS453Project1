package com.example.cecs453project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SignupActivity extends AppCompatActivity {
    private EditText txtUser, txtPass, txtRePass, txtEmail, txtPhone;
    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

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
                String email = txtEmail.getText().toString();
                String phone = txtPhone.getText().toString();

                String errorMessage = MainActivity.database.validateInput(user, pass, rPass, email, phone);

                if(errorMessage.equals("")) {
                    MainActivity.database.AddCredential(user, pass);
                    Intent login_page = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(login_page);
                } else {
                    Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}