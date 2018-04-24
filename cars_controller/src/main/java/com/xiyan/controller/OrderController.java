package com.xiyan.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xiyan.model.entity.Admin;
import com.xiyan.model.entity.Order;
import com.xiyan.model.entity.User;
import com.xiyan.model.utils.APIResponse;
import com.xiyan.service.AdminService;
import com.xiyan.service.OrderService;
import com.xiyan.service.UserService;
import com.xiyan.utils.JWTUtil;
import io.jsonwebtoken.Claims;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    private UserService userService;
    @Resource
    private AdminService adminService;
    @Resource
    private OrderService orderService;

    @PostMapping("/createorder")
    public String creatrOrder(String token,Order order) {
        User currentUser = getCurrentUser(token);
        if (currentUser == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(orderService.insertOrder(currentUser, order));

    }

    @PostMapping("/getcar")//取车
    public String getCar(String token,Integer OrderId) {
        User currentUser = getCurrentUser(token);
        if (currentUser == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        Object o = orderService.getCar(currentUser.getUserId(),OrderId);
        return JSON.toJSONString(o, SerializerFeature.WriteMapNullValue);
    }

    @PostMapping("/returncar")//取车
    public String returnCar(String token,Integer OrderId) {
        User currentUser = getCurrentUser(token);
        if (currentUser == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        Object o = orderService.returnCar(currentUser.getUserId(),OrderId);
        return JSON.toJSONString(o, SerializerFeature.WriteMapNullValue);
    }


    @PostMapping("/gethistoryorder")
    public String getHistoryOrder(String token) {
        Claims claims = null;
        try {
            claims = JWTUtil.parseJWT(token);
            String userId = claims.getSubject();
            return JSON.toJSONString(orderService.listOrderByUserId(Integer.parseInt(userId)));
        } catch (Exception e) {
            e.printStackTrace();
            return JSON.toJSONString(APIResponse.returnFail( e.getMessage()), SerializerFeature.WriteMapNullValue);

        }


    }

    private User getCurrentUser(String token) {
        User currentUser;
        try {
            Claims claims = JWTUtil.parseJWT(token);
            String userId = claims.getSubject();
            currentUser = userService.getUserById(Integer.parseInt(userId));
        } catch (Exception e) {
            return null;
        }
        return currentUser;
    }
    private Admin getCurrentAdmin(String token) {
        Admin currentAdmin;
        try {
            Claims claims = JWTUtil.parseJWT(token);
            String username = claims.getSubject();
            currentAdmin = adminService.getAdminByName(username);
        } catch (Exception e) {
            return null;
        }
        return currentAdmin;
    }
}
