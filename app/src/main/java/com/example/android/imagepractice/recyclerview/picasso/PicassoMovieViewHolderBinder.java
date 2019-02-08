package com.example.android.imagepractice.recyclerview.picasso;

import com.example.android.imagepractice.R;
import com.example.android.imagepractice.model.Movie;
import com.example.android.imagepractice.recyclerview.basic.MovieViewHolder;
import com.example.android.imagepractice.recyclerview.basic.MovieViewHolderBinder;
import com.squareup.picasso.Picasso;

public class PicassoMovieViewHolderBinder extends MovieViewHolderBinder {

    public PicassoMovieViewHolderBinder(int downloadType, Movie movie) {
        super(downloadType, movie);
    }

    @Override
    public void bindViewHolder(MovieViewHolder holder) {
        PicassoMovieViewHolder viewHolder = (PicassoMovieViewHolder) holder;
        viewHolder.mTitle.setText(getMovie().getTitle());
        Picasso.get()
                .load(getMovie().getUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .into(viewHolder.mPoster);
        viewHolder.mPicassoTextView.setText(R.string.picasso);
    }
}
