package com.yize.qqmusic.common.request;

import com.yize.qqmusic.util.GsonConverter;

import java.util.Map;

public class RequestBean {
    private String method;
    private String module;
    private Map<String,Object> param;

    public RequestBean() {
    }

    public RequestBean(String method, String module, Map<String, Object> param) {
        this.method = method;
        this.module = module;
        this.param = param;
    }

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

    public Map<String, Object> getParam() {
        return param;
    }

    public void setParam(Map<String, Object> param) {
        this.param = param;
    }

    @Override
    public String toString() {
        return GsonConverter.toJson(this);
    }
}
