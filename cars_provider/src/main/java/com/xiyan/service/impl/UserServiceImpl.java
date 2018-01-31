package com.xiyan.service.impl;

import com.xiyan.dao.UserDao;
import com.xiyan.model.entrty.User;
import com.xiyan.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @antuor binwang
 * @date 2018/1/24  16:20
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserDao userDao;

    public List<User> selectAllUser() {
        return userDao.selectAllUser();
    }

    public int insertUser(User user) {
        logger.info("传入的参数是：{}",user.toString());
        return userDao.saveUser(user);
    }
}
