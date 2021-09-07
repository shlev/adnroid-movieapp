package com.example.android_movieapp.request;

import com.example.android_movieapp.utils.BraveApi;
import com.example.android_movieapp.utils.Credentials;
import com.example.android_movieapp.utils.MovieApi;
import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Servicey {

    private static Retrofit.Builder retrofitBuilder =
            new Retrofit.Builder()
            .baseUrl(Credentials.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static MovieApi movieApi = retrofit.create(MovieApi.class);

    public static MovieApi getMovieApi() {
        return movieApi;
    }




    private static Retrofit.Builder retrofitBraveBuilder =
            new Retrofit.Builder()
                    .baseUrl(Credentials.BRAVE_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());



    private static Retrofit retrofitBrave = retrofitBraveBuilder.build();

    private static BraveApi braveApi = retrofitBrave.create(BraveApi.class);

    public static BraveApi getBraveApi() {
        return braveApi;
    }
}
