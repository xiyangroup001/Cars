package com.xiyan.service;

import com.xiyan.model.entrty.Car;
import com.xiyan.model.entrty.User;
import com.xiyan.model.utils.APIResponse;

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
    APIResponse<Integer> createCar(Car car);

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
    APIResponse<Integer> updateCar(Car car);

    /**
     * Method 根据车价位改车辆价格
     * @return
     */
    APIResponse<Integer> updateCarPrice(double low,double high,double price);
    /**
     * Method 添加审核信息
     * @return
     */
    APIResponse<Integer> updateCarPrice(int carId,int checkId);

}


//~ Formatted by Jindent --- http://www.jindent.com
