package com.yize.qqmusictest;

import com.google.gson.annotations.SerializedName;
import com.yize.qqmusic.model.SongBean;
import com.yize.qqmusic.music.impl.QqMusicSingerProfile;
import com.yize.qqmusic.util.GsonConverter;
import org.junit.Test;

import java.util.List;

public class QqMusicSingerSongTest {
    private QqMusicSingerProfile helper=new QqMusicSingerProfile();
    @Test
    public void testGetSongBySingerMid(){
        String mid="0025NhlN2yWrP4";
        List<SongBean> songBeanList=helper.getSongBySingerMid(mid,0,100);
        GsonConverter.printToJson(songBeanList);
    }
}
