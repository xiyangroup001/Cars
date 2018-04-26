package com.xiyan.controller;

import com.alibaba.fastjson.JSON;
import com.xiyan.model.entity.Platform;
import com.xiyan.model.entity.Store;
import com.xiyan.service.PlatformService;
import com.xiyan.service.StoreService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/platform")
public class PlatformController {
    @Resource
    private PlatformService platformService;
    @RequestMapping("/getplatforms")//返回发送的值
    public String getPlatforms(){
        return JSON.toJSONString(platformService.listAllPlatform());
    }

    @RequestMapping("/newplatform")//返回发送的值
    public String newPlatform(Platform platform){
        return JSON.toJSONString(platformService.insertPlatform(platform));
    }

    @RequestMapping("/update")//返回发送的值
    public String updatePlatform(Platform platform){
        return JSON.toJSONString(platformService.updatePlatform(platform));
    }
    @RequestMapping("/del")//返回发送的值
    public String delPlatform(int platformid){
        return JSON.toJSONString(platformService.deletePlatform(platformid));
    }

}
