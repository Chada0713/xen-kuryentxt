package com.xenenergy.projects.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by xesi on 18/05/2017.
 */
@Entity
@Table(name = "arm_fix_charge_master")
public class FixedChargeMaster {

    @Id
    @Column(name = "ID")
    private long id;
    @Column(name = "ID_RATE_MASTER")
    private long idRateMaster;
    @Column(name = "EFFECTIVITY_DATE")
    private Date effectivityDate;
    @Column(name = "TOTAL_AMOUNT")
    private Double totalAmount = 0.0000;
    @Column(name = "IS_CURRENT")
    private String isCurrent = "N";
    @Column(name = "IS_LOCKED")
    private String isLocked = "N";

    public FixedChargeMaster() {
    }

    public FixedChargeMaster(Long id, Long idRateMaster, Date effectivityDate, Double totalAmount, String isCurrent, String isLocked) {
        this.id = id;
        this.idRateMaster = idRateMaster;
        this.effectivityDate = effectivityDate;
        this.totalAmount = totalAmount;
        this.isCurrent = isCurrent;
        this.isLocked = isLocked;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdRateMaster() {
        return idRateMaster;
    }

    public void setIdRateMaster(Long idRateMaster) {
        this.idRateMaster = idRateMaster;
    }

    public Date getEffectivityDate() {
        return effectivityDate;
    }

    public void setEffectivityDate(Date effectivityDate) {
        this.effectivityDate = effectivityDate;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
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
