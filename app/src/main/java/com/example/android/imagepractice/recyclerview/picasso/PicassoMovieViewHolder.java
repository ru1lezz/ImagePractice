package com.example.android.imagepractice.recyclerview.picasso;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.imagepractice.R;
import com.example.android.imagepractice.recyclerview.basic.MovieViewHolder;

public class PicassoMovieViewHolder extends MovieViewHolder {

    TextView mTitle;
    ImageView mPoster;
    TextView mPicassoTextView;

    PicassoMovieViewHolder(@NonNull View itemView) {
        super(itemView);
        mTitle = itemView.findViewById(R.id.title_text_view);
        mPoster = itemView.findViewById(R.id.poster_image_view);
        mPicassoTextView = itemView.findViewById(R.id.download_type_text_view);
    }
}
