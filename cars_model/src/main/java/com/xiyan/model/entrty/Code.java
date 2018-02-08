package com.xiyan.model.entrty;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Code {
    private String userPhone;
    private String codeVal;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField( format = "yyyy-MM-dd HH:mm:ss")
    private Date sendTime;

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getCodeVal() {
        return codeVal;
    }

    public void setCodeVal(String codeVal) {
        this.codeVal = codeVal;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    @Override
    public String toString() {
        return "Code{" +
                "userPhone='" + userPhone + '\'' +
                ", codeVal='" + codeVal + '\'' +
                ", sendTime='" + sendTime + '\'' +
                '}';
    }
}
