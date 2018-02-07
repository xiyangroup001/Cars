package com.xiyan.dao.master;

import com.xiyan.model.entrty.Car;
import com.xiyan.model.entrty.twolevel.CarQualifications;
import com.xiyan.model.entrty.twolevel.CarsPictureUrl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @antuor binwang
 * @date 2018/2/7  10:54
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring/spring.xml")
@SuppressWarnings("deprecation")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
//@Transactional
public class CarMasterDaoTest {
    @Resource
    private CarMasterDao carMasterDao;
    @Test
    public void insertCar() throws Exception {
        /*
    private short aduitType;            //车辆审核状态
    private int aduitId;        //车辆审核号*/
        Car car = new Car();
        car.setCarId(10002);
        car.setAduitId(1001);
        car.setAduitType((short)1);
        car.setCarBrand("大众");
        car.setCarLicense("鲁A3503");
        car.setCarPrice(100.00);
        car.setCarState((short)1);
        car.setRentalPrice(111.25);
        car.setCarType((short)1);
        car.setCarState((short)2);
        car.setInStore(10236);
        CarQualifications qualifications = new CarQualifications();
        qualifications.setAddress("SSSSS");
        CarsPictureUrl carsPictureUrl = new CarsPictureUrl();

        carsPictureUrl.setComcInsrPicUrl("/001");
        carsPictureUrl.setRearPicUrl("/001");
        carsPictureUrl.setSidePicUrl("/001");
        carsPictureUrl.setInsideFrontPicUrl("/001");
        carsPictureUrl.setInsideRearPicUrl("/001");
        carsPictureUrl.setSignPicUrl("/001");
        carsPictureUrl.setLicensePicUrl("/001");
        carsPictureUrl.setInsrPicUrl("/001");
        carsPictureUrl.setComcInsrPicUrl("/001");

        ArrayList<String> list = new ArrayList<>();
        list.add("111");
        list.add("222");
        list.add("333");

        carsPictureUrl.setOtherPicUrl(list);
        car.setCarPicture(carsPictureUrl);
        car.setCarQualifications(qualifications);
        ArrayList<Integer> list1=new ArrayList<Integer>();
        list1.add(Integer.valueOf(11));
        car.setInsuranceType(list1);

        carMasterDao.insertCar(car);
    }



}
