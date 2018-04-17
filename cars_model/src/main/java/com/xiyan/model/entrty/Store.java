package com.xiyan.model.entrty;

import com.xiyan.model.entrty.twolevel.Position;

import java.io.Serializable;

/**
 * @antuor binwang
 * @date 2018/2/5  18:06
 */
public class Store implements Serializable {

    private int storeId;
    private String storeName;
    private short platform;
    private Position location;

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public short getPlatform() {
        return platform;
    }

    public void setPlatform(short platform) {
        this.platform = platform;
    }

    public Position getLocation() {
        return location;
    }

    public void setLocation(Position location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Store{" +
                "storeId=" + storeId +
                ", storeName='" + storeName + '\'' +
                ", platform=" + platform +
                ", location=" + location +
                '}';
    }
}
