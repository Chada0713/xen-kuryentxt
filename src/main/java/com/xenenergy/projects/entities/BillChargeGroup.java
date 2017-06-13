package com.xenenergy.projects.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by xesi on 02/06/2017.
 */
@Entity
@Table(name = "arm_bill_charge_group")
public class BillChargeGroup {

    @Id
    @Column(name = "ID")
    private long id;
    @Column(name = "BILL_NO")
    private String billNo;
    @Column(name = "PRINT_ORDER")
    private int printOrder;
    @Column(name = "CHARGE_GROUP_NAME")
    private String chargeGroupName;
    @Column(name = "CHARGE_SUM")
    private double chargeSum;
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

    public String getBillno() {
        return billNo;
    }

    public void setBillno(String billNo) {
        this.billNo = billNo;
    }

    public int getPrintOrder() {
        return printOrder;
    }

    public void setPrintOrder(int printOrder) {
        this.printOrder = printOrder;
    }

    public String getChargeGroupName() {
        return chargeGroupName;
    }

    public void setChargeGroupName(String chargeGroupName) {
        this.chargeGroupName = chargeGroupName;
    }

    public double getChargeSum() {
        return chargeSum;
    }

    public void setChargeSum(double chargeSum) {
        this.chargeSum = chargeSum;
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
