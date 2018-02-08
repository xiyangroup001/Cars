package com.xiyan.service;

import com.xiyan.model.entrty.Admin;
import com.xiyan.model.entrty.User;
import com.xiyan.model.utils.APIResponse;

import java.util.List;

/**
 * @antuor binwang
 * @date 2018/1/24  16:21
 */
public interface AdminService {

    /**
     * Method 删除用户
     * @param adminId
     * @return
     */
    APIResponse<Integer> deleteAdmin(Integer adminId);

    /**
     * Method 新建用户
     * @param admin
     * @return
     */
    APIResponse<Integer> insertAdmin(Admin admin);

    /**
     * Method 选择全部用户
     * @return
     */
    APIResponse<List<Admin>> listAllAdmin();

    /**
     * Method 更新用户信息
     * @param admin
     * @return
     */
    APIResponse<Integer> updateAdmin(Admin admin);
}


//~ Formatted by Jindent --- http://www.jindent.com
