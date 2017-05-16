package com.xenenergy.projects.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "arm_du_lifeline_rate_master")
public class LifeLine {

    @Id
    @Column(name = "ID")
    private long id;
    @Column(name = "EFFECTIVITY_DATE")
    private Date effectivity_Date;
    @Column(name = "IS_CURRENT")
    private String is_Current;

    public LifeLine() {
    }

    public LifeLine(long id, Date effectivity_Date, String is_Current) {
        this.id = id;
        this.effectivity_Date = effectivity_Date;
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

    public String getIs_Current() {
        return is_Current;
    }

    public void setIs_Current(String is_Current) {
        this.is_Current = is_Current;
    }
}
