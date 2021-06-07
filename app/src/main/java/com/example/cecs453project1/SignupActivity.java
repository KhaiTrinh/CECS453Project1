/*
 * CECS 453-01 Project 1
 * Nikko Chan and Khai Trinh
 * June 7, 2021
 * */

package com.example.cecs453project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.basgeekball.awesomevalidation.utility.custom.SimpleCustomValidation;

public class SignupActivity extends AppCompatActivity {

    private AwesomeValidation awesomeValidation;

    private Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // These regex were provided by 3rd party sources
        String regexUsername = "^.*[a-zA-Z0-9]+.*$";;
        String regexPassword = "(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[~`!@#\\$%\\^&\\*\\(\\)\\-_\\+=\\{\\}\\[\\]\\|\\;:\"<>,./\\?]).{8,}";
        String regexPhone = "^^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$";

        // Basic style is used because it is compatible with constraint layout
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        // Check if username field is empty
        awesomeValidation.addValidation(this, R.id.et_registration_username, regexUsername, R.string.err_username);
        // Check if username already exists in the database
        awesomeValidation.addValidation(this, R.id.et_registration_username, new SimpleCustomValidation() {
            @Override
            public boolean compare(String s) {
                String username = ((EditText)findViewById(R.id.et_registration_username)).getText().toString();
                return !MainActivity.DATABASE.CheckUsername(username);
            }
        }, R.string.err_username);
        // Check if password has uppercase, lowercase, digit, special character, and 8 characters long
        awesomeValidation.addValidation(this, R.id.et_registration_password, regexPassword, R.string.err_password);
        // Check if the re-entered password matches the password
        awesomeValidation.addValidation(this, R.id.et_registration_password_confirmation, R.id.et_registration_password, R.string.err_password_confirmation);
        // Check if the email is in a valid format
        awesomeValidation.addValidation(this, R.id.et_registration_email, Patterns.EMAIL_ADDRESS, R.string.err_email);
        // Check if the phone number matches a few commonly used phone formats
        awesomeValidation.addValidation(this, R.id.et_registration_phone, regexPhone, R.string.err_phone);

        btnSignup = findViewById(R.id.btn_submit);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(awesomeValidation.validate()) {
                    String username = ((EditText)findViewById(R.id.et_registration_username)).getText().toString();
                    String password = ((EditText)findViewById(R.id.et_registration_password)).getText().toString();
                    // Add valid credentials to database
                    MainActivity.DATABASE.AddCredential(username, password);
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}