package com.example.android.imagepractice.recyclerview.basic;

import android.support.v7.widget.RecyclerView;

import com.example.android.imagepractice.model.Movie;

public abstract class MovieViewHolderBinder {

    protected final int downloadType;
    protected final Movie movie;

    public MovieViewHolderBinder(int downloadType, Movie movie) {
        this.downloadType = downloadType;
        this.movie = movie;
    }

    public abstract void bindViewHolder(MovieViewHolder holder);

    public Movie getMovie() {return movie;}
}
