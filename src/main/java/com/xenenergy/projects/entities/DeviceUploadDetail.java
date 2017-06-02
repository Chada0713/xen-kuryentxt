package com.xenenergy.projects.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by xesi on 01/06/2017.
 */
@Entity
@Table(name = "arm_device_upload_detail")
public class DeviceUploadDetail {

    @Id
    @Column(name = "ID")
    private long id;
    @Column(name = "TS")
    private Date ts;
    @Column(name = "ID_MASTER")
    private long idMaster;
    @Column(name = "BILL_NO")
    private String billNo;
    @Column(name = "IS_PROCESSED")
    private String isProcessed;

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

    public long getIdMaster() {
        return idMaster;
    }

    public void setIdMaster(long idMaster) {
        this.idMaster = idMaster;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getIsProcessed() {
        return isProcessed;
    }

    public void setIsProcessed(String isProcessed) {
        this.isProcessed = isProcessed;
    }
}
