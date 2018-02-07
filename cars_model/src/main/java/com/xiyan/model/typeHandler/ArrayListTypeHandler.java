package com.xiyan.model.typeHandler;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;

/**
 * @antuor binwang
 * @date 2018/2/7  11:36
 */
public class ArrayListTypeHandler extends BasicTypeHandler<ArrayList> {
    @Override
    protected ArrayList fromString(String str) {
        return (ArrayList)JSON.parseObject(str,ArrayList.class);
    }

    @Override
    protected String toString(ArrayList value) {
        return JSON.toJSONString(value);
    }
}
