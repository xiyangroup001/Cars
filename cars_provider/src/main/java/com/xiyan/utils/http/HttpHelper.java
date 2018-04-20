package com.xiyan.utils.http;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/**
 * Created by Sha Zhou on 2018/3/3.
 */
public class HttpHelper {
    private Logger logger = LoggerFactory.getLogger(HttpHelper.class);
    private String charSet = "UTF-8";

    private static HttpHelper instance;
    public static HttpHelper getInstance(){
        if(instance == null){
            instance = new HttpHelper();
        }
        return instance;
    }

    public String run(HttpArgs args){
        HttpURLConnection connection = null;
        OutputStream outputStream = null;
        OutputStreamWriter outputWriter = null;
        try {
            URL url = new URL(args.getUrl());
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(args.getMethod());
            if(args.getContentType() != null) {
                connection.setRequestProperty("Content-Type", args.getContentType());
            }
            if(args.getHeaders() != null) {
                for (Map.Entry<String, String> entry : args.getHeaders().entrySet()) {
                    connection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }
            if(args.getConnectTimeout() != 0){
                connection.setConnectTimeout(args.getConnectTimeout());
            }
            if(args.getReadTimeout() != 0){
                connection.setReadTimeout(args.getReadTimeout());
            }
            if(args.getPostData() != null && StringUtils.equalsIgnoreCase("post", args.getMethod())){
                connection.setDoInput(true);
                connection.setDoOutput(true);
                connection.connect();

                outputStream = connection.getOutputStream();
                outputWriter = new OutputStreamWriter(outputStream, "UTF-8");
                outputWriter.write(args.getPostData());
                outputWriter.flush();
            } else {
                connection.connect();
            }

            StringBuilder sb = new StringBuilder();
            //这里才实际发送
            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputReader;
            BufferedReader bufferReader;

            int statusCode = connection.getResponseCode();
            logger.info("http post finish! url:" + args.getUrl() + ",statusCode:" + statusCode);
            String contentEncoding = connection.getContentEncoding();
            if(StringUtils.equalsIgnoreCase("gzip", contentEncoding)){
                GZIPInputStream gzipInputStream = new GZIPInputStream(inputStream);
                inputReader = new InputStreamReader(gzipInputStream, charSet);
                bufferReader = new BufferedReader(inputReader);
            }else{
                inputReader = new InputStreamReader(inputStream, charSet);
                bufferReader = new BufferedReader(inputReader);
            }

            String line;
            while((line = bufferReader.readLine()) != null){
                sb.append(line);
                sb.append(System.lineSeparator());
            }
            return sb.toString();
        } catch (MalformedURLException e){
            logger.error("http post error!", e);
            return null;
        } catch(ProtocolException e){
            logger.error("http post error!", e);
            return null;
        } catch (IOException e){
            logger.error("http post error!", e);
            return null;
        } finally {
            try{
                if(outputWriter != null){
                    outputWriter.close();
                }
                if(outputStream != null){
                   outputStream.close();
                }
                if(connection != null){
                    connection.disconnect();
                }
            } catch(IOException e){
                logger.error("http post finally error!", e);
            }
        }
    }
}
