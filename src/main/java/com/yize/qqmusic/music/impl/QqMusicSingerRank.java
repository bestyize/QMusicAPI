package com.yize.qqmusic.music.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.sun.org.apache.bcel.internal.ExceptionConst;
import com.yize.qqmusic.model.base.Singer;
import com.yize.qqmusic.util.GsonConverter;
import com.yize.qqmusic.util.HttpRequestHelper;

public class QqMusicSingerRank {
    private static final String baseUrl="http://u.y.qq.com/cgi-bin/musicu.fcg?g_tk=2145210627&loginUin=0&hostUin=0&format=json&inCharset=utf-8&outCharset=utf-8&notice=0&platform=wk_v15.json&needNewCode=0&data=";
    private static final String reqParam="{\"comm\":{\"cv\":1666,\"ct\":20},\"singerList\":{\"module\":\"Music.SingerListServer\",\"method\":\"get_singer_list\",\"param\":{\"area\":-100,\"sex\":-100,\"genre\":-100,\"index\":-100,\"sin\":0,\"cur_page\":1}}}";

    private static final Map<String,Integer> areaMap=new HashMap<>();
    private static final Map<String,Integer> genreMap=new HashMap<>();
    private static final Map<String,Integer> indexMap=new HashMap<>();
    private static final Map<String,Integer> sexMap=new HashMap<>();
    static {
        areaMap.put("全部",-100);
        areaMap.put("内地",200);
        areaMap.put("港台",-100);
        areaMap.put("欧美",200);
        areaMap.put("日本",-100);
        areaMap.put("韩国",200);
        areaMap.put("其他",200);

        genreMap.put("全部",-100);
        genreMap.put("流行",1);
        genreMap.put("嘻哈",6);
        genreMap.put("摇滚",2);
        genreMap.put("电子",4);
        genreMap.put("民谣",3);
        genreMap.put("R&B",8);
        genreMap.put("民歌",10);
        genreMap.put("轻音乐",9);
        genreMap.put("爵士",5);
        genreMap.put("古典",14);
        genreMap.put("乡村",25);
        genreMap.put("蓝调",20);

        indexMap.put("热门",-100);
        indexMap.put("#",27);
        for (int i='A';i<='Z';i++){
            indexMap.put((char)i+"",i-'A'+1);
        }

        sexMap.put("全部",-100);
        sexMap.put("男",0);
        sexMap.put("女",1);
        sexMap.put("组合",2);

    }

    /**
     * 每一页80个歌手
     * @param curPage
     * @param curPage
     * @return
     */
    public List<Singer> getTopRank(int curPage){
        int since=80*(curPage-1);
        return getTopRank(areaMap.get("全部"), sexMap.get("全部"),genreMap.get("全部"),indexMap.get("热门"),since,curPage);
    }

