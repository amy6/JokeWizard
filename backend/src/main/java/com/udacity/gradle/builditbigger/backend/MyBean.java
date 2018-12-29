package com.udacity.gradle.builditbigger.backend;

import com.example.jokestore.JokeStore;

import java.io.IOException;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private String myData;

    public String getData() throws IOException {
        return new JokeStore().getJoke();
    }

    public void setData(String data) {
        myData = data;
    }
}