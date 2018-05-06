package com.xiyan.utils;

import com.xiyan.model.entity.Admin;
import com.xiyan.model.entity.User;
import com.xiyan.service.AdminService;
import com.xiyan.service.UserService;
import io.jsonwebtoken.Claims;

public class GetUserUtil {
    private static UserService userService;
    private static AdminService adminService;

    public static User getCurrentUser(String token) {
        User currentUser;
        try {
            Claims claims = JWTUtil.parseJWT(token);
            String userName = claims.getSubject();
            currentUser = userService.getUserByName(userName);
        } catch (Exception e) {
            return null;
        }
        return currentUser;
    }

    public static Admin getCurrentAdmin(String token) {
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
