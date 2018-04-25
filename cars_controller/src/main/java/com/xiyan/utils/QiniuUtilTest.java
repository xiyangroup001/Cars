package com.xiyan.utils;

import io.jsonwebtoken.Claims;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;


public class QiniuUtilTest {
    @Test
    public void maissn() {
        try {
            File file= new File("C:\\Users\\beta_\\Desktop","003.jpg");
            System.out.println(QiniuUtil.upload(new FileInputStream(file), "35005"));
        } catch (Exception e) {
            e.getMessage();
        }
    }
    @Test
    public void mssaissn() {
        try {

            String s1 = JWTUtil.createJWT("12356","12356", 1000*60*60);
            String s2 = JWTUtil.createJWT("12356","12356", 1000*60*60);
            System.out.println(s1.equals(s2));
            Claims claims = JWTUtil.parseJWT(s1);
            String username = claims.getSubject();
            Claims claims2 = JWTUtil.parseJWT(s2);
            String username2 = claims.getSubject();
            System.out.println(username.equals(username2));

        } catch (Exception e) {
            e.getMessage();
        }
    }


}