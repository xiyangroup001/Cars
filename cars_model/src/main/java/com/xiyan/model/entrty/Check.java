package com.xiyan.model.entrty;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * @antuor binwang
 * @date 2018/2/6  18:26
 */
public class Check implements Serializable {

    private int checkId;
    private String checkUser;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date checkTime;

    private Short checkType;
    private String checkResult;

    public int getCheckId() {
        return checkId;
    }

    public void setCheckId(int checkId) {
        this.checkId = checkId;
    }

    public String getCheckUser() {
        return checkUser;
    }

    public void setCheckUser(String checkUser) {
        this.checkUser = checkUser;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public Short getCheckType() {
        return checkType;
    }

    public void setCheckType(Short checkType) {
        this.checkType = checkType;
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }

    @Override
    public String toString() {
        return "Check{" +
                "checkId=" + checkId +
                ", checkUserId='" + checkUser + '\'' +
                ", checkTime='" + checkTime + '\'' +
                ", checkType=" + checkType +
                ", checkResult='" + checkResult + '\'' +
                '}';
    }
}
