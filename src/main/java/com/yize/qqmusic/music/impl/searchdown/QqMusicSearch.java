package com.yize.qqmusic.music.impl.searchdown;

import com.google.gson.annotations.SerializedName;
import com.yize.qqmusic.model.SongBean;
import com.yize.qqmusic.model.base.*;
import com.yize.qqmusic.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static com.yize.qqmusic.model.SongUtils.*;
import static com.yize.qqmusic.model.SongUtils.QUALITY_LQ;
import static com.yize.qqmusic.music.impl.searchdown.QqMusic.qualityFileTypeMap;

public class QqMusicSearch {

    private static final Logger logger= LogManager.getLogger(QqMusicSearch.class);
    public static String qqSearchRequest(String keyword, int num){
        String response="";
        try {
            String link="https://c.y.qq.com/soso/fcgi-bin/client_search_cp?p=1&n="+num+"&w="+ URLEncoder.encode(keyword,"utf-8") +"&format=json";
            Map<String,String> headerMap=new HashMap<>();
            headerMap.put("User-Agent",USER_AGENT_ANDROID);
            response=HttpRequestHelper.downloadWebSiteUseGet(link,headerMap);
        }catch (Exception e){
            logger.error("encode failed");
        }
        return response;

    }
    /**
     *        this.songSrc = songSrc;
     *         this.songId = songId;
     *         this.songName = songName;
     *         this.singersName = singersName;
     *         this.albumName = albumName;
     *         this.quality=quality;
     *         this.picUrl = picUrl;
     *         this.lrcUrl = lrcUrl;
     *         this.mvUrl = mvUrl;
     * @param response
     * @return
     */
    public static List<SongBean> qqSongSearchRespProcess(String response) {
        List<SongBean> list = new LinkedList<>();
        if (response.length() == 0) {
            return list;
        }
        try {
            SearchResponseBean searchResponseBean= GsonConverter.fromJson(response, SearchResponseBean.class);
            if(searchResponseBean.getCode()==0){
                List<SearchResponseBean.Data.Song.SongDetail> songDetailList=searchResponseBean.data.song.songDetailList;
                for (SearchResponseBean.Data.Song.SongDetail detail:songDetailList){
                    SongBean songBean=new SongBean(SRC_QQ,
                            detail.getSongId(),
                            detail.getSongMid(),
                            detail.getSongName(),
                            detail.getPublishTime(),
                            parsePay(detail),
                            parseLyric(detail),
                            parseSingerList(detail.getSingers()),
                            parseAlbum(detail),
                            detail.getSqSize()>0?QUALITY_SQ:QUALITY_HQ,
                            "",
                            parseMv(detail),
                            parseDownloadLinkMap(detail));
                    list.add(songBean);
                }
            }
        }catch (Exception ignored){

        }
        return list;
    }

    private static List<Singer> parseSingerList(List<SearchResponseBean.Data.Song.SongDetail.Singer> singers){
        List<Singer> singerList=new LinkedList<>();
        for (SearchResponseBean.Data.Song.SongDetail.Singer singer:singers){
            singerList.add(new Singer(singer.getSingerId(),singer.getSingMid(),singer.getSingerName(),""));
        }
        return singerList;
    }

    private static Map<String, SongFile> parseDownloadLinkMap(SearchResponseBean.Data.Song.SongDetail detail){
        Map<String,SongFile> downloadLinkMap=new HashMap<>();
        downloadLinkMap.put(QUALITY_SQ,new SongFile(
                detail.getSongMid(),
                QUALITY_SQ,
                detail.getSqSize(),
                detail.getDuration(),
                qualityFileTypeMap.get(QUALITY_SQ),
                ""));
        downloadLinkMap.put(QUALITY_HQ,new SongFile(
                detail.getSongMid(),
                QUALITY_HQ,
                detail.getHqSize(),
                detail.getDuration(),
                qualityFileTypeMap.get(QUALITY_HQ),
                ""));
        downloadLinkMap.put(QUALITY_PQ,new SongFile(
                detail.getSongMid(),
                QUALITY_PQ,
                detail.getPqSize(),
                detail.getDuration(),
                qualityFileTypeMap.get(QUALITY_PQ),
                ""));
        downloadLinkMap.put(QUALITY_LQ,new SongFile(
                detail.getSongMid(),
                QUALITY_LQ,
                detail.getLqSize(),
                detail.getDuration(),
                qualityFileTypeMap.get(QUALITY_LQ),
                ""));
        return downloadLinkMap;
    }

    private static Album parseAlbum(SearchResponseBean.Data.Song.SongDetail detail){
        return new Album(detail.getAlbumId(),detail.getAlbumMid(),detail.getAlbumName());
    }

    private static Pay parsePay(SearchResponseBean.Data.Song.SongDetail detail){
        SearchResponseBean.Data.Song.SongDetail.Pay pay=detail.getPay();
        return new Pay(pay.getPayAlbum(),pay.getPayAlbumPrice(),pay.getPayDownload(),pay.getPayInfo(),pay.getPayPlay());
    }

    private static Lyric parseLyric(SearchResponseBean.Data.Song.SongDetail detail){
        return new Lyric(detail.getSongId(),detail.getLyric());
    }

    private static Mv parseMv(SearchResponseBean.Data.Song.SongDetail detail){
        return new Mv("", detail.getMvId(),"","");
    }

    private static class SearchResponseBean{
        int code;
        Data data;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public Data getData() {
            return data;
        }

        public void setData(Data data) {
            this.data = data;
        }

        class Data{
            String keyword;
            Song song;

            public String getKeyword() {
                return keyword;
            }

            public void setKeyword(String keyword) {
                this.keyword = keyword;
            }

            public Song getSong() {
                return song;
            }

            public void setSong(Song song) {
                this.song = song;
            }

