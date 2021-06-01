package com.example.cecs453project1;

import androidx.appcompat.app.AppCompatActivity;
import com.example.project1.Data;

import android.content.Intent;
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
                StringBuilder sb = new StringBuilder();

                String user = txtUser.getText().toString();
                String pass = txtPass.getText().toString();
                String rPass = txtRePass.getText().toString();
                String email = txtEmail.getText().toString();
                String phone = txtPhone.getText().toString();

                database.validateInput(user, pass, rPass, email, phone);
                if(database.CheckUsername(user)){ // true = username exists already, false = new username
                    sb.append("Username Taken Already,");
                    error = true;
                }

                if(pass.equals("")){
                    sb.append("Password can not be empty");
                    error = true;
                }

                if(!pass.equals(rPass)){ // Password and Repassword are not the same
                    sb.append("Password and Re-Typed Password aren't the same,");
                    error = true;
                }

                if(phone.length != 10){ // phone has to be 10 in length
                    sb.append("Incorrect Phone Format, ");
                    error = true;
                }else{
                    for(char c : phone){ // all characters have to be a digit
                        if(!Character.isDigit(c)){
                            sb.append("Incorrect Phone Format, ");
                            error = true;
                            break;
                        }
                    }
                }

                if(error)
                    Toast.makeText(getApplicationContext(), sb.toString(), Toast.LENGTH_LONG).show();
                else{
                    database.AddCredential(user, pass);
                    Intent loginPage = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(loginPage);
                }




            }
        });
    }
}