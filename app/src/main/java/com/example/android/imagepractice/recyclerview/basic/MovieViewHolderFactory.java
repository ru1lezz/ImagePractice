package com.example.android.imagepractice.recyclerview.basic;

import android.view.LayoutInflater;
import android.view.ViewGroup;

public interface MovieViewHolderFactory {

    /**
     * Метод создания конкретного MovieViewHolder
     *
     * @param parent родительский view
     * @param inflater {@link LayoutInflater} для получения view из xml
     * @return готовый обЪект класса {@link MovieViewHolder}
     */
    MovieViewHolder createViewHolder(ViewGroup parent, LayoutInflater inflater);
}
