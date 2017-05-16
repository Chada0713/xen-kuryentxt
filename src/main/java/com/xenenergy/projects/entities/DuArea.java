package com.xenenergy.projects.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "arm_du_area")
public class DuArea {

    @Id
    @Column(name = "ID")
    private long id;

    @Column(name = "AREA_CODE")
    private String areaCode;

    @Column(name = "AREA_NAME")
    private String areaName;

    public DuArea() {
    }

    public DuArea(long id, String areaCode, String areaName) {
        this.id = id;
        this.areaCode = areaCode;
        this.areaName = areaName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
}
