package com.xenenergy.projects.entities;

/**
 * Created by xenuser on 5/8/2017.
 */
public class BillingStatementModel {
    private String duName;
    private String addressLine1;
    private String addressLine2;
    private String contactNo;
    private String contactPerson;
    private int billsCount;
    private String description;
    private String totalBill;
    private String curDate;

    public String getCurDate() {
        return curDate;
    }

    public void setCurDate(String curDate) {
        this.curDate = curDate;
    }

    public String getDuName() {
        return duName;
    }

    public void setDuName(String duName) {
        this.duName = duName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public int getBillsCount() {
        return billsCount;
    }

    public void setBillsCount(int billsCount) {
        this.billsCount = billsCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(String totalBill) {
        this.totalBill = totalBill;
    }
}
