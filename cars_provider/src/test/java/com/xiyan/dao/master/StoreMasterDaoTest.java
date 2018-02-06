package com.xiyan.dao.master;

import com.xiyan.model.entrty.Store;
import com.xiyan.model.entrty.twolevel.Position;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * @antuor binwang
 * @date 2018/2/5  19:40
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring/spring.xml")
@SuppressWarnings("deprecation")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
//@Transactional
public class StoreMasterDaoTest {

    @Autowired
    private StoreMasterDao storeMasterDao;
    @Test
    public void insertStore() throws Exception {
        Position p1 = new Position();
        p1.setLatitude(11.11);
        p1.setLongitude(22.22);

        Store store = new Store();
        store.setLocation(p1);
        store.setStoreId(1002);
        store.setStoreName("第一门店");
        store.setPlatform((short) 1);
        storeMasterDao.insertStore(store);

    }



}
