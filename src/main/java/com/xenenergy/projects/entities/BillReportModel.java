package com.xenenergy.projects.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xesi on 08/06/2017.
 */
public class BillReportModel {

    private List<ChargeGroupDetails> chargeGroupDetailsList;
    List<String> test = new ArrayList<>();

    public List<String> getTest() {
        return test;
    }

    public void setTest(List<String> test) {
        this.test = test;
    }

    private String duCode;
    private String duName;
    private String addrLn1;
    private String addrLn2;
    private String contactPerson;
    private String contactNumber;

    private String oldAcctNo;
    private String accountName;
    private String addressLn1;
    private String addressLn2;

    private String consumerType;
    private String periodFrom;
    private String periodTo;
    private String dueDate;
    private String meterNo;
    private String currentReading;
    private String previousReading;
    private String consumption;
    private String multiplier;
    private String totalOfMultiplierCon;
    private String coreloss;
    private String addOnKwhTotal;
    private String totalConsumption;

    private String disconnectionDate;

    public String getDuCode() {
        return duCode;
    }

    public void setDuCode(String duCode) {
        this.duCode = duCode;
    }

    public String getDuName() {
        return duName;
    }

    public void setDuName(String duName) {
        this.duName = duName;
    }

    public String getAddrLn1() {
        return addrLn1;
    }

    public void setAddrLn1(String addrLn1) {
        this.addrLn1 = addrLn1;
    }

    public String getAddrLn2() {
        return addrLn2;
    }

    public void setAddrLn2(String addrLn2) {
        this.addrLn2 = addrLn2;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getOldAcctNo() {
        return oldAcctNo;
    }

    public void setOldAcctNo(String oldAcctNo) {
        this.oldAcctNo = oldAcctNo;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAddressLn1() {
        return addressLn1;
    }

    public void setAddressLn1(String addressLn1) {
        this.addressLn1 = addressLn1;
    }

    public String getAddressLn2() {
        return addressLn2;
    }

    public void setAddressLn2(String addressLn2) {
        this.addressLn2 = addressLn2;
    }

    public String getConsumerType() {
        return consumerType;
    }

    public void setConsumerType(String consumerType) {
        this.consumerType = consumerType;
    }

    public String getPeriodFrom() {
        return periodFrom;
    }

    public void setPeriodFrom(String periodFrom) {
        this.periodFrom = periodFrom;
    }

    public String getPeriodTo() {
        return periodTo;
    }

    public void setPeriodTo(String periodTo) {
        this.periodTo = periodTo;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getMeterNo() {
        return meterNo;
    }

    public void setMeterNo(String meterNo) {
        this.meterNo = meterNo;
    }

    public String getCurrentReading() {
        return currentReading;
    }

    public void setCurrentReading(String currentReading) {
        this.currentReading = currentReading;
    }

    public String getPreviousReading() {
        return previousReading;
    }

    public void setPreviousReading(String previousReading) {
        this.previousReading = previousReading;
    }

    public String getConsumption() {
        return consumption;
    }

    public void setConsumption(String consumption) {
        this.consumption = consumption;
    }

    public String getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(String multiplier) {
        this.multiplier = multiplier;
    }

    public String getTotalOfMultiplierCon() {
        return totalOfMultiplierCon;
    }

    public void setTotalOfMultiplierCon(String totalOfMultiplierCon) {
        this.totalOfMultiplierCon = totalOfMultiplierCon;
    }

    public String getCoreloss() {
        return coreloss;
    }

    public void setCoreloss(String coreloss) {
        this.coreloss = coreloss;
    }

    public String getAddOnKwhTotal() {
        return addOnKwhTotal;
    }

    public void setAddOnKwhTotal(String addOnKwhTotal) {
        this.addOnKwhTotal = addOnKwhTotal;
    }

    public String getTotalConsumption() {
        return totalConsumption;
    }

    public void setTotalConsumption(String totalConsumption) {
        this.totalConsumption = totalConsumption;
    }

    public String getDisconnectionDate() {
        return disconnectionDate;
    }

    public void setDisconnectionDate(String disconnectionDate) {
        this.disconnectionDate = disconnectionDate;
    }

    public List<ChargeGroupDetails> getChargeGroupDetailsList() {
        return chargeGroupDetailsList;
    }

    public void setChargeGroupDetailsList(List<ChargeGroupDetails> chargeGroupDetailsList) {
        this.chargeGroupDetailsList = chargeGroupDetailsList;
    }
}
