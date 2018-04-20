package com.xiyan.service.impl;

import com.google.common.base.Preconditions;
import com.xiyan.dao.master.UserMasterDao;
import com.xiyan.dao.slave.UserSlaveDao;
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

import java.util.Date;
import java.util.List;

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
                return APIResponse.returnSuccess(userMasterDao.delete(userid));
            }
        }.execute();
    }

    @Override
    public APIResponse<Integer> insertUser(User user) {
        return new ApiTemplate<Integer>(TmonitorConstants.DUBBO_USER_INSERT) {
            @Override
            protected void checkParams() throws BizException {
                Preconditions.checkNotNull(user, "传入参数为空！");
                Preconditions.checkArgument(userSlaveDao.selectByName(user.getUserName())==0,"用户名已被占用！");
                Preconditions.checkArgument(userSlaveDao.selectByPhone(user.getUserPhone())==0,"电话号已注册！");

            }
            @Override
            protected APIResponse<Integer> process() throws BizException {
                logger.info("用户注册：{}",user);
                user.setUserType(User.USER);
                user.setUserGuid(""+new Date().getTime());
                user.setRegistrateTime(new Date());
                //user.set
                return APIResponse.returnSuccess(userMasterDao.insert(user));
            }
        }.execute();
    }

    @Override
    public APIResponse<List<User>> listAllUser() {
        return new ApiTemplate<List<User>>(TmonitorConstants.DUBBO_LANDLORD_SERVICE_QUERY_BY_ID) {
            @Override
            protected APIResponse<List<User>> process() throws BizException {
                logger.info("查找所有的用户");
                return APIResponse.returnSuccess(userSlaveDao.selectAll());
            }
        }.execute();
    }

    @Override
    public APIResponse<Integer> updateUser(User currentUser,User user) {
        return new ApiTemplate<Integer>(TmonitorConstants.DUBBO_USER_UPDATE) {
            @Override
            protected void checkParams() throws BizException {
                Preconditions.checkArgument(currentUser.getUserId()==user.getUserId(),"请正确使用！");
                Preconditions.checkNotNull(user, "传入参数为空");
                Preconditions.checkNotNull(user.getUserId(), "用户Id不能为空");
            }
            @Override
            protected APIResponse<Integer> process() throws BizException {
                logger.info("更新用户信息---参数：{}",user);
                APIResponse<Integer> response= APIResponse.returnSuccess(userMasterDao.update(user));
                logger.info("更新用户信息---结果：{}",user,response);
                return response;
            }
        }.execute();
    }

    @Override
    public boolean loginUser(int userId, String password) {
        User user = userSlaveDao.selectById(userId);
        if (user==null)
            return false;
        else
            return user.getUserPassword().equals(password);
    }

    @Override
    public User getUserById(int userId) {
        return userSlaveDao.selectById(userId);
    }

    @Override
    public APIResponse<Boolean> nameIsUsing(String name) {
        return new ApiTemplate<Boolean>() {
            @Override
            protected APIResponse<Boolean> process() throws BizException {
                if (userSlaveDao.selectByName(name)>0){
                    return APIResponse.returnSuccess(false);
                }else
                    return APIResponse.returnSuccess(true);
            }
        }.execute();
    }

    @Override
    public APIResponse<Boolean> phoneIsUsing(String phone) {
        return new ApiTemplate<Boolean>() {
            @Override
            protected APIResponse<Boolean> process() throws BizException {
                if (userSlaveDao.selectByPhone(phone)>0){
                    return APIResponse.returnSuccess(false);
                }else
                    return APIResponse.returnSuccess(true);
            }
        }.execute();
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
