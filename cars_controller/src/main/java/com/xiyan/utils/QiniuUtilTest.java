package com.xiyan.utils;

import io.jsonwebtoken.Claims;
import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class QiniuUtilTest {
    @Test
    public void maissn() {
        try {
            File file= new File("C:\\Users\\beta_\\Desktop","004.jpg");
            MultipartFile multipartFile = new MockMultipartFile("ss1",new FileInputStream(file));
            System.out.println(QiniuUtil.upload(multipartFile.getInputStream(), "3506"));
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

    @Test
    public void mssssaissn() {
        try {
            QiniuUtil.delete("3506");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}