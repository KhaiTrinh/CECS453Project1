package com.example.cecs453project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {
    private TextView txtWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // grabs the previous intent that was called
        Intent intent = getIntent();

        txtWelcome = findViewById(R.id.txtWelcome);
        txtWelcome.setText(txtWelcome.getText().toString() + " " + intent.getStringExtra("Username"));
    }
}