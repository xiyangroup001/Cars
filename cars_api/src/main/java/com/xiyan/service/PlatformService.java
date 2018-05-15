package com.xiyan.service;

import com.xiyan.model.entity.Admin;
import com.xiyan.model.entity.Platform;
import com.xiyan.model.utils.APIResponse;

import java.util.List;

/**
 * @antuor binwang
 * @date 2018/1/24  16:21
 */
public interface PlatformService {

    /**
     * Method 删除用户
     * @param platformId
     * @return
     */
    APIResponse<Integer> deletePlatform(int platformId, Admin admin);

    /**
     * Method 新建用户
     * @param platform
     * @return
     */
    APIResponse<Integer> insertPlatform(Platform platform, Admin admin);

    /**
     * Method 选择全部用户
     * @return
     */
    APIResponse<List<Platform>> listAllPlatform( Admin admin);

    /**
     * Method 更新用户信息
     * @param platform
     * @return
     */
    APIResponse<Integer> updatePlatform(Platform platform, Admin admin);
}


//~ Formatted by Jindent --- http://www.jindent.com
