package com.xiyan.utils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;


public class QiniuUtil {

    //设置需要操作的账号的AK和SK
    private static final String ACCESS_KEY = PropertiesUtil.getProp("QINIU.ACCESS_KEY");
    private static final String SECRET_KEY = PropertiesUtil.getProp("QINIU.SECRET_KEY");

    //要上传的空间
    private static final String bucketname = PropertiesUtil.getProp("QINIU.bucketname");

    //密钥
    private static final Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

    //构造一个带指定Zone对象的配置类
    static Configuration cfg = new Configuration(Zone.zone0());
    //...其他参数参考类注释
    static UploadManager uploadManager = new UploadManager(cfg);
    //普通上传
    public static String upload(File file) throws IOException{
        try {
            //调用put方法上传
            Response res = uploadManager.put(file,new Date().getTime()+"",auth.uploadToken(bucketname));
            //打印返回的信息
            System.out.println(res.bodyString());
            return res.jsonToMap().get("key").toString();
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            //System.out.println(r.toString());
            try {
                //响应的文本信息
                System.out.println(r.bodyString());
            } catch (QiniuException e1) {
                //ignore
            }
        }
        return "";
    }

    //普通上传
    public static String upload(File file,String key) throws IOException{
        try {
            //调用put方法上传
            Response res = uploadManager.put(file,key,auth.uploadToken(bucketname));
            //打印返回的信息
            System.out.println(res.bodyString());
            return res.jsonToMap().get("key").toString();
        } catch (QiniuException e) {
            e.printStackTrace();
        }
        return "";
    }

    //普通上传
    public static String upload(InputStream inputStream) throws IOException{
        try {
            Response response = uploadManager.put(inputStream,new Date().getTime()+"",auth.uploadToken(bucketname),null, null);
            //解析上传成功的结果
            return response.jsonToMap().get("key").toString();
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
        return "";
    }
    //普通上传
    public static String upload(InputStream inputStream,String key) throws IOException{
        try {
            Response response = uploadManager.put(inputStream,key,auth.uploadToken(bucketname),null, null);
            //解析上传成功的结果
            return response.jsonToMap().get("key").toString();
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
        return "";
    }
    //普通删除
    public static void delete(String key) throws IOException {
        //实例化一个BucketManager对象
        BucketManager bucketManager = new BucketManager(auth, cfg);
        //此处的33是去掉：http://p7kmq7vjn.bkt.clouddn.com/,剩下的key就是图片在七牛云的名称
        //System.out.println("key---------->" + key);
        try {
            //调用delete方法移动文件
            bucketManager.delete(bucketname, key);
        } catch (QiniuException e) {
            //捕获异常信息
            Response r = e.response;
            System.out.println(r.toString());
        }
    }
}