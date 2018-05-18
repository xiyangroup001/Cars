package com.xiyan.dao.master;

import com.xiyan.model.entity.Admin;
import com.xiyan.model.entity.Car;
import com.xiyan.model.entity.twolevel.CarQualification;
import com.xiyan.model.entity.twolevel.CarsPictureUrl;
import com.xiyan.model.entity.twolevel.ReserveDate;
import com.xiyan.service.AdminService;
import com.xiyan.service.CarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
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
    @Resource
    private CarService carService;
    @Resource
    private AdminService adminService;

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

        List<ReserveDate> reserveDates =new ArrayList<ReserveDate>();

        ReserveDate reserveDate = new ReserveDate();
        reserveDate.setStartDate( new Date(118,5,9));
        reserveDate.setEndDate( new Date(118,5,12));
        reserveDates.add(reserveDate);
        car.setReserveDateList(reserveDates);
        car.setCarId(120);
        carMasterDao.update(car);
       // Admin admin = adminService.getAdminByName("张三1");
       // carService.createCar(admin,car);
    }

    @Test
    public void selectCars() {
        Date d1 =  new Date(118,5,8);
        Date d2 =  new Date(118,5,11);
        Date cd1 =  new Date(118,5,9);
        Date cd2 =  new Date(118,5,12);
        System.out.println(checkTime(d1,d2,cd1,cd2));
    }
    private boolean checkTime(Date d1,Date d2,Date cd1,Date cd2){
        return cd1.after(d2) || cd2.before(d1);

    }

}
