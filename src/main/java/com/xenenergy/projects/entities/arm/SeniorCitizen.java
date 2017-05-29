package com.xenenergy.projects.entities.arm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "arm_sc_discount_rate")
public class SeniorCitizen {

    @Id
    @Column(name = "ID")
    private long id;
    @Column(name = "EFFECTIVITY_DATE")
    private Date effectivity_Date;
    @Column(name = "RATE")
    private Double rate;
    @Column(name = "KW_LIMIT")
    private int kw_Limit;
    @Column(name = "IS_CURRENT")
    private String is_Current;

    public SeniorCitizen() {
    }

    public SeniorCitizen(long id, Date effectivity_Date, Double rate, int kw_Limit, String is_Current) {
        this.id = id;
        this.effectivity_Date = effectivity_Date;
        this.rate = rate;
        this.kw_Limit = kw_Limit;
        this.is_Current = is_Current;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getEffectivity_Date() {
        return effectivity_Date;
    }

    public void setEffectivity_Date(Date effectivity_Date) {
        this.effectivity_Date = effectivity_Date;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public int getKw_Limit() {
        return kw_Limit;
    }

    public void setKw_Limit(int kw_Limit) {
        this.kw_Limit = kw_Limit;
    }

    public String getIs_Current() {
        return is_Current;
    }

    public void setIs_Current(String is_Current) {
        this.is_Current = is_Current;
    }
}
