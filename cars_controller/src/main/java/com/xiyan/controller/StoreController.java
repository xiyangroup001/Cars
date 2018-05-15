package com.xiyan.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xiyan.model.entity.Admin;
import com.xiyan.model.entity.Store;
import com.xiyan.model.utils.APIResponse;
import com.xiyan.service.CodeService;
import com.xiyan.service.StoreService;
import com.xiyan.utils.GetUserUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/store")
public class StoreController {
    @Resource
    private StoreService storeService;
    @Resource
    private GetUserUtil getUserUtil;

    @RequestMapping(value = "/getstorebycity",produces="text/html;charset=UTF-8")//返回发送的值
    public String getStoreByCity( String city){

        return JSON.toJSONString(storeService.getStoreByCity(city));
    }

    @RequestMapping(value = "/newstore",produces="text/html;charset=UTF-8")//返回发送的值
    public String newScore(  Store store,String token){
        Admin currentAdmin = getUserUtil.getCurrentAdmin(token);
        if (currentAdmin == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(storeService.insertStore(store,currentAdmin));
    }
    @RequestMapping(value = "/updatestore",produces="text/html;charset=UTF-8")
    public String updateScore( Store store,String token){
        Admin currentAdmin = getUserUtil.getCurrentAdmin(token);
        if (currentAdmin == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(storeService.updateStore(store,currentAdmin));
    }

    @RequestMapping(value = "/delstore",produces="text/html;charset=UTF-8")
    public String delScore( int storeId,String token){
        Admin currentAdmin = getUserUtil.getCurrentAdmin(token);
        if (currentAdmin == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(storeService.deleteStore(storeId,currentAdmin));
    }
    @RequestMapping(value = "/getstorebyid",produces="text/html;charset=UTF-8")
    public String getStoreById( int storeId){

        return JSON.toJSONString(storeService.getStoreById(storeId));
    }
}
