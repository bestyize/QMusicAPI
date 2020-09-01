package com.yize.qqmusic.model.base;

import com.google.gson.annotations.SerializedName;

public class Mv {
    @SerializedName("id")
    private String mvId;
    @SerializedName("vid")
    private String mvVid;
    @SerializedName("name")
    private String mvName;
    @SerializedName("id")
    private String mvTitle;

    public Mv() {
    }

    public Mv(String mvId, String mvVid, String mvName, String mvTitle) {
        this.mvId = mvId;
        this.mvVid = mvVid;
        this.mvName = mvName;
        this.mvTitle = mvTitle;
    }

    public String getMvId() {
        return mvId;
    }

    public void setMvId(String mvId) {
        this.mvId = mvId;
    }

    public String getMvVid() {
        return mvVid;
    }

    public void setMvVid(String mvVid) {
        this.mvVid = mvVid;
    }

    public String getMvName() {
        return mvName;
    }

    public void setMvName(String mvName) {
        this.mvName = mvName;
    }

    public String getMvTitle() {
        return mvTitle;
    }

    public void setMvTitle(String mvTitle) {
        this.mvTitle = mvTitle;
    }
}
