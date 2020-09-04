package com.yize.qqmusic.music.module.comment;

import com.google.gson.annotations.SerializedName;
import com.yize.qqmusic.common.request.ModuleRequestConfig;
import com.yize.qqmusic.common.request.RequestBean;
import com.yize.qqmusic.model.comment.CommentBean;
import com.yize.qqmusic.util.GsonConverter;
import com.yize.qqmusic.util.HttpRequestHelper;

import java.util.HashMap;
import java.util.Map;

import static com.yize.qqmusic.common.UrlConfig.baseLink;

public class QqMusicComment {
    private static final Map<String,Object> paramsMap=new HashMap<>();
    public CommentBean getCommentBySongMid(String bizId,int pageSize,int pageNum){
        String params=requestBuilder(bizId,pageSize,pageNum);
        return parse(request(params));
    }

    public String request(String params){
        String response=null;
        try {
            response= HttpRequestHelper.downloadWebSiteUsePost(baseLink,params,null);
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    public CommentBean parse(String response){
        CommentBean commentBean=new CommentBean();
        try {
            ResponseBean responseBean= GsonConverter.fromJson(response,ResponseBean.class);
            commentBean=responseBean.getRequest().getCommentList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return commentBean;
    }

    public String requestBuilder(String bizId,int pageSize,int pageNum){
        paramsMap.put("BizType",1);
        paramsMap.put("BizId",bizId);
        paramsMap.put("PageSize",pageSize);
        paramsMap.put("PageNum",pageNum);
        paramsMap.put("WithHot",1);
        RequestBean requestBean=new RequestBean(
                ModuleRequestConfig.NewComment.METHOD,
                ModuleRequestConfig.NewComment.MODULE,
                paramsMap
                );
        Map<String, RequestBean> map=new HashMap<>();
        map.put("request",requestBean);
        return GsonConverter.toJson(map);
    }

    private class ResponseBean{
        int code;
        Request request;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public Request getRequest() {
            return request;
        }

        public void setRequest(Request request) {
            this.request = request;
        }

        class Request{
            int code;
            @SerializedName(value = "commentList",alternate = "data")
            CommentBean commentList;

            public int getCode() {
                return code;
            }

            public void setCode(int code) {
                this.code = code;
            }

            public CommentBean getCommentList() {
                return commentList;
            }

            public void setCommentList(CommentBean commentList) {
                this.commentList = commentList;
            }
        }
    }
}
