package com.example.cecs453project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static Data database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = new Data();

        Intent login_page = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(login_page);
    }
}