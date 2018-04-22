package com.xiyan.dao.slave;

import com.xiyan.model.entity.Store;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @antuor binwang
 * @date 2018/2/6  11:23
 */
@MapperScan
public interface StoreSlaveDao  extends GeneralSlaveDao<Store> {
}
