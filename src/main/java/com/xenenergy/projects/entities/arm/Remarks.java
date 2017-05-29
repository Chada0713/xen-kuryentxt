package com.xenenergy.projects.entities.arm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by xenuser on 5/11/2017.
 */
@Entity
@Table(name = "arm_du_remarks")
public class Remarks {

    @Id
    @Column(name = "ID")
    private long id;

    @Column(name = "REMARKS")
    private String sRemarks;

    public Remarks() {
    }

    public Remarks(long id, String sRemarks) {
        this.id = id;
        this.sRemarks = sRemarks;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getsRemarks() {
        return sRemarks;
    }

    public void setsRemarks(String sRemarks) {
        this.sRemarks = sRemarks;
    }
}
