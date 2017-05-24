package com.xenenergy.projects.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "arm_account")
public class Account {

    @Id
    @Column(name = "ID")
    private long id;
    @Column(name = "SEQUENCE_NO")
    private int seqNo;
    @Column(name = "ROUTE_CODE")
    private String routeCode;
    @Column(name = "ACCOUNT_NAME")
    private String accountName;
    @Column(name = "CURRENT_METER_NO")
    private String meterNo;
    @Column(name = "OLD_ACCOUNT_NO")
    private String accountNo;
    @Column(name = "CURRENT_READING")
    private int curRdg;

    public Account() {
    }

    public Account(long id, int seqNo, String routeCode, String accountName, String meterNo, String accountNo, int curRdg) {
        this.id = id;
        this.seqNo = seqNo;
        this.routeCode = routeCode;
        this.accountName = accountName;
        this.meterNo = meterNo;
        this.accountNo = accountNo;
        this.curRdg = curRdg;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(int seqNo) {
        this.seqNo = seqNo;
    }

    public String getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
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

    public int getCurRdg() {
        return curRdg;
    }

    public void setCurRdg(int curRdg) {
        this.curRdg = curRdg;
    }
}
