package com.xiyan.dao;

import com.xiyan.model.entrty.User;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * @antuor binwang
 * @date 2018/1/24  16:12
 */
@MapperScan
public interface UserDao {
    List<User> selectAllUser();
    int saveUser(User user);
}
