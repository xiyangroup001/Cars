package com.xiyan.model.typeHandler;

import com.alibaba.fastjson.JSON;
import com.xiyan.model.entity.twolevel.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @antuor binwang
 * @date 2018/2/5  19:53
 */
public class PositionTypeHandler extends BasicTypeHandler<Position> {
    private Logger logger = LoggerFactory.getLogger(PositionTypeHandler.class);

    @Override
    protected Position fromString(String str) {
        Position position = new Position();
        try {
            position = (Position)JSON.parseObject(str, Position.class);

            return position;
        } catch (Exception ex) {
            logger.error("解析位置类出错,str = {},error msg = {}", str, ex.getMessage(), ex);
            return position;
        }
    }

    @Override
    protected String toString(Position value) {
        System.out.println(JSON.toJSONString(value));
        return JSON.toJSONString(value);
    }
}
