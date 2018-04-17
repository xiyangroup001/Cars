package com.xiyan.dao.master;

public interface GeneralMasterDao <T> {
    int delete(int id);
    int insert(T pojo);
    int update(T pojo);
}
