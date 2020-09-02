package com.yize.qqmusic.model.base;

import com.google.gson.annotations.SerializedName;

public class Pay {
    @SerializedName(value = "payAlbum",alternate = {"pay_album"})
    public int payAlbum;
    @SerializedName(value = "payAlbumPrice",alternate = {"price_album"})
    public int payAlbumPrice;
    @SerializedName(value = "payDownload",alternate = {"pay_down"})
    public int payDownload;
    @SerializedName(value = "payInfo",alternate = {"pay_state"})
    public int payInfo;
    @SerializedName(value = "payPlay",alternate = {"pay_play"})
    public int payPlay;

    public Pay() {
    }

    public Pay(int payAlbum, int payAlbumPrice, int payDownload, int payInfo, int payPlay) {
        this.payAlbum = payAlbum;
        this.payAlbumPrice = payAlbumPrice;
        this.payDownload = payDownload;
        this.payInfo = payInfo;
        this.payPlay = payPlay;
    }

    public int getPayAlbum() {
        return payAlbum;
    }

    public void setPayAlbum(int payAlbum) {
        this.payAlbum = payAlbum;
    }

    public int getPayAlbumPrice() {
        return payAlbumPrice;
    }

    public void setPayAlbumPrice(int payAlbumPrice) {
        this.payAlbumPrice = payAlbumPrice;
    }

    public int getPayDownload() {
        return payDownload;
    }

    public void setPayDownload(int payDownload) {
        this.payDownload = payDownload;
    }

    public int getPayInfo() {
        return payInfo;
    }

    public void setPayInfo(int payInfo) {
        this.payInfo = payInfo;
    }

    public int getPayPlay() {
        return payPlay;
    }

    public void setPayPlay(int payPlay) {
        this.payPlay = payPlay;
    }
}
