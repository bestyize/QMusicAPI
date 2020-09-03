package com.yize.qqmusic.model.mv;

import com.google.gson.annotations.SerializedName;
import com.yize.qqmusic.model.base.Mv;
import com.yize.qqmusic.model.base.Singer;

import java.util.List;

public class MvInfo extends Mv {
    @SerializedName(value = "singerList",alternate = "singers")
    List<Singer> singerList;

}
