package com.yize.qqmusic.music.impl;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.yize.qqmusic.model.SongBean;
import com.yize.qqmusic.model.base.*;
import com.yize.qqmusic.util.GsonConverter;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static com.yize.qqmusic.model.SongUtils.*;
import static com.yize.qqmusic.util.HttpRequestHelper.*;

public class QqMusicSinger {

    public List<SongBean> getSongBySingerMid(String singerMid,int start,int num){
        String response=requestSingerInfo(singerMid,start,num);
        return parseResponseData(response);
    }

    public List<SongBean> getAllSongBySingerMid(String singerMid){
        int total=getSingerSongsCountById(singerMid);
        String response=requestSingerInfo(singerMid,0,total);
        return parseResponseData(response);
    }

    public int getSingerSongsCountById(String singerMid){
        String response=requestSingerInfo(singerMid,0,1);
        response=response.substring(response.indexOf("\"total\":")+"\"total\":".length());
        response=response.substring(0,response.indexOf(",")-1);
        return Integer.valueOf(response);
    }

    private String requestSingerInfo(String singerMid,int start,int num){
        String url="http://c.y.qq.com/v8/fcg-bin/fcg_v8_singer_track_cp.fcg?g_tk=1068642624&loginUin=0&hostUin=0&format=json&inCharset=UTF-8&outCharset=utf-8&notice=0&platform=wk_v15.json&needNewCode=0&singermid="+singerMid+"&order=listen&begin="+start+"&num="+num+"&songstatus=1&newsong=1";
        Map<String,String> headerMap=new HashMap<>();
        headerMap.put(HEADER_USER_AGENT,USER_AGENT_PC);
        headerMap.put(HEADER_CONNECTION,"Keep-Alive");
        return downloadWebSiteUseGet(url,headerMap);
    }

