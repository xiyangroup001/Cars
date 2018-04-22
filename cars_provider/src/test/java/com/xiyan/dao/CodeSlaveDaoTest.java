package com.xiyan.dao;

import com.alibaba.fastjson.JSON;
import com.xiyan.dao.master.CodeMasterDao;
import com.xiyan.dao.slave.CodeSlaveDao;
import com.xiyan.model.entity.Code;
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
public class CodeSlaveDaoTest {
    @Resource
    CodeSlaveDao codeSlaveDao;
    @Resource
    CodeMasterDao codeMasterDao;

    @Test
    public void testOne(){
        Code c1 = new Code();
        c1.setUserPhone("12345678101");
        c1.setSendTime(new Date());
        c1.setCodeVal("1234565");
        codeMasterDao.insert(c1);
        System.out.println(JSON.toJSONString(codeSlaveDao.selectByPhone("12345678901")));

    }
}