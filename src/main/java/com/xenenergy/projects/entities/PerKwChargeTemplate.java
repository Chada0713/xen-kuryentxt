package com.xenenergy.projects.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by xesi on 23/06/2017.
 */
@Entity
@Table(name = "arm_du_per_kw_charge_template")
public class PerKwChargeTemplate {

    @Id
    @Column(name = "ID")
    private long id;
    @Column(name = "TS")
    private Date ts;
    @Column(name = "CHARGE_TYPE")
    private String chargeType;
    @Column(name = "PER_KW_RATE_NAME")
    private String perKwRateName;
    @Column(name = "PER_KW_RATE_LONG_NAME")
    private String perKwRateLongName;
    @Column(name = "PRINT_ORDER")
    private int printOrder;
    @Column(name = "FIXED_ADDTL")
    private Double fixedAddtl = 0.0000;
    @Column(name = "TOTAL_AMOUNT")
    private String totalAmount;
    @Column(name = "IS_SUB_TO_LIFELINE")
    private String isSubToLifeline;

    public PerKwChargeTemplate() {
    }

    public PerKwChargeTemplate(long id, Date ts, String chargeType, String perKwRateName, String perKwRateLongName, int printOrder, Double fixedAddtl, String totalAmount, String isSubToLifeline) {
        this.id = id;
        this.ts = ts;
        this.chargeType = chargeType;
        this.perKwRateName = perKwRateName;
        this.perKwRateLongName = perKwRateLongName;
        this.printOrder = printOrder;
        this.fixedAddtl = fixedAddtl;
        this.totalAmount = totalAmount;
        this.isSubToLifeline = isSubToLifeline;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    public String getPerKwRateName() {
        return perKwRateName;
    }

    public void setPerKwRateName(String perKwRateName) {
        this.perKwRateName = perKwRateName;
    }

    public String getPerKwRateLongName() {
        return perKwRateLongName;
    }

    public void setPerKwRateLongName(String perKwRateLongName) {
        this.perKwRateLongName = perKwRateLongName;
    }

    public int getPrintOrder() {
        return printOrder;
    }

    public void setPrintOrder(int printOrder) {
        this.printOrder = printOrder;
    }

    public Double getFixedAddtl() {
        return fixedAddtl;
    }

    public void setFixedAddtl(Double fixedAddtl) {
        this.fixedAddtl = fixedAddtl;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getIsSubToLifeline() {
        return isSubToLifeline;
    }

    public void setIsSubToLifeline(String isSubToLifeline) {
        this.isSubToLifeline = isSubToLifeline;
    }

}
