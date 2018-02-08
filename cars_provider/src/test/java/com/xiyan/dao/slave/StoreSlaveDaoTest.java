package com.xiyan.dao.slave;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @antuor binwang
 * @date 2018/2/6  11:24
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring/spring.xml")
@SuppressWarnings("deprecation")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class StoreSlaveDaoTest {
    private Logger logger = LoggerFactory.getLogger(StoreSlaveDaoTest.class);
    @Resource
    private StoreSlaveDao storeSlaveDao;
    @Test
    public void selectAllStore() throws Exception {
        logger.info(JSON.toJSONString(storeSlaveDao.listAllStore()));
    }


}
