package com.example.android.imagepractice.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.example.android.imagepractice.model.Movie;
import com.example.android.imagepractice.recyclerview.basic.MovieViewHolder;
import com.example.android.imagepractice.recyclerview.basic.MovieViewHolderBinder;
import com.example.android.imagepractice.recyclerview.basic.MovieViewHolderFactory;
import com.example.android.imagepractice.recyclerview.glide.GlideMovieViewHolderBinder;
import com.example.android.imagepractice.recyclerview.glide.GlideMovieViewHolderFactory;
import com.example.android.imagepractice.recyclerview.httpurlconnection.HUCMovieHolderFactory;
import com.example.android.imagepractice.recyclerview.httpurlconnection.HUCMovieViewHolderBinder;
import com.example.android.imagepractice.recyclerview.picasso.PicassoMovieViewHolderBinder;
import com.example.android.imagepractice.recyclerview.picasso.PicassoMovieViewHolderFactory;
import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {
    private final List<MovieViewHolderBinder> mBinders;
    private SparseArray<MovieViewHolderFactory> mFactoryMap;

    public MovieAdapter() {
        mBinders = new ArrayList<>();
        initFactory();
    }

    private void initFactory() {
        mFactoryMap = new SparseArray<>();
        mFactoryMap.put(DownloadType.HTTP_URL_CONNECTION.type, new HUCMovieHolderFactory());
        mFactoryMap.put(DownloadType.PICASSO.type, new PicassoMovieViewHolderFactory());
        mFactoryMap.put(DownloadType.GLIDE.type, new GlideMovieViewHolderFactory());
    }

    public void setMovies(List<Movie> movies) {
        mBinders.clear();
        for(Movie movie : movies) {
            movie.setDownloadType(DownloadType.getRandomType());
            mBinders.add(generateBinder(movie));
        }
        notifyDataSetChanged();
    }

    private MovieViewHolderBinder generateBinder(Movie movie) {
        if(movie.getDownloadType().type == DownloadType.HTTP_URL_CONNECTION.type) {
            return new HUCMovieViewHolderBinder(movie.getDownloadType().getType(), movie);
        } else if(movie.getDownloadType().type == DownloadType.PICASSO.type) {
            return new PicassoMovieViewHolderBinder(movie.getDownloadType().getType(), movie);
        } else if(movie.getDownloadType().type == DownloadType.GLIDE.type) {
            return new GlideMovieViewHolderBinder(movie.getDownloadType().type, movie);
        }
        return null;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        MovieViewHolderFactory factory = mFactoryMap.get(i);
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        return factory.createViewHolder(viewGroup, inflater);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder movieViewHolder, int i) {
        MovieViewHolderBinder binder = mBinders.get(i);
        binder.bindViewHolder(movieViewHolder);
    }

    @Override
    public int getItemCount() {
        return mBinders.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mBinders.get(position).getMovie().getDownloadType().type;
    }
}