    /**
     *
     * @param area 地区
     * @param sex 性别
     * @param genre 种类
     * @param index 索引
     * @param sin 起始位置
     * @param curPage 当前页
     * @return
     */
    public List<Singer> getTopRank(int area,int sex,int genre,int index,int sin,int curPage){
        String requestParams=requestParamBuilder(area, sex,genre,index,sin,curPage);
        String response= null;
        try {
            response = HttpRequestHelper.downloadWebSiteUseGet(baseUrl+ URLEncoder.encode(requestParams,"utf-8"),null);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return parseSingerList(response);
    }


    private String requestParamBuilder(int area,int sex,int genre,int index,int sin,int curPage){
        RequestParam param= GsonConverter.fromJson(reqParam,RequestParam.class);
        param.getSingerList().getParam().setArea(area);
        param.getSingerList().getParam().setSex(sex);
        param.getSingerList().getParam().setGenre(genre);
        param.getSingerList().getParam().setIndex(index);
        param.getSingerList().getParam().setSin(sin);
        param.getSingerList().getParam().setCur_page(curPage);
        return GsonConverter.toJson(param);
    }
    private List<Singer> parseSingerList(String response){
        List<Singer> singerList=new LinkedList<>();
        if(response==null){
            return singerList;
        }
        try {
            ResponseBean responseBean=GsonConverter.fromJson(response,ResponseBean.class);
            List<ResponseBean.Data.Data1.Singer> singers=responseBean.getData().getData().getSingerList();
            for (ResponseBean.Data.Data1.Singer singer:singers){
                singerList.add(new Singer(singer.getSingeId(),singer.getSingerMid(),singer.getSingerName(),singer.getSingPic()));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return singerList;
    }


    /**
     * 请求格式如下
     * {
     *     "comm": {
     *         "cv": 1666,
     *         "ct": 20
     *     },
     *     "singerList": {
     *         "module": "Music.SingerListServer",
     *         "method": "get_singer_list",
     *         "param": {
     *             "area": -100,
     *             "sex": -100,
     *             "genre": -100,
     *             "index": -100,
     *             "sin": 0,
     *             "cur_page": 1
     *         }
     *     }
     * }
     */
    class RequestParam{
        Comm comm;
        SingerList singerList;

        public Comm getComm() {
            return comm;
        }

        public void setComm(Comm comm) {
            this.comm = comm;
        }

        public SingerList getSingerList() {
            return singerList;
        }

        public void setSingerList(SingerList singerList) {
            this.singerList = singerList;
        }

        class Comm{
            String cv;
            String ct;

            public String getCv() {
                return cv;
            }

            public void setCv(String cv) {
                this.cv = cv;
            }

            public String getCt() {
                return ct;
            }

            public void setCt(String ct) {
                this.ct = ct;
            }
        }

        class SingerList{
            String module;
            String method;
            Param param;

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
                int area;
                int sex;
                int genre;
                int index;
                int sin;
                int cur_page;

                public int getArea() {
                    return area;
                }

                public void setArea(int area) {
                    this.area = area;
                }

                public int getSex() {
                    return sex;
                }

                public void setSex(int sex) {
                    this.sex = sex;
                }

                public int getGenre() {
                    return genre;
                }

                public void setGenre(int genre) {
                    this.genre = genre;
                }

                public int getIndex() {
                    return index;
                }

                public void setIndex(int index) {
                    this.index = index;
                }

                public int getSin() {
                    return sin;
                }

                public void setSin(int sin) {
                    this.sin = sin;
                }

                public int getCur_page() {
                    return cur_page;
                }

                public void setCur_page(int cur_page) {
                    this.cur_page = cur_page;
                }
            }
        }
    }

    public class ResponseBean {
        int code;
        long ts;
        @SerializedName("start_ts")
        long startTs;
        @SerializedName("singerList")
        Data data;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public long getTs() {
            return ts;
        }

        public void setTs(long ts) {
            this.ts = ts;
        }

        public long getStartTs() {
            return startTs;
        }

        public void setStartTs(long startTs) {
            this.startTs = startTs;
        }

        public Data getData() {
            return data;
        }

        public void setData(Data data) {
            this.data = data;
        }

        class Data{
            int code;
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
                int area;
                int genre;
                int index;
                int sex;
                @SerializedName("singerlist")
                List<Singer> singerList;
                Tag tags;
                public int getArea() {
                    return area;
                }

                public void setArea(int area) {
                    this.area = area;
                }

                public int getGenre() {
                    return genre;
                }

                public void setGenre(int genre) {
                    this.genre = genre;
                }

                public int getIndex() {
                    return index;
                }

                public void setIndex(int index) {
                    this.index = index;
                }

                public int getSex() {
                    return sex;
                }

                public void setSex(int sex) {
                    this.sex = sex;
                }

                public List<Singer> getSingerList() {
                    return singerList;
                }

                public void setSingerList(List<Singer> singerList) {
                    this.singerList = singerList;
                }

                class Singer {
                    @SerializedName("singer_id")
                    public String singeId;
                    @SerializedName("singer_mid")
                    public String singerMid;
                    @SerializedName("singer_name")
                    public String singerName;
                    @SerializedName("singer_pic")
                    public String singPic;

                    public Singer() {
                    }

                    public Singer(String singeId, String singerMid, String singerName, String singPic) {
                        this.singeId = singeId;
                        this.singerMid = singerMid;
                        this.singerName = singerName;
                        this.singPic = singPic;
                    }

                    public String getSingeId() {
                        return singeId;
                    }

                    public void setSingeId(String singeId) {
                        this.singeId = singeId;
                    }

                    public String getSingerMid() {
                        return singerMid;
                    }

                    public void setSingerMid(String singerMid) {
                        this.singerMid = singerMid;
                    }

                    public String getSingerName() {
                        return singerName;
                    }

                    public void setSingerName(String singerName) {
                        this.singerName = singerName;
                    }

                    public String getSingPic() {
                        return singPic;
                    }

                    public void setSingPic(String singPic) {
                        this.singPic = singPic;
                    }

                }
            }
        }
    }

    class Tag{
        List<Option> area;
        List<Option> genre;
        List<Option> index;
        List<Option> sex;

        public List<Option> getArea() {
            return area;
        }

        public void setArea(List<Option> area) {
            this.area = area;
        }

        public List<Option> getGenre() {
            return genre;
        }

        public void setGenre(List<Option> genre) {
            this.genre = genre;
        }

        public List<Option> getIndex() {
            return index;
        }

        public void setIndex(List<Option> index) {
            this.index = index;
        }

        public List<Option> getSex() {
            return sex;
        }

        public void setSex(List<Option> sex) {
            this.sex = sex;
        }
        private class Option{
            int id;
            String name;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }



}
