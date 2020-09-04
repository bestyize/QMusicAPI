package com.yize.qqmusic.music.module.searchdown;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.yize.qqmusic.model.SongBean;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import com.yize.qqmusic.util.*;
import static com.yize.qqmusic.model.SongUtils.SRC_QQ;
import static com.yize.qqmusic.music.module.searchdown.QqMusic.baseDownloadServer;
import static com.yize.qqmusic.music.module.searchdown.QqMusic.qualityMap;

public class QqMusicDownload {

    private static String downloadLinkRequestParamsBuilder(List<SongBean> downloadInfoList) {
        String qqUin= PropertyReader.loadConfig("qq_uin");
        DownloadRequestBean requestBean=new DownloadRequestBean();
        requestBean.queryvkey.param.setUin(qqUin);
        List<String> filenames=new LinkedList<>();
        List<String> musicfiles=new LinkedList<>();
        List<String> songmid=new LinkedList<>();
        List<Integer> songtype=new LinkedList<>();
        for (SongBean info:downloadInfoList){
            filenames.add(qualityMap.get(info.getQuality()).replace("songid",info.getSongId()));
            musicfiles.add(qualityMap.get(info.getQuality()).replace("songid",info.getSongId()));
            songmid.add(info.getSongId());
            songtype.add(1);
        }
        requestBean.queryvkey.param.setFilename(filenames);
        requestBean.queryvkey.param.setMusicfile(musicfiles);
        requestBean.queryvkey.param.setSongmid(songmid);
        requestBean.queryvkey.param.setSongtype(songtype);
        return new Gson().toJson(requestBean);
    }




    public static String getDownloadLinkBySongId(String songid,String quality){
        SongBean downloadInfo=new SongBean(SRC_QQ,songid,quality);
        List<SongBean> downloadInfoList=new LinkedList<>();
        downloadInfoList.add(downloadInfo);
        String requestParams=downloadLinkRequestParamsBuilder(downloadInfoList);
        String response=downloadRequest(requestParams);
        String downloadLink="";
        DownloadBean downloadBean=GsonConverter.fromJson(response,DownloadBean.class);
        if(downloadBean!=null&&downloadBean.data!=null&&downloadBean.data.data.songDetailList.size()>0){
            List<DownloadBean.Data1.Data.SongDetail> songDetailList=downloadBean.data.data.songDetailList;
            DownloadBean.Data1.Data.SongDetail songDetail=songDetailList.get(0);
            downloadLink=songDetail.getDownloadLink();
        }
        return downloadLink;


    }

    public static List<SongBean> getDownloadLinkBySongIdList(List<SongBean> downloadInfoList){
        String requestParams=downloadLinkRequestParamsBuilder(downloadInfoList);
        String response=downloadRequest(requestParams);
        DownloadBean downloadBean=GsonConverter.fromJson(response,DownloadBean.class);
        if(downloadBean!=null&&downloadBean.data!=null&&downloadBean.data.data.songDetailList.size()>0){
            List<DownloadBean.Data1.Data.SongDetail> songDetailList=downloadBean.data.data.songDetailList;
            for (int i=0;i<songDetailList.size();i++){
                DownloadBean.Data1.Data.SongDetail detail= songDetailList.get(i);
                downloadInfoList.get(i).getDownloadLinkMap().get(downloadInfoList.get(i).getQuality()).setDownloadLink(detail.getDownloadLink());
            }
        }
        return downloadInfoList;


    }

    private static String downloadRequest(String params){
        String qqUin=PropertyReader.loadConfig("qq_uin");
        String qqKey=PropertyReader.loadConfig("qq_key");
        String qqCookie="qqmusic_key="+qqKey+"qqmusic_uin="+qqUin;
        Map<String,String> headerMap=new HashMap<>();
        headerMap.put("User-Agent","Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0)");
        headerMap.put("Host","u.y.qq.com");
        headerMap.put("Connection","Keep-Alive");
        headerMap.put("Cookie",qqCookie);
        return HttpRequestHelper.downloadWebSiteUsePost("https://u.y.qq.com/cgi-bin/musicu.fcg",params,headerMap);
    }

