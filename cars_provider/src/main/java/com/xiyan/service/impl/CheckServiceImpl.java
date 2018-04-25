package com.xiyan.service.impl;

import com.google.common.base.Preconditions;
import com.xiyan.dao.master.CarMasterDao;
import com.xiyan.dao.master.CheckMasterDao;
import com.xiyan.dao.slave.CarSlaveDao;
import com.xiyan.model.entity.Car;
import com.xiyan.model.entity.Check;
import com.xiyan.model.exception.BizException;
import com.xiyan.model.utils.APIResponse;
import com.xiyan.model.utils.ApiTemplate;
import com.xiyan.service.CarService;
import com.xiyan.service.CheckService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("checkService")
public class CheckServiceImpl implements CheckService {
    @Resource
    CheckMasterDao checkMasterDao;
    @Resource
    CheckService checkService;


    public APIResponse<List<Car>> selectCarByCondition(int getStore, int[] carType, String[] carBrand, int lowPrice, int highPrice, int lowRentalPrice, int highRentalPrice) {
        return new ApiTemplate<List<Car>>() {
            @Override
            protected void checkParams() throws BizException {
                Preconditions.checkArgument(getStore > 0, "门店错误！");
                Preconditions.checkArgument(carType.length > 0, "车辆类型错误！");
                Preconditions.checkArgument(carBrand.length > 0, "车辆品牌错误！");
                Preconditions.checkArgument(lowPrice < highPrice, "车辆价位错误！");
                Preconditions.checkArgument(lowRentalPrice < highRentalPrice, "车辆租价错误！");

            }

            @Override
            protected APIResponse<List<Car>> process() throws BizException {
//                List<Car> cars = carSlaveDao.selectCarByCondition(getStore, carType, carBrand, lowPrice * 10000, highPrice * 10000, lowRentalPrice, highRentalPrice);
//                return APIResponse.returnSuccess(cars);
                return null;
            }
        }.execute();
    }


    @Override
    public APIResponse<Integer> deleteCheck(Integer checkId) {
        return null;
    }

    @Override
    public APIResponse<Integer> insertCheck(Check check) {
        return null;
    }

    @Override
    public APIResponse<List<Check>> listAllCheck() {
        return null;
    }

    @Override
    public APIResponse<Integer> updateCheck(Check check) {
        return null;
    }
}
