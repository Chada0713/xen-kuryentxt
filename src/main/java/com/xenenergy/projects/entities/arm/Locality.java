package com.xenenergy.projects.entities.arm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by xenuser on 5/15/2017.
 */
@Entity
@Table(name = "arm_du_locality")
public class Locality {

    @Id
    @Column(name = "ID")
    private long id;

    @Column(name = "ID_AREA")
    private long idArea;

    @Column(name = "LOCALITY_CODE")
    private String localityCode;

    @Column(name = "LOCALITY")
    private String sLocality;

    public String getsLocality() {
        return sLocality;
    }

    public void setsLocality(String sLocality) {
        this.sLocality = sLocality;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdArea() {
        return idArea;
    }

    public void setIdArea(long idArea) {
        this.idArea = idArea;
    }

    public String getLocalityCode() {
        return localityCode;
    }

    public void setLocalityCode(String localityCode) {
        this.localityCode = localityCode;
    }


}
