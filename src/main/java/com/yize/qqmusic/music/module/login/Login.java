package com.yize.qqmusic.music.module.login;

import com.yize.qqmusic.model.user.Token;
import com.yize.qqmusic.util.HttpRequestHelper;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import static com.yize.qqmusic.common.UrlConfig.baseLink;

public class Login {
    public Token getToken(){
        String params="{\"comm\":{\"g_tk\":5381,\"platform\":\"yqq\",\"ct\":24,\"cv\":0},\"token\":{\"module\":\"QQConnectLogin.LoginServer\",\"method\":\"QQLogin\",\"param\":{\"code\":\"4DD9F11569182A6EFE3892FB53D34BFB\"}}}";
        Map<String,String> headerMap=new HashMap<>();
        headerMap.put("Cookie","yqq_stat=0; pgv_pvi=3140648960; pgv_si=s7089171456; pgv_info=ssid=s2737208574; ts_last=y.qq.com/; pgv_pvid=5082563395; ts_uid=9569481894; userAction=1; _qpsvr_localtk=0.30240888522338083; ptui_loginuin=3011429848; RK=sPYobRfWn4; ptcz=1bf191e98451d4e577be2422a2ca824ebe2c524ead518927eb1dfe9398e274ac");
        headerMap.put("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4209.2 Safari/537.36");
        headerMap.put("Host","u.y.qq.com");
        headerMap.put("Referer","https://y.qq.com");
        headerMap.put("Origin","https://y.qq.com");
        String response= null;
        try {
            String requestLink=baseLink+"?data="+ URLEncoder.encode(params,"utf-8");
            System.out.println(requestLink);
            response = HttpRequestHelper.downloadWebSiteUseGet(requestLink,headerMap);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(response);
        return null;
    }
}
