package com.example.android_movieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.android_movieapp.models.MovieModel;
import com.example.android_movieapp.models.User;
import com.example.android_movieapp.response.MovieSearchResponse;
import com.example.android_movieapp.retrofit.Servicey;
import com.example.android_movieapp.utils.BraveApi;
import com.example.android_movieapp.utils.Credentials;
import com.example.android_movieapp.utils.MovieApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetUser();
            }
        });
    }

    private void GetUser() {
        BraveApi braveApi = Servicey.getBraveApi();

        Call<User> responseCall = braveApi.getUser("1");


        responseCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.e("Tag", Integer.toString(response.code()));
                if ( response.code() == 200) {
                    Log.v("Tag", "the response " + response.body().toString());
                    Log.v("RESULT", response.body().getFirstName());
                } else {
                    Log.v("Tag", "Error " + response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("Nightmare", "Failed connecting " + call.request().url());
                t.printStackTrace();
            }
        });
    }




    private void GetRetrofitResponse() {
        MovieApi movieApi = Servicey.getMovieApi();

        Call<MovieSearchResponse> responseCall = movieApi
                .searchMovie(
                        Credentials.API_KEY,
                        "Jack Reacher",
                        "1"
                );

        responseCall.enqueue(new Callback<MovieSearchResponse>() {
            @Override
            public void onResponse(Call<MovieSearchResponse> call, Response<MovieSearchResponse> response) {
                Log.e("Tag", Integer.toString(response.code()));
                if ( response.code() == 200) {
                    Log.v("Tag", "the response " + response.body().toString());
                    List<MovieModel> movies = new ArrayList<>(response.body().getMovies());
                    for (MovieModel movie : movies) {
                        Log.v("Tag", "The List" + movie.getRelease_date());
                    }
                } else {
                    Log.v("Tag", "Error " + response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<MovieSearchResponse> call, Throwable t) {

            }
        });
    }

    private void GetRetrofitResponseAccordingToID() {
        MovieApi movieApi = Servicey.getMovieApi();

        Call<MovieModel> responseCall = movieApi.getMovie(550, Credentials.API_KEY);

        responseCall.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                Log.e("Tag", Integer.toString(response.code()));
                if ( response.code() == 200) {
                    MovieModel movieModel = response.body();
                    Log.v("Tag", "the response " + movieModel.getTitle());
                } else {
                    Log.v("Tag", "Error " + response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {

            }
        });
    }
}