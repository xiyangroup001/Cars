package com.xiyan.dao.slave;

import com.xiyan.model.entrty.User;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * @antuor binwang
 * @date 2018/2/2  18:00
 */
@MapperScan
public interface UserSlaveDao {
    List<User> listAllUser();
    int queryMaxUserId();

}
