package com.xiyan.service.impl;

import com.google.common.base.Preconditions;
import com.xiyan.dao.master.CarMasterDao;
import com.xiyan.dao.master.CheckMasterDao;
import com.xiyan.dao.slave.CarSlaveDao;
import com.xiyan.dao.slave.CheckSlaveDao;
import com.xiyan.model.entity.Admin;
import com.xiyan.model.entity.Car;
import com.xiyan.model.entity.Check;
import com.xiyan.model.entity.twolevel.ReserveDate;
import com.xiyan.model.exception.BizException;
import com.xiyan.model.utils.APIResponse;
import com.xiyan.model.utils.ApiTemplate;
import com.xiyan.service.CarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("carService")
public class CarServiceImpl implements CarService {
    @Resource
    CarMasterDao carMasterDao;
    @Resource
    CarSlaveDao carSlaveDao;

    @Resource
    CheckMasterDao checkMasterDao;
    @Resource
    CheckSlaveDao checkSlaveDao;


    @Override
    public APIResponse<Integer> deleteCar(Integer carId) {
        return null;
    }

    @Override
    public APIResponse<Integer> createCar(Admin currentAdmin, Car car) {

        return new ApiTemplate<Integer>() {
            @Override
            protected void checkParams() throws BizException {
                Preconditions.checkNotNull(car , "传入数据不能为NULL");
                Preconditions.checkArgument(car.getCarBrand()!=null&&!car.getCarBrand().equals(""), "传入品牌不能为NULL");
                Preconditions.checkArgument(car.getCarLicense()!=null&&!car.getCarLicense().equals(""), "传入牌照不能为NULL");
                Preconditions.checkArgument(car.getRentalPrice()!=null&&car.getRentalPrice() >= 0, "租金需要大于等于0");
                Preconditions.checkArgument(car.getRentalPrice()!=null&&car.getCarPrice() > 0, "车辆价位需要大于0");

            }

            @Override
            protected APIResponse<Integer> process() throws BizException {

                logger.info("参数 操作人： currentAdmin : {}", currentAdmin);
                logger.info("参数 car : {}", car);
                Check c1 = new Check();
                c1.setCheckType(Check.CHECK_CAR);
                checkMasterDao.insert(c1);

                car.setInStore(currentAdmin.getStore());
                car.setCarState(Car.SYATE_INSTORE);
                car.setAduitType(Car.NOT_ADUIT);
                car.setAduitId(c1.getCheckId());
                List<ReserveDate> reserveDates = new ArrayList<>();
                car.setReserveDateList(reserveDates);
                carMasterDao.insert(car);
                return APIResponse.returnSuccess();
            }
        }.execute();
    }

    @Override
    public APIResponse<Integer> createCarList(List<Car> cars) {
        return null;
    }

    @Override
    public APIResponse<List<Car>> selectCars() {
        return null;
    }

    @Override
    public APIResponse<Integer> updateCar(Admin currentAdmin, Car car) {
        return new ApiTemplate<Integer>() {
            @Override
            protected APIResponse<Integer> process() throws BizException {
                if (currentAdmin.getStore() != car.getInStore()) {
                    return APIResponse.returnFail("只能修改所在门店的车！");
                }
                Preconditions.checkArgument(car != null, "传入数据不能为NULL");
                Preconditions.checkArgument(!car.getCarBrand().equals(""), "传入品牌不能为NULL");
                Preconditions.checkArgument(!car.getCarLicense().equals(""), "传入牌照不能为NULL");
                Preconditions.checkArgument(car.getRentalPrice() >= 0, "租金需要大于等于0");
                Preconditions.checkArgument(car.getCarPrice() > 0, "车辆价位需要大于0");

                Check c1 = new Check();
                c1.setCheckType(Check.CHECK_CAR);
                checkMasterDao.insert(c1);
                car.setAduitType(Car.NOT_ADUIT);
                car.setAduitId(c1.getCheckId());
                carMasterDao.insert(car);
                return APIResponse.returnSuccess();
            }
        }.execute();

    }

    @Override
    public APIResponse<Integer> updateCarPrice(Admin currentAdmin, int low, int high, double price) {
        return new ApiTemplate<Integer>() {
            @Override
            protected void checkParams() throws BizException {
                Preconditions.checkArgument(low < high, "价格下限要低于上限！");
            }

            @Override
            protected APIResponse<Integer> process() throws BizException {
                if (price <= 0.0) return APIResponse.returnFail("价格出错！");
                carMasterDao.updatePriceBypp(currentAdmin.getStore(), low, high, price);
                return APIResponse.returnSuccess();
            }
        }.execute();
    }

    @Override
    public APIResponse<Integer> updateCarPrice(Admin currentAdmin, int carId, double price) {
        return new ApiTemplate<Integer>() {
            @Override
            protected APIResponse<Integer> process() throws BizException {
                Car c = carSlaveDao.selectById(carId);
                if (currentAdmin.getStore() != c.getInStore()) return APIResponse.returnFail("只能修改所在门店的车！");
                if (price <= 0.0) return APIResponse.returnFail("价格出错！");
                carMasterDao.updatePrice(carId, price);
                return APIResponse.returnSuccess();
            }
        }.execute();
    }

