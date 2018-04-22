package com.xiyan.service;

import com.xiyan.model.entity.Admin;
import com.xiyan.model.utils.APIResponse;

import java.util.List;

/**
 * @antuor binwang
 * @date 2018/1/24  16:21
 */
public interface AdminService {
    /**
     * Method 新建管理员
     * @param admin
     * @return
     */
    APIResponse<Integer> createAdmin(Admin currentAdmin,Admin admin);

    /**
     * Method 选择管理员
     * @return
     */
    APIResponse<List<Admin>> listAdmin(Admin currentAdmin, Admin admin);

    /**
     * Method 选择自己下属
     * @return
     */
    APIResponse<List<Admin>> listUnde(Admin admin);

    /**
     * Method 更新用户信息
     * @param admin
     * @return
     */
    APIResponse<Integer> updateAdmin(Admin currentAdmin,Admin admin);

    /**
     * Method 修改密码
     * @param admin
     * @return
     */
    APIResponse<Integer> alertPassWord(Admin admin,String newPassWord);
    /**
     * Method 删除管理员
     * @return
     */
    APIResponse<Integer> deleteAdmin(Admin currentAdmin,String adminId);

    /**
     * Metho
     * @return
     */
    boolean loginAdmin(String adminName,String passWord);

    /**
     * Metho
     * @return
     */
    Admin getAdminByName(String adminName);
}


//~ Formatted by Jindent --- http://www.jindent.com
