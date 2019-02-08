package com.example.android.imagepractice.recyclerview.basic;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;


public abstract class MovieViewHolder extends RecyclerView.ViewHolder {
    protected MovieViewHolder(@NonNull View itemView) {
        super(itemView);
    }
}
