package com.xiyan.service;


import com.xiyan.model.entrty.User;

import java.util.List;

/**
 * @antuor binwang
 * @date 2018/1/24  16:21
 */
public interface UserService {
    List<User> selectAllUser();
    int insertUser(User user);
}
