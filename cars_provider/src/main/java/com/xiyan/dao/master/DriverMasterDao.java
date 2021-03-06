package com.xiyan.dao.master;

import com.xiyan.model.entity.Driver;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @antuor binwang
 * @date 2018/2/7  10:42
 */
@MapperScan

public interface DriverMasterDao extends GeneralMasterDao<Driver> {
    int deleteByIdNumber(String idNumber);

}
