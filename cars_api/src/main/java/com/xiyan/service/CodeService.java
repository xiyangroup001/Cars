package com.xiyan.service;

import com.xiyan.model.entity.Code;
import com.xiyan.model.utils.APIResponse;

/**
 * @antuor binwang
 * @date 2018/1/24  16:21
 */
public interface CodeService {

    /**
     * Method 删除用户
     * @param userid
     * @return

    APIResponse<Integer> deleteCode(Integer userid);
    */
    /**
     * Method 新建用户
     * @param code
     * @return
     */
    APIResponse<Integer> insertCodr(Code code);


    /**
     * Method 更新用户信息
     * @param code
     * @return
     */
    APIResponse<Integer> updateCode(Code code);

    APIResponse<String> sendCode(String phone);

    APIResponse<Boolean> checkCode(String phone, String val);
}


//~ Formatted by Jindent --- http://www.jindent.com
