package com.xiyan.dao.slave;

import com.xiyan.model.entity.Code;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @antuor binwang
 * @date 2018/2/7  11:28
 */
@MapperScan
public interface CodeSlaveDao extends GeneralSlaveDao<Code> {
    Code selectByPhone(String phone);
}

