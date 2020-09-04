package com.yize.qqmusic.music.module.lyric;

import com.yize.qqmusic.model.base.Lyric;
import com.yize.qqmusic.util.Base64Converter;
import com.yize.qqmusic.util.GsonConverter;
import com.yize.qqmusic.util.HttpRequestHelper;

import java.util.HashMap;
import java.util.Map;

public class QqMusicLyric {
    private static final String baseLink="https://c.y.qq.com/lyric/fcgi-bin/fcg_query_lyric_new.fcg?g_tk=5381&format=json&songmid=";
    public Lyric getLyricByMid(String songMid){
        String link=baseLink+songMid;
        String response=requestLyric(link);
        return parseLyric(response,songMid);
    }

    private String requestLyric(String link){
        //String bakLink="https://c.y.qq.com/lyric/fcgi-bin/fcg_query_lyric_new.fcg?songmid=002imZ142vVoIL";
        Map<String,String> headerMap=new HashMap<>();
        headerMap.put("Referer","https://y.qq.com/portal/player.html");
        return HttpRequestHelper.downloadWebSiteUseGet(link,headerMap);
    }

    private Lyric parseLyric(String response,String songMid){
        Lyric lyric=new Lyric(songMid,"");
        try {
            ResponseBean bean=GsonConverter.fromJson(response,ResponseBean.class);
            lyric.setLyricText(Base64Converter.decode(bean.getLyric()));
            lyric.setLyricTextTrans(Base64Converter.decode(bean.getTrans()));
        }catch (Exception e){
            e.printStackTrace();
        }
        return lyric;
    }
    private class ResponseBean{
        String lyric;
        String trans;

        public String getLyric() {
            return lyric;
        }

        public void setLyric(String lyric) {
            this.lyric = lyric;
        }

        public String getTrans() {
            return trans;
        }

        public void setTrans(String trans) {
            this.trans = trans;
        }
    }

}
