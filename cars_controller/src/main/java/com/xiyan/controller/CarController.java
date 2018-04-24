package com.xiyan.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xiyan.service.CarService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/car")
public class CarController {
    @Resource
    private CarService carService;

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
}
