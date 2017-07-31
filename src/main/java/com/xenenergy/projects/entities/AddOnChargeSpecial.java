package com.xenenergy.projects.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by xesi on 27/07/2017.
 */
@Entity
@Table(name = "arm_rate_add_on_tran_special")
public class AddOnChargeSpecial {
    @Id
    @Column(name = "ID")
    private long id;
    @Column(name = "SERVICE_PERIOD_END")
    private Date servicePeriodEnd;
    @Column(name = "ACCOUNT_NO")
    private String accountNo;
    @Column(name = "CHARGE_NAME")
    private String chargeName;
    @Column(name = "AMOUNT")
    private String amount;

    public AddOnChargeSpecial() {
    }

    public AddOnChargeSpecial(long id, Date servicePeriodEnd, String accountNo, String chargeName, String amount) {
        this.id = id;
        this.servicePeriodEnd = servicePeriodEnd;
        this.accountNo = accountNo;
        this.chargeName = chargeName;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getServicePeriodEnd() {
        return servicePeriodEnd;
    }

    public void setServicePeriodEnd(Date servicePeriodEnd) {
        this.servicePeriodEnd = servicePeriodEnd;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getChargeName() {
        return chargeName;
    }

    public void setChargeName(String chargeName) {
        this.chargeName = chargeName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
