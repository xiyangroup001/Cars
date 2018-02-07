package com.xiyan.model.entrty;

/**
 * @antuor binwang
 * @date 2018/2/6  18:26
 */
public class Check {
    private String checkUserId;
    private String checkTime;
    private short checkType;
    private String checkResult;

    public String getCheckUserId() {
        return checkUserId;
    }

    public void setCheckUserId(String checkUserId) {
        this.checkUserId = checkUserId;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public short getCheckType() {
        return checkType;
    }

    public void setCheckType(short checkType) {
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
                "checkUserId='" + checkUserId + '\'' +
                ", checkTime='" + checkTime + '\'' +
                ", checkType='" + checkType + '\'' +
                ", checkResult='" + checkResult + '\'' +
                '}';
    }
}
