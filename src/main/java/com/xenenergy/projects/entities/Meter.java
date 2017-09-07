package com.xenenergy.projects.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by xesi on 27/07/2017.
 */
@Entity
@Table(name = "arm_meter_new")
public class Meter {
    @Id
    @Column(name = "ID")
    private long id;
    @Column(name = "TS")
    private Date ts;
    @Column(name = "ID_ROUTE")
    private long idRoute;
    @Column(name = "MSN")
    private String msn;
    @Column(name = "DATE_READ")
    private String dateRead;
    @Column(name = "TIME_READ")
    private String timeRead;
    @Column(name = "READING")
    private int reading;

    public Meter() {
    }

    public Meter(long id, Date ts, long idRoute, String msn, String dateRead, String timeRead, int reading) {
        this.id = id;
        this.ts = ts;
        this.idRoute = idRoute;
        this.msn = msn;
        this.dateRead = dateRead;
        this.timeRead = timeRead;
        this.reading = reading;
    }

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

    public long getIdRoute() {
        return idRoute;
    }

    public void setIdRoute(long idRoute) {
        this.idRoute = idRoute;
    }

    public String getMsn() {
        return msn;
    }

    public void setMsn(String msn) {
        this.msn = msn;
    }

    public String getDateRead() {
        return dateRead;
    }

    public void setDateRead(String dateRead) {
        this.dateRead = dateRead;
    }

    public String getTimeRead() {
        return timeRead;
    }

    public void setTimeRead(String timeRead) {
        this.timeRead = timeRead;
    }

    public int getReading() {
        return reading;
    }

    public void setReading(int reading) {
        this.reading = reading;
    }
}
