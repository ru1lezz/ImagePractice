package com.example.android.imagepractice.network;

import com.example.android.imagepractice.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieService {
    @GET("?")
    Call<MovieResponse> getMovie(@Query("apikey") String apiKey, @Query("s") String movieName);
}
