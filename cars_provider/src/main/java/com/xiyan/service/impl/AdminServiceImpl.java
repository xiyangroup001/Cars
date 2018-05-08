package com.xiyan.service.impl;

import com.google.common.base.Preconditions;
import com.xiyan.dao.master.AdminMasterDao;
import com.xiyan.dao.master.CarMasterDao;
import com.xiyan.dao.master.CheckMasterDao;
import com.xiyan.dao.slave.AdminSlaveDao;
import com.xiyan.dao.slave.CarSlaveDao;
import com.xiyan.dao.slave.CheckSlaveDao;
import com.xiyan.model.entity.Admin;
import com.xiyan.model.entity.Car;
import com.xiyan.model.entity.Check;
import com.xiyan.model.exception.BizException;
import com.xiyan.model.monitor.TmonitorConstants;
import com.xiyan.model.utils.APIResponse;
import com.xiyan.model.utils.ApiTemplate;
import com.xiyan.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @antuor binwang
 * @date 2018/2/8  16:54
 */

@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminSlaveDao adminSlaveDao;
    @Autowired
    private AdminMasterDao adminMasterDao;
    @Autowired
    private CarSlaveDao carSlaveDao;
    @Autowired
    private CarMasterDao carMasterDao;
    @Autowired
    private CheckSlaveDao checkSlaveDao;
    @Autowired
    private CheckMasterDao checkMasterDao;

    @Override
    public APIResponse<Integer> deleteAdmin(Admin currentAdmin,String adminId) {
        return new ApiTemplate<Integer>(TmonitorConstants.DUBBO_ADMIN_DELETE) {
            @Override
            protected void checkParams() throws BizException {
                Preconditions.checkNotNull(adminId);
                Admin admin = adminSlaveDao.selectById(adminId);
                Preconditions.checkArgument(currentAdmin.getPower()>admin.getPower(),"权限不匹配！");
            }
            @Override
            protected APIResponse<Integer> process() throws BizException {
                logger.info("删除Admin---参数：{}", adminId);
                logger.info("删除Admin---操作人：{}", currentAdmin);
                APIResponse<Integer> response = APIResponse.returnSuccess(adminMasterDao.delete(adminId));
                logger.info("删除Admin---参数结果：{}", response);
                return response;
            }
        }.execute();
    }

    @Override
    public boolean loginAdmin(String adminName, String passWord) {
        Preconditions.checkArgument(Pattern.matches("^[a-zA-Z0-9]{6,16}$",passWord), "密码不符合要求！");

        Admin admin = adminSlaveDao.selectByName(adminName);
        if (admin == null) return false;
        else return admin.getPassWord().equals(passWord);
    }

    @Override
    public Admin getAdminByName(String adminName) {
        return  adminSlaveDao.selectByName(adminName);
    }

    @Override
    public APIResponse<Boolean> changePassword(Admin currentAdmin, String oldPassword, String newPassword) {
        return new ApiTemplate<Boolean>() {
            @Override
            protected APIResponse<Boolean> process() throws BizException {
                Preconditions.checkArgument(Pattern.matches("^[a-zA-Z0-9]{6,16}$", currentAdmin.getPassWord()), "密码不符合要求！");
                Preconditions.checkArgument(Pattern.matches("^[a-zA-Z0-9]{6,16}$", oldPassword), "密码不符合要求！");
                Preconditions.checkArgument(Pattern.matches("^[a-zA-Z0-9]{6,16}$", newPassword), "密码不符合要求！");
                if(currentAdmin.getPassWord()==oldPassword){
                    currentAdmin.setPassWord(newPassword);
                    adminMasterDao.update(currentAdmin);
                    return APIResponse.returnSuccess();
                }else
                    return APIResponse.returnFail("旧密码输入不正确！");
            }
        }.execute();
    }

    @Override
    public APIResponse<Boolean> checkCarPass(Admin currentAdmin, int carId) {
        return new ApiTemplate<Boolean>() {
            @Override
            protected APIResponse<Boolean> process() throws BizException {
                if (currentAdmin.getPower()!=Admin.SUPER_ADMIN){
                    return  APIResponse.returnFail("没有审核权限！");
                }
                Car car = carSlaveDao.selectById(carId);
                if (car==null || car.getAduitType()!=Car.NOT_ADUIT){
                    return  APIResponse.returnFail("该车辆不存在或者不该审核！");
                }
                Check check = checkSlaveDao.selectById(car.getAduitId());
                check.setCheckResult("通过审核！");
                check.setCheckUser(currentAdmin.getAdminName());
                check.setCheckTime(new Date());
                checkMasterDao.update(check);
                car.setAduitType(Car.ADUIT_PASS);
                carMasterDao.update(car);
                return APIResponse.returnSuccess();
            }
        }.execute();
    }

    @Override
    public APIResponse<Boolean> checkCarFail(Admin currentAdmin, int carId,String message) {
        return new ApiTemplate<Boolean>() {
            @Override
            protected APIResponse<Boolean> process() throws BizException {
                if (currentAdmin.getPower()!=Admin.SUPER_ADMIN){
                    return  APIResponse.returnFail("没有审核权限！");
                }
                Car car = carSlaveDao.selectById(carId);
                if (car==null || car.getAduitType()!=Car.NOT_ADUIT){
                    return  APIResponse.returnFail("该车辆不存在或者不该审核！");
                }
                Check check = checkSlaveDao.selectById(car.getAduitId());
                check.setCheckResult(message);
                check.setCheckUser(currentAdmin.getAdminName());
                check.setCheckTime(new Date());
                checkMasterDao.update(check);
                car.setAduitType(Car.ADUIT_ERROR);

                carMasterDao.update(car);
                return APIResponse.returnSuccess();
            }
        }.execute();
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
                Preconditions.checkNotNull(admin);
                Preconditions.checkArgument(currentAdmin.getAdminId()==admin.getAdminId(),"只允许修改自己信息！");
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
                Preconditions.checkArgument(Pattern.matches("^[a-zA-Z0-9]{6,16}$",newPassWord), "密码不符合要求！");

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
