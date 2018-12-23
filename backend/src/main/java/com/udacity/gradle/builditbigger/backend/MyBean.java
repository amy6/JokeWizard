package com.udacity.gradle.builditbigger.backend;

import com.example.jokestore.JokeStore;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private String myData;

    public String getData() {
        return new JokeStore().getJoke();
    }

    public void setData(String data) {
        myData = data;
    }
}