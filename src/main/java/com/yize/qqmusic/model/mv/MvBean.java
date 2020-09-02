package com.yize.qqmusic.model.mv;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class MvBean {
    @SerializedName(value = "mvMap",alternate = "data")
    private Map<String,MvInfo> mvMap;

    public Map<String, MvInfo> getMvMap() {
        return mvMap;
    }

    public void setMvMap(Map<String, MvInfo> mvMap) {
        this.mvMap = mvMap;
    }
}
