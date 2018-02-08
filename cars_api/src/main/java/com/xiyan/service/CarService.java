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
     * Method 删除用户
     * @param carId
     * @return
     */
    APIResponse<Integer> deleteCar(Integer carId);

    /**
     * Method 新建用户
     * @param car
     * @return
     */
    APIResponse<Integer> insertCar(Car car);

    /**
     * Method 选择全部用户
     * @return
     */
    APIResponse<List<Car>> listAllCar();

    /**
     * Method 更新用户信息
     * @param car
     * @return
     */
    APIResponse<Integer> updateCar(Car car);
}


//~ Formatted by Jindent --- http://www.jindent.com
