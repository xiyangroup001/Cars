package com.xiyan.service;

import com.xiyan.model.entity.Car;
import com.xiyan.model.utils.APIResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring/spring.xml")
@SuppressWarnings("deprecation")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
//@Transactional
public class CarServiceTest {
    @Resource
    private CarService carService;

    @Test
    public void test() {
        Object cars = carService.selectCarByStore(10236);
        System.out.println(cars);
    }
}