package com.example.android_movieapp.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.android_movieapp.models.MovieModel;
import com.example.android_movieapp.request.MovieApiClient;

import java.util.List;

public class MovieRepository {

    // this class is acting as repository

    private static MovieRepository instance;

    private MovieApiClient movieApiClient;

    public static MovieRepository getInstance() {
        if ( instance == null) {
            instance = new MovieRepository();
        }
        return instance;
    }

    private MovieRepository() {
        movieApiClient = MovieApiClient.getInstance();
    }

    public LiveData<List<MovieModel>> getMovies() {
        return movieApiClient.getMovies();
    }

    // 2 - Calling the method
    public void searchMovieApi(String query, int pageNumber) {
        movieApiClient.searchMoviesApi(query, pageNumber);
    }
}
