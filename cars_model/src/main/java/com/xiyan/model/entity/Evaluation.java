package com.xiyan.model.entity;

import java.io.Serializable;
import java.util.List;

public class Evaluation implements Serializable {

    private int evaluationId;
    private int userId;
    private int carId;
    private int OrderId;
    private int carCondition;
    private int service;
    private String message;
    private List<String> pics;

    public int getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(int evaluationId) {
        this.evaluationId = evaluationId;
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

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int orderId) {
        OrderId = orderId;
    }

    public int getCarCondition() {
        return carCondition;
    }

    public void setCarCondition(int carCondition) {
        this.carCondition = carCondition;
    }

    public int getService() {
        return service;
    }

    public void setService(int service) {
        this.service = service;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getPics() {
        return pics;
    }

    public void setPics(List<String> pics) {
        this.pics = pics;
    }

    @Override
    public String toString() {
        return "Evaluation{" + "evaluationId=" + evaluationId + ", userId=" + userId + ", carId=" + carId + ", OrderId=" + OrderId + ", carCondition=" + carCondition + ", service=" + service + ", message='" + message + '\'' + ", pics=" + pics + '}';
    }
}
