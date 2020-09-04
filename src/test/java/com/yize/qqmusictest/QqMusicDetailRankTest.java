package com.yize.qqmusictest;

import com.yize.qqmusic.model.rank.DetailRankBean;
import com.yize.qqmusic.music.module.rank.QqMusicDetailRank;
import com.yize.qqmusic.util.GsonConverter;
import org.junit.Test;

public class QqMusicDetailRankTest {
    QqMusicDetailRank qqMusicDetailRank =new QqMusicDetailRank();
    @Test
    public void testDetailAcq(){
        DetailRankBean detailRankBean= qqMusicDetailRank.getRankDetail(62,300,"2020-09-03");
        GsonConverter.printToJson(detailRankBean);
    }
}
