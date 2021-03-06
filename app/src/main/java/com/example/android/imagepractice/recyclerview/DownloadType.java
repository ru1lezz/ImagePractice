package com.example.android.imagepractice.recyclerview;

import java.util.Random;

public enum DownloadType {
    HTTP_URL_CONNECTION(0),
    PICASSO(1),
    GLIDE(2);

    int type;

    DownloadType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    private static final int LENGTH = values().length;
    private static final Random RANDOM = new Random();

    public static DownloadType getRandomType() {
        return values()[RANDOM.nextInt(LENGTH)];
    }
}