            class Song{
                @SerializedName("curnum")
                int curNum;
                @SerializedName("curpage")
                int curPage;
                @SerializedName("list")
                List<SongDetail> songDetailList;

                public int getCurNum() {
                    return curNum;
                }

                public void setCurNum(int curNum) {
                    this.curNum = curNum;
                }

                public int getCurPage() {
                    return curPage;
                }

                public void setCurPage(int curPage) {
                    this.curPage = curPage;
                }

                public List<SongDetail> getSongDetailList() {
                    return songDetailList;
                }

                public void setSongDetailList(List<SongDetail> songDetailList) {
                    this.songDetailList = songDetailList;
                }

                class SongDetail{
                    @SerializedName("songid")
                    String songId;
                    @SerializedName("songmid")
                    String songMid;
                    @SerializedName("songname")
                    String songName;
                    @SerializedName("pubtime")
                    String publishTime;
                    String lyric;
                    @SerializedName("vid")
                    String mvId;
                    @SerializedName("albumid")
                    String albumId;
                    @SerializedName("albummid")
                    String albumMid;
                    @SerializedName("albumname")
                    String albumName;
                    @SerializedName("singer")
                    List<Singer> singers;
                    @SerializedName("sizeogg")
                    long lqSize;
                    @SerializedName("size128")
                    long pqSize;
                    @SerializedName("size320")
                    long hqSize;
                    @SerializedName("sizeflac")
                    long sqSize;
                    @SerializedName("interval")
                    long duration;

                    Pay pay;

                    public Pay getPay() {
                        return pay;
                    }

                    public void setPay(Pay pay) {
                        this.pay = pay;
                    }

                    public String getSongId() {
                        return songId;
                    }

                    public void setSongId(String songId) {
                        this.songId = songId;
                    }

                    public String getSongMid() {
                        return songMid;
                    }

                    public void setSongMid(String songMid) {
                        this.songMid = songMid;
                    }

                    public String getPublishTime() {
                        return publishTime;
                    }

                    public void setPublishTime(String publishTime) {
                        this.publishTime = publishTime;
                    }

                    public String getLyric() {
                        return lyric;
                    }

                    public void setLyric(String lyric) {
                        this.lyric = lyric;
                    }

                    public String getSongName() {
                        return songName;
                    }

                    public void setSongName(String songName) {
                        this.songName = songName;
                    }

                    public String getMvId() {
                        return mvId;
                    }

                    public void setMvId(String mvId) {
                        this.mvId = mvId;
                    }

                    public String getAlbumId() {
                        return albumId;
                    }

                    public void setAlbumId(String albumId) {
                        this.albumId = albumId;
                    }

                    public String getAlbumName() {
                        return albumName;
                    }

                    public void setAlbumName(String albumName) {
                        this.albumName = albumName;
                    }

                    public List<Singer> getSingers() {
                        return singers;
                    }

                    public void setSingers(List<Singer> singers) {
                        this.singers = singers;
                    }

                    public long getLqSize() {
                        return lqSize;
                    }

                    public void setLqSize(long lqSize) {
                        this.lqSize = lqSize;
                    }

                    public long getPqSize() {
                        return pqSize;
                    }

                    public void setPqSize(long pqSize) {
                        this.pqSize = pqSize;
                    }

                    public long getHqSize() {
                        return hqSize;
                    }

                    public void setHqSize(long hqSize) {
                        this.hqSize = hqSize;
                    }

                    public long getSqSize() {
                        return sqSize;
                    }

                    public void setSqSize(long sqSize) {
                        this.sqSize = sqSize;
                    }

                    public long getDuration() {
                        return duration;
                    }

                    public void setDuration(long duration) {
                        this.duration = duration;
                    }


                    public String getAlbumMid() {
                        return albumMid;
                    }

                    public void setAlbumMid(String albumMid) {
                        this.albumMid = albumMid;
                    }

                    class Singer{
                        @SerializedName("id")
                        String singerId;
                        @SerializedName("mid")
                        String singMid;
                        @SerializedName("name")
                        String singerName;

                        public String getSingerId() {
                            return singerId;
                        }

                        public void setSingerId(String singerId) {
                            this.singerId = singerId;
                        }

                        public String getSingMid() {
                            return singMid;
                        }

                        public void setSingMid(String singMid) {
                            this.singMid = singMid;
                        }

                        public String getSingerName() {
                            return singerName;
                        }

                        public void setSingerName(String singerName) {
                            this.singerName = singerName;
                        }
                    }

                    class Pay{
                        @SerializedName("payalbum")
                        public int payAlbum;
                        @SerializedName("payalbumprice")
                        public int payAlbumPrice;
                        @SerializedName("paydownload")
                        public int payDownload;
                        @SerializedName("payinfo")
                        public int payInfo;
                        @SerializedName("payplay")
                        public int payPlay;

                        public int getPayAlbum() {
                            return payAlbum;
                        }

                        public void setPayAlbum(int payAlbum) {
                            this.payAlbum = payAlbum;
                        }

                        public int getPayAlbumPrice() {
                            return payAlbumPrice;
                        }

                        public void setPayAlbumPrice(int payAlbumPrice) {
                            this.payAlbumPrice = payAlbumPrice;
                        }

                        public int getPayDownload() {
                            return payDownload;
                        }

                        public void setPayDownload(int payDownload) {
                            this.payDownload = payDownload;
                        }

                        public int getPayInfo() {
                            return payInfo;
                        }

                        public void setPayInfo(int payInfo) {
                            this.payInfo = payInfo;
                        }

                        public int getPayPlay() {
                            return payPlay;
                        }

                        public void setPayPlay(int payPlay) {
                            this.payPlay = payPlay;
                        }
                    }


                }
            }
        }
    }

}
