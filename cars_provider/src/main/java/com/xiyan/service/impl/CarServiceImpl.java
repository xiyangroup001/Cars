package com.xiyan.service.impl;

import com.google.common.base.Preconditions;
import com.xiyan.dao.master.CarMasterDao;
import com.xiyan.dao.slave.CarSlaveDao;
import com.xiyan.model.entity.Car;
import com.xiyan.model.exception.BizException;
import com.xiyan.model.utils.APIResponse;
import com.xiyan.model.utils.ApiTemplate;
import com.xiyan.service.CarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("carService")
public class CarServiceImpl implements CarService {
    @Resource
    CarMasterDao carMasterDao;
    @Resource
    CarSlaveDao carSlaveDao;

    @Override
    public APIResponse<Integer> deleteCar(Integer carId) {
        return null;
    }

    @Override
    public APIResponse<Integer> createCar(Car car) {
        return null;
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
    public APIResponse<Integer> updateCar(Car car) {
        return null;
    }

    @Override
    public APIResponse<Integer> updateCarPrice(double low, double high, double price) {
        return null;
    }

    @Override
    public APIResponse<Integer> updateCarPrice(int carId, int checkId) {
        return null;
    }

    @Override
    public APIResponse<List<Car>> selectCarByCondition(int getStore, int[] carType, String[] carBrand, int lowPrice, int highPrice, int lowRentalPrice, int highRentalPrice) {
        return new ApiTemplate<List<Car>>() {
            @Override
            protected void checkParams() throws BizException {
                Preconditions.checkArgument(getStore > 0, "门店错误！");
                Preconditions.checkArgument(carType.length > 0, "车辆类型错误！");
                Preconditions.checkArgument(carBrand.length > 0, "车辆品牌错误！");
                Preconditions.checkArgument(lowPrice < highPrice, "车辆价位错误！");
                Preconditions.checkArgument(lowRentalPrice < highRentalPrice, "车辆租价错误！");

            }

            @Override
            protected APIResponse<List<Car>> process() throws BizException {
                List<Car> cars = carSlaveDao.selectCarByCondition(getStore, carType, carBrand, lowPrice * 10000, highPrice * 10000, lowRentalPrice, highRentalPrice);
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
                c.setCarState(Car.SYATE_INSTORE);
                c.setAduitType(Car.ADUIT_PASS);
                List<Car> cars = carSlaveDao.select(c);
                return APIResponse.returnSuccess(cars);
            }
        }.execute();
    }
}
