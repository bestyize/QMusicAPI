package com.yize.qqmusic.music.module.rank;

import com.google.gson.annotations.SerializedName;
import com.yize.qqmusic.model.SongBean;
import com.yize.qqmusic.model.base.Lyric;
import com.yize.qqmusic.model.base.SongFile;
import com.yize.qqmusic.model.rank.DetailRankBean;
import com.yize.qqmusic.model.rank.TopRank;
import com.yize.qqmusic.util.GsonConverter;
import com.yize.qqmusic.util.HttpRequestHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URLEncoder;
import java.util.*;

import static com.yize.qqmusic.common.CommonConfig.qualityFileTypeMap;
import static com.yize.qqmusic.model.SongUtils.*;
import static com.yize.qqmusic.model.SongUtils.QUALITY_LQ;


public class QqMusicDetailRank {
    private static final Logger logger= LogManager.getLogger(QqMusicDetailRank.class);
    private static final String MODULE="musicToplist.ToplistInfoServer";
    private static final String METHOD="GetDetail";
    private static final String baseLink="https://u.y.qq.com/cgi-bin/musicu.fcg";
    public DetailRankBean getRankDetail(int topId,int num,String period){
        String requestParams=requestRaramBuilder(topId,num,period);
        System.out.println(requestParams);
        return parseDetailRank(requestTopList(requestParams));
    }

    private String requestTopList(String params){
        String response= null;
        try {
            Map<String,String> headerMap=new HashMap<>();
            response = HttpRequestHelper.downloadWebSiteUseGet(baseLink+"?data="+URLEncoder.encode(params,"utf-8"),headerMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    private DetailRankBean parseDetailRank(String response){
        DetailRankBean detailRankBean=new DetailRankBean();
        if(response==null){
            return detailRankBean;
        }
        try {
            response=response.replaceAll("%","");
            ResponseBean responseBean=GsonConverter.fromJson(response,ResponseBean.class);
            detailRankBean.setTopRank(responseBean.getData().getData().getTopRank());
            List<SongBean> songBeanList=new LinkedList<>();
            List<ResponseBean.Data1.Data.SongBeanExt> songBeanExtList=responseBean.getData().getData().getSongList();
            for (ResponseBean.Data1.Data.SongBeanExt ext:songBeanExtList){
                songBeanList.add(builderSongBean(ext));
            }
            detailRankBean.setSongList(songBeanList);

        }catch (Exception e){
            e.printStackTrace();
            logger.error("解析失败"+e.toString());
        }
        return detailRankBean;
    }

    private SongBean builderSongBean(ResponseBean.Data1.Data.SongBeanExt ext){
        SongBean bean=ext;
        ResponseBean.Data1.Data.SongBeanExt.File file=ext.getFile();
        Map<String, SongFile> downloadLinkMap=new HashMap<>();
        downloadLinkMap.put(QUALITY_SQ,new SongFile(
                ext.getSongMid(),
                QUALITY_SQ,
                file.getSqSize(),
                ext.getDuration(),
                qualityFileTypeMap.get(QUALITY_SQ),
                ""));
        downloadLinkMap.put(QUALITY_HQ,new SongFile(
                ext.getSongMid(),
                QUALITY_HQ,
                file.getHqSize(),
                ext.getDuration(),
                qualityFileTypeMap.get(QUALITY_HQ),
                ""));
        downloadLinkMap.put(QUALITY_PQ,new SongFile(
                ext.getSongMid(),
                QUALITY_PQ,
                file.getPqSize(),
                ext.getDuration(),
                qualityFileTypeMap.get(QUALITY_PQ),
                ""));
        downloadLinkMap.put(QUALITY_LQ,new SongFile(
                ext.getSongMid(),
                QUALITY_LQ,
                file.getLqSize(),
                ext.getDuration(),
                qualityFileTypeMap.get(QUALITY_LQ),
                ""));
        bean.setDownloadLinkMap(downloadLinkMap);
        ext.setFile(null);
        bean.setLyric(new Lyric(ext.getSongMid(),ext.getSongName()));
        return bean;
    }

    private String requestRaramBuilder(int topId,int num,String period){
        RequestParam param=new RequestParam();
        param.getDetail().getParam().setTopId(topId);
        param.getDetail().getParam().setNum(num);
        param.getDetail().getParam().setPeriod(period);
        return GsonConverter.toJson(param);
    }

    private class RequestParam{
        Data1 detail=new Data1();
        Data2 comm=new Data2();

        public Data1 getDetail() {
            return detail;
        }

        public void setDetail(Data1 detail) {
            this.detail = detail;
        }

        public Data2 getComm() {
            return comm;
        }

        public void setComm(Data2 comm) {
            this.comm = comm;
        }

        class Data1{
            String module=MODULE;
            String method=METHOD;
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
                int topId;
                int offset=0;
                int num;
                String period;

                public int getTopId() {
                    return topId;
                }

                public void setTopId(int topId) {
                    this.topId = topId;
                }

                public int getOffset() {
                    return offset;
                }

                public void setOffset(int offset) {
                    this.offset = offset;
                }

                public int getNum() {
                    return num;
                }

                public void setNum(int num) {
                    this.num = num;
                }

                public String getPeriod() {
                    return period;
                }

                public void setPeriod(String period) {
                    this.period = period;
                }
            }

        }

        class Data2{
            int ct=24;
            int cv=0;

            public int getCt() {
                return ct;
            }

            public void setCt(int ct) {
                this.ct = ct;
            }

            public int getCv() {
                return cv;
            }

            public void setCv(int cv) {
                this.cv = cv;
            }
        }
    }


    private class ResponseBean{
        int code;
        @SerializedName("detail")
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
            Data data;

            public int getCode() {
                return code;
            }

            public void setCode(int code) {
                this.code = code;
            }

            public Data getData() {
                return data;
            }

            public void setData(Data data) {
                this.data = data;
            }

            class Data{
                @SerializedName(value = "topRank",alternate = {"data"})
                TopRank topRank;
                @SerializedName(value = "songList",alternate = {"songInfoList"})
                List<SongBeanExt> songList;

                public TopRank getTopRank() {
                    return topRank;
                }

                public void setTopRank(TopRank topRank) {
                    this.topRank = topRank;
                }

                public List<SongBeanExt> getSongList() {
                    return songList;
                }

                public void setSongList(List<SongBeanExt> songList) {
                    this.songList = songList;
                }

                class SongBeanExt extends SongBean{
                    File file;
                    @SerializedName(value = "duration",alternate = {"interval"})
                    int duration;

                    public File getFile() {
                        return file;
                    }

                    public void setFile(File file) {
                        this.file = file;
                    }


                    public int getDuration() {
                        return duration;
                    }

                    public void setDuration(int duration) {
                        this.duration = duration;
                    }

                    class File{
                        @SerializedName("media_mid")
                        String songMid;
                        @SerializedName("size_96ogg")
                        long lqSize;
                        @SerializedName("size_128mp3")
                        long pqSize;
                        @SerializedName("size_192mp3")
                        long hqSize;
                        @SerializedName("size_flac")
                        long sqSize;

                        public String getSongMid() {
                            return songMid;
                        }

                        public void setSongMid(String songMid) {
                            this.songMid = songMid;
                        }

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
                }
            }
        }

    }
}
