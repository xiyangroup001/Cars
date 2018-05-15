package com.xiyan.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xiyan.model.entity.User;
import com.xiyan.model.utils.APIResponse;
import com.xiyan.service.UserService;
import com.xiyan.utils.GetUserUtil;
import com.xiyan.utils.JWTUtil;
import io.jsonwebtoken.Claims;
import org.springframework.web.bind.annotation.*;

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

    @Resource
    private GetUserUtil getUserUtil;
    @RequestMapping(value = "/login",produces="text/html;charset=UTF-8")
    public String loginUser(String userName,String password) {
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
    @RequestMapping(value="/register",produces="text/html;charset=UTF-8")//注册
    public String insertUser(User user) {
        return JSON.toJSONString(userService.insertUser(user), SerializerFeature.WriteMapNullValue);
    }

    @RequestMapping(value = "/changepassword",produces="text/html;charset=UTF-8")//修改密码。
    public String changePassword( String token,
                                  String oldPassword,String newPassword) {
        User currentUser = getUserUtil.getCurrentUser(token);
        if (currentUser == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(userService.changePassword(currentUser,oldPassword,newPassword), SerializerFeature.WriteMapNullValue);
    }


    @RequestMapping(value = "/all",produces="text/html;charset=UTF-8")//暂时用不到
    public String selectAllUser( String token){
        return JSON.toJSONString(userService.listAllUser(),SerializerFeature.WriteMapNullValue);
    }

    @RequestMapping(value = "/delete" ,produces="text/html;charset=UTF-8")//注销，先用不到
    public String deleteUser( String token,Integer userId){
        User currentUser = getUserUtil.getCurrentUser(token);
        if (currentUser == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(userService.deleteUser(currentUser,userId),SerializerFeature.WriteMapNullValue);
    }
    @RequestMapping(value = "/namecanuse",produces="text/html;charset=UTF-8")//用户名是否可用，返回bool
    public String nameCanUse( String name){
        return JSON.toJSONString(userService.nameIsUsing(name),SerializerFeature.WriteMapNullValue);
    }

    @RequestMapping(value = "/phonecanuse",produces="text/html;charset=UTF-8")//电话是否已经注册，返回bool
    public String phoneCanUse(  String phone){
        return JSON.toJSONString(userService.phoneIsUsing(phone),SerializerFeature.WriteMapNullValue);
    }

    @RequestMapping(value = "/update",produces="text/html;charset=UTF-8")//用户修改信息
    public String updateUser( String token,User user){
        User currentUser = getUserUtil.getCurrentUser(token);
        if (currentUser == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(userService.updateUser(currentUser,user),SerializerFeature.WriteMapNullValue);
    }

    @RequestMapping(value = "/getuser",produces="text/html;charset=UTF-8")
    public String getUserById( String token){
        User currentUser = getUserUtil.getCurrentUser(token);
        if (currentUser == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(APIResponse.returnSuccess(currentUser),SerializerFeature.WriteMapNullValue);
    }

    @RequestMapping(value = "/islogin",produces="text/html;charset=UTF-8")
    public String isLogin(String token){
        User currentUser = getUserUtil.getCurrentUser(token);
        if (currentUser == null) {
            return JSON.toJSONString(APIResponse.returnFail("false"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(APIResponse.returnSuccess(true),SerializerFeature.WriteMapNullValue);
    }




}

