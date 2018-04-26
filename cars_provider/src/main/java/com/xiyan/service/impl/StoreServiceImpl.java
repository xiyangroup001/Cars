package com.xiyan.service.impl;


import com.xiyan.dao.master.StoreMasterDao;
import com.xiyan.dao.slave.StoreSlaveDao;

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
    public APIResponse<Integer> deleteStore(Integer storeId) {
        return null;
    }

    @Override
    public APIResponse<Integer> insertStore(Store store) {
        return new ApiTemplate<Integer>() {
            @Override
            protected APIResponse<Integer> process() throws BizException {
                storeMasterDao.insert(store);
                return null;
            }
        }.execute();
    }

    @Override
    public APIResponse<List<Store>> listAllStore() {
        return new ApiTemplate<List<Store>>() {
            @Override
            protected APIResponse<List<Store>> process() throws BizException {
                List<Store> storeList = storeSlaveDao.selectAll();
                return APIResponse.returnSuccess(storeList);
            }
        }.execute();
    }

    @Override
    public APIResponse<Integer> updateStore(Store store) {
        return new ApiTemplate<Integer>() {
            @Override
            protected APIResponse<Integer> process() throws BizException {
                return APIResponse.returnSuccess(storeMasterDao.update(store));
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
                    if (!s.getLocation().getCity().equals(city)){
                        storeList.remove(s);
                    }
                }
                return APIResponse.returnSuccess(storeList);
            }
        }.execute();


    }

    @Override
    public APIResponse<Store> getStoreById(int storeId) {
        return new ApiTemplate<Store>() {
            @Override
            protected APIResponse<Store> process() throws BizException {
                return APIResponse.returnSuccess(storeSlaveDao.selectById(storeId));
            }
        }.execute();

    }
}
