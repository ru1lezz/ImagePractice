package com.example.android.imagepractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.android.imagepractice.model.Movie;
import com.example.android.imagepractice.model.MovieResponse;
import com.example.android.imagepractice.network.ApiMapper;
import com.example.android.imagepractice.network.RetrofitHelper;
import com.example.android.imagepractice.recyclerview.MovieAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MovieAdapter mAdapter;
    private ApiMapper mApiMapper;
    private List<Movie> movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mApiMapper = new ApiMapper(new RetrofitHelper());
        mAdapter = new MovieAdapter();
        mRecyclerView = findViewById(R.id.recycler_view);
        initRecyclerView();
        movieList = new ArrayList<>();
    }

    private void initRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mApiMapper.getMovieAsync("Avengers", new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if(response.isSuccessful()) {
                    MovieResponse movieResponse = response.body();
                    movieList.clear();
                    movieList.addAll(movieResponse.getMovieList());
                    mAdapter.setMovies(movieList);
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.v("MainActivity", "onFailure: " + t.getMessage());
            }
        });
    }
}
