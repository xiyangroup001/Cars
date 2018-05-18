package com.xiyan.service.impl;

import com.xiyan.service.AdminService;
import com.xiyan.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring/spring.xml")
@SuppressWarnings("deprecation")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)

public class OrderServiceImplTest {

    @Resource
    private OrderService orderService;
    @Test
    @Transactional
    public void orderService() throws Exception {
        System.out.println(orderService.listOrderByUserId(1));;
    }
}