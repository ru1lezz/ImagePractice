package com.example.android.imagepractice.recyclerview.picasso;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.android.imagepractice.R;
import com.example.android.imagepractice.recyclerview.basic.MovieViewHolder;
import com.example.android.imagepractice.recyclerview.basic.MovieViewHolderFactory;

public class PicassoMovieViewHolderFactory implements MovieViewHolderFactory {
    @Override
    public MovieViewHolder createViewHolder(ViewGroup parent, LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.movie_item, parent, false);
        return new PicassoMovieViewHolder(view);
    }
}
