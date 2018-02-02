package com.xiyan.model.typeHandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.joda.time.DateTime;

import java.sql.*;

/**
 * @antuor binwang
 * @date 2018/1/24  17:21
 */

public class JodaTimeTypeHandler extends BaseTypeHandler<DateTime> {
    public void setNonNullParameter(PreparedStatement ps, int i, DateTime parameter, JdbcType jdbcType) throws SQLException {
        System.out.println(1);

        ps.setDate(i, new Date(parameter.getMillis()));
    }

    public DateTime getNullableResult(ResultSet rs, String columnName) throws SQLException {
        System.out.println(2);
        return new DateTime(2000,12,11,12,30,30);
    }

    public DateTime getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        System.out.println(3);
        return new DateTime();

    }

    public DateTime getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        System.out.println(4);

        return new DateTime(cs.getDate(columnIndex));
    }
}
