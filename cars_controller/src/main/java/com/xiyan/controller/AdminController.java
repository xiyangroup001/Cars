package com.xiyan.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xiyan.model.entity.Admin;
import com.xiyan.model.utils.APIResponse;
import com.xiyan.service.AdminService;
import com.xiyan.utils.JWTUtil;
import io.jsonwebtoken.Claims;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private AdminService adminService;

    @RequestMapping("/login")//登陆，返回token
    public String clientLogin(String username, String password) {
        if (adminService.loginAdmin(username, password)) {
            String token = "";
            try {
                token = JWTUtil.createJWT(username, username, 1000 * 60 * 30);
                return JSON.toJSONString(APIResponse.returnSuccess(token));
            } catch (Exception e1) {
                e1.printStackTrace();
            }

        }
        return JSON.toJSONString(APIResponse.returnFail("用户名或密码错误！"));
    }

    @PostMapping("/create")//新建用户，即注册，正常返回1
    public String createAdmin(Admin admin, String token) {
        Admin currentAdmin = getCurrentAdmin(token);
        if (currentAdmin == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(adminService.createAdmin(currentAdmin, admin), SerializerFeature.WriteMapNullValue);
    }

    @RequestMapping("/changepassword")//修改密码，正常返回无数据，
    public String changePassword(String token,String oldPassword,String newPassword) {
        Admin currentAdmin = getCurrentAdmin(token);
        if (currentAdmin == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(adminService.changePassword(currentAdmin,oldPassword,newPassword), SerializerFeature.WriteMapNullValue);
    }

    @PostMapping("/list")//全部列表,给超级管理员使用
    public String selectAdmin(String token) {
        Admin currentAdmin = getCurrentAdmin(token);
        if (currentAdmin == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        Admin admin = new Admin();
        return JSON.toJSONString(adminService.listAdmin(currentAdmin, admin), SerializerFeature.WriteMapNullValue);
    }

    @PostMapping("/listunde")//获取下属列表，给门店店主用返回一个Admin列表
    public String selectUndeAdmin(String token) {
        Admin currentAdmin = getCurrentAdmin(token);
        if (currentAdmin == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(adminService.listUnde(currentAdmin), SerializerFeature.WriteMapNullValue);
    }

    @PostMapping("/delete")//删除下属，给门店店主用
    public String deleteAdmin(String token, String adminId) {
        Admin currentAdmin = getCurrentAdmin(token);
        if (currentAdmin == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(adminService.deleteAdmin(currentAdmin, adminId), SerializerFeature.WriteMapNullValue);
    }

    @PostMapping("/checkcarpass")//审核车辆通过，无数据返回 ret=true
    public String checkCarPass(String token, int carId) {
        Admin currentAdmin = getCurrentAdmin(token);
        if (currentAdmin == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(adminService.checkCarPass(currentAdmin, carId), SerializerFeature.WriteMapNullValue);
    }

    @PostMapping("/checkcarfail")// ，这两个给系统管管理员用，审核车辆不通过，无数据返回 ret=true
    public String checkCarFail(String token, int carId,String message) {
        Admin currentAdmin = getCurrentAdmin(token);
        if (currentAdmin == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(adminService.checkCarFail(currentAdmin, carId,message), SerializerFeature.WriteMapNullValue);
    }

    @PostMapping("/update")//修改个人信息，不过能改的项很少，可以不用这个。
    public String updateAdmin(String token, Admin admin) {
        Admin currentAdmin = getCurrentAdmin(token);
        if (currentAdmin == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(adminService.updateAdmin(currentAdmin, admin), SerializerFeature.WriteMapNullValue);
    }

    @PostMapping("/islogin")//
    public String isLogin(String token){
        Admin currentAdmin = getCurrentAdmin(token);
        if (currentAdmin == null) {
            return JSON.toJSONString(APIResponse.returnFail("false"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(APIResponse.returnSuccess(true),SerializerFeature.WriteMapNullValue);
    }
    private Admin getCurrentAdmin(String token) {
        Admin currentAdmin;
        try {
            Claims claims = JWTUtil.parseJWT(token);
            String username = claims.getSubject();
            currentAdmin = adminService.getAdminByName(username);
        } catch (Exception e) {
            return null;
        }
        return currentAdmin;
    }
}
