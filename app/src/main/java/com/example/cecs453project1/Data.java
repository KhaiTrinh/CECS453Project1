package com.example.project1;

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
        // Write your code here
        if(!username.equals("")){
            retval = true;
        }
        
        if(hmCredentials.containsKey(username)){ // username exists already
            retval = true;
            return retval;
        }
        return retval;
    }

    // This method checks a username and password combination is correct!
    public Boolean CheckCredentials(String username, String Password){
        Boolean  retval = true;
        // Write your code here

        return retval;
    }

    public String validateInput(String user, String pass, String rPass, String email, String phone){

    }

    private String validateUser(String user){
        if(user.equals("")){
            sb.append("Username Taken Already,");
            error = true;
        }

        if(CheckUsername(user)){ // true = username exists already, false = new username
            sb.append("Username Taken Already,");
            error = true;
        }
    }

    private String validatePass(String pass){

    }

    private String validatePhone(String phone){

    }


}
