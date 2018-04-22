package com.xiyan.model.entity;

import com.xiyan.model.entity.twolevel.CarQualification;
import com.xiyan.model.entity.twolevel.CarsPictureUrl;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @antuor binwang
 * @date 2018/2/6  18:13
 */
public class Car implements Serializable {
    private int carId;    //车辆Id
    private String carLicense;   // 车牌号
    private String carBrand;    //品牌
    private Short carType;      //车辆类型
    private Double carPrice;    //车辆价位
    private int inStore;    //目前所在门店
    private Short carState;     //车辆状态
    private Double rentalPrice;     //出租价格
    private CarsPictureUrl carPicture;      //相关照片路径
    private CarQualification carQualification;        //相关资质信息
    private ArrayList<Integer> insuranceType;       //保险类型
    private Short aduitType;            //车辆审核状态
    private int aduitId;        //车辆审核号


    public static final short ADUIT_PASS = 1;

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

    public Short getCarType() {
        return carType;
    }

    public void setCarType(Short carType) {
        this.carType = carType;
    }

    public Double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(Double carPrice) {
        this.carPrice = carPrice;
    }

    public int getInStore() {
        return inStore;
    }

    public void setInStore(int inStore) {
        this.inStore = inStore;
    }

    public Short getCarState() {
        return carState;
    }

    public void setCarState(Short carState) {
        this.carState = carState;
    }

    public Double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(Double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public CarsPictureUrl getCarPicture() {
        return carPicture;
    }

    public void setCarPicture(CarsPictureUrl carPicture) {
        this.carPicture = carPicture;
    }

    public CarQualification getCarQualification() {
        return carQualification;
    }

    public void setCarQualification(CarQualification carQualification) {
        this.carQualification = carQualification;
    }

    public ArrayList<Integer> getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(ArrayList<Integer> insuranceType) {
        this.insuranceType = insuranceType;
    }

    public Short getAduitType() {
        return aduitType;
    }

    public void setAduitType(Short aduitType) {
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
        return "Car{" + "carId=" + carId + ", carLicense='" + carLicense + '\'' + ", carBrand='" + carBrand + '\'' + ", carType=" + carType + ", carPrice=" + carPrice + ", inStore=" + inStore + ", carState=" + carState + ", rentalPrice=" + rentalPrice + ", carPicture=" + carPicture + ", carQualification=" + carQualification + ", insuranceType=" + insuranceType + ", aduitType=" + aduitType + ", aduitId=" + aduitId + '}';
    }
}
