package com.example.newmovies;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MovieDescription extends AppCompatActivity {

    @BindView(R.id.movie_title)
    TextView title;

    @BindView(R.id.movie_release)
    TextView release;

    @BindView(R.id.movie_description)
    TextView description;

    @BindView(R.id.movie_poster)
    ImageView poster;

    @BindView(R.id.rating)
    TextView ratingText;

    @BindView(R.id.movie_rating)
    RatingBar rating;

    private boolean isBookmarked = false;

    public MoviesApiService service;
    private Movie selectedMovie = new Movie();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_film_description);
        Intent i = getIntent();
        ButterKnife.bind(this);
        setMovieData(i);
    }

    public void setMovieData(Intent i) {
        Movie movie = (Movie) i.getSerializableExtra(this.getString(R.string.selected_movie));
        selectedMovie = movie;
        title.setText(movie.getTitle());
        release.setText(movie.getReleaseDate());
        description.setText(movie.getDescription());
        ratingText.setText(movie.getRating());
        rating.setRating(Float.parseFloat(movie.getRating()));
        rating.setRating(rating.getRating());
        Picasso.with(this)
                .load(movie.getPoster())
                .placeholder(R.color.colorAccent)
                .into(poster);
    }

}




