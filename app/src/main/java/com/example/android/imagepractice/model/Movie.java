package com.example.android.imagepractice.model;

import com.example.android.imagepractice.recyclerview.DownloadType;
import com.google.gson.annotations.SerializedName;

public class Movie {
    @SerializedName("Title")
    private String title;

    @SerializedName("Poster")
    private String url;

    private DownloadType downloadType;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public DownloadType getDownloadType() {
        return downloadType;
    }

    public void setDownloadType(DownloadType downloadType) {
        this.downloadType = downloadType;
    }
}
