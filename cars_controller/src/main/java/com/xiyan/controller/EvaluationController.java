package com.xiyan.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xiyan.model.entity.Admin;
import com.xiyan.model.entity.Evaluation;
import com.xiyan.model.entity.User;
import com.xiyan.model.utils.APIResponse;
import com.xiyan.service.EvaluationService;
import com.xiyan.utils.GetUserUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/eval")
public class EvaluationController {
    @Resource
    private EvaluationService evaluationService;
    @Resource
    private GetUserUtil getUserUtil;
    @RequestMapping(value = "/create",produces="text/html;charset=UTF-8")//新建
    public String createEvaluation(int orderId, Evaluation evaluation, String token) {
        User currentUser = getUserUtil.getCurrentUser(token);
        if (currentUser == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(evaluationService.createEvaluation(currentUser,orderId,evaluation), SerializerFeature.WriteMapNullValue);
    }

    @RequestMapping(value = "/listbycar",produces="text/html;charset=UTF-8")//
    public String ListEvaluationByCar(int carId) {
        return JSON.toJSONString(evaluationService.listEvaluationByCar(carId), SerializerFeature.WriteMapNullValue);
    }

    @RequestMapping(value = "/getbyorder",produces="text/html;charset=UTF-8")//
    public String getEvaluationByOrder(int orderId,String token) {
        User currentUser = getUserUtil.getCurrentUser(token);
        if (currentUser == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(evaluationService.getEvaluationByOrder(currentUser,orderId), SerializerFeature.WriteMapNullValue);
    }

    @RequestMapping(value = "/listbygrade",produces="text/html;charset=UTF-8")//
    public String ListEvaluationByGrade(int grade,int carId) {
        return JSON.toJSONString(evaluationService.listEvaluationByGrade(grade,carId), SerializerFeature.WriteMapNullValue);
    }

    @RequestMapping(value = "/update",produces="text/html;charset=UTF-8")//
    public String updateEvaluation(Evaluation evaluation,String token) {
        User currentUser = getUserUtil.getCurrentUser(token);
        if (currentUser == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(evaluationService.updateEvaluation(currentUser,evaluation), SerializerFeature.WriteMapNullValue);
    }

    @RequestMapping(value = "/del",produces="text/html;charset=UTF-8")//
    public String delEvaluation(int evaluationId,String token) {
        Admin currentAdmin = getUserUtil.getCurrentAdmin(token);
        if (currentAdmin == null) {
            return JSON.toJSONString(APIResponse.returnFail("请登录！"), SerializerFeature.WriteMapNullValue);
        }
        return JSON.toJSONString(evaluationService.deleteEvaluation(currentAdmin,evaluationId), SerializerFeature.WriteMapNullValue);
    }


}