    @Override
    public APIResponse<List<Car>> selectCarByCondition(int getStore, int[] carType, String[] carBrand, int lowPrice, int highPrice, int lowRentalPrice, int highRentalPrice, Date startDate, Date endDate) {
        return new ApiTemplate<List<Car>>() {
            @Override
            protected void checkParams() throws BizException {
                Preconditions.checkArgument(getStore > 0, "门店错误！");
                Preconditions.checkArgument(carType.length > 0, "车辆类型错误！");
                Preconditions.checkArgument(carBrand.length > 0, "车辆品牌错误！");
                Preconditions.checkArgument(lowPrice < highPrice, "车辆价位错误！");
                Preconditions.checkArgument(lowRentalPrice < highRentalPrice, "车辆租价错误！");
                Preconditions.checkArgument(startDate.before(endDate) , "车辆时间选择错误！");

            }

            @Override
            protected APIResponse<List<Car>> process() throws BizException {
                List<Car> cars = carSlaveDao.selectCarByCondition(getStore, carType, carBrand, lowPrice * 10000, highPrice * 10000, lowRentalPrice, highRentalPrice);
                for (int i =0;i<cars.size();) {
                    Car c = cars.get(i);
                    List<ReserveDate> list = c.getReserveDateList();
                    if (list != null && !list.isEmpty()) {
                        for (int j=0;j<list.size();j++ ){
                            ReserveDate r = list.get(j);
                            if (!checkTime(r.getStartDate(),r.getEndDate(),startDate,endDate)){//时间不合适
                                cars.remove(c);
                                break;
                            }else {
                                i++;
                            }
                        }
                    }
                }
                return APIResponse.returnSuccess(cars);
            }
        }.execute();
    }

    @Override
    public APIResponse<List<Car>> selectAllCarCanUse() {
        return new ApiTemplate<List<Car>>() {
            @Override
            protected APIResponse<List<Car>> process() throws BizException {
                List<Car> cars = carSlaveDao.selectAllCarCanUse();
                return APIResponse.returnSuccess(cars);
            }
        }.execute();
    }

    @Override
    public APIResponse<List<Car>> selectCarByStore(int storeid) {
        return new ApiTemplate<List<Car>>() {
            @Override
            protected void checkParams() throws BizException {
                Preconditions.checkArgument(storeid > 0, "门店ID出错！");
            }

            @Override
            protected APIResponse<List<Car>> process() throws BizException {
                Car c = new Car();
                c.setInStore(storeid);
                List<Car> cars = carSlaveDao.select(c);
                return APIResponse.returnSuccess(cars);
            }
        }.execute();
    }

    @Override
    public APIResponse<List<Car>> getNotPassCar(Admin currentAdmin) {
        return new ApiTemplate<List<Car>>() {
            @Override
            protected APIResponse<List<Car>> process() throws BizException {
                Car c = new Car();
                c.setInStore(currentAdmin.getStore());
                c.setAduitType(Car.ADUIT_ERROR);
                List<Car> cars = carSlaveDao.select(c);
                return APIResponse.returnSuccess(cars);
            }
        }.execute();
    }

    @Override
    public APIResponse<Car> selectCarById(int carId) {
        return new ApiTemplate<Car>() {
            @Override
            protected APIResponse<Car> process() throws BizException {
                Car car = carSlaveDao.selectById(carId);
                return APIResponse.returnSuccess(car);
            }
        }.execute();
    }

    @Override
    public APIResponse<List<Car>> getNeedCheckCarList(Admin currentAdmin) {
        return new ApiTemplate<List<Car>>() {
            @Override
            protected APIResponse<List<Car>> process() throws BizException {

                if (currentAdmin.getPower() != Admin.SUPER_ADMIN) return APIResponse.returnFail("权限不匹配！");
                Car c = new Car();
                c.setAduitType(Car.NOT_ADUIT);
                List<Car> cars = carSlaveDao.select(c);
                return APIResponse.returnSuccess(cars);
            }
        }.execute();
    }

    @Override
    public APIResponse<List<Car>> selectCarByType(Admin currentAdmin, int carState) {
        return new ApiTemplate<List<Car>>() {
            @Override
            protected APIResponse<List<Car>> process() throws BizException {
                if (currentAdmin.getPower()>=Admin.PLATFORM_ADMIN) return APIResponse.returnFail("权限不匹配！只允许门店或普通管理员进行此操作！");
                Car c = new Car();
                c.setInStore(currentAdmin.getStore());
                c.setCarState((short) carState);
                List<Car> cars = carSlaveDao.select(c);
                return APIResponse.returnSuccess(cars);
            }
        }.execute();
    }

    private boolean checkTime(Date d1, Date d2, Date cd1, Date cd2){
        return cd1.after(d2) || cd2.before(d1);

    }
}
