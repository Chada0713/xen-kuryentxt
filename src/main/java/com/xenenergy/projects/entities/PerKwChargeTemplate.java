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
    @Column(name = "AMOUNT")
    private String amount;
    @Column(name = "VAT_RATE")
    private Double vatRate = 0.00;
    @Column(name = "VAT_AMT")
    private String vatAmt; /*Double*/
    @Column(name = "FIXED_ADDTL")
    private Double fixedAddtl = 0.0000;
    @Column(name = "TOTAL_AMOUNT")
    private String totalAmount;
    @Column(name = "IS_SUB_TO_VAT")
    private String isSubToVat;
    @Column(name = "IS_SUB_TO_LIFELINE")
    private String isSubToLifeline;
    @Column(name = "IS_SUB_TO_SC_DISCOUNT")
    private String isSubToScDiscount;

    public PerKwChargeTemplate() {
    }

    public PerKwChargeTemplate(long id, Date ts, String chargeType, String perKwRateName, String perKwRateLongName, int printOrder, String amount, Double vatRate, String vatAmt, Double fixedAddtl, String totalAmount, String isSubToVat, String isSubToLifeline, String isSubToScDiscount) {
        this.id = id;
        this.ts = ts;
        this.chargeType = chargeType;
        this.perKwRateName = perKwRateName;
        this.perKwRateLongName = perKwRateLongName;
        this.printOrder = printOrder;
        this.amount = amount;
        this.vatRate = vatRate;
        this.vatAmt = vatAmt;
        this.fixedAddtl = fixedAddtl;
        this.totalAmount = totalAmount;
        this.isSubToVat = isSubToVat;
        this.isSubToLifeline = isSubToLifeline;
        this.isSubToScDiscount = isSubToScDiscount;
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Double getVatRate() {
        return vatRate;
    }

    public void setVatRate(Double vatRate) {
        this.vatRate = vatRate;
    }

    public String getVatAmt() {
        return vatAmt;
    }

    public void setVatAmt(String vatAmt) {
        this.vatAmt = vatAmt;
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

    public String getIsSubToVat() {
        return isSubToVat;
    }

    public void setIsSubToVat(String isSubToVat) {
        this.isSubToVat = isSubToVat;
    }

    public String getIsSubToLifeline() {
        return isSubToLifeline;
    }

    public void setIsSubToLifeline(String isSubToLifeline) {
        this.isSubToLifeline = isSubToLifeline;
    }

    public String getIsSubToScDiscount() {
        return isSubToScDiscount;
    }

    public void setIsSubToScDiscount(String isSubToScDiscount) {
        this.isSubToScDiscount = isSubToScDiscount;
    }
}
