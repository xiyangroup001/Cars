package com.xiyan.model.typeHandler;

import com.alibaba.fastjson.JSON;
import com.xiyan.model.entity.twolevel.DriverPictureUrl;

/**
 * @antuor binwang
 * @date 2018/2/8  11:47
 */
public class DriverPicTypeHandler extends BasicTypeHandler<DriverPictureUrl> {
    @Override
    protected DriverPictureUrl fromString(String str) {
        return (DriverPictureUrl) JSON.parseObject(str,DriverPictureUrl.class);
    }

    @Override
    protected String toString(DriverPictureUrl value) {
        return JSON.toJSONString(value);
    }
}
