package com.yize.qqmusic.model.base;

public class Lyric {
    public String lyricId;
    public String lyricName;

    public Lyric() {
    }

    public Lyric(String lyricId, String lyricName) {
        this.lyricId = lyricId;
        this.lyricName = lyricName;
    }

    public String getLyricId() {
        return lyricId;
    }

    public void setLyricId(String lyricId) {
        this.lyricId = lyricId;
    }

    public String getLyricName() {
        return lyricName;
    }

    public void setLyricName(String lyricName) {
        this.lyricName = lyricName;
    }
}
