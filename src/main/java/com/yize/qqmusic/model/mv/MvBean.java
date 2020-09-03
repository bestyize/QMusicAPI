package com.yize.qqmusic.model.mv;

import com.google.gson.annotations.SerializedName;
import com.yize.qqmusic.model.base.MvFile;

import java.util.Map;

public class MvBean extends MvInfo{
    private Map<String, MvFile> downloadLinkMap;

    public Map<String, MvFile> getDownloadLinkMap() {
        return downloadLinkMap;
    }

    public void setDownloadLinkMap(Map<String, MvFile> downloadLinkMap) {
        this.downloadLinkMap = downloadLinkMap;
    }
}
