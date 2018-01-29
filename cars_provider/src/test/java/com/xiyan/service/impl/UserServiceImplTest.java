package com.xiyan.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xiyan.model.entrty.User;
import com.xiyan.service.UserService;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @antuor binwang
 * @date 2018/1/24  16:27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring.xml")
@SuppressWarnings("deprecation")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    public void selectAllUser() throws Exception {
        System.out.println(new Timestamp(System.currentTimeMillis()));

        User u1 = new User();
        u1.setRegistrateTime("2017-11-11 12:53:22");
        System.out.println(JSON.toJSONString(u1, SerializerFeature.WriteMapNullValue));
        System.out.println(JSON.toJSONString(userService.selectAllUser()));
    }


    @Test
    @Rollback
    @Transactional
    public void saveUser() throws Exception {
        User u1 = new User();
        u1.setUserId(1003);
        u1.setUserName("xiyan");
        u1.setUserGuid("qazwsxedcrfvtgbyhnujmiko");
        u1.setUserPassword("123456");
        u1.setUserType((short) 0);
        u1.setUserPhone("12345678901");
        u1.setHeadPicUrl("iwrghjk");
        u1.setRegistrateTime("2017-11-11 12:53:22");
        System.out.println(userService.insertUser(u1));
    }


}
