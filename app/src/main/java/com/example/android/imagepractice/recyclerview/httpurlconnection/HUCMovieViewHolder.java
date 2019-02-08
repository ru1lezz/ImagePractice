package com.example.android.imagepractice.recyclerview.httpurlconnection;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.imagepractice.R;
import com.example.android.imagepractice.recyclerview.basic.MovieViewHolder;

public class HUCMovieViewHolder extends MovieViewHolder {

    TextView mTitle;
    ImageView mPoster;
    TextView mHttpUrlConnectionTextView;

    HUCMovieViewHolder(@NonNull View itemView) {
        super(itemView);
        mTitle = itemView.findViewById(R.id.title_text_view);
        mPoster = itemView.findViewById(R.id.poster_image_view);
        mHttpUrlConnectionTextView = itemView.findViewById(R.id.download_type_text_view);
    }
}
