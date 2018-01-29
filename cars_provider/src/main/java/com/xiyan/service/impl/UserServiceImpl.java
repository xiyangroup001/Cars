package com.xiyan.service.impl;

import com.xiyan.dao.UserDao;
import com.xiyan.model.entrty.User;
import com.xiyan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @antuor binwang
 * @date 2018/1/24  16:20
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public List<User> selectAllUser() {
        return userDao.selectAllUser();
    }

    public int insertUser(User user) {
        return userDao.saveUser(user);
    }
}
