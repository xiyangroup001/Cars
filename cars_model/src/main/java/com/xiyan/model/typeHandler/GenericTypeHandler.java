package com.xiyan.model.typeHandler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenericTypeHandler<T extends Object, TOutput extends Object> extends BaseTypeHandler<TOutput> {

    private Class<T> entityClass;

    public GenericTypeHandler(Class<T> clazz) {
        if (clazz == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.entityClass = clazz;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, TOutput parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, this.toJson(parameter));
    }

    @Override
    public TOutput getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return this.toObject(rs.getString(columnName), entityClass);
    }

    @Override
    public TOutput getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return this.toObject(rs.getString(columnIndex), entityClass);
    }

    @Override
    public TOutput getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return this.toObject(cs.getString(columnIndex), entityClass);
    }

    private String toJson(TOutput object) {
        try {
            String result = JSON.toJSONString(object, SerializerFeature.WriteMapNullValue);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private TOutput toObject(String content, Class<?> entityClass) {
        if (content != null && StringUtils.isNotEmpty(content)) {
            try {
                if (entityClass == java.util.List.class) {
                    TOutput list = (TOutput) JSON.parseArray(content, entityClass);
                    return list;
                } else {
                    TOutput list = (TOutput) JSON.parseObject(content, entityClass);
                    return list;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            return null;
        }
    }
}
