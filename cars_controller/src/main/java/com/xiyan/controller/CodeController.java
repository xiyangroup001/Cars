package com.xiyan.controller;

import com.alibaba.fastjson.JSON;
import com.xiyan.service.CodeService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/code")
public class CodeController {
    @Resource
    private CodeService codeService;
    @RequestMapping(value = "/send",produces="text/html;charset=UTF-8")//返回发送的值
    public String sendCode( String phone){
        return JSON.toJSONString(codeService.sendCode(phone));
    }
    @RequestMapping(value = "/checkcode",produces="text/html;charset=UTF-8")//返回发送的值
    public String checkCode( String phone,
                             String val){
        return JSON.toJSONString(codeService.checkCode(phone,val));
    }
}
