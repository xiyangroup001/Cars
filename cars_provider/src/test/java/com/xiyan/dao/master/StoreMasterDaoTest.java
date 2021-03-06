package com.xiyan.dao.master;

import com.xiyan.model.entity.Store;
import com.xiyan.model.entity.twolevel.Position;
import com.xiyan.service.StoreService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

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
    @Autowired
    private StoreService storeService;
    @Test
    public void insertStore() throws Exception {
        Position p1 = new Position();
        p1.setLatitude(11.11);
        p1.setLongitude(22.22);
        p1.setCity("北京");
        p1.setAddress("朝阳区酒仙桥180号");
        Store store = new Store();
        store.setLocation(p1);
       // store.setStoreId(1002);
        store.setStoreName("第一门店");
        store.setPlatform((short) 1);
        storeMasterDao.insert(store);

    }
    @Test
    public void insertssStore() throws Exception {
        storeService.getStoreByCity("北京");
    }

}
