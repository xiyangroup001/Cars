package com.xiyan.dao.master;

import com.xiyan.model.entity.Conpon;
import org.mybatis.spring.annotation.MapperScan;

import java.util.Date;

@MapperScan

public interface ConponMasterDao extends GeneralMasterDao<Conpon> {
    int deleteByUser(int userId);

    int delExpire(int userId, Date date);
}
