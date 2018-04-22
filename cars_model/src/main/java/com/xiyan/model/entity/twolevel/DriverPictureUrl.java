package com.xiyan.model.entity.twolevel;

import java.io.Serializable;

/**
 * @antuor binwang
 * @date 2018/2/6  19:58
 */
public class DriverPictureUrl implements Serializable {
    private String positiveIDPhoto;
    private String backIDPhoto;
    private String DriverLicensePhoto;

    @Override
    public String toString() {
        return "DriverPictureUrl{" +
                "positiveIDPhoto='" + positiveIDPhoto + '\'' +
                ", backIDPhoto='" + backIDPhoto + '\'' +
                ", DriverLicensePhoto='" + DriverLicensePhoto + '\'' +
                '}';
    }

    public String getPositiveIDPhoto() {
        return positiveIDPhoto;
    }

    public void setPositiveIDPhoto(String positiveIDPhoto) {
        this.positiveIDPhoto = positiveIDPhoto;
    }

    public String getBackIDPhoto() {
        return backIDPhoto;
    }

    public void setBackIDPhoto(String backIDPhoto) {
        this.backIDPhoto = backIDPhoto;
    }

    public String getDriverLicensePhoto() {
        return DriverLicensePhoto;
    }

    public void setDriverLicensePhoto(String driverLicensePhoto) {
        DriverLicensePhoto = driverLicensePhoto;
    }
}
