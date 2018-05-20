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
        Admin currentAdmin = getUserUtil.getCurrentAdmin(token);
        if (currentAdmin == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        Object o = orderService.getCar(currentAdmin, OrderId);
        return JSON.toJSONString(o, SerializerFeature.WriteMapNullValue);
    }

    @RequestMapping(value = "/returncar", produces = "text/html;charset=UTF-8")//客户还车，这一步还有点问题 牵扯到支付还没做。
    public String returnCar(String token, Integer OrderId) {
        Admin currentAdmin = getUserUtil.getCurrentAdmin(token);
        if (currentAdmin == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        Object o = orderService.returnCar(currentAdmin, OrderId);
        return JSON.toJSONString(o, SerializerFeature.WriteMapNullValue);
    }


    @RequestMapping(value = "/getbycar", produces = "text/html;charset=UTF-8")//新建订单
    public String getByCar(String token, int carId) {
        Admin currentAdmin = getUserUtil.getCurrentAdmin(token);
        if (currentAdmin == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(orderService.getByCarId(currentAdmin, carId));

    }

    @RequestMapping(value = "/getbyorderidinuser", produces = "text/html;charset=UTF-8")//用户用来查看订单详情
    public String getByIdInUser(String token, int carId) {
        User currentUser = getUserUtil.getCurrentUser(token);
        if (currentUser == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(orderService.getByIdInUser(currentUser, carId));
    }
    @RequestMapping(value = "/getbyorderidinadmin", produces = "text/html;charset=UTF-8")//Admin用来查看订单详情
    public String getByIdInAdmin(String token, int carId) {
        Admin currentAdmin = getUserUtil.getCurrentAdmin(token);
        if (currentAdmin == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(orderService.getByIdInAdmin(currentAdmin, carId));
    }

    @RequestMapping(value = "/getorderbystore", produces = "text/html;charset=UTF-8")//获取历史订单
    public String getOrderByStore(String token) {
        Admin currentAdmin = getUserUtil.getCurrentAdmin(token);
        if (currentAdmin == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(orderService.getOrderByStore(currentAdmin));
    }

    @RequestMapping(value = "/gethistoryorder", produces = "text/html;charset=UTF-8")//获取历史订单
    public String getHistoryOrder(String token) {
        User currentUser = getUserUtil.getCurrentUser(token);
        if (currentUser == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(orderService.listOrderByUserId(currentUser.getUserId()));
    }

    @RequestMapping(value = "/delorder", produces = "text/html;charset=UTF-8")//获取历史订单
    public String delOrder(String token,int orderId) {
        Admin currentAdmin = getUserUtil.getCurrentAdmin(token);
        if (currentAdmin == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(orderService.deleteOrder(currentAdmin,orderId));
    }

}
