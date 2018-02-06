package com.xiyan.model.entrty;

import com.xiyan.model.entrty.twolevel.CarQualifications;
import com.xiyan.model.entrty.twolevel.CarsPictureUrl;

import java.util.ArrayList;

/**
 * @antuor binwang
 * @date 2018/2/6  18:13
 */
public class Car {
    /*
  `car_id` bigint(20) NOT NULL DEFAULT '0'  COMMENT '车辆Id',
  `car_license` VARCHAR(10) NOT NULL COMMENT '车牌号',
  `car_brand` VARCHAR(16) NOT NULL DEFAULT '0'  COMMENT '品牌',
  `car_type` TINYINT NOT NULL DEFAULT '0' COMMENT '车辆类型',
  `car_price` DECIMAL(5,2) NOT NULL DEFAULT '0.0' COMMENT '车辆价位',
  `in_store` bigint(20) NOT NULL DEFAULT '0' COMMENT '目前所在门店',
  `car_state` TINYINT NOT NULL DEFAULT '0' COMMENT '车辆状态',
  `rental_price` DECIMAL(5,2) NOT NULL DEFAULT '0' COMMENT '出租价格',
  `car_picture` VARCHAR(300) NOT NULL DEFAULT '' COMMENT '相关照片路径',
  `car_qualification` DECIMAL(5,2) NOT NULL DEFAULT '0.00' COMMENT '相关资质信息',
  `insurance_type` VARCHAR(40) NOT NULL DEFAULT '' COMMENT '保险类型',
  `aduit_type` TINYINT NOT NULL DEFAULT '0' COMMENT '车辆审核状态',
  `aduit_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '车辆审核号',
  PRIMARY KEY (`car_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='车辆表';*/
    private int carId;    //车辆Id
    private String carLicense;   // 车牌号
    private String carBrand;    //品牌
    private short carType;      //车辆类型
    private double carPrice;    //车辆价位
    private int inStore;    //目前所在门店
    private short carState;     //车辆状态
    private double rentalPrice;     //出租价格
    private CarsPictureUrl carpicture;      //相关照片路径
    private CarQualifications carQualifications;        //相关资质信息
    private ArrayList<Integer> insuranceType;       //保险类型
    private short aduitType;            //车辆审核状态
    private int aduitId;        //车辆审核号


    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarLicense() {
        return carLicense;
    }

    public void setCarLicense(String carLicense) {
        this.carLicense = carLicense;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public short getCarType() {
        return carType;
    }

    public void setCarType(short carType) {
        this.carType = carType;
    }

    public double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(double carPrice) {
        this.carPrice = carPrice;
    }

    public int getInStore() {
        return inStore;
    }

    public void setInStore(int inStore) {
        this.inStore = inStore;
    }

    public short getCarState() {
        return carState;
    }

    public void setCarState(short carState) {
        this.carState = carState;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public CarsPictureUrl getCarpicture() {
        return carpicture;
    }

    public void setCarpicture(CarsPictureUrl carpicture) {
        this.carpicture = carpicture;
    }

    public CarQualifications getCarQualifications() {
        return carQualifications;
    }

    public void setCarQualifications(CarQualifications carQualifications) {
        this.carQualifications = carQualifications;
    }

    public ArrayList<Integer> getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(ArrayList<Integer> insuranceType) {
        this.insuranceType = insuranceType;
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
        return "Car{" +
                "carId=" + carId +
                ", carLicense='" + carLicense + '\'' +
                ", carBrand='" + carBrand + '\'' +
                ", carType=" + carType +
                ", carPrice=" + carPrice +
                ", inStore=" + inStore +
                ", carState=" + carState +
                ", rentalPrice=" + rentalPrice +
                ", carpicture=" + carpicture +
                ", carQualifications=" + carQualifications +
                ", insuranceType=" + insuranceType +
                ", aduitType=" + aduitType +
                ", aduitId=" + aduitId +
                '}';
    }
}
