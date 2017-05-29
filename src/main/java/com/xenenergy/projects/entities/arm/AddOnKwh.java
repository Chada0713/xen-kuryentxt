package com.xenenergy.projects.entities.arm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by xesi on 16/05/2017.
 */
@Entity
@Table(name = "arm_kwh_add_on_tran")
public class AddOnKwh {

    @Id
    @Column(name = "ID")
    private long id;
    @Column(name = "SERVICE_PERIOD_END")
    private Date service_Period_End;
    @Column(name = "ACCOUNT_NO")
    private String account_No;
    @Column(name = "ADD_ON_KWH_NAME")
    private String add_On_Kwh_Name;
    @Column(name = "KWH")
    private int kwh;

    public AddOnKwh() {
    }

    public AddOnKwh(long id, Date service_Period_End, String account_No, String add_On_Kwh_Name, int kwh) {
        this.id = id;
        this.service_Period_End = service_Period_End;
        this.account_No = account_No;
        this.add_On_Kwh_Name = add_On_Kwh_Name;
        this.kwh = kwh;
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

    public String getAdd_On_Kwh_Name() {
        return add_On_Kwh_Name;
    }

    public void setAdd_On_Kwh_Name(String add_On_Kwh_Name) {
        this.add_On_Kwh_Name = add_On_Kwh_Name;
    }

    public int getKwh() {
        return kwh;
    }

    public void setKwh(int kwh) {
        this.kwh = kwh;
    }
}
