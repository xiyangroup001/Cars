package com.xiyan.dao.slave;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @antuor binwang
 * @date 2018/2/7  11:32
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring/spring.xml")
@SuppressWarnings("deprecation")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class CarSlaveDaoTest {
    @Resource
    private CarSlaveDao carSlaveDao;
    @Test
    public void selectAllCar() throws Exception {
        System.out.println(carSlaveDao.selectAll());
    }

    @Test
    public void selectCarByCondition() throws Exception {
        int[] a = new int[]{1,2,3};
        String[] brand = new String[]{"大众","奔驰","宝马"};
        System.out.println(carSlaveDao.selectCarByCondition(10236,a,brand,30,120000,50,200));
    }

}
