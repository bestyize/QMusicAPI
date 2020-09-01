package com.yize.qqmusic.model;

import com.google.gson.annotations.SerializedName;
import com.yize.qqmusic.model.base.RankSong;

import java.util.List;

public class DetailRankBean {
    @SerializedName("data")
    List<RankSong> rankSongList;
}
