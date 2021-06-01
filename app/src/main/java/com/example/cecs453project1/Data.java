package com.example.cecs453project1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Data {

    // A hashmap data structure for holding usernames and passwords pair
    HashMap <String, String> hmCredentials;

    public Data(){

        hmCredentials = new HashMap<>();

        // Adding some items into the hashmap table

        hmCredentials.put("AJ", "CoolDude1");
        hmCredentials.put("test", "1234");
    }

    // This method adds a new username and password to the hashmap
    public void AddCredential(String username, String password){
        hmCredentials.put(username, password);
    }

    // This method checks if username exists in the hashmap
    public Boolean CheckUsername(String username){
        return hmCredentials.containsKey(username);
    }

    // This method checks a username and password combination is correct!
    public Boolean CheckCredentials(String username, String Password){
        return hmCredentials.containsKey(username) && hmCredentials.containsValue(Password);
    }

    public String validateInput(String user, String pass, String rPass, String email, String phone){
        // This string will be the error message
        StringBuilder sb = new StringBuilder();

        sb.append(validateUser(user));
        sb.append(validatePass(pass, rPass));
        sb.append(validateEmail(email));
        sb.append(validatePhone(phone));

        return sb.toString();
    }

    private String validateUser(String user){
        // Checks if the username field is empty
        if(user.equals("")){
            return "Username cannot be empty. ";
        }

        // Checks if the username already exists in the database
        if(CheckUsername(user)){ // true = username exists already, false = new username
            return "Username already exist. ";
        }

        return "";
    }

    private String validatePass(String pass, String rPass){
        // Checks if the password field is empty
        if(pass.equals("")){
            return "Password cannot be empty. ";
        }

        // Checks if the password matches the retyped password
        if(!pass.equals(rPass)){ // Password and Repassword are not the same
            return "Password and Re-Typed Password aren't the same. ";
        }

        return "";
    }

    private String validateEmail(String email) {
        // Commonly used email formats
        ArrayList<String> emailFormat = new ArrayList<>(Arrays.asList("@gmail.com", "@yahoo.com", "@student.csulb.edu", "@hotmail.com", "@aol.com"));

        // Checks if email field is empty
        if(email.equals("")) {
            return "Email cannot be empty. ";
        }

        // Checks if email format is valid
        int atIndex = email.indexOf("@");
        if(atIndex == -1) {
            return "Incorrect email format. ";
        } else {
            String emailService = email.substring(atIndex);
            if(!emailFormat.contains(emailService)) {
                return "Incorrect email format. ";
            }
        }

        return "";
    }

    private String validatePhone(String phone){
        // Checks if phone field is empty
        if(phone.length() == 0) {
            return "Phone cannot be empty. ";
        } else if(phone.length() != 10) { // phone has to be 10 in length
            return "Incorrect phone format. ";
        } else {
            char[] phoneChar = phone.toCharArray();
            for(char c : phoneChar){ // all characters have to be a digit
                if(!Character.isDigit(c)){
                    return "Incorrect phone format. ";
                }
            }
        }

        return "";
    }
}
