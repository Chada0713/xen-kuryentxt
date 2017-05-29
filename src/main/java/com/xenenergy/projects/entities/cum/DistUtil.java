package com.xenenergy.projects.entities.cum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Daryll Sabate on 5/29/2017.
 */
@Entity
@Table(name = "du")
public class DistUtil {

    @Id
    @Column(name = "ID")
    private long id;
    @Column(name = "DU_INDEX")
    private String duIndex;
    @Column(name = "DU_CODE")
    private String duCode;
    @Column(name = "DU_NAME")
    private String duName;
    @Column(name = "ADDRLN1")
    private String addrln1;
    @Column(name = "ADDRLN2")
    private String addrln2;
    @Column(name = "SERVER_IP")
    private String serverIp;
    @Column(name = "PORT")
    private String port;
    @Column(name = "CONTACT_NUMBER")
    private String contactNo;
    @Column(name = "IS_ADMIN_USER")
    private long idAdminUser;
    @Column(name = "IS_ACTIVE")
    private String isActive;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDuIndex() {
        return duIndex;
    }

    public void setDuIndex(String duIndex) {
        this.duIndex = duIndex;
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

    public String getAddrln1() {
        return addrln1;
    }

    public void setAddrln1(String addrln1) {
        this.addrln1 = addrln1;
    }

    public String getAddrln2() {
        return addrln2;
    }

    public void setAddrln2(String addrln2) {
        this.addrln2 = addrln2;
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public long getIdAdminUser() {
        return idAdminUser;
    }

    public void setIdAdminUser(long idAdminUser) {
        this.idAdminUser = idAdminUser;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }
}
