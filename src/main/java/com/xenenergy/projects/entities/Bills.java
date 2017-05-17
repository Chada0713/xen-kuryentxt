package com.xenenergy.projects.entities;

import org.springframework.stereotype.Controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by xesi on 17/05/2017.
 */
@Entity
@Table(name = "arm_bill_header")
public class Bills {

    @Id
    @Column(name = "ID") private long id;
    @Column(name = "RUN_DATE") private String runDate;
    @Column(name = "BILL_NO") private String billNo;
    @Column(name = "OLD_ACCT_NO") private String oldAcctNo;
    @Column(name = "ID_ROUTE") private long idRoute;
    @Column(name = "ROUTE_CODE") private String routeCode;
    @Column(name = "SEQUENCE_NO") private int sequentNo;
    @Column(name = "ACCOUNT_NAME") private String accountName;
    @Column(name = "METER_NO") private String meterNo;
    @Column(name = "ACCOUNT_NO") private String accountNo;
    @Column(name = "CONSUMER_TYPE") private String consumerType;
    @Column(name = "CURRENT_READING") private int currentReading;
    @Column(name = "PREVIOUS_READING") private int previousReading;
    @Column(name = "CONSUMPTION") private int consumption;
    @Column(name = "MULTIPLIER") private int multiplier;
    @Column(name = "CORELOSS") private int coreloss;
    @Column(name = "ADD_ON_KWH_TOTAL") private int addOnKwhTotal;
    @Column(name = "TOTAL_CONSUMPTION") private int totalConsumption;
    @Column(name = "PERIOD_FROM") private Date periodFrom;
    @Column(name = "PERIOD_TO") private Date periodTo;
    @Column(name = "BILLING_MO") private String billingMo;
    @Column(name = "CURRENT_BILL") private Double currentBill;
    @Column(name = "TOTAL_AMOUNT_DUE") private Double totalAmountDue;
    @Column(name = "READER") private String reader;
    @Column(name = "DEVICE_ID") private long deviceId;
    @Column(name = "DUE_DATE") private Date dueDate;
    @Column(name = "REMARKS") private String remarks;
    @Column(name = "IS_UPLOADED") private String isUploaded;

    public Bills() {
    }

    public Bills(long id, String runDate, String billNo, String oldAcctNo, long idRoute, String routeCode, int sequentNo, String accountName, String meterNo, String accountNo, String consumerType, int currentReading, int previousReading, int consumption, int multiplier, int coreloss, int addOnKwhTotal, int totalConsumption, Date periodFrom, Date periodTo, String billingMo, Double currentBill, Double totalAmountDue, String reader, long deviceId, Date dueDate, String remarks, String isUploaded) {
        this.id = id;
        this.runDate = runDate;
        this.billNo = billNo;
        this.oldAcctNo = oldAcctNo;
        this.idRoute = idRoute;
        this.routeCode = routeCode;
        this.sequentNo = sequentNo;
        this.accountName = accountName;
        this.meterNo = meterNo;
        this.accountNo = accountNo;
        this.consumerType = consumerType;
        this.currentReading = currentReading;
        this.previousReading = previousReading;
        this.consumption = consumption;
        this.multiplier = multiplier;
        this.coreloss = coreloss;
        this.addOnKwhTotal = addOnKwhTotal;
        this.totalConsumption = totalConsumption;
        this.periodFrom = periodFrom;
        this.periodTo = periodTo;
        this.billingMo = billingMo;
        this.currentBill = currentBill;
        this.totalAmountDue = totalAmountDue;
        this.reader = reader;
        this.deviceId = deviceId;
        this.dueDate = dueDate;
        this.remarks = remarks;
        this.isUploaded = isUploaded;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRunDate() {
        return runDate;
    }

    public void setRunDate(String runDate) {
        this.runDate = runDate;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getOldAcctNo() {
        return oldAcctNo;
    }

    public void setOldAcctNo(String oldAcctNo) {
        this.oldAcctNo = oldAcctNo;
    }

    public long getIdRoute() {
        return idRoute;
    }

    public void setIdRoute(long idRoute) {
        this.idRoute = idRoute;
    }

    public String getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    public int getSequentNo() {
        return sequentNo;
    }

    public void setSequentNo(int sequentNo) {
        this.sequentNo = sequentNo;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getMeterNo() {
        return meterNo;
    }

    public void setMeterNo(String meterNo) {
        this.meterNo = meterNo;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getConsumerType() {
        return consumerType;
    }

    public void setConsumerType(String consumerType) {
        this.consumerType = consumerType;
    }

    public int getCurrentReading() {
        return currentReading;
    }

    public void setCurrentReading(int currentReading) {
        this.currentReading = currentReading;
    }

    public int getPreviousReading() {
        return previousReading;
    }

    public void setPreviousReading(int previousReading) {
        this.previousReading = previousReading;
    }

    public int getConsumption() {
        return consumption;
    }

    public void setConsumption(int consumption) {
        this.consumption = consumption;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }

    public int getCoreloss() {
        return coreloss;
    }

    public void setCoreloss(int coreloss) {
        this.coreloss = coreloss;
    }

    public int getAddOnKwhTotal() {
        return addOnKwhTotal;
    }

    public void setAddOnKwhTotal(int addOnKwhTotal) {
        this.addOnKwhTotal = addOnKwhTotal;
    }

    public int getTotalConsumption() {
        return totalConsumption;
    }

    public void setTotalConsumption(int totalConsumption) {
        this.totalConsumption = totalConsumption;
    }

    public Date getPeriodFrom() {
        return periodFrom;
    }

    public void setPeriodFrom(Date periodFrom) {
        this.periodFrom = periodFrom;
    }

    public Date getPeriodTo() {
        return periodTo;
    }

    public void setPeriodTo(Date periodTo) {
        this.periodTo = periodTo;
    }

    public String getBillingMo() {
        return billingMo;
    }

    public void setBillingMo(String billingMo) {
        this.billingMo = billingMo;
    }

    public Double getCurrentBill() {
        return currentBill;
    }

    public void setCurrentBill(Double currentBill) {
        this.currentBill = currentBill;
    }

    public Double getTotalAmountDue() {
        return totalAmountDue;
    }

    public void setTotalAmountDue(Double totalAmountDue) {
        this.totalAmountDue = totalAmountDue;
    }

    public String getReader() {
        return reader;
    }

    public void setReader(String reader) {
        this.reader = reader;
    }

    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getIsUploaded() {
        return isUploaded;
    }

    public void setIsUploaded(String isUploaded) {
        this.isUploaded = isUploaded;
    }
}
