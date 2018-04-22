package com.xiyan.dao.slave;

import com.xiyan.model.entity.Driver;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @antuor binwang
 * @date 2018/2/7  11:28
 */
@MapperScan
public interface DriverSlaveDao extends GeneralSlaveDao<Driver> {
    Driver selectByIdNumber(String idNumber);
}
