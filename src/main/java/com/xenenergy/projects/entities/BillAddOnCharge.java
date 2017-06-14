package com.xenenergy.projects.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by xesi on 13/06/2017.
 */
@Entity
@Table(name = "arm_bill_add_on_charge")
public class BillAddOnCharge {

    @Id
    @Column(name = "ID")
    private long id;
    @Column(name = "TS")
    private Date ts;
    @Column(name = "BILL_NO")
    private String billNo;
    @Column(name = "ADD_ON_CHARGE")
    private String addOnCharge;
    @Column(name = "VALUE_CHARGE")
    private double valueCharge;
    @Column(name = "IS_UPLOADED")
    private String isUploaded;

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

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getAddOnCharge() {
        return addOnCharge;
    }

    public void setAddOnCharge(String addOnCharge) {
        this.addOnCharge = addOnCharge;
    }

    public double getValueCharge() {
        return valueCharge;
    }

    public void setValueCharge(double valueCharge) {
        this.valueCharge = valueCharge;
    }

    public String getIsUploaded() {
        return isUploaded;
    }

    public void setIsUploaded(String isUploaded) {
        this.isUploaded = isUploaded;
    }
}
