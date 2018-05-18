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
import com.xiyan.utils.GetUserUtil;
import com.xiyan.utils.JWTUtil;
import io.jsonwebtoken.Claims;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    private OrderService orderService;
    @Resource
    private GetUserUtil getUserUtil;
    @RequestMapping(value = "/createorder", produces = "text/html;charset=UTF-8")//新建订单
    public String creatrOrder(String token, Order order) {
        User currentUser = getUserUtil.getCurrentUser(token);
        if (currentUser == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(orderService.insertOrder(currentUser, order));

    }

    @RequestMapping(value = "/getbycar", produces = "text/html;charset=UTF-8")//新建订单
    public String getByCar(String token, int carId) {
        Admin currentAdmin = getUserUtil.getCurrentAdmin(token);
        if (currentAdmin == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(orderService.getByCarId(currentAdmin, carId));

    }

    @RequestMapping(value = "/getbyorderid", produces = "text/html;charset=UTF-8")//新建订单
    public String getById(String token, int carId) {
        Admin currentAdmin = getUserUtil.getCurrentAdmin(token);
        if (currentAdmin == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(orderService.getByOrderId(currentAdmin, carId));

    }

    @RequestMapping(value = "/paydeposit", produces = "text/html;charset=UTF-8")//支付定金
    public String PayDeposit(String token, Integer OrderId) {
        User currentUser = getUserUtil.getCurrentUser(token);
        if (currentUser == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        Object o = orderService.payDeposit(currentUser.getUserId(), OrderId);
        return JSON.toJSONString(o, SerializerFeature.WriteMapNullValue);
    }

    @RequestMapping(value = "/payall", produces = "text/html;charset=UTF-8")//支付定金
    public String PayAll(String token, Integer OrderId) {
        User currentUser = getUserUtil.getCurrentUser(token);
        if (currentUser == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        Object o = orderService.payAll(currentUser.getUserId(), OrderId);
        return JSON.toJSONString(o, SerializerFeature.WriteMapNullValue);
    }
    @RequestMapping(value = "/getcar", produces = "text/html;charset=UTF-8")//客户取车，这一步还有点问题 牵扯到支付还没做，这个应该是门店管理员做的。
    public String getCar(String token, Integer OrderId) {
        User currentUser = getUserUtil.getCurrentUser(token);
        if (currentUser == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        Object o = orderService.getCar(currentUser.getUserId(), OrderId);
        return JSON.toJSONString(o, SerializerFeature.WriteMapNullValue);
    }

    @RequestMapping(value = "/returncar", produces = "text/html;charset=UTF-8")//客户还车，这一步还有点问题 牵扯到支付还没做。
    public String returnCar(String token, Integer OrderId) {
        User currentUser = getUserUtil.getCurrentUser(token);
        if (currentUser == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        Object o = orderService.returnCar(currentUser.getUserId(), OrderId);
        return JSON.toJSONString(o, SerializerFeature.WriteMapNullValue);
    }
    @RequestMapping(value = "/returndeposit", produces = "text/html;charset=UTF-8")//支付定金
    public String returnDeposit(String token, Integer OrderId) {
        User currentUser = getUserUtil.getCurrentUser(token);
        if (currentUser == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        Object o = orderService.returnDeposit(currentUser.getUserId(), OrderId);
        return JSON.toJSONString(o, SerializerFeature.WriteMapNullValue);
    }

    @RequestMapping(value = "/gethistoryorder", produces = "text/html;charset=UTF-8")//获取历史订单
    public String getHistoryOrder(String token) {
        User currentUser = getUserUtil.getCurrentUser(token);
        if (currentUser == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(orderService.listOrderByUserId(currentUser.getUserId()));
    }

}
