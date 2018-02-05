package com.xiyan.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xiyan.model.entrty.User;
import com.xiyan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @antuor binwang
 * @date 2018/1/29  11:29
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/save")
    public String insertUser(User user) {
        return JSON.toJSONString(userService.insertUser(user), SerializerFeature.WRITE_MAP_NULL_FEATURES);
    }

    @GetMapping("/all")
    public String selectAllUser(){
        return JSON.toJSONString(userService.selectAllUser(),SerializerFeature.WRITE_MAP_NULL_FEATURES);
    }

    @GetMapping("/delete")
    public String deleteUser(Integer userId){
        return JSON.toJSONString(userService.deleteUser(userId),SerializerFeature.WRITE_MAP_NULL_FEATURES);
    }
    @GetMapping("/update")
    public String updateUser(User user){
        return JSON.toJSONString(userService.updateUser(user),SerializerFeature.WRITE_MAP_NULL_FEATURES);
    }

}

