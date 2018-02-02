package com.xiyan.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xiyan.model.entrty.User;
import com.xiyan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

/**
 * @antuor binwang
 * @date 2018/1/29  11:29
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/save")
    public String savaUser(User user){
        return JSON.toJSONString(userService.insertUser(user), SerializerFeature.WRITE_MAP_NULL_FEATURES);
    }
}

