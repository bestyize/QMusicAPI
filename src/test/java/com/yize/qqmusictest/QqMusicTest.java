package com.yize.qqmusictest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yize.qqmusic.model.SongBean;
import com.yize.qqmusic.music.MusicHelper;
import com.yize.qqmusic.music.impl.searchdown.QqMusic;
import com.yize.qqmusic.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;

public class QqMusicTest {
    private static final Logger logger= LogManager.getLogger(QqMusicTest.class);
    @Test
    public void testSearchMusicByKeyWord(){
        String keyword="十年";
        int num=10;
        MusicHelper helper=new QqMusic();
        List<SongBean> songBeanList=helper.searchMusic(keyword,num);
        Gson gson= new GsonBuilder().disableHtmlEscaping().create();
        System.out.println(gson.toJson(songBeanList));
    }
    @Test
    public void testsearchDownloadLink(){
        MusicHelper helper=new QqMusic();
        SongBean bean=new SongBean("QQ","001OyHbk2MSIi4");
        helper.searchDownloadLink(bean,"SQ");
        Gson gson= new GsonBuilder().disableHtmlEscaping().create();
        System.out.println(gson.toJson(bean));
    }
    @Test
    public void testsearchDownloadLinks() throws UnsupportedEncodingException {
        MusicHelper helper=new QqMusic();
        List<SongBean> infos=new LinkedList<>();
        infos.add(new SongBean("QQ","001OyHbk2MSIi4","SQ"));
        infos.add(new SongBean("QQ","001OyHbk2MSIi4","HQ"));
        infos.add(new SongBean("QQ","001OyHbk2MSIi4","PQ"));
        infos.add(new SongBean("QQ","001OyHbk2MSIi4","LQ"));

        infos.add(new SongBean("QQ","003e4b5o0jOMXV","SQ"));
        infos.add(new SongBean("QQ","000PkZXC11iZUC","PQ"));
        Gson gson= new GsonBuilder().disableHtmlEscaping().create();
        System.out.println(Base64Converter.encode(gson.toJson(infos)));

        //helper.searchDownloadLink(infos);

        System.out.println(gson.toJson(infos));

    }

    @Test
    public void testSearchAndDownload(){
        String keyword="陈奕迅";
        int num=10;
        MusicHelper helper=new QqMusic();
        List<SongBean> songBeanList=helper.searchMusic(keyword,num);
        for (SongBean bean:songBeanList){
            helper.searchDownloadLink(bean, bean.getQuality());
        }
        GsonConverter.printToJson(songBeanList);
    }
    @Test
    public void testSearchWithDownload(){
        String keyword="周杰伦";
        int num=10;
        MusicHelper helper=new QqMusic();
        List<SongBean> songBeanList=helper.searchWithDownload(keyword,num);
        GsonConverter.printToJson(songBeanList);
    }



}
