package com.yize.qqmusic.model.base;

import com.google.gson.annotations.SerializedName;

public class Album {
    @SerializedName("id")
    public String albumId;
    @SerializedName("mid")
    public String albumMid;
    @SerializedName("name")
    public String albumName;
    @SerializedName("time_public")
    public String timePublish;

    public Album() {
    }

    public Album(String albumId, String albumMid, String albumName) {
        this.albumId = albumId;
        this.albumMid = albumMid;
        this.albumName = albumName;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getAlbumMid() {
        return albumMid;
    }

    public void setAlbumMid(String albumMid) {
        this.albumMid = albumMid;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getTimePublish() {
        return timePublish;
    }

    public void setTimePublish(String timePublish) {
        this.timePublish = timePublish;
    }
}
