package com.xenenergy.projects.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Daryll Sabate on 10/25/2017.
 */
@Entity
@Table(name = "arm_log")
public class LogMsg {

    @Id
    @Column(name = "ID")
    private long id;
    @Column(name = "DATE_TIME_PROCESS")
    private String dateTimeProcess;
    @Column(name = "MESSAGE")
    private String message;

    public LogMsg() {
    }

    public LogMsg(long id, String dateTimeProcess, String message) {
        this.id = id;
        this.dateTimeProcess = dateTimeProcess;
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDateTimeProcess() {
        return dateTimeProcess;
    }

    public void setDateTimeProcess(String dateTimeProcess) {
        this.dateTimeProcess = dateTimeProcess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
