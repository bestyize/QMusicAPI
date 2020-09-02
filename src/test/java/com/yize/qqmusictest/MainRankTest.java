package com.yize.qqmusictest;

import com.yize.qqmusic.model.rank.MainRankBean;
import com.yize.qqmusic.music.impl.rank.MainRank;
import com.yize.qqmusic.util.GsonConverter;
import org.junit.Test;

public class MainRankTest {
    @Test
    public void testGetMainRank(){
        MainRank mainRank=new MainRank();
        MainRankBean rankBean=mainRank.getMainRank();
        GsonConverter.printToJson(rankBean);
    }
}
