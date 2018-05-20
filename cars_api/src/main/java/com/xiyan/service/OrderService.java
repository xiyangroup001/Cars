package com.xiyan.service;

import com.xiyan.model.entity.Admin;
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
    APIResponse<Integer> deleteOrder(Admin currentAdmin,Integer orderId);

    /**
     * Method 新建用户
     * @param order
     * @return
     */
    APIResponse<Integer> insertOrder(User currentUser,Order order);

    APIResponse<List<Order>> listOrderByUserId(int userId);

    APIResponse<Boolean> getCar(Admin currentAdmin, int orderId);

    APIResponse<Boolean> returnCar(Admin currentAdmin, int orderId);

    APIResponse<Integer> payAll(int userId, Integer orderId);

    APIResponse<Integer> payDeposit(int userId, Integer orderId);

    APIResponse<List<Order>> getByCarId(Admin currentAdmin, int carId);

    APIResponse<Order> getByIdInAdmin(Admin currentAdmin, int orderId);

    APIResponse<Order> getByIdInUser(User currentUser, int carId);

    APIResponse<List<Order>> getOrderByStore(Admin currentAdmin);
}


//~ Formatted by Jindent --- http://www.jindent.com
