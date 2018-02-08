package com.xiyan.service;

import com.xiyan.model.entrty.Code;
import com.xiyan.model.entrty.User;
import com.xiyan.model.utils.APIResponse;

import java.util.List;

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
}


//~ Formatted by Jindent --- http://www.jindent.com
