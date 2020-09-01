package com.yize.qqmusic.model;

import com.google.gson.annotations.SerializedName;
import com.yize.qqmusic.model.base.RankSong;

import java.util.List;

public class TopRank{
    int topId;
    int recType;
    int topType;
    int updateType;
    String title;
    String titleDetail;
    String titleShare;
    String titleSub;
    String intro;
    String cornerMark;
    String period;
    String updateTime;
    //Map<String,List<Integer>> history;
    long listenNum;
    int totalNum;
    @SerializedName("song")
    List<RankSong> songList;
    String headPicUrl;
    String fontPicUrl;
    String mbFrontPicUrl;
    String mbHeadPicUrl;
    List<String> pcSubTopIds;
    List<String> pcSubTopTitles;
    List<String> subTopIds;
    String adJumpUrl;
    String h5JUmpUrl;
    String updateTips;
    String bannerText;
    @SerializedName("AdShareContent")
    String adShareContent;
    String abt;
    int cityId;
    int provId;
    int sinceCv;
    String musichallTitle;
    String musichallSubtitle;
    String musichallPicUrl;

    public int getTopId() {
        return topId;
    }

    public void setTopId(int topId) {
        this.topId = topId;
    }

    public int getRecType() {
        return recType;
    }

    public void setRecType(int recType) {
        this.recType = recType;
    }

    public int getTopType() {
        return topType;
    }

    public void setTopType(int topType) {
        this.topType = topType;
    }

    public int getUpdateType() {
        return updateType;
    }

    public void setUpdateType(int updateType) {
        this.updateType = updateType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleDetail() {
        return titleDetail;
    }

    public void setTitleDetail(String titleDetail) {
        this.titleDetail = titleDetail;
    }

    public String getTitleShare() {
        return titleShare;
    }

    public void setTitleShare(String titleShare) {
        this.titleShare = titleShare;
    }

    public String getTitleSub() {
        return titleSub;
    }

    public void setTitleSub(String titleSub) {
        this.titleSub = titleSub;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getCornerMark() {
        return cornerMark;
    }

    public void setCornerMark(String cornerMark) {
        this.cornerMark = cornerMark;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public long getListenNum() {
        return listenNum;
    }

    public void setListenNum(long listenNum) {
        this.listenNum = listenNum;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public List<RankSong> getSongList() {
        return songList;
    }

    public void setSongList(List<RankSong> songList) {
        this.songList = songList;
    }

    public String getHeadPicUrl() {
        return headPicUrl;
    }

    public void setHeadPicUrl(String headPicUrl) {
        this.headPicUrl = headPicUrl;
    }

    public String getFontPicUrl() {
        return fontPicUrl;
    }

    public void setFontPicUrl(String fontPicUrl) {
        this.fontPicUrl = fontPicUrl;
    }

    public String getMbFrontPicUrl() {
        return mbFrontPicUrl;
    }

    public void setMbFrontPicUrl(String mbFrontPicUrl) {
        this.mbFrontPicUrl = mbFrontPicUrl;
    }

    public String getMbHeadPicUrl() {
        return mbHeadPicUrl;
    }

    public void setMbHeadPicUrl(String mbHeadPicUrl) {
        this.mbHeadPicUrl = mbHeadPicUrl;
    }

    public List<String> getPcSubTopIds() {
        return pcSubTopIds;
    }

    public void setPcSubTopIds(List<String> pcSubTopIds) {
        this.pcSubTopIds = pcSubTopIds;
    }

    public List<String> getPcSubTopTitles() {
        return pcSubTopTitles;
    }

    public void setPcSubTopTitles(List<String> pcSubTopTitles) {
        this.pcSubTopTitles = pcSubTopTitles;
    }

    public List<String> getSubTopIds() {
        return subTopIds;
    }

    public void setSubTopIds(List<String> subTopIds) {
        this.subTopIds = subTopIds;
    }

    public String getAdJumpUrl() {
        return adJumpUrl;
    }

    public void setAdJumpUrl(String adJumpUrl) {
        this.adJumpUrl = adJumpUrl;
    }

    public String getH5JUmpUrl() {
        return h5JUmpUrl;
    }

    public void setH5JUmpUrl(String h5JUmpUrl) {
        this.h5JUmpUrl = h5JUmpUrl;
    }

    public String getUpdateTips() {
        return updateTips;
    }

    public void setUpdateTips(String updateTips) {
        this.updateTips = updateTips;
    }

    public String getBannerText() {
        return bannerText;
    }

    public void setBannerText(String bannerText) {
        this.bannerText = bannerText;
    }

    public String getAdShareContent() {
        return adShareContent;
    }

    public void setAdShareContent(String adShareContent) {
        this.adShareContent = adShareContent;
    }

    public String getAbt() {
        return abt;
    }

    public void setAbt(String abt) {
        this.abt = abt;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getProvId() {
        return provId;
    }

    public void setProvId(int provId) {
        this.provId = provId;
    }

    public int getSinceCv() {
        return sinceCv;
    }

    public void setSinceCv(int sinceCv) {
        this.sinceCv = sinceCv;
    }

    public String getMusichallTitle() {
        return musichallTitle;
    }

    public void setMusichallTitle(String musichallTitle) {
        this.musichallTitle = musichallTitle;
    }

    public String getMusichallSubtitle() {
        return musichallSubtitle;
    }

    public void setMusichallSubtitle(String musichallSubtitle) {
        this.musichallSubtitle = musichallSubtitle;
    }

    public String getMusichallPicUrl() {
        return musichallPicUrl;
    }

    public void setMusichallPicUrl(String musichallPicUrl) {
        this.musichallPicUrl = musichallPicUrl;
    }

}