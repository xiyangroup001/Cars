package com.xiyan.model.entrty;

/**
 * @antuor binwang
 * @date 2018/2/6  18:24
 */
public class Platform {
    private short platformId;
    private String platformName;

    public short getPlatformId() {
        return platformId;
    }

    public void setPlatformId(short platformId) {
        this.platformId = platformId;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    @Override
    public String toString() {
        return "Platform{" +
                "platformId=" + platformId +
                ", platformName='" + platformName + '\'' +
                '}';
    }
}