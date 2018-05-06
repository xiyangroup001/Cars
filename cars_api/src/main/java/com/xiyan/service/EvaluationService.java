package com.xiyan.service;

import com.xiyan.model.entity.Admin;
import com.xiyan.model.entity.Evaluation;
import com.xiyan.model.entity.User;
import com.xiyan.model.utils.APIResponse;

import java.util.List;

/**
 * @antuor binwang
 * @date 2018/1/24  16:21
 */
public interface EvaluationService {
    /**
     * Method 新建
     * @param
     * @return
     */
    APIResponse<Integer> createEvaluation(User user, int orderId, Evaluation evaluation);

    /**
     * Method 选择,通过车辆
     * @return
     */
    APIResponse<List<Evaluation>> listEvaluationByCar(int carId);

    /**
     * Method 用户选择，通过订单
     * @return
     */
    APIResponse<Evaluation> getEvaluationByOrder(User user,int OrderId);
    /**
     * Method 选择,通过星级
     * @return
     */
    APIResponse<List<Evaluation>> listEvaluationByGrade(int grade,int carId);


    /**
     * Method 更新
     * @param
     * @return
     */
    APIResponse<Integer> updateEvaluation(User user, Evaluation evaluation);

    /**
     * Method 删除
     * @return
     */
    APIResponse<Integer> deleteEvaluation(Admin currentAdmin, int evaluationid);


}


//~ Formatted by Jindent --- http://www.jindent.com
