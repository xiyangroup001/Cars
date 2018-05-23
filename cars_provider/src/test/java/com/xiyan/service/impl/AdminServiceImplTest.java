package com.xiyan.service.impl;

import com.xiyan.model.entity.Admin;
import com.xiyan.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @antuor binwang
 * @date 2018/2/8  18:15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring/spring.xml")
@SuppressWarnings("deprecation")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class AdminServiceImplTest {
    @Resource
    private AdminService adminService;
    @Test
    @Transactional
    public void deleteAdmin() throws Exception {
    }

    @Test
    public void insertAdmin() throws Exception {
        Admin admin = new Admin();
        admin.setAdminId("36985214798765412X");
        admin.setAdminName("xiyan001");
        admin.setPassWord("123456789");
        admin.setPlatformId((short) 1);
        admin.setPower((short)2);
        admin.setStore(1003);

       // adminService.createAdmin(admin,admin);
    }

    @Test
    public void testcheck() throws Exception {
        Admin admin = new Admin();

        admin.setPower(Admin.SUPER_ADMIN);
        //adminService.checkCarPass(admin,139);
        System.out.println(adminService.listUnde(admin));
        // adminService.createAdmin(admin,admin);
    }


}
