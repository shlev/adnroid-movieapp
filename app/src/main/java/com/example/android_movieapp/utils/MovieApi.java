package com.example.android_movieapp.utils;

import com.example.android_movieapp.models.MovieModel;
import com.example.android_movieapp.response.MovieSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApi {

    //Search for movies
    @GET("search/movie")
    Call<MovieSearchResponse> searchMovie(
        @Query("api_key") String key,
        @Query("query") String query,
        @Query("page") String page
            );

    @GET("movie/{movie_id}?")
    Call<MovieModel> getMovie (
        @Path("movie_id") int movie_id,
        @Query("api_key") String api_key
    );

}
