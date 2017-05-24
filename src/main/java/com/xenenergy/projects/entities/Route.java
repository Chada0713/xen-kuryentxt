package com.xenenergy.projects.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by xesi on 22/05/2017.
 */
@Entity
@Table(name = "arm_route")
public class Route {

    @Id
    @Column(name = "ID")
    private long id;
    @Column(name = "ID_AREA")
    private long idArea;
    @Column(name = "AREA_CODE")
    private String areaCode;
    @Column(name = "ROUTE_CODE")
    private String routeCode;
    @Column(name = "ROUTE_NAME")
    private String routeName;
    @Column(name = "START_SEQUENCE")
    private int startSequence;
    @Column(name = "END_SEQUENCE")
    private int endSequence;
    @Column(name = "COUNT_CONSUMER")
    private int countConsumer;
    @Column(name = "COUNT_ACTIVE")
    private int countActive;
    @Column(name = "COUNT_DISCONNECTED")
    private int countDisconnected;
    @Column(name = "PERCENTAGE_DISCONNECTED")
    private double percentageDisconnected;

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

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public int getStartSequence() {
        return startSequence;
    }

    public void setStartSequence(int startSequence) {
        this.startSequence = startSequence;
    }

    public int getEndSequence() {
        return endSequence;
    }

    public void setEndSequence(int endSequence) {
        this.endSequence = endSequence;
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
}
