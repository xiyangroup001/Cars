package com.xiyan.model.entity;

import java.io.Serializable;

/**
 * @antuor binwang
 * @date 2018/2/6  18:29
 */
public class Admin implements Serializable {

    private String adminId;
    private String adminName;
    private short platformId;
    private String passWord;
    private int store;
    private short power;

    public static final short PLATFORM_ADMIN = 3;//平台级别的管理员
    public static final short STORE_ADMIN = 2;//门店级别的管理员
    public static final short ADMIN = 1;//普通管理员
    public static final short SUPER_ADMIN = 4;//我们的后台管理员

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public short getPlatformId() {
        return platformId;
    }

    public void setPlatformId(short platformId) {
        this.platformId = platformId;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getStore() {
        return store;
    }

    public void setStore(int store) {
        this.store = store;
    }

    public short getPower() {
        return power;
    }

    public void setPower(short power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId='" + adminId + '\'' +
                ", adminName='" + adminName + '\'' +
                ", platformId=" + platformId +
                ", passWord='" + passWord + '\'' +
                ", store=" + store +
                ", power=" + power +
                '}';
    }
}
