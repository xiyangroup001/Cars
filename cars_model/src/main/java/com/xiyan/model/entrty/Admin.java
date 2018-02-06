package com.xiyan.model.entrty;

/**
 * @antuor binwang
 * @date 2018/2/6  18:29
 */
public class Admin {
    /*`admin_id` VARCHAR(18) NOT NULL DEFAULT ' ' COMMENT '帐号',
  `admin_name` VARCHAR(10) NOT NULL DEFAULT ' '  COMMENT '姓名',
  `platform_id` TINYINT NOT NULL DEFAULT '0' COMMENT '所属平台',
  `power` TINYINT NOT NULL DEFAULT '0' COMMENT '权限',
  `password` VARCHAR(18) NOT NULL DEFAULT ' ' COMMENT '密码',
  `store` bigint(20) NOT NULL DEFAULT '0' COMMENT '所属门店',
  PRIMARY KEY (`admin_id`)*/

    private String adminId;
    private String adminName;
    private short platformId;
    private String passWord;
    private int store;
    private short power;

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
