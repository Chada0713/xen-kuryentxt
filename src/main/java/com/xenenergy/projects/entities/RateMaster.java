package com.xenenergy.projects.entities;

import javax.persistence.*;

@Entity
@Table(name = "arm_rate_master")
public class RateMaster {

    @Id
    @Column(name = "ID")
    private long id;
    @Column(name = "RATE_NAME")
    private String rateName;
    @Column(name = "TOTAL_FIXED_CHARGE")
    private Double totalFixedCharge = 0.0000;
    @Column(name = "TOTAL_PER_KW_CHARGE")
    private Double totalPerKwCharge = 0.0000;
    @Column(name = "TOTAL_PER_KW_CHARGE_STL")
    private Double totalPerKwChargeStl = 0.0000;
    @Column(name = "IS_STL")
    private String isStl;

    public RateMaster() {
    }

    public RateMaster(long id, String rateName, Double totalFixedCharge, Double totalPerKwCharge, Double totalPerKwChargeStl, String isStl) {
        this.id = id;
        this.rateName = rateName;
        this.totalFixedCharge = totalFixedCharge;
        this.totalPerKwCharge = totalPerKwCharge;
        this.totalPerKwChargeStl = totalPerKwChargeStl;
        this.isStl = isStl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRateName() {
        return rateName;
    }

    public void setRateName(String rateName) {
        this.rateName = rateName;
    }

    public Double getTotalFixedCharge() {
        return totalFixedCharge;
    }

    public void setTotalFixedCharge(Double totalFixedCharge) {
        this.totalFixedCharge = totalFixedCharge;
    }

    public Double getTotalPerKwCharge() {
        return totalPerKwCharge;
    }

    public void setTotalPerKwCharge(Double totalPerKwCharge) {
        this.totalPerKwCharge = totalPerKwCharge;
    }

    public Double getTotalPerKwChargeStl() {
        return totalPerKwChargeStl;
    }

    public void setTotalPerKwChargeStl(Double totalPerKwChargeStl) {
        this.totalPerKwChargeStl = totalPerKwChargeStl;
    }

    public String getIsStl() {
        return isStl;
    }

    public void setIsStl(String isStl) {
        this.isStl = isStl;
    }
}
