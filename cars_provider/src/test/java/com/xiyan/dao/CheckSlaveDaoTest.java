package com.xiyan.dao;

import com.alibaba.fastjson.JSON;
import com.xiyan.dao.master.CheckMasterDao;
import com.xiyan.dao.slave.CheckSlaveDao;
import com.xiyan.model.entity.Check;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.annotation.Resource;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring/spring.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
//@Transactional
public class CheckSlaveDaoTest {
    @Resource
    private CheckSlaveDao checkSlaveDao;

    @Resource
    private CheckMasterDao checkMasterDao;

    @Test
    public void testInsert(){
        Check check = new Check();
        check.setCheckTime(new Date());
        Short s = 1;
        check.setCheckType(s);
        check.setCheckUser("369852147789654123");
        check.setCheckResult("符合要求");
        checkMasterDao.insert(check);
        check.setCheckResult("qqqq");
        checkMasterDao.update(check);
        System.out.println(checkSlaveDao.selectAll());
//        checkMasterDao.delete(check.getCheckId());
        System.out.println(checkSlaveDao.selectAll());
        System.out.println(JSON.toJSONString(checkSlaveDao.selectById(1)));
        System.out.println(JSON.toJSONString(checkSlaveDao.selectRowNumber()));
        check.setCheckId(1);

        System.out.println(JSON.toJSONString(checkSlaveDao.select(check)));

    }
}