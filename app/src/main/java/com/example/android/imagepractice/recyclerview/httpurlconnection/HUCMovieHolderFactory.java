package com.example.android.imagepractice.recyclerview.httpurlconnection;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.imagepractice.R;
import com.example.android.imagepractice.recyclerview.basic.MovieViewHolder;
import com.example.android.imagepractice.recyclerview.basic.MovieViewHolderFactory;

public class HUCMovieHolderFactory implements MovieViewHolderFactory {
    @Override
    public MovieViewHolder createViewHolder(ViewGroup parent, LayoutInflater inflater) {
        View itemView = inflater.inflate(R.layout.movie_item, parent, false);
        MovieViewHolder holder = new HUCMovieViewHolder(itemView);
        return holder;
    }
}
