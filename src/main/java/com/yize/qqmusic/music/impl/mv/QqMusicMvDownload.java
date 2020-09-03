package com.yize.qqmusic.music.impl.mv;

import com.google.gson.annotations.SerializedName;
import com.yize.qqmusic.model.base.Mv;
import com.yize.qqmusic.model.base.MvFile;
import com.yize.qqmusic.model.mv.MvBean;
import com.yize.qqmusic.util.GsonConverter;
import com.yize.qqmusic.util.HttpRequestHelper;
import javafx.scene.chart.ValueAxis;
import sun.dc.pr.PRError;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class QqMusicMvDownload {
    private String baseLink="https://u.y.qq.com/cgi-bin/musicu.fcg";
    private String[] mp4Type={"LQ","PQ","HQ","SQ"};

    public MvBean getMvDownloadLink(MvBean mvBean){
        List<String> mvVidList=new LinkedList<>();
        mvVidList.add(mvBean.getMvVid());
        String param=requestParamBuilder(mvVidList);
        return parseMvBean(mvUrlRequest(param));
    }

    public List<MvBean> getMvDownloadLink(List<MvBean> mvBeanList){
        List<String> mvVidList=new LinkedList<>();
        for (MvBean bean:mvBeanList){
            mvVidList.add(bean.getMvVid());
        }
        String param=requestParamBuilder(mvVidList);
        return parseMvBeanList(mvUrlRequest(param));
    }

    private String mvUrlRequest(String params){
        Map<String,String> headerMap=new HashMap<>();
        String response= null;
        try {
            response = HttpRequestHelper.downloadWebSiteUsePost(baseLink, params,headerMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    private String requestParamBuilder(List<String> mvVidList){
        RequestBean requestBean=new RequestBean();
        requestBean.getGetMvUrl().getParam().setVids(mvVidList);
        return GsonConverter.toJson(requestBean);
    }

    private MvBean parseMvBean(String response){
       List<MvBean> beans=parseMvBeanList(response);
        return beans.size()>0?beans.get(0):new MvBean();
    }

    private List<MvBean> parseMvBeanList(String response){
        List<MvBean> mvBeanList=new LinkedList<>();
        if(response==null){
            return mvBeanList;
        }
        try {
            ResponseBean responseBean=GsonConverter.fromJson(response,ResponseBean.class);
            Map<String, ResponseBean.Data1.MvDetail> detailMap=responseBean.getData().getMvMap();
            for (String key:detailMap.keySet()){
                mvBeanList.add(buildMvBean(detailMap.get(key),key));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return mvBeanList;
    }

    private MvBean buildMvBean(ResponseBean.Data1.MvDetail detail,String key){
        MvBean mvBean=new MvBean();
        mvBean.setMvId(key);
        Map<String,MvFile> downloadLinkMap=new HashMap<>();
        mvBean.setDownloadLinkMap(downloadLinkMap);
        int count=0;
        for (ResponseBean.Data1.MvDetail.Mp4 mp4:detail.getMp4()){
            if(mp4.getFileSize()>0){
                String downloadLink=mp4.getDownloadLinkGroup().get(1);
                //String fileMid, String quality, long size, long duration, String type, String downloadLink
                String quality=mp4Type[count++];
                MvFile file=new MvFile(key,quality,mp4.getFileSize(),0,mp4.getFileType()+"",downloadLink);
                downloadLinkMap.put(quality,file);
            }
        }
        return mvBean;

    }



    private class RequestBean{
        Comm comm=new Comm();
        Request getMvUrl=new Request();

        public Comm getComm() {
            return comm;
        }

        public void setComm(Comm comm) {
            this.comm = comm;
        }

        public Request getGetMvUrl() {
            return getMvUrl;
        }

        public void setGetMvUrl(Request getMvUrl) {
            this.getMvUrl = getMvUrl;
        }

        class Comm{
            int ct=24;
            int cv=4747474;
            int g_tk=5381;
            int uin=0;
            String format="json";
            String platform="yqq";

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

            public int getG_tk() {
                return g_tk;
            }

            public void setG_tk(int g_tk) {
                this.g_tk = g_tk;
            }

            public int getUin() {
                return uin;
            }

            public void setUin(int uin) {
                this.uin = uin;
            }

            public String getFormat() {
                return format;
            }

            public void setFormat(String format) {
                this.format = format;
            }

            public String getPlatform() {
                return platform;
            }

            public void setPlatform(String platform) {
                this.platform = platform;
            }
        }

        class Request{
            String module="gosrf.Stream.MvUrlProxy";
            String method="GetMvUrls";
            Params param=new Params();


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

            public Params getParam() {
                return param;
            }

            public void setParams(Params params) {
                this.param = params;
            }

            class Params{
                List<String> vids=new LinkedList<>();
                int request_typet=10001;
                int addrtype=3;

                public List<String> getVids() {
                    return vids;
                }

                public void setVids(List<String> vids) {
                    this.vids = vids;
                }

                public int getRequest_typet() {
                    return request_typet;
                }

                public void setRequest_typet(int request_typet) {
                    this.request_typet = request_typet;
                }

                public int getAddrtype() {
                    return addrtype;
                }

                public void setAddrtype(int addrtype) {
                    this.addrtype = addrtype;
                }
            }
        }
    }

    private class ResponseBean{
        int code;
        @SerializedName("getMvUrl")
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
            @SerializedName("data")
            Map<String,MvDetail> mvMap;

            public int getCode() {
                return code;
            }

            public void setCode(int code) {
                this.code = code;
            }

            public Map<String, MvDetail> getMvMap() {
                return mvMap;
            }

            public void setMvMap(Map<String, MvDetail> mvMap) {
                this.mvMap = mvMap;
            }

            class MvDetail{
                List<Mp4> mp4;

                public List<Mp4> getMp4() {
                    return mp4;
                }

                public void setMp4(List<Mp4> mp4) {
                    this.mp4 = mp4;
                }

                class Mp4{
                    @SerializedName(value = "downloadLinkGroup" ,alternate = "freeflow_url")
                    List<String> downloadLinkGroup;
                    int fileType;
                    long fileSize;
                    int format;

                    public List<String> getDownloadLinkGroup() {
                        return downloadLinkGroup;
                    }

                    public void setDownloadLinkGroup(List<String> downloadLinkGroup) {
                        this.downloadLinkGroup = downloadLinkGroup;
                    }

                    public int getFileType() {
                        return fileType;
                    }

                    public void setFileType(int fileType) {
                        this.fileType = fileType;
                    }

                    public long getFileSize() {
                        return fileSize;
                    }

                    public void setFileSize(long fileSize) {
                        this.fileSize = fileSize;
                    }

                    public int getFormat() {
                        return format;
                    }

                    public void setFormat(int format) {
                        this.format = format;
                    }
                }
            }
        }
    }
}
