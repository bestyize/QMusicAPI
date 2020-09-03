package com.yize.qqmusictest;

import com.yize.qqmusic.util.HttpRequestHelper;
import org.junit.Test;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.InputStreamReader;
//https://blog.csdn.net/friendan/article/details/51746664
public class QqMusicSignTest {
    @Test
    public void testSign(){
        String params="";
        ScriptEngineManager manager=new ScriptEngineManager();
        ScriptEngine engine=manager.getEngineByName("JavaScript");
        String scriptText= HttpRequestHelper.downloadWebSiteUseGet("http://localhost/requestSign.js",null);
        System.out.println(scriptText);
        try {
            engine.eval(scriptText);
            if(engine instanceof Invocable){
                Invocable invocable=(Invocable)engine;
                String result=(String)invocable.invokeFunction("getSecuritySign",params);
                System.out.println(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
