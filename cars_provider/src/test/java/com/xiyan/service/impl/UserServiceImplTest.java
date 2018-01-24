package com.xiyan.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xiyan.model.entrty.User;
import com.xiyan.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;

import static org.junit.Assert.*;

/**
 * @antuor binwang
 * @date 2018/1/24  16:27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring.xml")

public class UserServiceImplTest {
    @Autowired
    private UserService userService;
    @Test
    public void selectAllUser() throws Exception {
        User u1 = new User();
        u1.setRegistrateTime( Timestamp.valueOf("2018-01-01 23:11:22"));
        System.out.println(JSON.toJSONString(u1, SerializerFeature.WriteMapNullValue));
        System.out.println(JSON.toJSONString(userService.selectAllUser()));
    }



}
