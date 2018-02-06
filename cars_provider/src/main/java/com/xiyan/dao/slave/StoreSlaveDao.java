package com.xiyan.dao.slave;

import com.xiyan.model.entrty.Store;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * @antuor binwang
 * @date 2018/2/6  11:23
 */
@MapperScan
public interface StoreSlaveDao {
    List<Store> selectAllStore();
}
