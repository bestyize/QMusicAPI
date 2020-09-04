package com.yize.qqmusictest;

import com.yize.qqmusic.model.SongBean;
import com.yize.qqmusic.music.module.searchdown.QqMusicDownload;
import com.yize.qqmusic.music.module.singer.QqMusicSingerProfile;
import com.yize.qqmusic.util.GsonConverter;
import org.junit.Test;

import java.util.List;

public class QqMusicSingerSongTest {
    private QqMusicSingerProfile helper=new QqMusicSingerProfile();
    @Test
    public void testGetSongBySingerMid(){
        String mid="0025NhlN2yWrP4";
        List<SongBean> songBeanList=helper.getSongBySingerMid(mid,101,200);
        QqMusicDownload.getDownloadLinkBySongIdList(songBeanList);
        GsonConverter.printToJson(songBeanList);
    }
}
