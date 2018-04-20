package com.xiyan.utils.http;

import java.util.Map;

/**
 * Created by Sha Zhou on 2018/3/3.
 */
public class HttpArgs {
    private String url;
    private String method;

    public static final String HttpMethod_Get = "GET";
    public static final String HttpMethod_Post = "POST";

    private Map<String, String> headers;
    private String postData;
    private String contentType;

    public static final String ContentType_Json_Utf8 = "application/json;charset=utf-8";

    private int connectTimeout = Default_ConnectTimeout_MS;
    private int readTimeout = Default_ReadTimeout_MS;

    public static final int Default_ConnectTimeout_MS = 5000;
    public static final int Default_ReadTimeout_MS =10000;

    public String getUrl(){
        return this.url;
    }
    public void setUrl(String url){
        this.url = url;
    }
    public String getMethod(){
        return this.method;
    }
    public void setMethod(String method){
        this.method = method;
    }
    public Map<String, String> getHeaders(){
        return this.headers;
    }
    public void setHeaders(Map<String, String> headers){
        this.headers = headers;
    }
    public String getPostData(){
        return this.postData;
    }
    public void setPostData(String postData){
        this.postData = postData;
    }
    public String getContentType(){
        return this.contentType;
    }
    public void setContentType(String contentType){
        this.contentType = contentType;
    }
    public int getConnectTimeout(){
        return this.connectTimeout;
    }
    public void setConnectTimeout(int connectTimeout){
        this.connectTimeout = connectTimeout;
    }
    public int getReadTimeout(){
        return this.readTimeout;
    }
    public void setReadTimeout(int readTimeout){
        this.readTimeout = readTimeout;
    }
}
