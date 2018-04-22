package com.xiyan.utils;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class QiniuUtilTest {
    @Test
    public void maissn() {
        try {

            System.out.println(QiniuUtil.upload(new File("D:\\resources\\1524126034084_cut.jpg"), "1524126034084_cut.jpg"));
        } catch (Exception e) {
            e.getMessage();
        }
    }
}