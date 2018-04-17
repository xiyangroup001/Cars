package com.xiyan.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xiyan.model.entrty.Admin;
import com.xiyan.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/save")
    public String insertAdmin(Admin admin) {
        return JSON.toJSONString(adminService.insertAdmin(admin), SerializerFeature.WriteMapNullValue);
    }

    @GetMapping("/all")
    public String selectAllAdmin(){
        return JSON.toJSONString(adminService.listAllAdmin(),SerializerFeature.WriteMapNullValue);
    }

    @GetMapping("/delete")
    public String deleteAdmin(Integer adminId){
        return JSON.toJSONString(adminService.deleteAdmin(adminId),SerializerFeature.WriteMapNullValue);
    }
    @GetMapping("/update")
    public String updateAdmin(Admin admin){
        return JSON.toJSONString(adminService.updateAdmin(admin),SerializerFeature.WriteMapNullValue);
    }
}
