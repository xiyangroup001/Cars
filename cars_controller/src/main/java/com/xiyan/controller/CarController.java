package com.xiyan.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xiyan.model.entity.Admin;
import com.xiyan.model.entity.Car;
import com.xiyan.model.utils.APIResponse;
import com.xiyan.service.AdminService;
import com.xiyan.service.CarService;
import com.xiyan.service.UserService;
import com.xiyan.utils.JWTUtil;
import io.jsonwebtoken.Claims;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/car")
public class CarController {
    @Resource
    private CarService carService;
    @Resource
    private AdminService adminService;

    @RequestMapping("/selectcar")
    public String selectCar(int getStore,
                            @RequestParam(value = "carType[]")int[] carType,
                            @RequestParam(value = "carBrand[]")String[] carBrand,
                            int lowPrice, int highPrice,
                            int lowRentalPrice, int highRentalPrice) {
        Object o = carService.selectCarByCondition(getStore,carType,carBrand,lowPrice,highPrice,lowRentalPrice,highRentalPrice);
        return JSON.toJSONString(o, SerializerFeature.WriteMapNullValue);
    }

    @RequestMapping("/selectcarbystore")
    public String selectCarByStore(int storeid) {
        Object o = carService.selectCarByStore(storeid);
        return JSON.toJSONString(o, SerializerFeature.WriteMapNullValue);
    }

    @RequestMapping("/newcar")
    public String createCar(String token,Car car) {
        Admin currentAdmin = getCurrentAdmin(token);
        if (currentAdmin == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(carService.createCar(currentAdmin,car), SerializerFeature.WriteMapNullValue);
    }

    @RequestMapping("/update")
    public String updateCar(String token,Car car) {
        Admin currentAdmin = getCurrentAdmin(token);
        if (currentAdmin == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(carService.updateCar(currentAdmin,car), SerializerFeature.WriteMapNullValue);
    }

    @RequestMapping("/updateprice")
    public String updateCaPrice(String token,int carId,double price) {
        Admin currentAdmin = getCurrentAdmin(token);
        if (currentAdmin == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(carService.updateCarPrice(currentAdmin,carId,price), SerializerFeature.WriteMapNullValue);
    }
    @RequestMapping("/updatepricebypp")
    public String updateCaPrice(String token,int low,int high,double price) {
        Admin currentAdmin = getCurrentAdmin(token);
        if (currentAdmin == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(carService.updateCarPrice(currentAdmin,low,high,price), SerializerFeature.WriteMapNullValue);
    }

       @RequestMapping("/getnotpasscar")
    public String getNotPassCar(String token) {
        Admin currentAdmin = getCurrentAdmin(token);
        if (currentAdmin == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(carService.getNotPassCar(currentAdmin), SerializerFeature.WriteMapNullValue);
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
