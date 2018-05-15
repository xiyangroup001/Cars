package com.xiyan.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xiyan.model.entity.Admin;
import com.xiyan.model.entity.Conpon;
import com.xiyan.model.entity.Store;
import com.xiyan.model.entity.User;
import com.xiyan.model.utils.APIResponse;
import com.xiyan.service.ConponService;
import com.xiyan.service.StoreService;
import com.xiyan.service.UserService;
import com.xiyan.utils.GetUserUtil;
import com.xiyan.utils.JWTUtil;
import io.jsonwebtoken.Claims;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/conpon")
public class ConponController {
    @Resource
    private ConponService conponService;

    @Resource
    private GetUserUtil getUserUtil;
    @RequestMapping(value = "/getbyuser",produces="text/html;charset=UTF-8")//返回发送的值
    public String getConponByUser(String token){
        User currentUser = getUserUtil.getCurrentUser(token);
        if (currentUser == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(conponService.listConponByUser(currentUser.getUserId()));
    }

    @RequestMapping(value = "/newconpon",produces="text/html;charset=UTF-8")//返回发送的值
    public String newConpon(Conpon conpon,String token){
        Admin currentAdmin = getUserUtil.getCurrentAdmin(token);
        if (currentAdmin == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(conponService.insertConpon(conpon,currentAdmin));
    }

    @RequestMapping(value = "/updateconpon",produces="text/html;charset=UTF-8")
    public String updateConpon(Conpon conpon,String token){
        Admin currentAdmin = getUserUtil.getCurrentAdmin(token);
        if (currentAdmin == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(conponService.updateConpon(conpon,currentAdmin));
    }

    @RequestMapping(value = "/delconpon",produces="text/html;charset=UTF-8")
    public String delConpon( int conponId){
        return JSON.toJSONString(conponService.deleteConpon(conponId));
    }

    @RequestMapping(value = "/getbyid",produces="text/html;charset=UTF-8")
    public String getConponById(int conponId,String token){
        User currentUser = getUserUtil.getCurrentUser(token);
        if (currentUser == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(conponService.getConponById(conponId,currentUser));
    }

    @RequestMapping(value = "/delexpire",produces="text/html;charset=UTF-8")
    public String delExpire(String token){
        User currentUser = getUserUtil.getCurrentUser(token);
        if (currentUser == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(conponService.delExpire(currentUser));
    }


}
