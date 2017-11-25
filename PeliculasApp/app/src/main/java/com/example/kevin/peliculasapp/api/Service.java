package com.example.kevin.peliculasapp.api;

import com.example.kevin.peliculasapp.model.MoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Kevin on 22/11/2017.
 */

public interface Service {

    @GET("movie/popular?api_key=1732d79af63f747d3fc73f04a0a7185f")
    Call<MoviesResponse> getPopularMovies();

    @GET("movie/top_rated?api_key=1732d79af63f747d3fc73f04a0a7185f")
    Call<MoviesResponse> getTopRatedMovies();
}

