package com.xiyan.model.typeHandler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xiyan.model.entrty.twolevel.CarsPictureUrl;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        return JSON.toJSONString(value, SerializerFeature.WRITE_MAP_NULL_FEATURES);
    }
}
