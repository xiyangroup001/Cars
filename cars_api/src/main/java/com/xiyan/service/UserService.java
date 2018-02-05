package com.xiyan.service;

import java.util.List;

import com.xiyan.model.entrty.User;
import com.xiyan.model.utils.APIResponse;

/**
 * @antuor binwang
 * @date 2018/1/24  16:21
 */
public interface UserService {

    /**
     * Method 删除用户
     * @param userid
     * @return
     */
    APIResponse<Integer> deleteUser(Integer userid);

    /**
     * Method 新建用户
     * @param user
     * @return
     */
    APIResponse<Integer> insertUser(User user);

    /**
     * Method 选择全部用户
     * @return
     */
    APIResponse<List<User>> selectAllUser();

    /**
     * Method 更新用户信息
     * @param user
     * @return
     */
    APIResponse<Integer> updateUser(User user);
}


//~ Formatted by Jindent --- http://www.jindent.com
