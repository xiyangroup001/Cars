package com.xiyan.model.entity.twolevel;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @antuor binwang
 * @date 2018/2/6  17:55
 */
public class CarsPictureUrl implements Serializable {
    /*正面照片*/
    private String frontPicUrl;

    /*后面照片*/
    private String rearPicUrl;

    /*侧面照片*/
    private String sidePicUrl;

    /*内部前排照片*/
    private String insideFrontPicUrl;

    /*后排照片*/
    private String insideRearPicUrl;

    /*标志照片*/
    private String signPicUrl;

    /*行驶证照片*/
    private String licensePicUrl;

    /*强险照片*/
    private String insrPicUrl;

    /*商业险照片*/
    private String comcInsrPicUrl;

    /*其他照片*/
    private ArrayList<String> otherPicUrl;

    public String getFrontPicUrl() {
        return frontPicUrl;
    }

    public void setFrontPicUrl(String frontPicUrl) {
        this.frontPicUrl = frontPicUrl;
    }

    public String getRearPicUrl() {
        return rearPicUrl;
    }

    public void setRearPicUrl(String rearPicUrl) {
        this.rearPicUrl = rearPicUrl;
    }

    public String getSidePicUrl() {
        return sidePicUrl;
    }

    public void setSidePicUrl(String sidePicUrl) {
        this.sidePicUrl = sidePicUrl;
    }

    public String getInsideFrontPicUrl() {
        return insideFrontPicUrl;
    }

    public void setInsideFrontPicUrl(String insideFrontPicUrl) {
        this.insideFrontPicUrl = insideFrontPicUrl;
    }

    public String getInsideRearPicUrl() {
        return insideRearPicUrl;
    }

    public void setInsideRearPicUrl(String insideRearPicUrl) {
        this.insideRearPicUrl = insideRearPicUrl;
    }

    public String getSignPicUrl() {
        return signPicUrl;
    }

    public void setSignPicUrl(String signPicUrl) {
        this.signPicUrl = signPicUrl;
    }

    public String getLicensePicUrl() {
        return licensePicUrl;
    }

    public void setLicensePicUrl(String licensePicUrl) {
        this.licensePicUrl = licensePicUrl;
    }

    public String getInsrPicUrl() {
        return insrPicUrl;
    }

    public void setInsrPicUrl(String insrPicUrl) {
        this.insrPicUrl = insrPicUrl;
    }

    public String getComcInsrPicUrl() {
        return comcInsrPicUrl;
    }

    public void setComcInsrPicUrl(String comcInsrPicUrl) {
        this.comcInsrPicUrl = comcInsrPicUrl;
    }

    public ArrayList<String> getOtherPicUrl() {
        return otherPicUrl;
    }

    public void setOtherPicUrl(ArrayList<String> otherPicUrl) {
        this.otherPicUrl = otherPicUrl;
    }

    @Override
    public String toString() {
        return "CarsPictureUrl{" +
                "frontPicUrl='" + frontPicUrl + '\'' +
                ", rearPicUrl='" + rearPicUrl + '\'' +
                ", sidePicUrl='" + sidePicUrl + '\'' +
                ", insideFrontPicUrl='" + insideFrontPicUrl + '\'' +
                ", insideRearPicUrl='" + insideRearPicUrl + '\'' +
                ", signPicUrl='" + signPicUrl + '\'' +
                ", licensePicUrl='" + licensePicUrl + '\'' +
                ", insrPicUrl='" + insrPicUrl + '\'' +
                ", comcInsrPicUrl='" + comcInsrPicUrl + '\'' +
                ", otherPicUrl=" + otherPicUrl +
                '}';
    }
}
