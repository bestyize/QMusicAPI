package com.yize.qqmusic.model.base;

public class MvFile {
    public String fileMid;
    public String quality;
    public long size;
    public long duration;
    public String type;
    public String downloadLink;

    public MvFile() {
    }

    public MvFile(String fileMid, String quality, long size, long duration, String type, String downloadLink) {
        this.fileMid = fileMid;
        this.quality = quality;
        this.size = size;
        this.duration = duration;
        this.type = type;
        this.downloadLink = downloadLink;
    }

    public String getFileMid() {
        return fileMid;
    }

    public void setFileMid(String fileMid) {
        this.fileMid = fileMid;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDownloadLink() {
        return downloadLink;
    }

    public void setDownloadLink(String downloadLink) {
        this.downloadLink = downloadLink;
    }
}
