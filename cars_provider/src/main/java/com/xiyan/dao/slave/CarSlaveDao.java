package com.xiyan.dao.slave;

import com.xiyan.model.entrty.Car;

import java.util.List;

/**
 * @antuor binwang
 * @date 2018/2/7  11:28
 */
public interface CarSlaveDao {
    List<Car> selectAllCar();
}
