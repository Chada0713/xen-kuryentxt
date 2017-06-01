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

    @Column(name = "COUNT_CONSUMER")
    private int countConsumer;

    @Column(name = "COUNT_ACTIVE")
    private int countActive;

    @Column(name = "COUNT_DISCONNECTED")
    private int countDisconnected;

    @Column(name = "PERCENTAGE_DISCONNECTED")
    private double percentageDisconnected;

    /*@OneToOne(mappedBy = "duArea")
    private Account account;*/

    public DuArea() {
    }

    public DuArea(long id, String areaCode, String areaName, int countConsumer, int countActive, int countDisconnected, double percentageDisconnected) {
        this.id = id;
        this.areaCode = areaCode;
        this.areaName = areaName;
        this.countConsumer = countConsumer;
        this.countActive = countActive;
        this.countDisconnected = countDisconnected;
        this.percentageDisconnected = percentageDisconnected;
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

    public int getCountConsumer() {
        return countConsumer;
    }

    public void setCountConsumer(int countConsumer) {
        this.countConsumer = countConsumer;
    }

    public int getCountActive() {
        return countActive;
    }

    public void setCountActive(int countActive) {
        this.countActive = countActive;
    }

    public int getCountDisconnected() {
        return countDisconnected;
    }

    public void setCountDisconnected(int countDisconnected) {
        this.countDisconnected = countDisconnected;
    }

    public double getPercentageDisconnected() {
        return percentageDisconnected;
    }

    public void setPercentageDisconnected(double percentageDisconnected) {
        this.percentageDisconnected = percentageDisconnected;
    }

    /*public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }*/
}
