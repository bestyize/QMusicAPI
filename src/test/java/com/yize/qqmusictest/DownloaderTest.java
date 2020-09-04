package com.yize.qqmusictest;

import com.yize.qqmusic.local.download.DownloadItem;
import com.yize.qqmusic.local.download.Downloader;
import com.yize.qqmusic.model.SongBean;
import com.yize.qqmusic.model.base.SongFile;
import com.yize.qqmusic.music.MusicHelper;
import com.yize.qqmusic.music.module.searchdown.QqMusic;
import com.yize.qqmusic.music.module.searchdown.QqMusicDownload;
import com.yize.qqmusic.music.module.singer.QqMusicSingerProfile;
import com.yize.qqmusic.util.GsonConverter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.List;

import static com.yize.qqmusic.common.CommonConfig.qualityFileTypeMap;
import static com.yize.qqmusic.common.CommonConfig.qualityMap;

public class DownloaderTest {
    private static final Logger logger= LogManager.getLogger(DownloaderTest.class);
    private QqMusicSingerProfile singerProfile=new QqMusicSingerProfile();
    private MusicHelper helper=new QqMusic();
    private Downloader downloader=new Downloader();
    @Test
    public void testDownload(){
        String mid="0025NhlN2yWrP4";
        int num=10;

        List<SongBean> songBeanList=singerProfile.getSongBySingerMid(mid,0,2);

        GsonConverter.printToJson(songBeanList);
        for (SongBean bean:songBeanList){
            helper.searchDownloadLink(bean, bean.getQuality());
        }

        for (SongBean bean:songBeanList){
            SongFile songFile=bean.getDownloadLinkMap().get(bean.getQuality());
            String saveFileName= bean.getSongName()+"_"+
                    bean.getSingerList().get(0).getSingerName()+
                    "_"+bean.getAlbum().getAlbumName()+
                    "_"+bean.getSongMid()+
                    "_"+bean.getQuality()+
                    "."+qualityFileTypeMap.get(bean.getQuality());
            DownloadItem item=new DownloadItem(songFile.getDownloadLink(),
                    saveFileName,
                    songFile.getSize(),
                    0);
            if(bean.getPay().getPayAlbum()==0){
                downloader.startDownload(item);
            }else {
                logger.info("需要付费下载");
            }

        }
        GsonConverter.printToJson(songBeanList);
        //QqMusicDownload.getDownloadLinkBySongIdList(songBeanList);
    }
}
