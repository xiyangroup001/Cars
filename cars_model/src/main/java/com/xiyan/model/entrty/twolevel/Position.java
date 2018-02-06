package com.xiyan.model.entrty.twolevel;

import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.Serializable;

/**
 * @antuor binwang
 * @date 2018/2/5  18:01
 */
public class Position implements Serializable {
    //经度
    private Double longitude;
    //纬度
    private Double latitude;

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "Position{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
