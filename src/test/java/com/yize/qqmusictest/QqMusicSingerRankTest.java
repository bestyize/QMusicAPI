package com.yize.qqmusictest;

import com.yize.qqmusic.model.base.Singer;
import com.yize.qqmusic.music.impl.QqMusicSingerRank;
import com.yize.qqmusic.util.GsonConverter;
import org.junit.Test;

import java.util.List;

public class QqMusicSingerRankTest {
    @Test
    public void getTopRankTest(){
        QqMusicSingerRank singerRank=new QqMusicSingerRank();
        List<Singer> singerList=singerRank.getTopRank(2);
        GsonConverter.printToJson(singerList);
    }
}
