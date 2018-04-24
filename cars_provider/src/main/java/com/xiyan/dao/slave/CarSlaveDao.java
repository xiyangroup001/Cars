package com.xiyan.dao.slave;

import com.xiyan.model.entity.Car;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * @antuor binwang
 * @date 2018/2/7  11:28
 */
@MapperScan
public interface CarSlaveDao extends GeneralSlaveDao<Car> {
    Car selectById(int carId);

    List<Car> selectCarByCondition(int getStore, int[] carType, String[] carBrand, int lowPrice, int highPrice,int lowRentalPrice, int highRentalPrice);

    List<Car> selectAllCarCanUse();

    List<Car> selectByStore(int storeid);
}