    private List<SongBean> parseResponseData(String response){
        List<SongBean> list=new LinkedList<>();
        try {
            ResponseBean responseBean= GsonConverter.fromJson(response,ResponseBean.class);
            List<ResponseBean.Data.Song> songs=responseBean.getData().getSongList();
            for (ResponseBean.Data.Song song:songs){
                ResponseBean.Data.Song.MusicData detail=song.getMusicData();
                SongBean songBean=new SongBean(SRC_QQ,
                        detail.getSongId(),
                        detail.getSongMid(),
                        detail.getSongName(),
                        detail.getPublishTime(),
                        parsePay(detail.getPay()),
                        parseLyric(detail.getSongId(),detail.getSongName()),
                        parseSingerList(detail.getSingerList()),
                        parseAlbum(detail.getAlbum()),
                        detail.getFile().getSqSize()>0?QUALITY_SQ:QUALITY_HQ,
                        "",
                        parseMv(detail.getMv()),
                        parseDownloadLinkMap(""));
                list.add(songBean);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }

    private Map<String, SongFile> parseDownloadLinkMap(String s) {
        return new HashMap<>();
    }

    private Mv parseMv(ResponseBean.Data.Song.MusicData.Mv mv) {
        return new Mv(mv.getMvId(),mv.getMvVid(),mv.getMvName(), mv.getMvName());
    }

    private Album parseAlbum(ResponseBean.Data.Song.MusicData.Album album) {
        return new Album(album.getAlbumId(),album.getAlbumMid(),album.getAlbumName());
    }

    private Lyric parseLyric(String songId,String songName) {
        return new Lyric(songId,songName);
    }


    private List<Singer> parseSingerList(List<ResponseBean.Data.Song.MusicData.Singer> singers) {
        List<Singer> singerList=new LinkedList<>();
        for (ResponseBean.Data.Song.MusicData.Singer singer:singers){
            singerList.add(new Singer(singer.getSingeId(),singer.getSingerMid(),singer.getSingerName(),singer.getSingPic()));
        }
        return singerList;
    }

    private Pay parsePay(ResponseBean.Data.Song.MusicData.Pay pay) {
        return new Pay(pay.getPayAlbum(),pay.getPayAlbumPrice(),pay.getPayDownload(),pay.getPayInfo(),pay.getPayPlay());
    }


    private class ResponseBean {
        int code;
        String message;
        Data data;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Data getData() {
            return data;
        }

        public void setData(Data data) {
            this.data = data;
        }

        class Data {
            @SerializedName("singer_id")
            String singerId;
            @SerializedName("singer_mid")
            String singerMid;
            @SerializedName("singer_name")
            String singerName;
            int total;
            @SerializedName("list")
            List<Song> songList;

            public String getSingerId() {
                return singerId;
            }

            public void setSingerId(String singerId) {
                this.singerId = singerId;
            }

            public String getSingerMid() {
                return singerMid;
            }

            public void setSingerMid(String singerMid) {
                this.singerMid = singerMid;
            }

            public String getSingerName() {
                return singerName;
            }

            public void setSingerName(String singerName) {
                this.singerName = singerName;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public List<Song> getSongList() {
                return songList;
            }

            public void setSongList(List<Song> songList) {
                this.songList = songList;
            }

            class Song {
                int index;
                @SerializedName("isnew")
                int isNew;
                long listenCount;
                int price;
                MusicData musicData;

                public int getIndex() {
                    return index;
                }

                public void setIndex(int index) {
                    this.index = index;
                }

                public int getIsNew() {
                    return isNew;
                }

                public void setIsNew(int isNew) {
                    this.isNew = isNew;
                }

                public long getListenCount() {
                    return listenCount;
                }

                public void setListenCount(long listenCount) {
                    this.listenCount = listenCount;
                }

                public int getPrice() {
                    return price;
                }

                public void setPrice(int price) {
                    this.price = price;
                }

                public MusicData getMusicData() {
                    return musicData;
                }

                public void setMusicData(MusicData musicData) {
                    this.musicData = musicData;
                }

                class MusicData {
                    Album album;
                    Files file;
                    @SerializedName("id")
                    String songId;
                    @SerializedName("mid")
                    String songMid;

                    @SerializedName("interval")
                    long duration;
                    @SerializedName("isonly")
                    int isOnly;
                    @SerializedName("name")
                    String songName;
                    Mv mv;
                    Pay pay;
                    @SerializedName("singer")
                    List<Singer> singerList;
                    String publishTime;

                    public Album getAlbum() {
                        return album;
                    }

                    public void setAlbum(Album album) {
                        this.album = album;
                    }

                    public Files getFile() {
                        return file;
                    }

                    public void setFile(Files file) {
                        this.file = file;
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

                    public long getDuration() {
                        return duration;
                    }

                    public void setDuration(long duration) {
                        this.duration = duration;
                    }

                    public int getIsOnly() {
                        return isOnly;
                    }

                    public void setIsOnly(int isOnly) {
                        this.isOnly = isOnly;
                    }

                    public String getSongName() {
                        return songName;
                    }

                    public void setSongName(String songName) {
                        this.songName = songName;
                    }

                    public Mv getMv() {
                        return mv;
                    }

                    public void setMv(Mv mv) {
                        this.mv = mv;
                    }

                    public Pay getPay() {
                        return pay;
                    }

                    public void setPay(Pay pay) {
                        this.pay = pay;
                    }

                    public List<Singer> getSingerList() {
                        return singerList;
                    }

                    public void setSingerList(List<Singer> singerList) {
                        this.singerList = singerList;
                    }

                    public String getPublishTime() {
                        return publishTime;
                    }

                    public void setPublishTime(String publishTime) {
                        this.publishTime = publishTime;
                    }

                    class Files {
                        @SerializedName("size_192ogg")
                        long lqSize;
                        @SerializedName("size_128mp3")
                        long pqSize;
                        @SerializedName("size_320mp3")
                        long hqSize;
                        @SerializedName("size_flac")
                        long sqSize;

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
                    }

                    class Album {
                        @SerializedName("id")
                        public String albumId;
                        @SerializedName("mid")
                        public String albumMid;
                        @SerializedName("name")
                        public String albumName;
                        @SerializedName("time_publish")
                        public String timePublish;

                        public Album() {
                        }

                        public Album(String albumId, String albumMid, String albumName) {
                            this.albumId = albumId;
                            this.albumMid = albumMid;
                            this.albumName = albumName;
                        }

                        public String getAlbumId() {
                            return albumId;
                        }

                        public void setAlbumId(String albumId) {
                            this.albumId = albumId;
                        }

                        public String getAlbumMid() {
                            return albumMid;
                        }

                        public void setAlbumMid(String albumMid) {
                            this.albumMid = albumMid;
                        }

                        public String getAlbumName() {
                            return albumName;
                        }

                        public void setAlbumName(String albumName) {
                            this.albumName = albumName;
                        }

                        public String getTimePublish() {
                            return timePublish;
                        }

                        public void setTimePublish(String timePublish) {
                            this.timePublish = timePublish;
                        }
                    }

                    class Mv {
                        @SerializedName("id")
                        private String mvId;
                        @SerializedName("vid")
                        private String mvVid;
                        @SerializedName("name")
                        private String mvName;
                        @SerializedName("title")
                        private String mvTitle;

                        public Mv() {
                        }

                        public String getMvId() {
                            return mvId;
                        }

                        public void setMvId(String mvId) {
                            this.mvId = mvId;
                        }

                        public String getMvVid() {
                            return mvVid;
                        }

                        public void setMvVid(String mvVid) {
                            this.mvVid = mvVid;
                        }

                        public String getMvName() {
                            return mvName;
                        }

                        public void setMvName(String mvName) {
                            this.mvName = mvName;
                        }

                        public String getMvTitle() {
                            return mvTitle;
                        }

                        public void setMvTitle(String mvTitle) {
                            this.mvTitle = mvTitle;
                        }
                    }

                    class Pay {
                        @SerializedName("price_album")
                        public int payAlbum;
                        @SerializedName("price_track")
                        public int payAlbumPrice;
                        @SerializedName("pay_down")
                        public int payDownload;
                        @SerializedName("pay_status")
                        public int payInfo;
                        @SerializedName("pay_play")
                        public int payPlay;

                        public Pay() {
                        }

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

                    class Singer {
                        @SerializedName("id")
                        public String singeId;
                        @SerializedName("mid")
                        public String singerMid;
                        @SerializedName("name")
                        public String singerName;
                        @SerializedName("")
                        public String singPic;

                        public Singer() {
                        }


                        public String getSingeId() {
                            return singeId;
                        }

                        public void setSingeId(String singeId) {
                            this.singeId = singeId;
                        }

                        public String getSingerMid() {
                            return singerMid;
                        }

                        public void setSingerMid(String singerMid) {
                            this.singerMid = singerMid;
                        }

                        public String getSingerName() {
                            return singerName;
                        }

                        public void setSingerName(String singerName) {
                            this.singerName = singerName;
                        }

                        public String getSingPic() {
                            return singPic;
                        }

                        public void setSingPic(String singPic) {
                            this.singPic = singPic;
                        }

                    }

                }
            }
        }
    }
}
