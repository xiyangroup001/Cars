package com.xiyan.model.entity;

import com.xiyan.model.entity.twolevel.DriverPictureUrl;

import java.io.Serializable;
import java.util.Date;

/**
 * @antuor binwang
 * @date 2018/2/6  20:10
 */
public class Driver implements Serializable {
    private String driverName;
    private String idNumber;
    private int userId;
    private Date expirationDate;
    private String fileNumber;
    private DriverPictureUrl driverPic;
    private short aduitType;
    private int aduitId;

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(String fileNumber) {
        this.fileNumber = fileNumber;
    }

    public DriverPictureUrl getDriverPic() {
        return driverPic;
    }

    public void setDriverPic(DriverPictureUrl driverPic) {
        this.driverPic = driverPic;
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

    @Override
    public String toString() {
        return "Driver{" + "driverName='" + driverName + '\'' + ", idNumber='" + idNumber + '\'' + ", userId=" + userId + ", expirationDate=" + expirationDate + ", fileNumber='" + fileNumber + '\'' + ", driverPic=" + driverPic + ", aduitType=" + aduitType + ", aduitId=" + aduitId + '}';
    }
}
