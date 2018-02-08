package com.xiyan.service.impl;

import com.google.common.base.Preconditions;
import com.xiyan.dao.master.AdminMasterDao;
import com.xiyan.dao.slave.AdminSlaveDao;
import com.xiyan.model.entrty.Admin;
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
    public APIResponse<Integer> deleteAdmin(Integer adminId) {
        return new ApiTemplate<Integer>(TmonitorConstants.DUBBO_ADMIN_DELETE){
            @Override
            protected void checkParams() throws BizException {
                Preconditions.checkNotNull(adminId);
                Preconditions.checkArgument(adminId>0,"");
            }
            @Override
            protected APIResponse<Integer> process() throws BizException {
                logger.info("删除Admin---参数：{}",adminId);
                APIResponse<Integer> response =APIResponse.returnSuccess(adminMasterDao.deleteAdmin(adminId));
                logger.info("删除Admin---参数结果：{}",response);
                return response;
            }
        }.execute();
    }

    @Override
    public APIResponse<Integer> insertAdmin(Admin admin) {
        return new ApiTemplate<Integer>(TmonitorConstants.DUBBO_ADMIN_INSERT){
            @Override
            protected void checkParams() throws BizException {
                Preconditions.checkNotNull(admin);
                Preconditions.checkArgument(Pattern.matches("^\\d{17}((\\d)|(X))$", admin.getAdminId()),"身份证号不正确！");
                Preconditions.checkArgument(Pattern.matches("^[a-zA-Z0-9]{6,16}$",admin.getPassWord()),"密码不符合要求！");
            }
            @Override
            protected APIResponse<Integer> process() throws BizException {
                logger.info("新建Admin---参数：{}",admin);
                APIResponse<Integer> response = APIResponse.returnSuccess(adminMasterDao.insertAdmin(admin));
                logger.info("新建Admin---结果：{}",response);
                return null;
            }
        }.execute();
    }

    @Override
    public APIResponse<List<Admin>> listAllAdmin() {
        return null;
    }

    @Override
    public APIResponse<Integer> updateAdmin(Admin admin) {
        return null;
    }


}
