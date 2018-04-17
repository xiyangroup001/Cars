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



}
