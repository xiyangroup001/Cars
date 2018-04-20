package com.xiyan.dao.slave;

import com.xiyan.model.entrty.Admin;
import com.xiyan.model.entrty.Car;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * @antuor binwang
 * @date 2018/2/7  11:28
 */
@MapperScan
public interface AdminSlaveDao extends GeneralSlaveDao<Admin> {
    Admin selectById(String adminId);
    Admin selectByName(String adminName);
}
