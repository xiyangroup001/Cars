package com.xiyan.model.typeHandler;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @antuor binwang
 * @date 2018/2/5  19:54
 */
public abstract class BasicTypeHandler<T> implements TypeHandler<T> {
    @Override
    public void setParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, transToString(parameter));
    }

    @Override
    public T getResult(ResultSet rs, String columnName) throws SQLException {
        return parseFromString(rs.getString(columnName));
    }

    @Override
    public T getResult(ResultSet rs, int columnIndex) throws SQLException {
        return parseFromString(rs.getString(columnIndex));
    }

    @Override
    public T getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return parseFromString(cs.getString(columnIndex));
    }

    private T parseFromString(String value) {
        if(StringUtils.isBlank(value)){
            return null;
        }
        return fromString(value);
    }

    private String transToString(T value) {
        if(value == null){
            return null;
        }
        return toString(value);
    }


    protected abstract T fromString(String str);
    protected abstract String toString(T value);
}

