package com.xiyan.dao.master;

import com.xiyan.model.entity.Car;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @antuor binwang
 * @date 2018/2/7  10:42
 */
@MapperScan
public interface CarMasterDao extends GeneralMasterDao<Car> {
    int updatePrice(int CarId,double price);
    int updatePriceBypp(int inStore, int low,int high,double price);
}
