package com.yize.qqmusic.model;

import com.yize.qqmusic.model.base.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SongBean implements Serializable {

    private static final long serialVersionUID = 876323294945176354L;
    private String songSrc;//歌曲来源，QQ音乐等
    private String songId;//歌曲ID
    private String songMid;
    private String songName;//歌曲名
    private String publishTime;
    private String picUrl;//歌曲封面
    private Mv mv;//MV链接
    private String quality;//最高质量
    private Album album;
    private Lyric lyric;
    private Pay pay;
    private List<Singer> singerList;
    private Map<String, SongFile> downloadLinkMap;

    //此处构造函数只传入songSrc,songId,仅供搜索下载链接时候使用
    public SongBean(String songSrc, String songId) {
        this.songSrc = songSrc;
        this.songId = songId;
    }

    public SongBean(String songSrc, String songId, String quality) {
        this.songSrc = songSrc;
        this.songId = songId;
        this.quality = quality;
    }

    public SongBean(String songSrc, String songId, String songMid,String songName, String publishTime,Pay pay,Lyric lyric,List<Singer> singerList,Album album, String quality, String picUrl, Mv mvId,Map<String,SongFile> downloadLinkMap) {
        this.songSrc = songSrc;
        this.songId = songId;
        this.songMid=songMid;
        this.songName = songName;
        this.publishTime=publishTime;
        this.pay=pay;
        this.lyric=lyric;
        this.singerList = singerList;
        this.album=album;
        this.quality = quality;
        this.picUrl = picUrl;
        this.mv = mv;
        this.downloadLinkMap=downloadLinkMap;
    }


    public Pay getPay() {
        return pay;
    }

    public void setPay(Pay pay) {
        this.pay = pay;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getSongMid() {
        return songMid;
    }

    public void setSongMid(String songMid) {
        this.songMid = songMid;
    }

    public String getSongSrc() {
        return songSrc;
    }

    public void setSongSrc(String songSrc) {
        this.songSrc = songSrc;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<Singer> getSingerList() {
        return singerList;
    }

    public void setSingerList(List<Singer> singerList) {
        this.singerList = singerList;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }


    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }



    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public Map<String, SongFile> getDownloadLinkMap() {
        if (downloadLinkMap == null) {
            downloadLinkMap = new HashMap<>();
        }
        return downloadLinkMap;
    }

    public void setDownloadLinkMap(Map<String, SongFile> downloadLinkMap) {
        this.downloadLinkMap = downloadLinkMap;
    }


    public Lyric getLyric() {
        return lyric;
    }

    public void setLyric(Lyric lyric) {
        this.lyric = lyric;
    }

    public Mv getMv() {
        return mv;
    }

    public void setMv(Mv mv) {
        this.mv = mv;
    }
}