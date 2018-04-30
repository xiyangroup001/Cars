package com.xiyan.service.impl;

import com.xiyan.dao.master.PlatformMasterDao;
import com.xiyan.dao.slave.PlatformSlaveDao;
import com.xiyan.model.entity.Platform;
import com.xiyan.model.exception.BizException;
import com.xiyan.model.utils.APIResponse;
import com.xiyan.model.utils.ApiTemplate;
import com.xiyan.service.PlatformService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("platformService")
public class PlatformServiceImpl implements PlatformService {
    @Resource
    private PlatformSlaveDao platformSlaveDao;
    @Resource
    private PlatformMasterDao platformMasterDao;

    @Override
    public APIResponse<Integer> deletePlatform(int platformId) {
        return new ApiTemplate<Integer>() {
            @Override
            protected APIResponse<Integer> process() throws BizException {
                return APIResponse.returnSuccess(platformMasterDao.delete(platformId));
            }
        }.execute();
    }

    @Override
    public APIResponse<Integer> insertPlatform(Platform platform) {
        return new ApiTemplate<Integer>() {
            @Override
            protected APIResponse<Integer> process() throws BizException {
                return APIResponse.returnSuccess(platformMasterDao.insert(platform));
            }
        }.execute();
    }

    @Override
    public APIResponse<List<Platform>> listAllPlatform() {
        return new ApiTemplate<List<Platform>>() {
            @Override
            protected APIResponse<List<Platform>> process() throws BizException {
                return APIResponse.returnSuccess(platformSlaveDao.selectAll());
            }
        }.execute();
    }

    @Override
    public APIResponse<Integer> updatePlatform(Platform platform) {
        return new ApiTemplate<Integer>() {
            @Override
            protected APIResponse<Integer> process() throws BizException {
                return APIResponse.returnSuccess(platformMasterDao.update(platform));
            }
        }.execute();
    }
}
