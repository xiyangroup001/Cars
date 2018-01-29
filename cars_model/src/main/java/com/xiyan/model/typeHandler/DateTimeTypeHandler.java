package com.xiyan.model.typeHandler;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.joda.time.DateTime;

@MappedJdbcTypes(value={JdbcType.DATE},includeNullJdbcType=true)
@MappedTypes({DateTime.class})
public class DateTimeTypeHandler implements TypeHandler<DateTime> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, DateTime dateTime, JdbcType jdbcType)
            throws SQLException {
        if (dateTime != null) {
            preparedStatement.setTimestamp(i, new Timestamp(dateTime.toDateTime().getMillis()));
        } else {
            preparedStatement.setTimestamp(i, null);
        }
    }
    @Override
    public DateTime getResult(ResultSet resultSet, String s) throws SQLException {
        return toDateTime(resultSet.getTimestamp(s));
    }
    @Override
    public DateTime getResult(ResultSet resultSet, int i) throws SQLException {
        return toDateTime(resultSet.getTimestamp(i));
    }
    @Override
    public DateTime getResult(CallableStatement callableStatement, int i) throws SQLException {
        return toDateTime(callableStatement.getTimestamp(i));
    }
    private static DateTime toDateTime(Timestamp timestamp) {
        if (timestamp != null) {
            DateTime dateTime = new DateTime(timestamp);
            return dateTime;
        } else {
            return null;
        }
    }
}


