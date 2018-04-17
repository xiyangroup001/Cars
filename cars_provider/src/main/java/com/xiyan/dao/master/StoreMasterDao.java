package com.xiyan.dao.master;

import com.xiyan.model.entrty.Store;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @antuor binwang
 * @date 2018/2/5  18:33
 */
@MapperScan
public interface StoreMasterDao extends GeneralMasterDao<Store> {

}
