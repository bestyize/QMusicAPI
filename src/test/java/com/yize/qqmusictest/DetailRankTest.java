package com.yize.qqmusictest;

import com.yize.qqmusic.model.rank.DetailRankBean;
import com.yize.qqmusic.music.impl.rank.DetailRank;
import com.yize.qqmusic.util.GsonConverter;
import org.junit.Test;

public class DetailRankTest {
    DetailRank detailRank=new DetailRank();
    @Test
    public void testDetailAcq(){
        DetailRankBean detailRankBean=detailRank.getRankDetail(62,300,"2020-09-02");
        GsonConverter.printToJson(detailRankBean);
    }
}
