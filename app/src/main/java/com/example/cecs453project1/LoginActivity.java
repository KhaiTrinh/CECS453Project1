/*
 * CECS 453-01 Project 1
 * Nikko Chan and Khai Trinh
 * June 7, 2021
 * */

package com.example.cecs453project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText etUsername, etPassword;
    private Button btnLogin, btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Stores all inputted data
        etUsername = findViewById(R.id.et_login_username);
        etPassword = findViewById(R.id.et_login_password);
        btnLogin = findViewById(R.id.btn_login);
        btnSignup = findViewById(R.id.btn_signup);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Casts all data into Strings
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                // If the login credentials exists in the database, redirects to welcome page
                if(MainActivity.DATABASE.CheckCredentials(username, password)) {
                    Intent intent = new Intent(getApplicationContext(), WelcomeActivity.class);
                    intent.putExtra("Username", username);
                    startActivity(intent);
                } else {
                    etPassword.getText().clear();
                    Toast.makeText(getApplicationContext(), "Incorrect login credentials.", Toast.LENGTH_LONG).show();
                }
            }
        });

        // When pressed redirects to the signup page
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent);
            }
        });
    }
}