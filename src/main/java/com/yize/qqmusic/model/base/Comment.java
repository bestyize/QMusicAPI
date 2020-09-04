package com.yize.qqmusic.model.base;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Comment {
    @SerializedName(value = "avatar",alternate = "Avatar")
    String avatar;
    @SerializedName(value = "commentId",alternate = "CmId")
    String commentId;
    @SerializedName(value = "isPraised",alternate = "IsPraised")
    int isPraised;
    @SerializedName(value = "praiseNum",alternate = "PraiseNum")
    int praiseNum;
    @SerializedName(value = "nick",alternate = "Nick")
    String nick;
    @SerializedName(value = "publishTime",alternate = "PubTime")
    long publishTime;
    @SerializedName(value = "encryptUin",alternate = "EncryptUin")
    String encryptUin;
    @SerializedName(value = "content",alternate = "Content")
    String content;
    @SerializedName(value = "commentState",alternate = "CommentState")
    int commentState;
    @SerializedName(value = "userType",alternate = "UserType")
    String userType;
    @SerializedName(value = "permission",alternate = "Permission")
    int permission;
    @SerializedName(value = "albumMid",alternate = "AlbumMid")
    String albumMid;
    @SerializedName(value = "albumPid",alternate = "AlbumPid")
    String albumPid;
    @SerializedName(value = "seqNumber",alternate = "SeqNo")
    String seqNumber;
    @SerializedName(value = "songId",alternate = "SongId")
    long songId;
    @SerializedName(value = "songType",alternate = "SongType")
    int songType;
    @SerializedName(value = "singerName",alternate = "SingerNames")
    String singerName;
    @SerializedName(value = "replyCount",alternate = "ReplyCnt")
    int replyCount;
    @SerializedName(value = "subCommentList",alternate = "SubComments")
    List<Comment> subCommentList;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public int isPraised() {
        return isPraised;
    }

    public void setPraised(int praised) {
        isPraised = praised;
    }

    public int getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(int praiseNum) {
        this.praiseNum = praiseNum;
    }

    public int getIsPraised() {
        return isPraised;
    }

    public void setIsPraised(int isPraised) {
        this.isPraised = isPraised;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public long getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(long publishTime) {
        this.publishTime = publishTime;
    }

    public String getEncryptUin() {
        return encryptUin;
    }

    public void setEncryptUin(String encryptUin) {
        this.encryptUin = encryptUin;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCommentState() {
        return commentState;
    }

    public void setCommentState(int commentState) {
        this.commentState = commentState;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    public String getAlbumMid() {
        return albumMid;
    }

    public void setAlbumMid(String albumMid) {
        this.albumMid = albumMid;
    }

    public String getAlbumPid() {
        return albumPid;
    }

    public void setAlbumPid(String albumPid) {
        this.albumPid = albumPid;
    }

    public String getSeqNumber() {
        return seqNumber;
    }

    public void setSeqNumber(String seqNumber) {
        this.seqNumber = seqNumber;
    }

    public long getSongId() {
        return songId;
    }

    public void setSongId(long songId) {
        this.songId = songId;
    }

    public int getSongType() {
        return songType;
    }

    public void setSongType(int songType) {
        this.songType = songType;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    public List<Comment> getSubCommentList() {
        return subCommentList;
    }

    public void setSubCommentList(List<Comment> subCommentList) {
        this.subCommentList = subCommentList;
    }
}
