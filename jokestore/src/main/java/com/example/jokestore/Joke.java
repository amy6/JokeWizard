package com.example.jokestore;

class Joke {

    private String setup;
    private String punchline;

    public String getSetup() {
        return setup;
    }

    public String getPunchline() {
        return punchline;
    }

    @Override
    public String toString() {
        return setup + "\n" + punchline;
    }
}
