package com.xenenergy.projects.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by xesi on 16/05/2017.
 */
@Entity
@Table(name = "arm_rate_add_on_tran")
public class AddOnCharge {

    @Id
    @Column(name = "ID")
    private long id;
    @Column(name = "SERVICE_PERIOD_END")
    private Date service_Period_End;
    @Column(name = "ACCOUNT_NO")
    private String account_No;
    @Column(name = "CHARGE_NAME")
    private String charge_Name;
    @Column(name = "AMOUNT")
    private Double amount;

    public AddOnCharge() {
    }

    public AddOnCharge(long id, Date service_Period_End, String account_No, String charge_Name, Double amount) {
        this.id = id;
        this.service_Period_End = service_Period_End;
        this.account_No = account_No;
        this.charge_Name = charge_Name;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getService_Period_End() {
        return service_Period_End;
    }

    public void setService_Period_End(Date service_Period_End) {
        this.service_Period_End = service_Period_End;
    }

    public String getAccount_No() {
        return account_No;
    }

    public void setAccount_No(String account_No) {
        this.account_No = account_No;
    }

    public String getCharge_Name() {
        return charge_Name;
    }

    public void setCharge_Name(String charge_Name) {
        this.charge_Name = charge_Name;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
