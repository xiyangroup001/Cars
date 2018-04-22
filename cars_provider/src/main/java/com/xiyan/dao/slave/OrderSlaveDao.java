package com.xiyan.dao.slave;

import com.xiyan.model.entity.Order;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @antuor binwang
 * @date 2018/2/7  11:28
 */
@MapperScan

public interface OrderSlaveDao  extends GeneralSlaveDao<Order> {
    Order selectById(int orderId);
}
