package com.example.jokestore;

import java.io.IOException;
import java.util.Objects;

import retrofit2.Call;

public class JokeStore {

    public String getJoke() throws IOException {

        JokeApiService apiService = JokeApiClient.getClient().create(JokeApiService.class);
        Call<Joke> jokeCall = apiService.getJoke();
        return Objects.requireNonNull(jokeCall.execute().body()).toString();
    }
}
