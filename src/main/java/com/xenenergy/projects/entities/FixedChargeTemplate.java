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
@Table(name = "arm_du_fix_charge_template")
public class FixedChargeTemplate {
    @Id
    @Column(name = "ID")
    private long id;
    @Column(name = "TS")
    private Date ts;
    @Column(name = "FIX_CHARGE_NAME")
    private String fixChargeName;
    @Column(name = "FIX_CHARGE_LONG_NAME")
    private String fixChargeLongName;
    @Column(name = "PRINT_ORDER")
    private int printOrder = 0;
    @Column(name = "AMOUNT")
    private double amount = 0.0000;
    @Column(name = "VAT_RATE")
    private double vatRate = 0.00;
    @Column(name = "VAT_AMT")
    private double vatAmt = 0.0000;
    @Column(name = "TOTAL_AMOUNT")
    private double totalAmount = 0.0000;
    @Column(name = "IS_SUB_TO_VAT")
    private String isSubToVat;

    public FixedChargeTemplate() {
    }

    public FixedChargeTemplate(long id, Date ts, String fixChargeName, String fixChargeLongName, int printOrder, double amount, double vatRate, double vatAmt, double totalAmount, String isSubToVat) {
        this.id = id;
        this.ts = ts;
        this.fixChargeName = fixChargeName;
        this.fixChargeLongName = fixChargeLongName;
        this.printOrder = printOrder;
        this.amount = amount;
        this.vatRate = vatRate;
        this.vatAmt = vatAmt;
        this.totalAmount = totalAmount;
        this.isSubToVat = isSubToVat;
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

    public String getFixChargeName() {
        return fixChargeName;
    }

    public void setFixChargeName(String fixChargeName) {
        this.fixChargeName = fixChargeName;
    }

    public String getFixChargeLongName() {
        return fixChargeLongName;
    }

    public void setFixChargeLongName(String fixChargeLongName) {
        this.fixChargeLongName = fixChargeLongName;
    }

    public int getPrintOrder() {
        return printOrder;
    }

    public void setPrintOrder(int printOrder) {
        this.printOrder = printOrder;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getVatRate() {
        return vatRate;
    }

    public void setVatRate(double vatRate) {
        this.vatRate = vatRate;
    }

    public double getVatAmt() {
        return vatAmt;
    }

    public void setVatAmt(double vatAmt) {
        this.vatAmt = vatAmt;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getIsSubToVat() {
        return isSubToVat;
    }

    public void setIsSubToVat(String isSubToVat) {
        this.isSubToVat = isSubToVat;
    }
}
