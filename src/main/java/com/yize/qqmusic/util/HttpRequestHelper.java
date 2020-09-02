package com.yize.qqmusic.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class HttpRequestHelper {
    public static final String USER_AGENT_ANDROID="Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Mobile Safari/537.36";
    public static final String USER_AGENT_PC="Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36";
    public static final String HEADER_USER_AGENT="User-Agent";
    public static final String HEADER_CONNECTION="Connection";
    public static final String HEADER_COOKIE="Cookie";
    public static final String HEADER_CONTENT_TYPE="Content-Type";
    public static final String HEADER_HOST="Host";
    public static final String HEADER_ACCEPT="Accept";
    private static final Logger logger= LogManager.getLogger(Base64Converter.class);
    public static String downloadWebSiteUseGet(String link, Map<String,String> headerMap){
        StringBuilder sb=new StringBuilder();
        try {
            URL url=new URL(link);
            HttpURLConnection conn=(HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(10000);
            if(headerMap!=null){
                for (String key:headerMap.keySet()){
                    conn.addRequestProperty(key,headerMap.get(key));
                }
            }
            BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line=reader.readLine())!=null){
                sb.append(line);
            }
            reader.close();
            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info(link);
        return sb.toString();
    }
    /**
     * 做POST请求
     * @param link 请求地址
     * @param params 请求体，类似于keyword=十年&num=100这样的格式
     * @param headerMap
     * @return
     */
    public static String downloadWebSiteUsePost(String link,String params, Map<String,String> headerMap){
        String response=null;
        try {
            URL url=new URL(link);
            HttpURLConnection conn=(HttpURLConnection)url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setConnectTimeout(10000);
            conn.setReadTimeout(10000);
            if((headerMap!=null&&headerMap.keySet().size()>0)){
                for(String key:headerMap.keySet()){
                    conn.setRequestProperty(key,headerMap.get(key));
                }
            }
            PrintWriter writer=new PrintWriter(conn.getOutputStream());
            writer.print(params);
            writer.flush();
            BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
            String line;
            StringBuilder sb=new StringBuilder();
            while ((line=reader.readLine())!=null){
                sb.append(line);
            }
            writer.close();
            reader.close();
            conn.disconnect();
            response=sb.toString();
        }catch (Exception ignored){

        }
        return response;
    }
}
