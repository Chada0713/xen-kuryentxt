package com.xenenergy.projects.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by xesi on 31/05/2017.
 */
@Entity
@Table(name = "arm_device_upload_master")
public class DeviceUploadMaster {

    @Id
    @Column(name = "ID")
    private long id;
    @Column(name = "ID_DEVICE")
    private long idDevice;
    @Column(name = "UPLOAD_START_TS")
    private Date uploadStartTs;
    @Column(name = "UPLOAD_END_TS")
    private Date uploadEndTs;
    @Column(name = "NO_OF_BILLS")
    private int noOfBills;
    @Column(name = "IS_PROCESSED")
    private String isProcessed;

    public DeviceUploadMaster() {
    }

    public DeviceUploadMaster(long id, long idDevice, Date uploadStartTs, Date uploadEndTs, int noOfBills, String isProcessed) {
        this.id = id;
        this.idDevice = idDevice;
        this.uploadStartTs = uploadStartTs;
        this.uploadEndTs = uploadEndTs;
        this.noOfBills = noOfBills;
        this.isProcessed = isProcessed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdDevice() {
        return idDevice;
    }

    public void setIdDevice(long idDevice) {
        this.idDevice = idDevice;
    }

    public Date getUploadStartTs() {
        return uploadStartTs;
    }

    public void setUploadStartTs(Date uploadStartTs) {
        this.uploadStartTs = uploadStartTs;
    }

    public Date getUploadEndTs() {
        return uploadEndTs;
    }

    public void setUploadEndTs(Date uploadEndTs) {
        this.uploadEndTs = uploadEndTs;
    }

    public int getNoOfBills() {
        return noOfBills;
    }

    public void setNoOfBills(int noOfBills) {
        this.noOfBills = noOfBills;
    }

    public String getIsProcessed() {
        return isProcessed;
    }

    public void setIsProcessed(String isProcessed) {
        this.isProcessed = isProcessed;
    }
}
