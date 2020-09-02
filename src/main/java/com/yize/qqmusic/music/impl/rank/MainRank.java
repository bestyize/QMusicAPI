package com.yize.qqmusic.music.impl.rank;

import com.google.gson.annotations.SerializedName;
import com.yize.qqmusic.model.rank.DetailRankBean;
import com.yize.qqmusic.model.rank.MainRankBean;
import com.yize.qqmusic.util.GsonConverter;
import com.yize.qqmusic.util.HttpRequestHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainRank {
    private static final Logger logger= LogManager.getLogger(MainRank.class);
    private static final String requestParams="{\"req_0\":{\"module\":\"musicToplist.ToplistInfoServer\",\"method\":\"GetAll\",\"param\":{}},\"comm\":{\"g_tk\":5381,\"uin\":\"0\",\"format\":\"json\",\"ct\":20,\"cv\":1773,\"platform\":\"wk_v17\"}}";
    private static final String baseLink="https://u.y.qq.com/cgi-bin/musics.fcg?sign=zzac3rwdj5r38hcdz8bea0f253f7c3786595bc8d7e3cd97f67";
    public MainRankBean getMainRank(){
        String response=requestMainRank();
        return parseMainRank(response);
    }
    private String requestMainRank(){
        String response= null;
        try {
            Map<String,String> headerMap=new HashMap<>();
            response = HttpRequestHelper.downloadWebSiteUseGet(baseLink+"&data="+ URLEncoder.encode(requestParams,"utf-8"),headerMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    private MainRankBean parseMainRank(String response){
        MainRankBean mainRankBean=new MainRankBean();
        if(response==null){
            return mainRankBean;
        }
        try {
            response=response.replaceAll("%","");
            ResponseBean responseBean=GsonConverter.fromJson(response,ResponseBean.class);
            mainRankBean=responseBean.getData().getMainRank();
        }catch (Exception e){
            logger.error("解析失败:"+e.toString());
            e.printStackTrace();
        }
        return mainRankBean;
    }


    private class ResponseBean{
        int code;
        @SerializedName("req_0")
        Data1 data;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public Data1 getData() {
            return data;
        }

        public void setData(Data1 data) {
            this.data = data;
        }

        class Data1{
            int code;
            @SerializedName(value = "mainRank",alternate = "data")
            MainRankBean mainRank;

            public int getCode() {
                return code;
            }

            public void setCode(int code) {
                this.code = code;
            }

            public MainRankBean getMainRank() {
                return mainRank;
            }

            public void setMainRank(MainRankBean mainRank) {
                this.mainRank = mainRank;
            }
        }
    }
}
