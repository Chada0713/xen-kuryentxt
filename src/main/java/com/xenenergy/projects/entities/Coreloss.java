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
@Table(name = "arm_coreloss_tran")
public class Coreloss {

    @Id
    @Column(name = "ID")
    private long id;
    @Column(name = "SERVICE_PERIOD_END")
    private Date service_Period_End;
    @Column(name = "ACCOUNT_NO")
    private String account_No;
    @Column(name = "CORELOSSKWH")
    private int corelossKwh;
    @Column(name = "CORELOSSLIMITKWH")
    private long corelossLimitKwh;

    public Coreloss() {
    }

    public Coreloss(long id, Date service_Period_End, String account_No, int corelossKwh, long corelossLimitKwh) {
        this.id = id;
        this.service_Period_End = service_Period_End;
        this.account_No = account_No;
        this.corelossKwh = corelossKwh;
        this.corelossLimitKwh = corelossLimitKwh;
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

    public int getCorelossKwh() {
        return corelossKwh;
    }

    public void setCorelossKwh(int corelossKwh) {
        this.corelossKwh = corelossKwh;
    }

    public long getCorelossLimitKwh() {
        return corelossLimitKwh;
    }

    public void setCorelossLimitKwh(long corelossLimitKwh) {
        this.corelossLimitKwh = corelossLimitKwh;
    }
}
