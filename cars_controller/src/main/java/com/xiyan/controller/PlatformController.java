package com.xiyan.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xiyan.model.entity.Admin;
import com.xiyan.model.entity.Platform;
import com.xiyan.model.entity.Store;
import com.xiyan.model.utils.APIResponse;
import com.xiyan.service.PlatformService;
import com.xiyan.service.StoreService;
import com.xiyan.utils.GetUserUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/platform")
public class PlatformController {
    @Resource
    private PlatformService platformService;
    @Resource
    private GetUserUtil getUserUtil;

    @RequestMapping(value = "/getplatforms",produces="text/html;charset=UTF-8")//返回发送的值
    public String getPlatforms(String token){
        Admin currentAdmin = getUserUtil.getCurrentAdmin(token);
        if (currentAdmin == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(platformService.listAllPlatform(currentAdmin));
    }

    @RequestMapping(value = "/newplatform",produces="text/html;charset=UTF-8")//返回发送的值
    public String newPlatform( Platform platform,String token){
        Admin currentAdmin = getUserUtil.getCurrentAdmin(token);
        if (currentAdmin == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(platformService.insertPlatform(platform,currentAdmin));
    }

    @RequestMapping(value = "/update",produces="text/html;charset=UTF-8")//返回发送的值
    public String updatePlatform( Platform platform,String token){
        Admin currentAdmin = getUserUtil.getCurrentAdmin(token);
        if (currentAdmin == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(platformService.updatePlatform(platform,currentAdmin));
    }
    @RequestMapping(value = "/del",produces="text/html;charset=UTF-8")//返回发送的值
    public String delPlatform( int platformid,String token){
        Admin currentAdmin = getUserUtil.getCurrentAdmin(token);
        if (currentAdmin == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(platformService.deletePlatform(platformid,currentAdmin));
    }

}
