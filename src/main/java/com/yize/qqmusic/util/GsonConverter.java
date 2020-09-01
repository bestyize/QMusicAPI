package com.yize.qqmusic.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

public class GsonConverter {
    private static Gson gson=new GsonBuilder().disableHtmlEscaping().create();
    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }
    public static void printToJson(Object obj){
        System.out.println(gson.toJson(obj));
    }
    public static <T> T fromJson(String json, Class<T> classOfT) throws JsonSyntaxException {
        return gson.fromJson(json,classOfT);
    }
}
