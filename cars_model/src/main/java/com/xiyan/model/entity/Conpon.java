package com.xiyan.model.entity;

import java.io.Serializable;
import java.util.Date;

public class Conpon implements Serializable {

    private int couponId;
    private int userId;
    private Date expiredTime;
    private Double satisfy;
    private Double minus;

    public int getCouponId() {
        return couponId;
    }

    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Date expiredTime) {
        this.expiredTime = expiredTime;
    }

    public Double getSatisfy() {
        return satisfy;
    }

    public void setSatisfy(Double satisfy) {
        this.satisfy = satisfy;
    }

    public Double getMinus() {
        return minus;
    }

    public void setMinus(Double minus) {
        this.minus = minus;
    }

    @Override
    public String toString() {
        return "Conpon{" + "couponId=" + couponId + ", userId=" + userId + ", expiredTime=" + expiredTime + ", satisfy=" + satisfy + ", minus=" + minus + '}';
    }
}
