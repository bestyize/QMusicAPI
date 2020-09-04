package com.yize.qqmusic.model.user;

import com.google.gson.annotations.SerializedName;

public class Token {
    @SerializedName(value = "openId",alternate = "openid")
    String openId;
    @SerializedName(value = "refreshToken",alternate = "refresh_token")
    String refreshToken;
    @SerializedName(value = "accessToken",alternate = "access_token")
    String accessToken;
    @SerializedName(value = "expiredAt",alternate = "expired_at")
    long expiredAt;
    @SerializedName(value = "userId",alternate = "musicid")
    long userId;
    @SerializedName(value = "musicKey",alternate = "musickey")
    String musicKey;
    @SerializedName(value = "musicKeyCreateTime",alternate = "musickeyCreateTime")
    long musicKeyCreateTime;
    @SerializedName(value = "firstLogin",alternate = "first_login")
    int firstLogin;
    String errMsg;
    String sessionKey;
    @SerializedName(value = "unionId",alternate = "unionid")
    String unionId;
    @SerializedName(value = "userIdStr",alternate = "str_musicid")
    String userIdStr;
    @SerializedName(value = "errTip",alternate = "errtip")
    String errTip;
    String nick;
    String logo;
    String encryptUin;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public long getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(long expiredAt) {
        this.expiredAt = expiredAt;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getMusicKey() {
        return musicKey;
    }

    public void setMusicKey(String musicKey) {
        this.musicKey = musicKey;
    }

    public long getMusicKeyCreateTime() {
        return musicKeyCreateTime;
    }

    public void setMusicKeyCreateTime(long musicKeyCreateTime) {
        this.musicKeyCreateTime = musicKeyCreateTime;
    }

    public int getFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(int firstLogin) {
        this.firstLogin = firstLogin;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getUserIdStr() {
        return userIdStr;
    }

    public void setUserIdStr(String userIdStr) {
        this.userIdStr = userIdStr;
    }

    public String getErrTip() {
        return errTip;
    }

    public void setErrTip(String errTip) {
        this.errTip = errTip;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getEncryptUin() {
        return encryptUin;
    }

    public void setEncryptUin(String encryptUin) {
        this.encryptUin = encryptUin;
    }
}
