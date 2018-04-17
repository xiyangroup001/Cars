package com.xiyan.model.entrty.twolevel;

import java.util.Date;

/**
 * @antuor binwang
 * @date 2018/2/6  17:24
 */
public class CarQualification {
    /*所有人*/
    private String owner;

    /*住址*/
    private String address;

    /*车辆识别代码*/
    private String vhcIdtfId;

    /*发动机编号*/
    private String engineId;

    /*行驶证到期日*/
    private Date drLicExDate;

    /*强险编号*/
    private String insuranceId;

    /*强险到期日期*/
    private Date insrExDate;

    /*商业险编号*/
    private String comcInsrId;

    /*商业险到期日期*/
    private Date comcInsrExDate;

    /*年检到期日期*/
    private Date AnnaInspcDate;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getVhcIdtfId() {
        return vhcIdtfId;
    }

    public void setVhcIdtfId(String vhcIdtfId) {
        this.vhcIdtfId = vhcIdtfId;
    }

    public String getEngineId() {
        return engineId;
    }

    public void setEngineId(String engineId) {
        this.engineId = engineId;
    }

    public Date getDrLicExDate() {
        return drLicExDate;
    }

    public void setDrLicExDate(Date drLicExDate) {
        this.drLicExDate = drLicExDate;
    }

    public String getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(String insuranceId) {
        this.insuranceId = insuranceId;
    }

    public Date getInsrExDate() {
        return insrExDate;
    }

    public void setInsrExDate(Date insrExDate) {
        this.insrExDate = insrExDate;
    }

    public String getComcInsrId() {
        return comcInsrId;
    }

    public void setComcInsrId(String comcInsrId) {
        this.comcInsrId = comcInsrId;
    }

    public Date getComcInsrExDate() {
        return comcInsrExDate;
    }

    public void setComcInsrExDate(Date comcInsrExDate) {
        this.comcInsrExDate = comcInsrExDate;
    }

    public Date getAnnaInspcDate() {
        return AnnaInspcDate;
    }

    public void setAnnaInspcDate(Date annaInspcDate) {
        AnnaInspcDate = annaInspcDate;
    }

    @Override
    public String toString() {
        return "CarQualifications{" +
                "owner='" + owner + '\'' +
                ", address='" + address + '\'' +
                ", vhcIdtfId='" + vhcIdtfId + '\'' +
                ", engineId='" + engineId + '\'' +
                ", drLicExDate=" + drLicExDate +
                ", insuranceId='" + insuranceId + '\'' +
                ", insrExDate=" + insrExDate +
                ", comcInsrId='" + comcInsrId + '\'' +
                ", comcInsrExDate=" + comcInsrExDate +
                ", AnnaInspcDate=" + AnnaInspcDate +
                '}';
    }
}
