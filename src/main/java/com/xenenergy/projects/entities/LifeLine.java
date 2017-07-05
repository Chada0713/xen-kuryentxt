package com.xenenergy.projects.entities;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "arm_du_lifeline_rate_detail")
public class LifeLine {

    @Id
    @Column(name = "ID")
    private long id;
    @Column(name = "TS")
    private Date ts;
    @Column(name = "FROM_KWH_USED")
    private int fromKwhUsed;
    @Column(name = "TO_KWH_USED")
    private int toKwhUsed;
    @Column(name = "DISCOUNT_RATE")
    @NumberFormat(style = NumberFormat.Style.NUMBER, pattern = "#0.0000")
    private double discountRate = 0.0000;

    public LifeLine() {
    }

    public LifeLine(long id, Date ts, int fromKwhUsed, int toKwhUsed, double discountRate) {
        this.id = id;
        this.ts = ts;
        this.fromKwhUsed = fromKwhUsed;
        this.toKwhUsed = toKwhUsed;
        this.discountRate = discountRate;
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

    public int getFromKwhUsed() {
        return fromKwhUsed;
    }

    public void setFromKwhUsed(int fromKwhUsed) {
        this.fromKwhUsed = fromKwhUsed;
    }

    public int getToKwhUsed() {
        return toKwhUsed;
    }

    public void setToKwhUsed(int toKwhUsed) {
        this.toKwhUsed = toKwhUsed;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
}

