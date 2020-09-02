package com.yize.qqmusic.model.rank;

import com.google.gson.annotations.SerializedName;
import com.yize.qqmusic.model.SongBean;

import java.util.List;

public class DetailRankBean {
    private int code;
    @SerializedName(value = "topRank",alternate = {"data"})
    private TopRank topRank;
    @SerializedName(value = "songList",alternate = {"songInfoList"})
    private List<SongBean> songList;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public TopRank getTopRank() {
        return topRank;
    }

    public void setTopRank(TopRank topRank) {
        this.topRank = topRank;
    }

    public List<SongBean> getSongList() {
        return songList;
    }

    public void setSongList(List<SongBean> songList) {
        this.songList = songList;
    }
}
