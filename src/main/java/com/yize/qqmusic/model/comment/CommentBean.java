package com.yize.qqmusic.model.comment;

import com.google.gson.annotations.SerializedName;
import com.yize.qqmusic.model.base.Comment;

import java.util.List;

public class CommentBean {
    String songMid;
    String songName;
    @SerializedName(value = "allowComment",alternate = "AllowComment")
    int allowComment;
    @SerializedName(value = "newComment",alternate = "CommentList")
    Data newComment;
    @SerializedName(value = "hotComment",alternate = "CommentList2")
    Data hotComment;
    @SerializedName(value = "riseComment",alternate = "CommentList3")
    Data riseComment;

    public String getSongMid() {
        return songMid;
    }

    public void setSongMid(String songMid) {
        this.songMid = songMid;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public int getAllowComment() {
        return allowComment;
    }

    public void setAllowComment(int allowComment) {
        this.allowComment = allowComment;
    }

    public Data getNewComment() {
        return newComment;
    }

    public void setNewComment(Data newComment) {
        this.newComment = newComment;
    }

    public Data getHotComment() {
        return hotComment;
    }

    public void setHotComment(Data hotComment) {
        this.hotComment = hotComment;
    }

    public Data getRiseComment() {
        return riseComment;
    }

    public void setRiseComment(Data riseComment) {
        this.riseComment = riseComment;
    }

    class Data{
        @SerializedName(value = "hasMore",alternate = "HasMore")
        int hasMore;
        @SerializedName(value = "total",alternate = "Total")
        int total;
        @SerializedName(value = "commentList",alternate = "Comments")
        private List<Comment> commentList;

        public int getHasMore() {
            return hasMore;
        }

        public void setHasMore(int hasMore) {
            this.hasMore = hasMore;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<Comment> getCommentList() {
            return commentList;
        }

        public void setCommentList(List<Comment> commentList) {
            this.commentList = commentList;
        }
    }
}
