package com.xiyan.model.entrty;

import com.alibaba.fastjson.annotation.JSONField;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @antuor binwang
 * @date 2018/1/24  15:33
 */
public class User implements Serializable {
    private String userName;
    private int userId;
    private String userGuid;
    private String userPhone;
    private String userPassword;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Timestamp registrateTime;

    private short userType;
    private String headPicUrl;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserGuid() {
        return userGuid;
    }

    public void setUserGuid(String userGuid) {
        this.userGuid = userGuid;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Timestamp getRegistrateTime() {
        return registrateTime;
    }

    public void setRegistrateTime(String registrateTime) {
        this.registrateTime = Timestamp.valueOf(registrateTime);
    }
    //public void setRegistrateTime(Timestamp registrateTime) {
    //    this.registrateTime = registrateTime;
    //}
    public short getUserType() {
        return userType;
    }

    public void setUserType(short userType) {
        this.userType = userType;
    }

    public String getHeadPicUrl() {
        return headPicUrl;
    }

    public void setHeadPicUrl(String headPicUrl) {
        this.headPicUrl = headPicUrl;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userId=" + userId +
                ", userGuid='" + userGuid + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", registrateTime=" + registrateTime +
                ", userType=" + userType +
                ", headPicUrl='" + headPicUrl + '\'' +
                '}';
    }
}
