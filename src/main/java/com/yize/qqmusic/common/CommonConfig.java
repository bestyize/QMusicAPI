package com.yize.qqmusic.common;

import java.util.HashMap;

import static com.yize.qqmusic.model.SongUtils.*;
import static com.yize.qqmusic.model.SongUtils.QUALITY_LQ;

public class CommonConfig {
    public static final HashMap<String, String> qualityMap;
    public static final HashMap<String, String> qualityFileTypeMap ;
    public static final String baseDownloadServer="http://ws.stream.qqmusic.qq.com/";

    static {
        qualityMap=new HashMap<>();
        qualityMap.put(QUALITY_SQ,"F000songid.flac");
        qualityMap.put(QUALITY_HQ,"M800songid.mp3");
        qualityMap.put(QUALITY_PQ,"M500songid.mp3");
        qualityMap.put(QUALITY_LQ,"C400songid.m4a");
        qualityFileTypeMap=new HashMap<>();
        qualityFileTypeMap.put(QUALITY_SQ,"flac");
        qualityFileTypeMap.put(QUALITY_HQ,"mp3");
        qualityFileTypeMap.put(QUALITY_PQ,"mp3");
        qualityFileTypeMap.put(QUALITY_LQ,"m4a");
    }
}
