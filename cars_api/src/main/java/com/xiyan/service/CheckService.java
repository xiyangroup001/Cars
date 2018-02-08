package com.xiyan.service;

import com.xiyan.model.entrty.Check;
import com.xiyan.model.entrty.User;
import com.xiyan.model.utils.APIResponse;

import java.util.List;

/**
 * @antuor binwang
 * @date 2018/1/24  16:21
 */
public interface CheckService {

    /**
     * Method 删除用户
     * @param checkId
     * @return
     */
    APIResponse<Integer> deleteCheck(Integer checkId);

    /**
     * Method 新建用户
     * @param check
     * @return
     */
    APIResponse<Integer> insertCheck(Check check);

    /**
     * Method 选择全部用户
     * @return
     */
    APIResponse<List<Check>> listAllCheck();

    /**
     * Method 更新用户信息
     * @param check
     * @return
     */
    APIResponse<Integer> updateCheck(Check check);
}


//~ Formatted by Jindent --- http://www.jindent.com
