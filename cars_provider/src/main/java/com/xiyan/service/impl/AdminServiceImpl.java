package com.xiyan.service.impl;

import com.google.common.base.Preconditions;
import com.xiyan.dao.master.AdminMasterDao;
import com.xiyan.dao.slave.AdminSlaveDao;
import com.xiyan.model.entity.Admin;
import com.xiyan.model.exception.BizException;
import com.xiyan.model.monitor.TmonitorConstants;
import com.xiyan.model.utils.APIResponse;
import com.xiyan.model.utils.ApiTemplate;
import com.xiyan.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

/**
 * @antuor binwang
 * @date 2018/2/8  16:54
 */

@Service("adminService")
public class AdminServiceImpl implements AdminService {
    protected Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Autowired
    private AdminSlaveDao adminSlaveDao;
    @Autowired
    private AdminMasterDao adminMasterDao;

    @Override
    public APIResponse<Integer> deleteAdmin(Admin currentAdmin,String adminId) {
        return new ApiTemplate<Integer>(TmonitorConstants.DUBBO_ADMIN_DELETE) {
            @Override
            protected void checkParams() throws BizException {
                Preconditions.checkNotNull(adminId);
                Admin admin = adminSlaveDao.selectById(adminId);
                Preconditions.checkArgument(currentAdmin.getPower()>admin.getPower(),"权限不匹配");
            }

            @Override
            protected APIResponse<Integer> process() throws BizException {
                logger.info("删除Admin---参数：{}", adminId);
                APIResponse<Integer> response = APIResponse.returnSuccess(adminMasterDao.delete(adminId));
                logger.info("删除Admin---参数结果：{}", response);
                return response;
            }
        }.execute();
    }

    @Override
    public boolean loginAdmin(String adminName, String passWord) {
        Admin admin = adminSlaveDao.selectByName(adminName);
        if (admin == null) return false;
        else return admin.getPassWord().equals(passWord);
    }

    @Override
    public Admin getAdminByName(String adminName) {
        return  adminSlaveDao.selectByName(adminName);
    }


    @Override
    public APIResponse<List<Admin>> listUnde(Admin admin) {
        return new ApiTemplate<List<Admin>>() {
            @Override
            protected APIResponse<List<Admin>> process() throws BizException {
                if (admin.getPower() == Admin.STORE_ADMIN) {
                    Admin cadmin = new Admin();
                    cadmin.setStore(admin.getStore());
                    List<Admin> admins = adminSlaveDao.select(cadmin);
                    logger.info("选取自己下属的管理员---参数：{}", admin);
                    APIResponse<List<Admin>> response = APIResponse.returnSuccess(admins);
                    logger.info("选取自己下属的管理员---结果：{}", response);
                    return response;
                }
                if (admin.getPower() == Admin.SUPER_ADMIN) {
                    Admin cadmin = new Admin();
                    List<Admin> admins = adminSlaveDao.select(cadmin);
                    logger.info("选取自己下属的管理员---参数：{}", admin);
                    APIResponse<List<Admin>> response = APIResponse.returnSuccess(admins);
                    logger.info("选取自己下属的管理员---结果：{}", response);
                    return response;
                }
                return APIResponse.returnFail("您不是门店管理员！");
            }
        }.execute();
    }

    @Override
    public APIResponse<Integer> createAdmin(Admin currentAdmin,Admin admin) {
        return new ApiTemplate<Integer>(TmonitorConstants.DUBBO_ADMIN_INSERT) {
            @Override
            protected void checkParams() throws BizException {
                Preconditions.checkArgument(currentAdmin.getPower()>admin.getPower(),"权限不匹配！");
                Preconditions.checkNotNull(admin);
                Preconditions.checkArgument(Pattern.matches("^\\d{17}((\\d)|(X))$", admin.getAdminId()), "身份证号不正确！");
                Preconditions.checkArgument(Pattern.matches("^[a-zA-Z0-9]{6,16}$", admin.getPassWord()), "密码不符合要求！");
            }

            @Override
            protected APIResponse<Integer> process() throws BizException {
                logger.info("新建Admin---参数：{}", admin);
                APIResponse<Integer> response = APIResponse.returnSuccess(adminMasterDao.insert(admin));
                logger.info("新建Admin---结果：{}", response);
                return response;
            }
        }.execute();
    }


    @Override
    public APIResponse<List<Admin>> listAdmin(Admin currentAdmin,Admin admin) {
        return new ApiTemplate<List<Admin>>(TmonitorConstants.DUBBO_ADMIN_LISTALL) {
            @Override
            protected void checkParams() throws BizException {
                Preconditions.checkArgument( currentAdmin.getPower()==Admin.SUPER_ADMIN,"用户权限不匹配！");


            }

            @Override
            protected APIResponse<List<Admin>> process() throws BizException {
                APIResponse<List<Admin>> response = APIResponse.returnSuccess(adminSlaveDao.select(admin));
                logger.info("查询Admin---结果：{}", response);
                return response;
            }
        }.execute();
    }

    @Override
    public APIResponse<Integer> updateAdmin(Admin currentAdmin,Admin admin) {
        return new ApiTemplate<Integer>(TmonitorConstants.DUBBO_ADMIN_UPDATE) {
            @Override
            protected void checkParams() throws BizException {
                Preconditions.checkArgument(currentAdmin.getAdminId()==admin.getAdminId(),"只允许修改自己信息！");

                Preconditions.checkNotNull(admin);
                Preconditions.checkArgument(Pattern.matches("^\\d{17}((\\d)|(X))$", admin.getAdminId()), "身份证号不正确！");
                Preconditions.checkArgument(Pattern.matches("^[a-zA-Z0-9]{6,16}$", admin.getPassWord()), "密码不符合要求！");
            }

            @Override
            protected APIResponse<Integer> process() throws BizException {
                logger.info("更新Admin---参数：{}", admin);
                APIResponse<Integer> response = APIResponse.returnSuccess(adminMasterDao.update(admin));
                logger.info("更新Admin---结果：{}", response);
                return response;
            }
        }.execute();
    }

    @Override
    public APIResponse<Integer> alertPassWord(Admin admin, String newPassWord) {
        return new ApiTemplate<Integer>() {
            @Override
            protected void checkParams() throws BizException {
                Preconditions.checkArgument(newPassWord.length() >= 6 && newPassWord.length() <= 16, "密码长度在6-16之间！");
            }

            @Override
            protected APIResponse<Integer> process() throws BizException {
                admin.setPassWord(newPassWord);
                adminMasterDao.update(admin);
                return APIResponse.returnSuccess();
            }
        }.execute();
    }


}
