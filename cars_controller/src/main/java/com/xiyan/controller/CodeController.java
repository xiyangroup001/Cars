package com.xiyan.controller;

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
    public void sendCode(String phone){
        codeService.sendCode(phone);
    }
}
