package com.xiyan.service;

import com.xiyan.model.entity.Order;
import com.xiyan.model.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.annotation.Resource;

import java.util.Date;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring/spring.xml")
@SuppressWarnings("deprecation")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
//@Transactional
public class OrderServiceTest {
    @Resource
    private OrderService orderService;
    @Test
    public void testInsert(){
        User u1 = new User();
        u1.setUserName("xiyan");
        u1.setUserGuid("qazwsxedcrfvtgbyhnujmiko");
        u1.setUserPassword("123456");
        u1.setUserType((short) 0);
        u1.setUserPhone("12345678901");
        u1.setHeadPicUrl("iwrghjk");
        u1.setRegistrateTime(new Date());

        Order order = new Order();
        short s=1;
        order.setPayType(s);
        order.setUserId(1);
        order.setEndTime(new Date(108,4,16));
        order.setStartTime(new Date(108,5,16));
        order.setCarId(64);
        order.setTakeCarShop(102);
        order.setTotalAmount(20.5);
        order.setPrepayAmount(10.5);
        orderService.insertOrder(u1,order);
    }
}