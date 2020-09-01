package com.yize.qqmusic.model.base;

public class Singer {
    public String singeId;
    public String singerMid;
    public String singerName;
    public String singPic;

    public Singer() {
    }

    public Singer(String singeId, String singerMid, String singerName, String singPic) {
        this.singeId = singeId;
        this.singerMid = singerMid;
        this.singerName = singerName;
        this.singPic = singPic;
    }

    public String getSingeId() {
        return singeId;
    }

    public void setSingeId(String singeId) {
        this.singeId = singeId;
    }

    public String getSingerMid() {
        return singerMid;
    }

    public void setSingerMid(String singerMid) {
        this.singerMid = singerMid;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getSingPic() {
        return singPic;
    }

    public void setSingPic(String singPic) {
        this.singPic = singPic;
    }

}
