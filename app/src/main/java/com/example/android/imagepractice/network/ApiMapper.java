package com.example.android.imagepractice.network;

import com.example.android.imagepractice.model.MovieResponse;

import retrofit2.Callback;

public class ApiMapper {

    private static final String API_KEY = "b94afd0";

    private RetrofitHelper retrofitHelper;

    public ApiMapper(RetrofitHelper retrofitHelper) {
        this.retrofitHelper = retrofitHelper;
    }

    public void getMovieAsync(String movieName, Callback<MovieResponse> callback) {
        retrofitHelper.getService().getMovie(API_KEY, movieName).enqueue(callback);
    }
}
