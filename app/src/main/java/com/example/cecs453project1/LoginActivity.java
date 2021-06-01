package com.example.cecs453project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText txtLoginUsername, txtLoginPassword;
    private Button btnLogin, btnSignup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtLoginUsername = findViewById(R.id.txtLoginUsername);
        txtLoginPassword = findViewById(R.id.txtLoginPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignup = findViewById(R.id.btnSignup);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = txtLoginUsername.getText().toString();
                String password = txtLoginPassword.getText().toString();
                if(MainActivity.database.CheckCredentials(username, password)) {
                    Intent welcome_page = new Intent(getApplicationContext(), WelcomeActivity.class);
                    welcome_page.putExtra("Username", username);
                    startActivity(welcome_page);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect login credentials.", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signup_page = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(signup_page);
            }
        });
    }
}