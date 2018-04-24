package com.xiyan.controller;

import com.alibaba.fastjson.JSON;
import com.xiyan.service.CodeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/code")
public class CodeController {
    @Resource
    private CodeService codeService;
    @RequestMapping("/send")
    public String sendCode(String phone){
        return JSON.toJSONString(codeService.sendCode(phone));
    }
}
