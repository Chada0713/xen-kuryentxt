package com.xenenergy.projects.entities;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "arm_mm_app_id")
public class ActivationCode {

    @Id
    @Column(name = "ID")
    private long id;
    @Column(name = "ID_RDM")
    private int idRdm;
    @Column(name = "ACTIVATION_CODE")
    private String activationCode;
    @Column(name = "ASSIGNED_TO")
    private String assignedTo;

    @NotNull
    @Size(min = 4, max = 12)
    @Column(name = "MASTER_KEY")
    private String masterKey;
    @Column(name = "IS_ACTIVE")
    private String isActive = "N";

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getIdRdm() {
        return idRdm;
    }

    public void setIdRdm(int idRdm) {
        this.idRdm = idRdm;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getMasterKey() {
        return masterKey;
    }

    public void setMasterKey(String masterKey) {
        this.masterKey = masterKey;
    }

    public String getIsActive() {
        return isActive;
    }
}
