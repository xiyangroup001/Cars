package com.xiyan.service.impl;

import com.google.common.base.Preconditions;
import com.xiyan.dao.UserDao;
import com.xiyan.model.entrty.User;
import com.xiyan.model.exception.BizException;
import com.xiyan.model.monitor.TmonitorConstants;
import com.xiyan.model.utils.APIResponse;
import com.xiyan.model.utils.ApiTemplate;
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

@Service(value = "userService")
public class UserServiceImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserDao userDao;

    @Override
    public APIResponse<List<User>> selectAllUser() {
        return new ApiTemplate<List<User>>(TmonitorConstants.DUBBO_LANDLORD_SERVICE_QUERY_BY_ID){

            @Override
            protected APIResponse<List<User>> process() throws BizException {
                return APIResponse.returnSuccess(userDao.selectAllUser());
            }
        }.execute();

    }

    @Override
    public APIResponse<Integer> insertUser(User user) {
        logger.info("传入的参数是：{}", user.toString());
        return new ApiTemplate<Integer>(""){
            @Override
            protected void checkParams() throws BizException {
                Preconditions.checkNotNull(user,"传入参数为空！");
            }

            @Override
            protected APIResponse<Integer> process() throws BizException {
                return APIResponse.returnSuccess(userDao.saveUser(user));
            }
        }.execute();
    }
}
