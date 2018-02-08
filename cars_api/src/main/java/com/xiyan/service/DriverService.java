package com.xiyan.service;

import com.xiyan.model.entrty.Driver;
import com.xiyan.model.entrty.User;
import com.xiyan.model.utils.APIResponse;

import java.util.List;

/**
 * @antuor binwang
 * @date 2018/1/24  16:21
 */
public interface DriverService {

    /**
     * Method 删除用户
     * @param IdNumber
     * @return
     */
    APIResponse<Integer> deleteDriver(Integer IdNumber);

    /**
     * Method 新建用户
     * @param driver
     * @return
     */
    APIResponse<Integer> insertDriver(Driver driver);

    /**
     * Method 选择全部用户
     * @return
     */
    APIResponse<List<Driver>> listAllDriver();

    /**
     * Method 更新用户信息
     * @param driver
     * @return
     */
    APIResponse<Integer> updateDriver(Driver driver);
}


//~ Formatted by Jindent --- http://www.jindent.com
