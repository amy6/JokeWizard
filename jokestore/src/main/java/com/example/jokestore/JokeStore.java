package com.example.jokestore;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JokeStore {

    private String joke = "";

    public String getJoke() {

        JokeApiService apiService = JokeApiClient.getClient().create(JokeApiService.class);
        Call<String> jokeCall = apiService.getJoke();
        jokeCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.body() != null) {
                    joke = response.body();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
        return joke;
    }
}
