/*
* CECS 453-01 Project 1
* Nikko Chan and Khai Trinh
* June 7, 2021
* */

package com.example.cecs453project1;

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
}
