package com.xiyan.dao.slave;

import java.util.List;

public interface GeneralSlaveDao<T> {
    List<T> selectAll();
    List<T> select(T t);
    int selectRowNumber();
}
