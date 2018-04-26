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
import org.springframework.web.bind.annotation.PostMapping;
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

    @RequestMapping("/selectcar")//条件选择车辆，价位（单位：万元）
    public String selectCar(int getStore,
                            @RequestParam(value = "carType[]")int[] carType,
                            @RequestParam(value = "carBrand[]")String[] carBrand,
                            int lowPrice, int highPrice,
                            int lowRentalPrice, int highRentalPrice) {
        Object o = carService.selectCarByCondition(getStore,carType,carBrand,lowPrice,highPrice,lowRentalPrice,highRentalPrice);
        return JSON.toJSONString(o, SerializerFeature.WriteMapNullValue);
    }

    @RequestMapping("/selectcarbystore")//通过门店选择车辆
    public String selectCarByStore(int storeId) {
        Object o = carService.selectCarByStore(storeId);
        return JSON.toJSONString(o, SerializerFeature.WriteMapNullValue);
    }

    @RequestMapping("/getcarbyid")
    public String getCarById(int carId) {
        Object o = carService.selectCarById(carId);
        return JSON.toJSONString(o, SerializerFeature.WriteMapNullValue);
    }


    @RequestMapping("/newcar") //新上车辆，普通门店管理员可调用。
    public String createCar(String token,Car car) {
        Admin currentAdmin = getCurrentAdmin(token);
        if (currentAdmin == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(carService.createCar(currentAdmin,car), SerializerFeature.WriteMapNullValue);
    }

    @RequestMapping("/update")//修改车辆，普通门店管理员可调用。
    public String updateCar(String token,Car car) {
        Admin currentAdmin = getCurrentAdmin(token);
        if (currentAdmin == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(carService.updateCar(currentAdmin,car), SerializerFeature.WriteMapNullValue);
    }

    @RequestMapping("/updateprice")//修改租金价格，改价用这个借口。
    public String updateCaPrice(String token,int carId,double price) {
        Admin currentAdmin = getCurrentAdmin(token);
        if (currentAdmin == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(carService.updateCarPrice(currentAdmin,carId,price), SerializerFeature.WriteMapNullValue);
    }
    @RequestMapping("/updatepricebypp")//修改租金价格，根据车辆的价位（单位：元）来修改，改价用这个借口。
    public String updateCaPrice(String token,int low,int high,double price) {
        Admin currentAdmin = getCurrentAdmin(token);
        if (currentAdmin == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(carService.updateCarPrice(currentAdmin,low,high,price), SerializerFeature.WriteMapNullValue);
    }
    @PostMapping("/getneedcheckcarlist")//审核车辆通过，无数据返回 ret=true
    public String getNeedCheckCarList(String token) {
        Admin currentAdmin = getCurrentAdmin(token);
        if (currentAdmin == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(carService.getNeedCheckCarList(currentAdmin), SerializerFeature.WriteMapNullValue);
    }
       @RequestMapping("/getnotpasscar")//获取没有通过审核的列表
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
