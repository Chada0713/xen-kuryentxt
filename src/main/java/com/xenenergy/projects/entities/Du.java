package com.xenenergy.projects.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by xenuser on 5/17/2017.
 */
@Entity
@Table(name = "arm_du")
public class Du {

    @Id
    @Column(name = "ID")
    private long id;
    @Column(name = "DU_CODE")
    private String duCode;
    @Column(name = "DU_NAME")
    private String duName;
    @Column(name = "ADDRLN1")
    private String addressLn1;
    @Column(name = "ADDRLN2")
    private String addressLn2;
    @Column(name = "CONTACT_PERSON")
    private String contactPerson;
    @Column(name = "CONTACT_NUMBER")
    private String contactNumber;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDuCode() {
        return duCode;
    }

    public void setDuCode(String duCode) {
        this.duCode = duCode;
    }

    public String getDuName() {
        return duName;
    }

    public void setDuName(String duName) {
        this.duName = duName;
    }

    public String getAddressLn1() {
        return addressLn1;
    }

    public void setAddressLn1(String addressLn1) {
        this.addressLn1 = addressLn1;
    }

    public String getAddressLn2() {
        return addressLn2;
    }

    public void setAddressLn2(String addressLn2) {
        this.addressLn2 = addressLn2;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
