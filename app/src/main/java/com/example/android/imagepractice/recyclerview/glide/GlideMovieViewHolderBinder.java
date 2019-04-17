package com.example.android.imagepractice.recyclerview.glide;

import com.bumptech.glide.Glide;
import com.example.android.imagepractice.R;
import com.example.android.imagepractice.model.Movie;
import com.example.android.imagepractice.recyclerview.basic.MovieViewHolder;
import com.example.android.imagepractice.recyclerview.basic.MovieViewHolderBinder;

public class GlideMovieViewHolderBinder extends MovieViewHolderBinder {
    public GlideMovieViewHolderBinder(int downloadType, Movie movie) {
        super(downloadType, movie);
    }

    @Override
    public void bindViewHolder(MovieViewHolder holder) {
        GlideMovieViewHolder glideMovieViewHolder = (GlideMovieViewHolder) holder;
        glideMovieViewHolder.mTitle.setText(movie.getTitle());
        glideMovieViewHolder.mGlideTextView.setText(R.string.glide);
        Glide.with(holder.itemView.getContext())
                .load(movie.getUrl())
                .into(((GlideMovieViewHolder) holder).mPoster);
    }
}
