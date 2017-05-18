package com.xenenergy.projects.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by xenuser on 5/18/2017.
 */
@Entity
@Table(name = "arm_per_kw_charge_master")
public class PerKwChargeMaster {

    @Id
    @Column(name = "ID")
    private long id;
    @Column(name = "ID_RATE_MASTER")
    private long idRateMaster;
    @Column(name = "EFFECTIVITY_DATE")
    private Date effectivityDate;
    @Column(name = "TOTAL_AMOUNT")
    private double totalAmount;
    @Column(name = "TOTAL_AMOUNT_STL")
    private double totalAmountStl;
    @Column(name = "IS_CURRENT")
    private String isCurrent;
    @Column(name = "IS_LOCKED")
    private String isLocked;

    public PerKwChargeMaster() {
    }

    public PerKwChargeMaster(long id, long idRateMaster, Date effectivityDate, double totalAmount, double totalAmountStl, String isCurrent, String isLocked) {
        this.id = id;
        this.idRateMaster = idRateMaster;
        this.effectivityDate = effectivityDate;
        this.totalAmount = totalAmount;
        this.totalAmountStl = totalAmountStl;
        this.isCurrent = isCurrent;
        this.isLocked = isLocked;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdRateMaster() {
        return idRateMaster;
    }

    public void setIdRateMaster(long idRateMaster) {
        this.idRateMaster = idRateMaster;
    }

    public Date getEffectivityDate() {
        return effectivityDate;
    }

    public void setEffectivityDate(Date effectivityDate) {
        this.effectivityDate = effectivityDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getTotalAmountStl() {
        return totalAmountStl;
    }

    public void setTotalAmountStl(double totalAmountStl) {
        this.totalAmountStl = totalAmountStl;
    }

    public String getIsCurrent() {
        return isCurrent;
    }

    public void setIsCurrent(String isCurrent) {
        this.isCurrent = isCurrent;
    }

    public String getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(String isLocked) {
        this.isLocked = isLocked;
    }
}
