package com.xiyan.service;

import com.xiyan.model.entity.Admin;
import com.xiyan.model.entity.Car;
import com.xiyan.model.utils.APIResponse;

import java.util.Date;
import java.util.List;

/**
 * @antuor binwang
 * @date 2018/1/24  16:21
 */
public interface CarService {

    /**
     * Method 删除车辆
     * @param carId
     * @return
     */
    APIResponse<Integer> deleteCar(Integer carId);

    /**
     * Method 上车
     * @param car
     * @return
     */
    APIResponse<Integer> createCar(Admin currentAdmin,Car car);

    /**
     * Method 上多个车辆
     * @param cars
     * @return
     */
    APIResponse<Integer> createCarList(List<Car> cars);
    /**
     * Method 根据条件选择车辆
     * @return
     */
    APIResponse<List<Car>> selectCars();

    /**
     * Method 更新车辆信息
     * @param car
     * @return
     */
    APIResponse<Integer> updateCar(Admin currentAdmin,Car car);

    /**
     * Method 根据车价位改车辆价格
     * @return
     */
    APIResponse<Integer> updateCarPrice(Admin currentAdmin,int low,int high,double price);

    APIResponse<Integer> updateCarPrice(Admin currentAdmin,int carId,double price);

    APIResponse<List<Car>> selectCarByCondition(int getStore, int[] carType, String[] carBrand, int lowPrice, int highPrice, int lowRentalPrice, int highRentalPrice, Date startDate, Date endDate);

    APIResponse<List<Car>> selectAllCarCanUse();

    APIResponse<List<Car>> selectCarByStore(int storeid);

    APIResponse<List<Car>>  getNotPassCar(Admin currentAdmin);

    APIResponse<Car> selectCarById(int carId);

    APIResponse<List<Car>> getNeedCheckCarList(Admin currentAdmin);

    APIResponse<List<Car>> selectCarByType(Admin currentAdmin, int carState);
}


//~ Formatted by Jindent --- http://www.jindent.com
