package com.xiyan.service.impl;

import com.google.common.base.Preconditions;
import com.xiyan.dao.master.EvaluationMasterDao;
import com.xiyan.dao.slave.EvaluationSlaveDao;
import com.xiyan.dao.slave.OrderSlaveDao;
import com.xiyan.dao.slave.UserSlaveDao;
import com.xiyan.model.entity.Admin;
import com.xiyan.model.entity.Evaluation;
import com.xiyan.model.entity.Order;
import com.xiyan.model.entity.User;
import com.xiyan.model.exception.BizException;
import com.xiyan.model.utils.APIResponse;
import com.xiyan.model.utils.ApiTemplate;
import com.xiyan.service.EvaluationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("evaluationService")
public class EvaluationServiceImpl implements EvaluationService {
    @Resource
    private EvaluationSlaveDao evaluationSlaveDao;
    @Resource
    private EvaluationMasterDao evaluationMasterDao;
    @Resource
    private OrderSlaveDao orderSlaveDao;
    @Resource
    private UserSlaveDao userSlaveDao;

    @Override
    public APIResponse<Integer> createEvaluation(User user, int orderId, Evaluation evaluation) {
        return new ApiTemplate<Integer>() {
            Order order = orderSlaveDao.selectById(orderId);

            @Override
            protected void checkParams() throws BizException {
                Preconditions.checkNotNull(order, "不存在此订单！");
                Preconditions.checkArgument(order.getUserId() == user.getUserId(), "该订单不属于此用户！");
            }

            @Override
            protected APIResponse<Integer> process() throws BizException {
                evaluation.setOrderId(orderId);
                evaluation.setCarId(order.getCarId());
                evaluation.setUserId(user.getUserId());
                return APIResponse.returnSuccess(evaluationMasterDao.insert(evaluation));
            }
        }.execute();
    }

    @Override
    public APIResponse<List<Evaluation>> listEvaluationByCar(int carId) {
        return new ApiTemplate<List<Evaluation>>() {
            @Override
            protected void checkParams() throws BizException {
                Preconditions.checkArgument(carId > 0, "车辆Id不符合要求！");
            }

            @Override
            protected APIResponse<List<Evaluation>> process() throws BizException {
                Evaluation evaluation = new Evaluation();
                evaluation.setCarId(carId);
                return APIResponse.returnSuccess(evaluationSlaveDao.select(evaluation));
            }
        }.execute();
    }

    @Override
    public APIResponse<Evaluation> getEvaluationByOrder(User user, int orderId) {
        return new ApiTemplate<Evaluation>() {
            @Override
            protected void checkParams() throws BizException {
                Order order = orderSlaveDao.selectById(orderId);
                Preconditions.checkNotNull(order, "不存在此订单！");
                Preconditions.checkArgument(order.getUserId() == user.getUserId(), "该订单不属于此用户！");
            }

            @Override
            protected APIResponse<Evaluation> process() throws BizException {
                Evaluation evaluation = new Evaluation();
                evaluation.setOrderId(orderId);
                return APIResponse.returnSuccess(evaluationSlaveDao.select(evaluation).get(0));
            }
        }.execute();
    }

    @Override
    public APIResponse<List<Evaluation>> listEvaluationByGrade(int grade, int carId) {
        return new ApiTemplate<List<Evaluation>>() {
            @Override
            protected void checkParams() throws BizException {
                Preconditions.checkArgument(grade >= 0 && grade <= 5, "选择等级不符合要求！");
                Preconditions.checkArgument(carId > 0, "车辆Id不符合要求！");
            }

            @Override
            protected APIResponse<List<Evaluation>> process() throws BizException {
                Evaluation evaluation = new Evaluation();
                evaluation.setCarId(carId);
                evaluation.setCarCondition(grade);
                List<Evaluation> list1 = evaluationSlaveDao.select(evaluation);

                Evaluation evaluation2 = new Evaluation();
                evaluation2.setService(grade);
                evaluation2.setCarId(carId);
                List<Evaluation> list2 = evaluationSlaveDao.select(evaluation2);

                for (Evaluation e : list1) {
                    if (!list2.contains(e)) {
                        list2.add(e);
                    }
                }
                return APIResponse.returnSuccess(list2);
            }
        }.execute();
    }

    @Override
    public APIResponse<Integer> updateEvaluation(User user, Evaluation evaluation) {
        return new ApiTemplate<Integer>() {
            @Override
            protected void checkParams() throws BizException {
                Preconditions.checkArgument(evaluation.getUserId() == user.getUserId(), "该评论不是由该用户发表！");
            }

            @Override
            protected APIResponse<Integer> process() throws BizException {

                return APIResponse.returnSuccess(evaluationMasterDao.update(evaluation));
            }
        }.execute();
    }

    @Override
    public APIResponse<Integer> deleteEvaluation(Admin currentAdmin, int evaluationid) {
        return new ApiTemplate<Integer>() {
            @Override
            protected void checkParams() throws BizException {
            }

            @Override
            protected APIResponse<Integer> process() throws BizException {
                return APIResponse.returnSuccess(evaluationMasterDao.delete(evaluationid));
            }
        }.execute();
    }
}
