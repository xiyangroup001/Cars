package com.xiyan.controller;

import com.alibaba.fastjson.JSON;
import com.xiyan.model.entity.Store;
import com.xiyan.service.CodeService;
import com.xiyan.service.StoreService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/store")
public class StoreController {
    @Resource
    private StoreService storeService;
    @RequestMapping("/getstorebycity")//返回发送的值
    public String getStoreByCity(String city){
        return JSON.toJSONString(storeService.getStoreByCity(city));
    }

    @RequestMapping("/newstore")//返回发送的值
    public String newScore(Store store){
        return JSON.toJSONString(storeService.insertStore(store));
    }
    @RequestMapping("/updatestore")
    public String updateScore(Store store){
        return JSON.toJSONString(storeService.updateStore(store));
    }

    @RequestMapping("/delstore")
    public String delScore(int storeId){
        return JSON.toJSONString(storeService.deleteStore(storeId));
    }
    @RequestMapping("/getstorebyid")
    public String getStoreById(int storeId){
        return JSON.toJSONString(storeService.getStoreById(storeId));
    }
}
