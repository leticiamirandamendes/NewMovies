package com.example.newmovies;

import retrofit.Callback;
import retrofit.http.GET;

public interface MoviesApiService {
    @GET("/movie/upcoming")
    void getPopularMovies(Callback<Movie.MovieResult> cb);
}
