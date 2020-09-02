package com.yize.qqmusic.music.impl.mv;

import com.yize.qqmusic.model.mv.MvInfo;
import com.yize.qqmusic.util.GsonConverter;
import com.yize.qqmusic.util.HttpRequestHelper;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;

public class QqMusicMv {
    private static List<String> defaultRequiredList=new LinkedList<>();
    private static String baseLink="https://u.y.qq.com/cgi-bin/musicu.fcg?_=1599054589618&g_tk=5381&g_tk_new_20200303=5381&uin=0&format=json&inCharset=utf-8&outCharset=utf-8&notice=0&platform=h5&needNewCode=1&ct=23&cv=0";
    public MvInfo getMvInfoByVid(String vid){
        if(defaultRequiredList.size()==0){
            defaultRequiredList.add("vid");
            defaultRequiredList.add("desc");
            defaultRequiredList.add("duration");
            defaultRequiredList.add("pubdate");
            defaultRequiredList.add("fileid");
            defaultRequiredList.add("filesize");
            defaultRequiredList.add("mp4");
            defaultRequiredList.add("comment_cnt");
            defaultRequiredList.add("cover_pic_medium");
            defaultRequiredList.add("name");
            defaultRequiredList.add("singers");
            defaultRequiredList.add("playcnt");
            defaultRequiredList.add("uploader_nick");
            defaultRequiredList.add("type");

        }
        List<String>vidList=new LinkedList<>();
        vidList.add(vid);
        String response=requestMvInfo(requestParamBuilder(vidList,defaultRequiredList));
        List<MvInfo> mvInfoList=parseResponse(response);
        System.out.println(response);
        return mvInfoList.size()==0?new MvInfo():mvInfoList.get(0);
    }

    public List<MvInfo> parseResponse(String response){
        List<MvInfo> mvInfoList=new LinkedList<>();
        return mvInfoList;
    }

    private String requestMvInfo(String params){
        String response=null;
        try {
            String link=baseLink+"&data="+ URLEncoder.encode(params,"utf-8");
            response= HttpRequestHelper.downloadWebSiteUseGet(link,null);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return response;
    }

    public String requestParamBuilder(List<String> vidList,List<String> required){
        RequestParamBean bean=new RequestParamBean();
        bean.getUpdateMVInfo().getParam().setVidlist(vidList);
        bean.getUpdateMVInfo().getParam().setRequired(required);
        return GsonConverter.toJson(bean);
    }


    private class RequestParamBean{
        MvInfo updateMVInfo=new MvInfo();

        public MvInfo getUpdateMVInfo() {
            return updateMVInfo;
        }

        public void setUpdateMVInfo(MvInfo updateMVInfo) {
            this.updateMVInfo = updateMVInfo;
        }

        class MvInfo{
            String module="video.VideoDataServer";
            String method="get_video_info_batch";
            Param param=new Param();

            public String getModule() {
                return module;
            }

            public void setModule(String module) {
                this.module = module;
            }

            public String getMethod() {
                return method;
            }

            public void setMethod(String method) {
                this.method = method;
            }

            public Param getParam() {
                return param;
            }

            public void setParam(Param param) {
                this.param = param;
            }

            class Param{
                List<String> vidlist=new LinkedList<>();
                List<String> required=new LinkedList<>();

                public List<String> getVidlist() {
                    return vidlist;
                }

                public void setVidlist(List<String> vidlist) {
                    this.vidlist = vidlist;
                }

                public List<String> getRequired() {
                    return required;
                }

                public void setRequired(List<String> required) {
                    this.required = required;
                }
            }
        }
    }
}
