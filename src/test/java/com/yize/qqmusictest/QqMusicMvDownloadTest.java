package com.yize.qqmusictest;

import com.yize.qqmusic.model.mv.MvBean;
import com.yize.qqmusic.music.impl.mv.QqMusicMvDownload;
import com.yize.qqmusic.util.GsonConverter;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class QqMusicMvDownloadTest {
    QqMusicMvDownload mvDownload=new QqMusicMvDownload();
    @Test
    public void testMvDownload(){

        MvBean mvBean=new MvBean();
        mvBean.setMvVid("w0026q7f01a");
        MvBean bean=mvDownload.getMvDownloadLink(mvBean);
        GsonConverter.printToJson(bean);
    }
    @Test
    public void testBatchDownload(){
        String mvVid="p0034nfuv2q,w0026q7f01a";
        String vids[]=mvVid.split(",");
        List<MvBean> mvBeanList=new LinkedList<>();
        for (String vid:vids){
            MvBean bean=new MvBean();
            bean.setMvVid(vid);
            mvBeanList.add(bean);
        }
        mvBeanList=mvDownload.getMvDownloadLink(mvBeanList);
        GsonConverter.printToJson(mvBeanList);
    }
}
