package com.xiyan.service.impl;


import com.alibaba.fastjson.JSON;
import com.xiyan.model.entity.User;
import com.xiyan.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


/**
 * @antuor binwang
 * @date 2018/1/24  16:27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring/spring.xml")
@SuppressWarnings("deprecation")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class UserServiceImplTest {
    @Autowired
    private UserService userService;
    private Logger logger = LoggerFactory.getLogger(UserServiceImplTest.class);
    @Test
    public void deleteUser() throws Exception {
       // System.out.println(userService.deleteUser(1001));
    }

    @Test
    public void insertUser() throws Exception {
        User u1 = new User();
        u1.setUserId(1006);
        u1.setUserName("xiyan");
        u1.setUserGuid("qazwsxedcrfvtgbyhnujmiko");
        u1.setUserPassword("123456");
        u1.setUserType((short) 0);
        u1.setUserPhone("12345678901");
        u1.setHeadPicUrl("iwrghjk");
        u1.setRegistrateTime(new Date());
        logger.info("传入的参数为：{}",u1.toString());
        System.out.println(userService.insertUser(u1));
    }

    @Test
    public void selectAllUser1() throws Exception {
        System.out.println(userService.listAllUser());
    }

    @Test
    public void updateUser() throws Exception {
    }



    @Test
    public void selectAllUser() throws Exception {

//        User u1 = new User();
//        u1.setRegistrateTime("2017-11-11 12:53:22");
//        System.out.println(JSON.toJSONString(u1, SerializerFeature.WriteMapNullValue));
        String result = JSON.toJSONString(userService.listAllUser());
        logger.info("结果是：{}", result);
        System.out.println(result);
        System.out.println(result);
    }


    @Test
    @Rollback
    @Transactional
    public void saveUser() throws Exception {
        User u1 = new User();
        u1.setUserName("xiyan");
        u1.setUserGuid("qazwsxedcrfvtgbyhnujmiko");
        u1.setUserPassword("123456");
        u1.setUserType((short) 0);
        u1.setUserPhone("12345678901");
        u1.setHeadPicUrl("iwrghjk");
        u1.setRegistrateTime(new Date());
        System.out.println(userService.insertUser(u1));
    }


}