    protected class DownloadBean{
        int code;
        @SerializedName("queryvkey")
        Data1 data;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
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
                long expiration;
                @SerializedName("midurlinfo")
                List<SongDetail> songDetailList;

                public long getExpiration() {
                    return expiration;
                }

                public void setExpiration(long expiration) {
                    this.expiration = expiration;
                }

                public List<SongDetail> getSongDetailList() {
                    return songDetailList;
                }

                public void setSongDetailList(List<SongDetail> songDetailList) {
                    this.songDetailList = songDetailList;
                }

                class SongDetail{
                    @SerializedName("filename")
                    String fileName;
                    @SerializedName("purl")
                    String downloadLink;
                    @SerializedName("songmid")
                    String songId;

                    public String getFileName() {
                        return fileName;
                    }

                    public void setFileName(String fileName) {
                        this.fileName = fileName;
                    }

                    public String getDownloadLink() {
                        return downloadLink.length()==0?downloadLink:baseDownloadServer+downloadLink;
                    }

                    public void setDownloadLink(String downloadLink) {
                        this.downloadLink = downloadLink;
                    }
                }
            }
        }




    }

    protected static class DownloadRequestBean{
        Queryvkey queryvkey=new Queryvkey();

        public Queryvkey getQueryvkey() {
            return queryvkey;
        }

        public void setQueryvkey(Queryvkey queryvkey) {
            this.queryvkey = queryvkey;
        }

        class Queryvkey{
            String method="CgiGetVkey";
            String module="vkey.GetVkeyServer";
            Param param=new Param();

            public String getMethod() {
                return method;
            }

            public void setMethod(String method) {
                this.method = method;
            }

            public String getModule() {
                return module;
            }

            public void setModule(String module) {
                this.module = module;
            }
            class Param{
                int checklimit=0;
                int ctx=1;
                int downloadfrom=0;
                List<String > filename;
                String guid="0";
                List<String> musicfile;
                String nettype="";
                String referer="y.qq.com";
                int scene=0;
                List<String> songmid;
                List<Integer> songtype;
                String uin;

                public int getChecklimit() {
                    return checklimit;
                }

                public void setChecklimit(int checklimit) {
                    this.checklimit = checklimit;
                }

                public int getCtx() {
                    return ctx;
                }

                public void setCtx(int ctx) {
                    this.ctx = ctx;
                }

                public int getDownloadfrom() {
                    return downloadfrom;
                }

                public void setDownloadfrom(int downloadfrom) {
                    this.downloadfrom = downloadfrom;
                }

                public List<String> getFilename() {
                    return filename;
                }

                public void setFilename(List<String> filename) {
                    this.filename = filename;
                }

                public String getGuid() {
                    return guid;
                }

                public void setGuid(String guid) {
                    this.guid = guid;
                }

                public List<String> getMusicfile() {
                    return musicfile;
                }

                public void setMusicfile(List<String> musicfile) {
                    this.musicfile = musicfile;
                }

                public String getNettype() {
                    return nettype;
                }

                public void setNettype(String nettype) {
                    this.nettype = nettype;
                }

                public String getReferer() {
                    return referer;
                }

                public void setReferer(String referer) {
                    this.referer = referer;
                }

                public int getScene() {
                    return scene;
                }

                public void setScene(int scene) {
                    this.scene = scene;
                }

                public List<String> getSongmid() {
                    return songmid;
                }

                public void setSongmid(List<String> songmid) {
                    this.songmid = songmid;
                }

                public List<Integer> getSongtype() {
                    return songtype;
                }

                public void setSongtype(List<Integer> songtype) {
                    this.songtype = songtype;
                }

                public String getUin() {
                    return uin;
                }

                public void setUin(String uin) {
                    this.uin = uin;
                }
            }
        }
    }
}
