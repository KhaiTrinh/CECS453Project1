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
        Boolean  retval = false;
        
        if(hmCredentials.containsKey(username)){ // username exists already
            retval = true;
            return retval;
        }
        return retval;
    }

    // This method checks a username and password combination is correct!
    public Boolean CheckCredentials(String username, String Password){
        return hmCredentials.containsKey(username) && hmCredentials.containsValue(Password);
    }

    public String validateInput(String user, String pass, String rPass, String email, String phone){
        StringBuilder sb = new StringBuilder();
        sb.append(validateUser(user));
        sb.append(validatePass(pass, rPass));
        sb.append(validateEmail(email));
        sb.append(validatePhone(phone));

        return sb.toString();
    }

    private String validateUser(String user){
        if(user.equals("")){
            return "Username cannot be empty. ";
        }

        if(CheckUsername(user)){ // true = username exists already, false = new username
            return "Username already exist. ";
        }

        return "";
    }

    private String validatePass(String pass, String rPass){
        if(pass.equals("")){
            return "Password cannot be emtpy. ";
        }

        if(!pass.equals(rPass)){ // Password and Repassword are not the same
            return "Password and Re-Typed Password aren't the same. ";
        }

        return "";
    }

    private String validateEmail(String email) {
        ArrayList<String> emailFormat = new ArrayList<>(Arrays.asList("@gmail.com", "@yahoo.com", "@student.csulb.edu", "@hotmail.com", "@aol.com"));

        if(email.equals("")) {
            return "Email cannot be empty. ";
        }

        int atIndex = email.indexOf("@");

        if(atIndex == -1) {
            return "Incorrect email format. ";
        }

        String emailService = email.substring(atIndex);
        if(!emailFormat.contains(emailService)) {
            return "Incorrect email format. ";
        }


        return "";
    }

    private String validatePhone(String phone){
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
