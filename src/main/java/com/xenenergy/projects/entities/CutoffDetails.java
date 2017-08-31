package com.xenenergy.projects.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by xesi on 29/08/2017.
 */
@Entity
@Table(name = "arm_cut_off_detail")
public class CutoffDetails {
    @Id
    @Column(name = "ID")
    private long id;
    @Column(name = "TS")
    private Date ts;
    @Column(name = "ID_CUT_OFF_MASTER")
    private long idCutOffMaster;
    @Column(name = "START_DATE")
    private String startDate;
    @Column(name = "END_DATE")
    private String endDate;

    public CutoffDetails() {
    }

    public CutoffDetails(long id, Date ts, long idCutOffMaster, String startDate, String endDate) {
        this.id = id;
        this.ts = ts;
        this.idCutOffMaster = idCutOffMaster;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    public long getIdCutOffMaster() {
        return idCutOffMaster;
    }

    public void setIdCutOffMaster(long idCutOffMaster) {
        this.idCutOffMaster = idCutOffMaster;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
