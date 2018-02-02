package com.xiyan.model.exception;

import java.io.Serializable;

/**
 * @antuor binwang
 * @date 2018/2/2  13:12
 */
public class ErrorCode implements Serializable {

    private static final long serialVersionUID = -6239192959362321352L;

    public ErrorCode() {

    }

    public ErrorCode(int code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public ErrorCode(int code, String message, Object... param) {
        super();
        this.code = code;
        this.message = String.format(message, param);
        this.param = param;
    }

    private int code;
    private String message;
    private Object[] param;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object[] getParam() {
        return param;
    }

    public void setParam(Object[] param) {
        this.param = param;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ErrorCode [code=");
        builder.append(code);
        builder.append(", message=");
        builder.append(message);
        builder.append("]");
        return builder.toString();
    }

}

