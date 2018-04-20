package com.xiyan.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xiyan.model.entrty.User;
import com.xiyan.model.utils.APIResponse;
import com.xiyan.service.UserService;
import com.xiyan.utils.JWTUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @RequestMapping("/login")
    public String loginUser(int userId, String password) {
        if(userService.loginUser(userId,password)){
            String token = "";
            try {
                token = JWTUtil.createJWT(String.valueOf(userId),String.valueOf(userId), 1000*60*60);
                return JSON.toJSONString(APIResponse.returnSuccess(token));
            } catch (Exception e1) {
                e1.printStackTrace();
            }

        }
        return JSON.toJSONString(APIResponse.returnFail("用户名或密码错误！"));
    }
    @RequestMapping("/register")
    public String insertUser(User user) {
        return JSON.toJSONString(userService.insertUser(user), SerializerFeature.WriteMapNullValue);
    }

    @GetMapping("/all")
    public String selectAllUser(String token){
        return JSON.toJSONString(userService.listAllUser(),SerializerFeature.WriteMapNullValue);
    }

    @GetMapping("/delete")
    public String deleteUser(Integer userId){
        return JSON.toJSONString(userService.deleteUser(userId),SerializerFeature.WriteMapNullValue);
    }
    @GetMapping("/namecanuse")
    public String nameCanUse(String name){
        return JSON.toJSONString(userService.nameIsUsing(name),SerializerFeature.WriteMapNullValue);
    }

    @GetMapping("/phonecanuse")
    public String phoneCanUse(String phone){
        return JSON.toJSONString(userService.phoneIsUsing(phone),SerializerFeature.WriteMapNullValue);
    }

    @GetMapping("/update")
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
            String userId = claims.getSubject();
            currentUser = userService.getUserById(Integer.parseInt(userId));
        } catch (Exception e) {
            return null;
        }
        return currentUser;
    }

}

