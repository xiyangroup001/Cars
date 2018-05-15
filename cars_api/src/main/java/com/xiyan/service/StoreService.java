package com.xiyan.service;

import com.xiyan.model.entity.Admin;
import com.xiyan.model.entity.Store;
import com.xiyan.model.utils.APIResponse;

import java.util.List;

/**
 * @antuor binwang
 * @date 2018/1/24  16:21
 */
public interface StoreService {

    /**
     * Method 删除用户
     * @param storeId
     * @return
     */
    APIResponse<Integer> deleteStore(Integer storeId, Admin admin);

    /**
     * Method 新建用户
     * @param store
     * @return
     */
    APIResponse<Integer> insertStore(Store store, Admin admin);

    /**
     * Method 选择全部用户
     * @return
     */
    APIResponse<List<Store>> listAllStore(Admin admin);

    /**
     * Method 更新用户信息
     * @param store
     * @return
     */
    APIResponse<Integer> updateStore(Store store, Admin admin);

    APIResponse<List<Store>> getStoreByCity(String city);

    APIResponse<Store> getStoreById(int storeId, Admin admin);
}


//~ Formatted by Jindent --- http://www.jindent.com
