package com.example.android.imagepractice.recyclerview.glide;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.imagepractice.R;
import com.example.android.imagepractice.recyclerview.basic.MovieViewHolder;

public class GlideMovieViewHolder extends MovieViewHolder {

    TextView mTitle;
    ImageView mPoster;
    TextView mGlideTextView;

    protected GlideMovieViewHolder(@NonNull View itemView) {
        super(itemView);
        mTitle = itemView.findViewById(R.id.title_text_view);
        mPoster = itemView.findViewById(R.id.poster_image_view);
        mGlideTextView = itemView.findViewById(R.id.download_type_text_view);
    }
}
