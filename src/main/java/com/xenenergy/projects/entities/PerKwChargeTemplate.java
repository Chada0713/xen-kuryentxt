package com.xenenergy.projects.entities;

import org.springframework.format.annotation.NumberFormat;

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
    @NumberFormat(style = NumberFormat.Style.NUMBER, pattern = "#0.0000")
    private Double fixedAddtl = 0.0000;
    @Column(name = "ATL")
    @NumberFormat(style = NumberFormat.Style.NUMBER, pattern = "#0.0000")
    private double adjToLifeline = 0.0000;
    @Column(name = "ATS")
    @NumberFormat(style = NumberFormat.Style.NUMBER, pattern = "#0.0000")
    private double adjToSc = 0.0000;
    @Column(name = "TOTAL_AMOUNT")
    @NumberFormat(style = NumberFormat.Style.NUMBER, pattern = "#0.0000")
    private String totalAmount;
    @Column(name = "IS_SUB_TO_LIFELINE")
    private String isSubToLifeline;

    public PerKwChargeTemplate() {
    }

    public PerKwChargeTemplate(long id, Date ts, String chargeType, String perKwRateName, String perKwRateLongName, int printOrder, Double fixedAddtl, double adjToLifeline, double adjToSc, String totalAmount, String isSubToLifeline) {
        this.id = id;
        this.ts = ts;
        this.chargeType = chargeType;
        this.perKwRateName = perKwRateName;
        this.perKwRateLongName = perKwRateLongName;
        this.printOrder = printOrder;
        this.fixedAddtl = fixedAddtl;
        this.adjToLifeline = adjToLifeline;
        this.adjToSc = adjToSc;
        this.totalAmount = totalAmount;
        this.isSubToLifeline = isSubToLifeline;
    }

    public double getAdjToLifeline() {
        return adjToLifeline;
    }

    public void setAdjToLifeline(double adjToLifeline) {
        this.adjToLifeline = adjToLifeline;
    }

    public double getAdjToSc() {
        return adjToSc;
    }

    public void setAdjToSc(double adjToSc) {
        this.adjToSc = adjToSc;
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

    @Override
    public String toString() {
        return "PerKwChargeTemplate{" +
                "id=" + id +
                ", ts=" + ts +
                ", chargeType='" + chargeType + '\'' +
                ", perKwRateName='" + perKwRateName + '\'' +
                ", perKwRateLongName='" + perKwRateLongName + '\'' +
                ", printOrder=" + printOrder +
                ", fixedAddtl=" + fixedAddtl +
                ", adjToLifeline=" + adjToLifeline +
                ", adjToSc=" + adjToSc +
                ", totalAmount='" + totalAmount + '\'' +
                ", isSubToLifeline='" + isSubToLifeline + '\'' +
                '}';
    }
}
