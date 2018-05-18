package com.xiyan.model.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.xiyan.model.entity.twolevel.Position;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @antuor binwang
 * @date 2018/2/5  17:55
 */
public class Order implements Serializable {
        private int orderId;
        private int userId;
        private int carId;
        @JSONField(format = "yyyy-MM-dd HH:mm:SS")
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:SS")
        private Date orderGenerationTime;

        @JSONField(format = "yyyy-MM-dd")
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private Date startTime;

        @DateTimeFormat(pattern = "yyyy-MM-dd")
        @JSONField(format = "yyyy-MM-dd")
        private Date endTime;
        private int takeCarShop;
        private int returnCarShop;
        private double prepayAmount;
        private double totalAmount;
        private short payType;
        private Position position;

        public static final short UNPAID_DEPOSIT = 1;//未支付定金
        public static final short UNPAID_RENT = 2;//支付定金，未支付全部金额
        public static final short PAID_RENT = 3;//支付全部
        public static final short REFUNDED_DEPOSIT = 4;//已退还押金，即完成


    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", userId=" + userId +
                ", carId=" + carId +
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

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
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
}
