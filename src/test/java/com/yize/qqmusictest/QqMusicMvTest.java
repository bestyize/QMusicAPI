package com.yize.qqmusictest;

import com.yize.qqmusic.model.mv.MvInfo;
import com.yize.qqmusic.music.impl.mv.QqMusicMv;
import com.yize.qqmusic.music.impl.searchdown.QqMusic;
import com.yize.qqmusic.util.GsonConverter;
import org.junit.Test;

public class QqMusicMvTest {
    @Test
    public void test1(){
        QqMusicMv qqMusicMv=new QqMusicMv();
        MvInfo info=qqMusicMv.getMvInfoByVid("w0026q7f01a");
        GsonConverter.printToJson(info);
    }
}
