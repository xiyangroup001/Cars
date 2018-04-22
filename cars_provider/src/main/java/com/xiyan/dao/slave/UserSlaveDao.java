package com.xiyan.dao.slave;

import com.xiyan.model.entity.User;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @antuor binwang
 * @date 2018/2/2  18:00
 */
@MapperScan
public interface UserSlaveDao  extends GeneralSlaveDao<User> {
    int queryMaxUserId();

    User selectById(int userId);
    int selectByPhone(String Phone);
    int selectByName(String name);
}
