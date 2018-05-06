package com.xiyan.dao;

import com.xiyan.dao.master.AdminMasterDao;
import com.xiyan.dao.slave.AdminSlaveDao;
import com.xiyan.model.entity.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring/spring.xml")
@TransactionConfiguration(transactionManager = "txManager")
public class AdminMasterDaoTest {
    @Resource
    private AdminMasterDao adminMasterDao;

    @Resource
    private AdminSlaveDao adminSlaveDao;

    @Test
    @Rollback
    public void testInsert(){
        Admin admin = new Admin();
        admin.setAdminId("123654789963258789");
        admin.setAdminName("张三");
        Short s=1;
        admin.setPlatformId(s);
        admin.setPower(s);
        admin.setPassWord("96325874123");
        admin.setStore(10025);
//        adminMasterDao.insert(admin);
        System.out.println(admin);
        admin.setPassWord("111111111");
     //   adminMasterDao.update(admin);
   //     adminMasterDao.delete(1234);
        System.out.println(adminSlaveDao.selectAll());
//        System.out.println(adminSlaveDao.selectById("123654789963258742"));
    }
}