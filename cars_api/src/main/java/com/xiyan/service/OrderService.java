package com.xiyan.service;

import com.xiyan.model.entity.Order;
import com.xiyan.model.entity.User;
import com.xiyan.model.utils.APIResponse;

import java.util.List;

/**
 * @antuor binwang
 * @date 2018/1/24  16:21
 */
public interface OrderService {

    /**
     * Method 删除用户
     * @param orderId
     * @return
     */
    APIResponse<Integer> deleteOrder(Integer orderId);

    /**
     * Method 新建用户
     * @param order
     * @return
     */
    APIResponse<Integer> insertOrder(User currentUser,Order order);

    /**
     * Method 选择全部用户
     * @return
     */
    APIResponse<List<Order>> listAllOrder();

    /**
     * Method 更新用户信息
     * @param order
     * @return
     */
    APIResponse<Integer> updateOrder(Order order);

    APIResponse<List<Order>> listOrderByUserId(int userId);

    APIResponse<Boolean> getCar(int userId, int orderId);

    APIResponse<Boolean> returnCar(int userId, int orderId);
}


//~ Formatted by Jindent --- http://www.jindent.com
