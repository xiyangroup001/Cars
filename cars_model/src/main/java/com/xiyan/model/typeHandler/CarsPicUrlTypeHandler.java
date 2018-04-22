package com.xiyan.model.typeHandler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xiyan.model.entity.twolevel.CarsPictureUrl;

/**
 * @antuor binwang
 * @date 2018/2/6  20:18
 */
public class CarsPicUrlTypeHandler extends BasicTypeHandler<CarsPictureUrl> {

    @Override
    protected CarsPictureUrl fromString(String str) {
        CarsPictureUrl carsPictureUrl = new CarsPictureUrl();
        carsPictureUrl = (CarsPictureUrl) JSON.parseObject(str, CarsPictureUrl.class);
        return carsPictureUrl;
    }

    @Override
    protected String toString(CarsPictureUrl value) {
        return JSON.toJSONString(value, SerializerFeature.WriteMapNullValue);
    }
}
