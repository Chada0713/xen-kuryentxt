package com.xenenergy.projects.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by xesi on 13/06/2017.
 */
@Entity
@Table(name = "arm_db_event_monitor")
public class DbEventMonitor {

    @Id
    @Column(name = "ID")
    private long id;
    @Column(name = "TS")
    private Date ts;
    @Column(name = "EVENT_NAME")
    private String eventName;
    @Column(name = "LAST_RUN_DATE")
    private Date lastRunDate;
    @Column(name = "LAST_RUN_TS")
    private Date lastRunTs;

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

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getLastRunDate() {
        return lastRunDate;
    }

    public void setLastRunDate(Date lastRunDate) {
        this.lastRunDate = lastRunDate;
    }

    public Date getLastRunTs() {
        return lastRunTs;
    }

    public void setLastRunTs(Date lastRunTs) {
        this.lastRunTs = lastRunTs;
    }
}
