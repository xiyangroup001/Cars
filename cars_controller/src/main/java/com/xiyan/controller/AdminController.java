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

    @RequestMapping("/login")
    public String clientLogin(String username, String password) {
        if (adminService.loginAdmin(username, password)) {
            String token = "";
            try {
                token = JWTUtil.createJWT(username, username, 1000 * 60 * 10);
                return JSON.toJSONString(APIResponse.returnSuccess(token));
            } catch (Exception e1) {
                e1.printStackTrace();
            }

        }
        return JSON.toJSONString(APIResponse.returnFail("用户名或密码错误！"));
    }

    @PostMapping("/create")
    public String createAdmin(Admin admin, String token) {
        Admin currentAdmin = getCurrentAdmin(token);
        if (currentAdmin == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(adminService.createAdmin(currentAdmin, admin), SerializerFeature.WriteMapNullValue);
    }

    @PostMapping("/list")//全部列表
    public String selectAdmin(String token) {
        Admin currentAdmin = getCurrentAdmin(token);
        if (currentAdmin == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        Admin admin = new Admin();
        return JSON.toJSONString(adminService.listAdmin(currentAdmin, admin), SerializerFeature.WriteMapNullValue);
    }

    @PostMapping("/listunde")//下属列表
    public String selectUndeAdmin(String token) {
        Admin currentAdmin = getCurrentAdmin(token);
        if (currentAdmin == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(adminService.listUnde(currentAdmin), SerializerFeature.WriteMapNullValue);
    }

    @PostMapping("/delete")
    public String deleteAdmin(String token, String adminId) {
        Admin currentAdmin = getCurrentAdmin(token);
        if (currentAdmin == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(adminService.deleteAdmin(currentAdmin, adminId), SerializerFeature.WriteMapNullValue);
    }

    @PostMapping("/update")
    public String updateAdmin(String token, Admin admin) {
        Admin currentAdmin = getCurrentAdmin(token);
        if (currentAdmin == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(adminService.updateAdmin(currentAdmin, admin), SerializerFeature.WriteMapNullValue);
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
