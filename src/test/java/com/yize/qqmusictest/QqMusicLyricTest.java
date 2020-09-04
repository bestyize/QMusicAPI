package com.yize.qqmusictest;

import com.yize.qqmusic.model.base.Lyric;
import com.yize.qqmusic.music.module.lyric.QqMusicLyric;
import com.yize.qqmusic.util.GsonConverter;
import org.junit.Test;

public class QqMusicLyricTest {
    @Test
    public void test(){
        QqMusicLyric musicLyric=new QqMusicLyric();
        Lyric lyric=musicLyric.getLyricByMid("002imZ142vVoIL");
        GsonConverter.printToJson(lyric);
    }
}
