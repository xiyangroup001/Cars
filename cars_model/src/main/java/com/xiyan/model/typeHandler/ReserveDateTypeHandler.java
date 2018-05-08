package com.xiyan.model.typeHandler;

import com.alibaba.fastjson.JSON;
import com.xiyan.model.entity.twolevel.CarQualification;
import com.xiyan.model.entity.twolevel.ReserveDate;

import java.util.List;

/**
 * @antuor binwang
 * @date 2018/2/7  11:24
 */
public class ReserveDateTypeHandler extends BasicTypeHandler<List<ReserveDate>> {
    @Override
    protected List<ReserveDate> fromString(String str) {
        List<ReserveDate> qualifications ;
        qualifications=JSON.parseArray(str,ReserveDate.class);
        return qualifications;
    }

    @Override
    protected String toString(List<ReserveDate> value) {
        return JSON.toJSONString(value);    }

}
