package com.xiyan.model.entrty;

import com.alibaba.fastjson.annotation.JSONField;
import com.xiyan.model.entrty.twolevel.Position;

import java.util.Date;

/**
 * @antuor binwang
 * @date 2018/2/5  17:55
 */
public class Order {


    private String orderId;
    private String userId;
    private String carId;

    @JSONField(format = "yyyy-MM-dd HH:mm:SS")
    private Date orderGenerationTime;

    @JSONField(format = "yyyy-MM-dd")
    private Date startTime;

    @JSONField(format = "yyyy-MM-dd")
    private Date endTime;
    private int takeCarShop;
    private int returnCarShop;
    private double prepayAmount;
    private double totalAmount;
    private short payType;
    private Position position;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public Date getOrderGenerationTime() {
        return orderGenerationTime;
    }

    public void setOrderGenerationTime(Date orderGenerationTime) {
        this.orderGenerationTime = orderGenerationTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getTakeCarShop() {
        return takeCarShop;
    }

    public void setTakeCarShop(int takeCarShop) {
        this.takeCarShop = takeCarShop;
    }

    public int getReturnCarShop() {
        return returnCarShop;
    }

    public void setReturnCarShop(int returnCarShop) {
        this.returnCarShop = returnCarShop;
    }

    public double getPrepayAmount() {
        return prepayAmount;
    }

    public void setPrepayAmount(double prepayAmount) {
        this.prepayAmount = prepayAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public short getPayType() {
        return payType;
    }

    public void setPayType(short payType) {
        this.payType = payType;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", userId='" + userId + '\'' +
                ", carId='" + carId + '\'' +
                ", orderGenerationTime=" + orderGenerationTime +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", takeCarShop=" + takeCarShop +
                ", returnCarShop=" + returnCarShop +
                ", prepayAmount=" + prepayAmount +
                ", totalAmount=" + totalAmount +
                ", payType=" + payType +
                ", position=" + position +
                '}';
    }
}
