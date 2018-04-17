package com.xiyan.model.typeHandler;

import com.alibaba.fastjson.JSON;
import com.xiyan.model.entrty.twolevel.CarQualification;

/**
 * @antuor binwang
 * @date 2018/2/7  11:24
 */
public class CarQualTypeHandler extends BasicTypeHandler<CarQualification> {
    @Override
    protected CarQualification fromString(String str) {
        CarQualification qualifications = new CarQualification();
        qualifications=(CarQualification)JSON.parseObject(str,CarQualification.class);
        return qualifications;
    }

    @Override
    protected String toString(CarQualification value) {
        return JSON.toJSONString(value);
    }
}
