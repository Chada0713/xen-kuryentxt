package com.xenenergy.projects.entities.arm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "arm_cut_off_master")
public class CutoffMaster {

    @Id
    @Column(name = "ID")
    private long id;

    @Column(name = "CUT_OFF_NAME")
    private String cutoffName;

    @Column(name = "CUT_OFF_DAY")
    private int cutoffDay;

    public CutoffMaster() {
    }

    public CutoffMaster(long id, String cutoffName, int cutoffDay) {
        this.id = id;
        this.cutoffName = cutoffName;
        this.cutoffDay = cutoffDay;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCutoffName() {
        return cutoffName;
    }

    public void setCutoffName(String cutoffName) {
        this.cutoffName = cutoffName;
    }

    public int getCutoffDay() {
        return cutoffDay;
    }

    public void setCutoffDay(int cutoffDay) {
        this.cutoffDay = cutoffDay;
    }
}
