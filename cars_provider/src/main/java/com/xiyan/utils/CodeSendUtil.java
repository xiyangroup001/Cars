package com.xiyan.utils;

import com.alibaba.fastjson.JSON;
import com.xiyan.utils.http.HttpArgs;
import com.xiyan.utils.http.HttpHelper;
import org.apache.commons.codec.binary.Hex;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CodeSendUtil {

    public static String send(String phone,String codeVal) {
        HttpArgs httpArgs = new HttpArgs();
        httpArgs.setMethod(HttpArgs.HttpMethod_Post);

        String u1=PropertiesUtil.getProp("TXCloud.server.url");
        String appid=PropertiesUtil.getProp("TXCloud.server.sdkappid");
        String appkey=PropertiesUtil.getProp("TXCloud.server.sdkappkey");
        String random = ""+new Random().nextInt();
        String time = new Date().getTime()/1000+"";

        String url = u1+"?sdkappid="+appid+"&random="+random;
        httpArgs.setUrl(url);
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("msg","如果不是您亲自所为，请忽略本信息！用户注册，您的验证码为"+codeVal+"，10分钟内有效！");

        HashMap<String,Object> telMap = new HashMap<>();
        telMap.put("mobile",phone);telMap.put("nationcode","86");

        hashMap.put("tel",telMap);
        hashMap.put("type",0);
        hashMap.put("time",""+time);
        //appkey=$appkey&random=$random&time=$time&mobile=$mobile
        String sig = "appkey="+appkey+"&random="+random+"&time="+time+"&mobile="+phone;
        hashMap.put("sig", getSHA256Str(sig));


        httpArgs.setPostData(JSON.toJSONString(hashMap));
        return HttpHelper.getInstance().run(httpArgs);
    }

    /***
     *  利用Apache的工具类实现SHA-256加密
     * @param str 加密后的报文
     * @return
     */
    public static String getSHA256Str(String str){
        MessageDigest messageDigest;
        String encdeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(str.getBytes("UTF-8"));
            encdeStr = Hex.encodeHexString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encdeStr;
    }



}
