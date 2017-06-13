package com.xenenergy.projects.entities;

import org.springframework.format.annotation.NumberFormat;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by xesi on 02/06/2017.
 */
public class ChargeGroupDetails {

    String chargeGroupName;
    double chargeSum;
    double chargeTotalgroup;

    String chargeName;
    @NumberFormat(style = NumberFormat.Style.NUMBER, pattern = "#0.0000")
    double chargeAmount = 0.0000;;
    @NumberFormat(style = NumberFormat.Style.NUMBER, pattern = "#0.0000")
    double chargeTotal = 0.0000;

    public String getChargeGroupName() {
        return chargeGroupName;
    }

    public void setChargeGroupName(String chargeGroupName) {
        this.chargeGroupName = chargeGroupName;
    }

    public double getChargeSum() {
        return chargeSum;
    }

    public void setChargeSum(double chargeSum) {
        this.chargeSum = chargeSum;
    }

    public double getChargeTotalgroup() {
        return chargeTotalgroup;
    }

    public void setChargeTotalgroup(double chargeTotalgroup) {
        this.chargeTotalgroup = chargeTotalgroup;
    }

    public String getChargeName() {
        return chargeName;
    }

    public void setChargeName(String chargeName) {
        this.chargeName = chargeName;
    }

    public double getChargeAmount() {
        return chargeAmount;
    }

    public void setChargeAmount(double chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    public double getChargeTotal() {
        return chargeTotal;
    }

    public void setChargeTotal(double chargeTotal) {
        this.chargeTotal = chargeTotal;
    }

}
