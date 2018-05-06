package com.xiyan.dao.master;

import com.xiyan.model.entity.Code;
import com.xiyan.service.CarService;
import com.xiyan.service.CodeService;
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
public class CodeMasterDaoTest {
    @Resource
    CodeMasterDao codeMasterDao;

    @Resource
    CodeService codeService;

    @Test
    public void test() {
        codeService.sendCode("77777777777");
        Code c1= new Code();
        c1.setCodeVal("1232225");
        c1.setSendTime(new Date());
        c1.setUserPhone("98745632145");

        codeMasterDao.update(c1);
    }
}