package com.xiyan.service.impl;

import com.google.common.base.Preconditions;
import com.xiyan.dao.master.ConponMasterDao;
import com.xiyan.dao.slave.ConponSlaveDao;
import com.xiyan.model.entity.Admin;
import com.xiyan.model.entity.Conpon;
import com.xiyan.model.entity.Driver;
import com.xiyan.model.entity.User;
import com.xiyan.model.exception.BizException;
import com.xiyan.model.utils.APIResponse;
import com.xiyan.model.utils.ApiTemplate;
import com.xiyan.service.ConponService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("conponService")
public class ConponServiceImpl implements ConponService {

    @Resource
    private ConponSlaveDao conponSlaveDao;
    @Resource
    private ConponMasterDao conponMasterDao;

    @Override
    public APIResponse<Integer> deleteConpon(Integer conponId) {
        return new ApiTemplate<Integer>() {
            @Override
            protected void checkParams() throws BizException {
                Preconditions.checkArgument(conponId > 0, "优惠券编号不正确！");
            }

            @Override
            protected APIResponse<Integer> process() throws BizException {
                int i = conponMasterDao.delete(conponId);
                if (i == 1) {
                    return APIResponse.returnSuccess(i);
                } else if (i == 0) {
                    return APIResponse.returnFail("不存在该优惠券！");
                } else {
                    return APIResponse.returnFail("出错，未知错误。");
                }
            }
        }.execute();
    }

    @Override
    public APIResponse<Integer> insertConpon(Conpon conpon, Admin admin) {
        return new ApiTemplate<Integer>() {
            @Override
            protected void checkParams() throws BizException {
                Preconditions.checkNotNull(conpon, "不许为Null!");
                Preconditions.checkArgument(admin.getPower() > Admin.STORE_ADMIN, "管理员权限不匹配！");

                Preconditions.checkArgument(conpon.getExpiredTime().after(new Date()), "到期日起必须晚于当前日期！");
            }

            @Override
            protected APIResponse<Integer> process() throws BizException {
                APIResponse response = APIResponse.returnSuccess(conponMasterDao.insert(conpon));
                return response;
            }
        }.execute();
    }

    @Override
    public APIResponse<Integer> updateConpon(Conpon conpon, Admin currentAdmin) {
        return new ApiTemplate<Integer>() {
            @Override
            protected void checkParams() throws BizException {
                Preconditions.checkNotNull(conpon, "不许为Null!");
                Preconditions.checkArgument(currentAdmin.getPower() > Admin.STORE_ADMIN, "管理员权限不匹配！");
                Preconditions.checkArgument(conpon.getCouponId() > 0, "优惠券编号出错！");
                Preconditions.checkArgument(conpon.getExpiredTime().after(new Date()), "到期日起必须晚于当前日期！");
            }

            @Override
            protected APIResponse<Integer> process() throws BizException {
                APIResponse response = APIResponse.returnSuccess(conponMasterDao.update(conpon));
                return response;
            }
        }.execute();
    }

    @Override
    public APIResponse<List<Conpon>> listConponByUser(Integer userId) {
        return new ApiTemplate<List<Conpon>>() {
            @Override
            protected void checkParams() throws BizException {
                Preconditions.checkArgument(userId > 0, "用户编号出错！");
            }

            @Override
            protected APIResponse<List<Conpon>> process() throws BizException {
                Conpon conpon = new Conpon();
                conpon.setUserId(userId);
                List<Conpon> conpons = conponSlaveDao.select(conpon);
                return APIResponse.returnSuccess(conpons);
            }
        }.execute();
    }

    @Override
    public APIResponse<Conpon> getConponById(int conponId, User currentUser) {
        return new ApiTemplate<Conpon>() {
            @Override
            protected void checkParams() throws BizException {
                Preconditions.checkArgument(conponId > 0, "编号出错！");
            }

            @Override
            protected APIResponse<Conpon> process() throws BizException {
                Conpon conpon = new Conpon();
                conpon.setCouponId(conponId);
                List<Conpon> conpons = conponSlaveDao.select(conpon);
                if (conpons.isEmpty()) {
                    return APIResponse.returnFail("不存在该优惠券编号！");
                }
                if (conpons.get(0).getUserId() != currentUser.getUserId()) {
                    return APIResponse.returnFail("该优惠券不属于你！");
                }
                return APIResponse.returnSuccess(conpons.get(0));
            }
        }.execute();
    }

    @Override
    public APIResponse<Boolean> delExpire(User currentUser) {
        return new ApiTemplate<Boolean>() {
            @Override
            protected APIResponse<Boolean> process() throws BizException {
                conponMasterDao.delExpire(currentUser.getUserId(),new Date());
                return APIResponse.returnSuccess(true);
            }
        }.execute();
    }
}
