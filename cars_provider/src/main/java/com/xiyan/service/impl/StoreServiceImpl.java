package com.xiyan.service.impl;


import com.google.common.base.Preconditions;
import com.xiyan.dao.master.StoreMasterDao;
import com.xiyan.dao.slave.StoreSlaveDao;

import com.xiyan.model.entity.Admin;
import com.xiyan.model.entity.Store;
import com.xiyan.model.exception.BizException;
import com.xiyan.model.utils.APIResponse;
import com.xiyan.model.utils.ApiTemplate;
import com.xiyan.service.StoreService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;


@Service("storeService")
public class StoreServiceImpl implements StoreService {
    @Resource
    private StoreMasterDao storeMasterDao;
    @Resource
    private StoreSlaveDao storeSlaveDao;

    @Override
    public APIResponse<Integer> deleteStore(Integer storeId, Admin admin) {

        return new ApiTemplate<Integer>() {
            @Override
            protected void checkParams() throws BizException {
                Preconditions.checkArgument(admin.getPower() > Admin.STORE_ADMIN, "权限不够！，需要平台管理员及以上权限！");
            }

            @Override
            protected APIResponse<Integer> process() throws BizException {
                return APIResponse.returnSuccess(storeMasterDao.delete(storeId));
            }
        }.execute();
    }

    @Override
    public APIResponse<Integer> insertStore(Store store, Admin admin) {
        return new ApiTemplate<Integer>() {
            @Override
            protected void checkParams() throws BizException {
                Preconditions.checkArgument(admin.getPower() > Admin.STORE_ADMIN, "权限不够！，需要平台管理员及以上权限！");
            }

            @Override
            protected APIResponse<Integer> process() throws BizException {

                return APIResponse.returnSuccess(storeMasterDao.insert(store));

            }
        }.execute();
    }

    @Override
    public APIResponse<List<Store>> listAllStore(Admin admin) {
        return new ApiTemplate<List<Store>>() {
            @Override
            protected void checkParams() throws BizException {
                Preconditions.checkArgument(admin.getPower() > Admin.STORE_ADMIN, "权限不够！，需要平台管理员及以上权限！");
            }

            @Override
            protected APIResponse<List<Store>> process() throws BizException {
                List<Store> storeList = storeSlaveDao.selectAll();
                return APIResponse.returnSuccess(storeList);
            }
        }.execute();
    }

    @Override
    public APIResponse<Integer> updateStore(Store store, Admin admin) {
        return new ApiTemplate<Integer>() {
            @Override
            protected APIResponse<Integer> process() throws BizException {
                if (admin.getPower() < Admin.STORE_ADMIN) return APIResponse.returnFail("权限不够！");
                else if (admin.getPower() == Admin.STORE_ADMIN) {
                    if (admin.getStore() == store.getStoreId()) {
                        return APIResponse.returnSuccess(storeMasterDao.update(store));
                    } else return APIResponse.returnFail("只许门店管理员修改所在门店！");
                } else return APIResponse.returnSuccess(storeMasterDao.update(store));
            }
        }.execute();

    }

    @Override
    public APIResponse<List<Store>> getStoreByCity(String city) {
        return new ApiTemplate<List<Store>>() {
            @Override
            protected APIResponse<List<Store>> process() throws BizException {
                List<Store> storeList = storeSlaveDao.selectAll();
                for (Store s : storeList) {
                    if (!s.getLocation().getCity().equals(city)) {
                        storeList.remove(s);
                    }
                }
                return APIResponse.returnSuccess(storeList);
            }
        }.execute();


    }

    @Override
    public APIResponse<Store> getStoreById(int storeId, Admin admin) {
        return new ApiTemplate<Store>() {
            @Override
            protected void checkParams() throws BizException {
                Preconditions.checkArgument(admin.getPower() > Admin.STORE_ADMIN, "权限不够！，需要平台管理员及以上权限！");
            }
            @Override
            protected APIResponse<Store> process() throws BizException {

                return APIResponse.returnSuccess(storeSlaveDao.selectById(storeId));
            }
        }.execute();

    }
}
