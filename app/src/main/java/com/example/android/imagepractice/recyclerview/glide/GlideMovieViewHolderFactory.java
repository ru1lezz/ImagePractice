package com.example.android.imagepractice.recyclerview.glide;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.imagepractice.R;
import com.example.android.imagepractice.recyclerview.basic.MovieViewHolder;
import com.example.android.imagepractice.recyclerview.basic.MovieViewHolderFactory;

public class GlideMovieViewHolderFactory implements MovieViewHolderFactory {
    @Override
    public MovieViewHolder createViewHolder(ViewGroup parent, LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.movie_item, parent, false);
        return new GlideMovieViewHolder(view);
    }
}
