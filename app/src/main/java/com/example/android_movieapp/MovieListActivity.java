package com.example.android_movieapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_movieapp.adapters.MovieRecyclerView;
import com.example.android_movieapp.adapters.OnMovieListener;
import com.example.android_movieapp.models.MovieModel;
import com.example.android_movieapp.viewmodels.MovieListViewModel;

import java.util.List;

public class MovieListActivity extends AppCompatActivity implements OnMovieListener {

    // RecyclerView
    private RecyclerView recyclerView;
    private MovieRecyclerView movieRecyclerAdapter;

    // ViewModel
    private MovieListViewModel movieListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recyclerView);

        movieListViewModel = new ViewModelProvider(this).get(MovieListViewModel.class);

        ConfigureRecyclerView();
        // Calling the Observers
        ObserveAnyChange();
        searchMovieApi("fast", 1);

    }

    // Observing any data change
    private void ObserveAnyChange() {
        movieListViewModel.getMovies().observe(this, new Observer<List<MovieModel>>() {
            @Override
            public void onChanged(List<MovieModel> movieModels) {
                // Observing for any data change
                if ( movieModels != null) {
                    for (MovieModel movieModel : movieModels) {
                        // Get the data in the log
                        Log.v("Tag", "OnChanged: " + movieModel.getTitle());
                        movieRecyclerAdapter.setmMovies(movieModels);
                    }
                }
            }
        });
    }


    // 4 = calling method in main activity
    private void searchMovieApi(String query, int pageNumber) {
        movieListViewModel.searchMovieApi(query, pageNumber);
    }

    // 5 - Initializing recyclerView
    private void ConfigureRecyclerView() {
        // LiveData can be passed view the constructor
        movieRecyclerAdapter = new MovieRecyclerView( this);

        recyclerView.setAdapter(movieRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onMovieClick(int position) {
        Toast.makeText(this, "The Position " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCategoryClick(String category) {

    }

    //    private void GetUser() {
//        BraveApi braveApi = Servicey.getBraveApi();
//
//        Call<User> responseCall = braveApi.getUser("1");
//
//
//        responseCall.enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//                Log.e("Tag", Integer.toString(response.code()));
//                if ( response.code() == 200) {
//                    Log.v("Tag", "the response " + response.body().toString());
//                    Log.v("RESULT", response.body().getFirstName());
//                } else {
//                    Log.v("Tag", "Error " + response.errorBody().toString());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//                Log.e("Nightmare", "Failed connecting " + call.request().url());
//                t.printStackTrace();
//            }
//        });
//    }
//
//    private void GetRetrofitResponse() {
//        MovieApi movieApi = Servicey.getMovieApi();
//
//        Call<MovieSearchResponse> responseCall = movieApi
//                .searchMovie(
//                        Credentials.API_KEY,
//                        "Jack Reacher",
//                        1
//                );
//
//        responseCall.enqueue(new Callback<MovieSearchResponse>() {
//            @Override
//            public void onResponse(Call<MovieSearchResponse> call, Response<MovieSearchResponse> response) {
//                Log.e("Tag", Integer.toString(response.code()));
//                if ( response.code() == 200) {
//                    Log.v("Tag", "the response " + response.body().toString());
//                    List<MovieModel> movies = new ArrayList<>(response.body().getMovies());
//                    for (MovieModel movie : movies) {
//                        Log.v("Tag", "The List" + movie.getRelease_date());
//                    }
//                } else {
//                    Log.v("Tag", "Error " + response.errorBody().toString());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<MovieSearchResponse> call, Throwable t) {
//
//            }
//        });
//    }
//
//    private void GetRetrofitResponseAccordingToID() {
//        MovieApi movieApi = Servicey.getMovieApi();
//
//        Call<MovieModel> responseCall = movieApi.getMovie(550, Credentials.API_KEY);
//
//        responseCall.enqueue(new Callback<MovieModel>() {
//            @Override
//            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
//                Log.e("Tag", Integer.toString(response.code()));
//                if ( response.code() == 200) {
//                    MovieModel movieModel = response.body();
//                    Log.v("Tag", "the response " + movieModel.getTitle());
//                } else {
//                    Log.v("Tag", "Error " + response.errorBody().toString());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<MovieModel> call, Throwable t) {
//
//            }
//        });
//    }

}