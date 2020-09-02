package com.yize.qqmusictest;

import com.yize.qqmusic.model.rank.MainRankBean;
import com.yize.qqmusic.music.impl.rank.QqMusicMainRank;
import com.yize.qqmusic.util.GsonConverter;
import org.junit.Test;

public class QqMusicMainRankTest {
    @Test
    public void testGetMainRank(){
        QqMusicMainRank qqMusicMainRank =new QqMusicMainRank();
        MainRankBean rankBean= qqMusicMainRank.getMainRank();
        GsonConverter.printToJson(rankBean);
    }
}
