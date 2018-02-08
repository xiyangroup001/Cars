package com.xiyan.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;

import com.xiyan.dao.master.UserMasterDao;
import com.xiyan.dao.slave.UserSlaveDao;
import com.xiyan.model.entrty.User;
import com.xiyan.model.exception.BizException;
import com.xiyan.model.monitor.TmonitorConstants;
import com.xiyan.model.utils.APIResponse;
import com.xiyan.model.utils.ApiTemplate;
import com.xiyan.model.utils.UserUtil;
import com.xiyan.service.UserService;

/**
 * @antuor binwang
 * @date 2018/1/24  16:20
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    /** Field description */
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /** Field description */
    @Autowired
    private UserMasterDao userMasterDao;

    /** Field description */
    @Autowired
    private UserSlaveDao userSlaveDao;

    /**
     * Method 创建用户Id
     * @return
     */
    private int createUserId() {
        return userSlaveDao.queryMaxUserId() + 1;
    }

    @Override
    public APIResponse<Integer> deleteUser(Integer userid) {
        return new ApiTemplate<Integer>(TmonitorConstants.DUBBO_USER_DELETE){
            @Override
            protected void checkParams() throws BizException {
                Preconditions.checkNotNull(userid,"用户id不许为空");
            }

            @Override
            protected APIResponse<Integer> process() throws BizException {
                logger.info("删除用户：{}",userid);
                return APIResponse.returnSuccess(userMasterDao.deleteUser(userid));
            }
        }.execute();
    }

    @Override
    public APIResponse<Integer> insertUser(User user) {
        user.setUserId(createUserId());
        logger.info("传入的参数是：{}", user.toString());
        return new ApiTemplate<Integer>(TmonitorConstants.DUBBO_USER_INSERT) {
            @Override
            protected void checkParams() throws BizException {
                Preconditions.checkNotNull(user, "传入参数为空！");
            }
            @Override
            protected APIResponse<Integer> process() throws BizException {
                logger.info("更新用户信息：{}",user);
                return APIResponse.returnSuccess(userMasterDao.insertUser(user));
            }
        }.execute();
    }

    @Override
    public APIResponse<List<User>> listAllUser() {
        return new ApiTemplate<List<User>>(TmonitorConstants.DUBBO_LANDLORD_SERVICE_QUERY_BY_ID) {
            @Override
            protected APIResponse<List<User>> process() throws BizException {
                logger.info("查找所有的用户");
                return APIResponse.returnSuccess(userSlaveDao.listAllUser());
            }
        }.execute();
    }

    @Override
    public APIResponse<Integer> updateUser(User user) {
        return new ApiTemplate<Integer>(TmonitorConstants.DUBBO_USER_UPDATE) {
            @Override
            protected void checkParams() throws BizException {
                Preconditions.checkNotNull(user, "传入参数为空");
                Preconditions.checkNotNull(user.getUserId(), "用户Id不能为空");
            }
            @Override
            protected APIResponse<Integer> process() throws BizException {
                logger.info("更新用户信息---参数：{}",user);
                APIResponse<Integer> response= APIResponse.returnSuccess(userMasterDao.updateUser(user));
                logger.info("更新用户信息---结果：{}",user,response);
                return response;
            }
        }.execute();
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
