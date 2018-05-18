package com.xiyan.service;

import com.xiyan.model.entity.Admin;
import com.xiyan.model.entity.Conpon;
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
public class ConponServiceTest {

    @Resource
    private ConponService conponService;
    @Test
    public void testInsert(){
        Admin admin = new Admin();
        admin.setAdminId("36985214798765412X");
        admin.setAdminName("xiyan001");
        admin.setPassWord("123456789");
        admin.setPlatformId((short) 1);
        admin.setPower(Admin.SUPER_ADMIN);
        admin.setStore(1003);

        Conpon conpon  = new Conpon();
        conpon.setUserId(1);
        conpon.setExpiredTime(new Date(118,5,15));
        conpon.setMinus(10.0);
        conpon.setSatisfy(50.0);
        conponService.insertConpon(conpon,admin);
    }

}