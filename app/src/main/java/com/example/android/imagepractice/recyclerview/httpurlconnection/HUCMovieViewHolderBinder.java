package com.example.android.imagepractice.recyclerview.httpurlconnection;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;

import com.example.android.imagepractice.R;
import com.example.android.imagepractice.model.Movie;
import com.example.android.imagepractice.recyclerview.basic.MovieViewHolder;
import com.example.android.imagepractice.recyclerview.basic.MovieViewHolderBinder;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HUCMovieViewHolderBinder extends MovieViewHolderBinder {

    private Handler mHandler;
    private ExecutorService executorService;

    public HUCMovieViewHolderBinder(int downloadType, Movie mMovie) {
        super(downloadType, mMovie);
        mHandler = new Handler(Looper.getMainLooper());
        executorService = Executors.newSingleThreadExecutor();
    }

    @Override
    public void bindViewHolder(MovieViewHolder holder) {
        HUCMovieViewHolder viewHolder = (HUCMovieViewHolder) holder;
        viewHolder.mTitle.setText(getMovie().getTitle());
        setImage(viewHolder);
        viewHolder.mHttpUrlConnectionTextView.setText(R.string.http_url_connection);
    }

    private void setImage(HUCMovieViewHolder viewHolder) {
        executorService.execute(() -> {
            Bitmap image = getImage(getMovie().getUrl());
            mHandler.post(() -> viewHolder.mPoster
                    .setImageBitmap(image));
        });
    }

    private Bitmap getImage(String imageUrl) {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(imageUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            int responseCode = connection.getResponseCode();
            if(responseCode == 200) {
                return BitmapFactory.decodeStream(connection.getInputStream());
            } else {
                return null;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
