package com.xiyan.model.entrty;

import com.xiyan.model.entrty.twolevel.DriverPictureUrl;

import java.util.Date;

/**
 * @antuor binwang
 * @date 2018/2/6  20:10
 */
public class Driver {


    private String driverName;
    private String IdNumber;
    private int userId;
    private Date expirateDate;
    private String fileNumber;
    private DriverPictureUrl driverPicUrl;
    private short aduitType;
    private int aduitId;

    @Override
    public String toString() {
        return "Driver{" +
                "driverName='" + driverName + '\'' +
                ", IdNumber='" + IdNumber + '\'' +
                ", userId=" + userId +
                ", expirateDate=" + expirateDate +
                ", fileNumber='" + fileNumber + '\'' +
                ", driverPicUrl=" + driverPicUrl +
                ", aduitType=" + aduitType +
                ", aduitId=" + aduitId +
                '}';
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getIdNumber() {
        return IdNumber;
    }

    public void setIdNumber(String idNumber) {
        IdNumber = idNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getExpirateDate() {
        return expirateDate;
    }

    public void setExpirateDate(Date expirateDate) {
        this.expirateDate = expirateDate;
    }

    public String getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(String fileNumber) {
        this.fileNumber = fileNumber;
    }

    public DriverPictureUrl getDriverPicUrl() {
        return driverPicUrl;
    }

    public void setDriverPicUrl(DriverPictureUrl driverPicUrl) {
        this.driverPicUrl = driverPicUrl;
    }

    public short getAduitType() {
        return aduitType;
    }

    public void setAduitType(short aduitType) {
        this.aduitType = aduitType;
    }

    public int getAduitId() {
        return aduitId;
    }

    public void setAduitId(int aduitId) {
        this.aduitId = aduitId;
    }
}
