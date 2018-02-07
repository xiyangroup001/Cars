package com.xiyan.model.typeHandler;

import com.alibaba.fastjson.JSON;
import com.xiyan.model.entrty.twolevel.CarQualifications;

/**
 * @antuor binwang
 * @date 2018/2/7  11:24
 */
public class CarQualTypeHandler extends BasicTypeHandler<CarQualifications> {
    @Override
    protected CarQualifications fromString(String str) {
        CarQualifications qualifications = new CarQualifications();
        qualifications=(CarQualifications)JSON.parseObject(str,CarQualifications.class);
        return qualifications;
    }

    @Override
    protected String toString(CarQualifications value) {
        return JSON.toJSONString(value);
    }
}
