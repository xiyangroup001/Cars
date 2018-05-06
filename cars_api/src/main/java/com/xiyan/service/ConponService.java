package com.xiyan.service;

import com.xiyan.model.entity.Admin;
import com.xiyan.model.entity.Conpon;
import com.xiyan.model.entity.Driver;
import com.xiyan.model.entity.User;
import com.xiyan.model.utils.APIResponse;

import java.util.List;

public interface  ConponService {
    /**
     * Method 删除
     * @param
     * @return
     */
    APIResponse<Integer> deleteConpon(Integer conponId);

    /**
     * Method 新建
     * @param
     * @return
     */
    APIResponse<Integer> insertConpon(Conpon conpon, Admin currentAdmin);

    APIResponse<Integer> updateConpon(Conpon conpon, Admin currentAdmin);

    APIResponse<List<Conpon>> listConponByUser(Integer userId);


    APIResponse<Conpon> getConponById(int conponId, User currentUser);

    APIResponse<Boolean> delExpire(User currentUser);
}
