package com.yize.qqmusic.model.base;

public class Lyric {
    public String lyricId;
    public String lyricName;
    public String lyricText;
    public String lyricTextTrans;
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

    public String getLyricText() {
        return lyricText;
    }

    public void setLyricText(String lyricText) {
        this.lyricText = lyricText;
    }

    public String getLyricTextTrans() {
        return lyricTextTrans;
    }

    public void setLyricTextTrans(String lyricTextTrans) {
        this.lyricTextTrans = lyricTextTrans;
    }
}
