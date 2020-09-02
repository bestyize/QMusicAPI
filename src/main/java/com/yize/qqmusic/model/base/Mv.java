package com.yize.qqmusic.model.base;

import com.google.gson.annotations.SerializedName;
import sun.dc.pr.PRError;

public class Mv {
    @SerializedName(value = "mvId",alternate = {"id"})
    private String mvId;
    @SerializedName(value = "mvVid",alternate = {"vid"})
    private String mvVid;
    @SerializedName(value = "mvName",alternate = {"name"})
    private String mvName;
    @SerializedName(value = "mvTitle",alternate = {"title"})
    private String mvTitle;
    @SerializedName(value ="playCount",alternate = "playcnt")
    private int playCount;
    @SerializedName(value ="coverPic",alternate = "cover_pic_medium")
    private String coverPic;

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

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public String getCoverPic() {
        return coverPic==null?null:coverPic.replaceAll("\\\\","");
    }

    public void setCoverPic(String coverPic) {
        this.coverPic = coverPic;
    }
}
