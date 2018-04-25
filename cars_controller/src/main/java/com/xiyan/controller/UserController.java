package com.xiyan.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xiyan.model.entity.User;
import com.xiyan.model.utils.APIResponse;
import com.xiyan.service.UserService;
import com.xiyan.utils.JWTUtil;
import io.jsonwebtoken.Claims;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @antuor binwang
 * @date 2018/1/29  11:29
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public String loginUser(String userName, String password) {
        if(userService.loginUser(userName,password)){
            String token = "";
            try {
                token = JWTUtil.createJWT(userName,userName, 1000*60*60);
                return JSON.toJSONString(APIResponse.returnSuccess(token));
            } catch (Exception e1) {
                e1.printStackTrace();
            }

        }
        return JSON.toJSONString(APIResponse.returnFail("用户名或密码错误！"));
    }
    @PostMapping("/register")//注册
    public String insertUser(User user) {
        return JSON.toJSONString(userService.insertUser(user), SerializerFeature.WriteMapNullValue);
    }

    @PostMapping("/changepassword")//修改密码。
    public String changePassword(String token,String oldPassword,String newPassword) {
        User currentUser = getCurrentUser(token);
        if (currentUser == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(userService.changePassword(currentUser,oldPassword,newPassword), SerializerFeature.WriteMapNullValue);
    }


    @PostMapping("/all")//暂时用不到
    public String selectAllUser(String token){
        return JSON.toJSONString(userService.listAllUser(),SerializerFeature.WriteMapNullValue);
    }

    @PostMapping("/delete")//注销，先用不到
    public String deleteUser(String token,Integer userId){
        User currentUser = getCurrentUser(token);
        if (currentUser == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(userService.deleteUser(currentUser,userId),SerializerFeature.WriteMapNullValue);
    }
    @PostMapping("/namecanuse")//用户名是否可用，返回bool
    public String nameCanUse(String name){
        return JSON.toJSONString(userService.nameIsUsing(name),SerializerFeature.WriteMapNullValue);
    }

    @PostMapping("/phonecanuse")//电话是否已经注册，返回bool
    public String phoneCanUse(String phone){
        return JSON.toJSONString(userService.phoneIsUsing(phone),SerializerFeature.WriteMapNullValue);
    }

    @PostMapping("/update")//用户修改信息
    public String updateUser(String token,User user){
        User currentUser = getCurrentUser(token);
        if (currentUser == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(userService.updateUser(currentUser,user),SerializerFeature.WriteMapNullValue);
    }



    private User getCurrentUser(String token) {
        User currentUser;
        try {
            Claims claims = JWTUtil.parseJWT(token);
            String userName = claims.getSubject();
            currentUser = userService.getUserByName(userName);
        } catch (Exception e) {
            return null;
        }
        return currentUser;
    }

}

