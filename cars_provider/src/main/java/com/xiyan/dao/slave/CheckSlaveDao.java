package com.xiyan.dao.slave;

import com.xiyan.model.entity.Check;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @antuor binwang
 * @date 2018/2/7  11:28
 */
@MapperScan

public interface CheckSlaveDao extends GeneralSlaveDao<Check> {
    Check selectById(int checkId);
}
