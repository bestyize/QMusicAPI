package com.yize.qqmusic.music.module.searchdown;

import com.yize.qqmusic.model.SongBean;
import com.yize.qqmusic.music.MusicHelper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

import static com.yize.qqmusic.model.SongUtils.*;
import static com.yize.qqmusic.model.SongUtils.QUALITY_LQ;
import static com.yize.qqmusic.music.module.searchdown.QqMusicDownload.getDownloadLinkBySongId;
import static com.yize.qqmusic.music.module.searchdown.QqMusicDownload.getDownloadLinkBySongIdList;
import static com.yize.qqmusic.music.module.searchdown.QqMusicSearch.qqSearchRequest;
import static com.yize.qqmusic.music.module.searchdown.QqMusicSearch.qqSongSearchRespProcess;

public class QqMusic implements MusicHelper {
    private static final Logger logger= LogManager.getLogger(QqMusic.class);
    public static final HashMap<String, String> qualityMap;
    public static final HashMap<String, String> qualityFileTypeMap ;
    public static final String baseDownloadServer="http://ws.stream.qqmusic.qq.com/";

    static {
        qualityMap=new HashMap<>();
        qualityMap.put(QUALITY_SQ,"F000songid.flac");
        qualityMap.put(QUALITY_HQ,"M800songid.mp3");
        qualityMap.put(QUALITY_PQ,"M500songid.mp3");
        qualityMap.put(QUALITY_LQ,"C400songid.m4a");
        qualityFileTypeMap=new HashMap<>();
        qualityFileTypeMap.put(QUALITY_SQ,"flac");
        qualityFileTypeMap.put(QUALITY_HQ,"mp3");
        qualityFileTypeMap.put(QUALITY_PQ,"mp3");
        qualityFileTypeMap.put(QUALITY_LQ,"m4a");
    }

    @Override
    public List<SongBean> searchMusic(String keyword, int num) {
        String response=qqSearchRequest(keyword,num);
        return qqSongSearchRespProcess(response);
    }

    @Override
    public SongBean searchDownloadLink(SongBean songBean,String quality) {
        String downloadLink=getDownloadLinkBySongId(songBean.getSongMid(),quality);
        songBean.getDownloadLinkMap().get(quality).setDownloadLink(downloadLink);
        return songBean;
    }

    @Override
    public List<SongBean> searchDownloadLink(List<SongBean> downloadInfoList) {
        //List<DownloadInfo> downloadInfoList
        return getDownloadLinkBySongIdList(downloadInfoList);
    }

    @Override
    public List<SongBean> searchWithDownload(String keyword, int num) {
        List<SongBean> songBeanList=searchMusic(keyword,num);
        for (SongBean bean:songBeanList){
            searchDownloadLink(bean,QUALITY_SQ);
            searchDownloadLink(bean,QUALITY_HQ);
            searchDownloadLink(bean,QUALITY_LQ);
            searchDownloadLink(bean,QUALITY_PQ);
        }
        return songBeanList;
    }





}
