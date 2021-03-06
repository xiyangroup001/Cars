package com.xiyan.model.entity;

import com.xiyan.model.entity.twolevel.CarQualification;
import com.xiyan.model.entity.twolevel.CarsPictureUrl;
import com.xiyan.model.entity.twolevel.ReserveDate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    private List<ReserveDate> reserveDateList;


    public static final short SYATE_INSTORE = 1;//车辆状态。在门店
    public static final short SYATE_BOOKED = 2;//车辆状态。已被预订，添加预订信息后已经不用该属性
    public static final short SYATE_RENTEND_OUT = 3;//车辆状态。在出租中
    public static final short SYATE_REPAIR = 4;//车辆状态。维修
    public static final short SYATE_OUTOFDATE = 5;//超出日期

    public static final short ADUIT_PASS = 1;//审核状态，通过
    public static final short NOT_ADUIT = 2;//审核状态，未审核
    public static final short ADUIT_ERROR = 3;//审核状态，未通过

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

    public List<ReserveDate> getReserveDateList() {
        return reserveDateList;
    }

    public void setReserveDateList(List<ReserveDate> reserveDateList) {
        this.reserveDateList = reserveDateList;
    }

    @Override
    public String toString() {
        return "Car{" + "carId=" + carId + ", carLicense='" + carLicense + '\'' + ", carBrand='" + carBrand + '\'' + ", carType=" + carType + ", carPrice=" + carPrice + ", inStore=" + inStore + ", carState=" + carState + ", rentalPrice=" + rentalPrice + ", carPicture=" + carPicture + ", carQualification=" + carQualification + ", insuranceType=" + insuranceType + ", aduitType=" + aduitType + ", aduitId=" + aduitId + ", reserveDateList=" + reserveDateList + '}';
    }
}
