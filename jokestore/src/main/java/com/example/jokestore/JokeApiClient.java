package com.example.jokestore;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class JokeApiClient {

    private static final String BASE_URL = "https://official-joke-api.herokuapp.com/";
    private static Retrofit retrofit;

    //OkHttpClient to enable logging
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    private static HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY);

    /**
     * called to get a reference to Retrofit instance
     *
     * @return retrofit client to be used for API calls
     */
    public static Retrofit getClient() {

        if (retrofit == null) {

            //add logging interceptor
            httpClient.addInterceptor(loggingInterceptor);

            retrofit = new Retrofit.Builder()
                    //specify json converter
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    //specify base URL for the API
                    .baseUrl(BASE_URL)
                    .build();
        }

        return retrofit;
    }
}

interface JokeApiService {

    @GET("random_joke")
    Call<Joke> getJoke();
}
