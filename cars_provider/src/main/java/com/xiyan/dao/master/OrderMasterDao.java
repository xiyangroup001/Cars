package com.xiyan.dao.master;

import com.xiyan.model.entity.Order;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @antuor binwang
 * @date 2018/2/7  10:42
 */
@MapperScan

public interface OrderMasterDao extends GeneralMasterDao<Order> {

}
