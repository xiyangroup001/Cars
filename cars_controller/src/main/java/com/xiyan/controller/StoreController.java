package com.xiyan.controller;

import com.alibaba.fastjson.JSON;
import com.xiyan.model.entity.Store;
import com.xiyan.service.CodeService;
import com.xiyan.service.StoreService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/store")
public class StoreController {
    @Resource
    private StoreService storeService;
    @RequestMapping(value = "/getstorebycity",produces="text/html;charset=UTF-8")//返回发送的值
    public String getStoreByCity( String city){
        return JSON.toJSONString(storeService.getStoreByCity(city));
    }

    @RequestMapping(value = "/newstore",produces="text/html;charset=UTF-8")//返回发送的值
    public String newScore(  Store store){
        return JSON.toJSONString(storeService.insertStore(store));
    }
    @RequestMapping(value = "/updatestore",produces="text/html;charset=UTF-8")
    public String updateScore( Store store){
        return JSON.toJSONString(storeService.updateStore(store));
    }

    @RequestMapping(value = "/delstore",produces="text/html;charset=UTF-8")
    public String delScore( int storeId){
        return JSON.toJSONString(storeService.deleteStore(storeId));
    }
    @RequestMapping(value = "/getstorebyid",produces="text/html;charset=UTF-8")
    public String getStoreById( int storeId){
        return JSON.toJSONString(storeService.getStoreById(storeId));
    }
}
