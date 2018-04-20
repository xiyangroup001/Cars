package com.xiyan.utils;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
    static Properties properties = new Properties();
    public static String getProp(String key){
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
       return properties.getProperty(key);
    }

}
