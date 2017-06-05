package com.xenenergy.projects.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by xesi on 02/06/2017.
 */
@Entity
@Table(name = "arm_bill_charge_detail")
public class BillChargeDetail {

    @Id
    @Column(name = "ID")
    private long id;
    @Column(name = "BILL_NO")
    private String billNo;
    @Column(name = "PRINT_ORDER_MASTER")
    private int printOrderMaster;
    @Column(name = "PRINT_ORDER")
    private int printOrder;
    @Column(name = "CHARGE_NAME")
    private String chargeName;
    @Column(name = "CHARGE_LONG_NAME")
    private String chargeLongName;
    @Column(name = "CHARGE_AMOUNT")
    private double chargeAmount;
    @Column(name = "CHARGE_TOTAL")
    private double chargeTotal;
    @Column(name = "IS_UPLOADED")
    private String isUploaded;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public int getPrintOrderMaster() {
        return printOrderMaster;
    }

    public void setPrintOrderMaster(int printOrderMaster) {
        this.printOrderMaster = printOrderMaster;
    }

    public int getPrintOrder() {
        return printOrder;
    }

    public void setPrintOrder(int printOrder) {
        this.printOrder = printOrder;
    }

    public String getChargeName() {
        return chargeName;
    }

    public void setChargeName(String chargeName) {
        this.chargeName = chargeName;
    }

    public String getChargeLongName() {
        return chargeLongName;
    }

    public void setChargeLongName(String chargeLongName) {
        this.chargeLongName = chargeLongName;
    }

    public double getChargeAmount() {
        return chargeAmount;
    }

    public void setChargeAmount(double chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    public double getChargeTotal() {
        return chargeTotal;
    }

    public void setChargeTotal(double chargeTotal) {
        this.chargeTotal = chargeTotal;
    }

    public String getIsUploaded() {
        return isUploaded;
    }

    public void setIsUploaded(String isUploaded) {
        this.isUploaded = isUploaded;
    }
}
