package com.xiyan.service;

import com.xiyan.model.entity.Admin;
import com.xiyan.model.entity.Car;
import com.xiyan.model.entity.twolevel.CarQualification;
import com.xiyan.model.entity.twolevel.CarsPictureUrl;
import com.xiyan.model.utils.APIResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring/spring.xml")
@SuppressWarnings("deprecation")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
//@Transactional
public class CarServiceTest {
    @Resource
    private CarService carService;
    @Resource
    private AdminService adminService;

    @Test
    public void test() {
        Object cars = carService.selectCarByStore(10236);
        System.out.println(cars);
    }

    @Test
    public void test2() {
        Car car = new Car();
        car.setCarId(10002);
        car.setAduitId(1001);
        car.setAduitType((short)1);
        car.setCarBrand("大众");
        car.setCarLicense("鲁A3503");
        car.setCarPrice(100000.00);
        car.setCarState((short)1);
        car.setRentalPrice(111.25);
        car.setCarType((short)1);
        car.setCarState((short)2);
        car.setInStore(10236);
        CarQualification qualification = new CarQualification();
        qualification.setAddress("SSSSS");
        CarsPictureUrl carsPictureUrl = new CarsPictureUrl();

        carsPictureUrl.setComcInsrPicUrl("/001");
        carsPictureUrl.setRearPicUrl("/002");
        carsPictureUrl.setSidePicUrl("/003");
        carsPictureUrl.setInsideFrontPicUrl("/004");
        carsPictureUrl.setInsideRearPicUrl("/005");
        carsPictureUrl.setSignPicUrl("/006");
        carsPictureUrl.setLicensePicUrl("/007");
        carsPictureUrl.setInsrPicUrl("/008");
        carsPictureUrl.setComcInsrPicUrl("/009");

        ArrayList<String> list = new ArrayList<>();
        list.add("111");
        list.add("222");
        list.add("333");

        carsPictureUrl.setOtherPicUrl(list);
        car.setCarPicture(carsPictureUrl);
        car.setCarQualification(qualification);
        ArrayList<Integer> list1=new ArrayList<Integer>();
        list1.add(Integer.valueOf(11));
        car.setInsuranceType(list1);

        Admin admin = adminService.getAdminByName("张三1");
        carService.createCar(admin,car);
        System.out.println(carService.selectCarByStore(10025));;
    }
}