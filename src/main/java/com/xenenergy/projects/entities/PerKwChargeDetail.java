package com.xenenergy.projects.entities;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;

/**
 * Created by Daryll Sabate on 5/19/2017.
 */
@Entity
@Table(name = "arm_per_kw_charge_detail")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "spCopyPerKWChargeTemplate",
                procedureName = "spCopyPerKWChargeTemplate",
                parameters = {@StoredProcedureParameter(mode = ParameterMode.IN, name = "idMaster", type = Long.class)}
        )})
public class PerKwChargeDetail {

    @Id
    @Column(name = "ID")
    private long id;
    @Column(name = "ID_MASTER")
    private long idMaster;
    @Column(name = "CHARGE_TYPE")
    private String chargeType;
    @Column(name = "PER_KW_RATE_NAME")
    private String perKwRateName;
    @Column(name = "PER_KW_RATE_LONG_NAME")
    private String perKwRateLongName;
    @Column(name = "PRINT_ORDER")
    private int printOrder = 0;
    @Column(name = "TOTAL_AMOUNT")
    @NumberFormat(style = NumberFormat.Style.NUMBER, pattern = "#0.0000")
    private double totalAmt = 0.0000;
    @Column(name = "FIXED_ADDTL")
    @NumberFormat(style = NumberFormat.Style.NUMBER, pattern = "#0.0000")
    private double fixedAddtl = 0.0000;
    @Column(name = "ATL")
    @NumberFormat(style = NumberFormat.Style.NUMBER, pattern = "#0.0000")
    private double adjToLifeline = 0.0000;
    @Column(name = "ATS")
    @NumberFormat(style = NumberFormat.Style.NUMBER, pattern = "#0.0000")
    private double adjToSc = 0.0000;
    @Column(name = "IS_SUB_TO_LIFELINE")
    @Enumerated(value = EnumType.STRING)
    private choices isSubToLifeLine = choices.Y;
    @Column(name = "IS_SUB_TO_SURCHARGE")
    @Enumerated(value = EnumType.STRING)
    private choices isSubToSurCharge = choices.Y;

    public PerKwChargeDetail() {
    }

    public PerKwChargeDetail(long id, long idMaster, String chargeType, String perKwRateName, String perKwRateLongName, int printOrder, double totalAmt, double fixedAddtl, double adjToLifeline, double adjToSc, choices isSubToLifeLine, choices isSubToSurCharge) {
        this.id = id;
        this.idMaster = idMaster;
        this.chargeType = chargeType;
        this.perKwRateName = perKwRateName;
        this.perKwRateLongName = perKwRateLongName;
        this.printOrder = printOrder;
        this.totalAmt = totalAmt;
        this.fixedAddtl = fixedAddtl;
        this.adjToLifeline = adjToLifeline;
        this.adjToSc = adjToSc;
        this.isSubToLifeLine = isSubToLifeLine;
        this.isSubToSurCharge = isSubToSurCharge;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdMaster() {
        return idMaster;
    }

    public void setIdMaster(long idMaster) {
        this.idMaster = idMaster;
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    public String getPerKwRateName() {
        return perKwRateName;
    }

    public void setPerKwRateName(String perKwRateName) {
        this.perKwRateName = perKwRateName;
    }

    public String getPerKwRateLongName() {
        return perKwRateLongName;
    }

    public void setPerKwRateLongName(String perKwRateLongName) {
        this.perKwRateLongName = perKwRateLongName;
    }

    public int getPrintOrder() {
        return printOrder;
    }

    public void setPrintOrder(int printOrder) {
        this.printOrder = printOrder;
    }

    public double getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(double totalAmt) {
        this.totalAmt = totalAmt;
    }

    public double getFixedAddtl() {
        return fixedAddtl;
    }

    public void setFixedAddtl(double fixedAddtl) {
        this.fixedAddtl = fixedAddtl;
    }

    public choices getIsSubToLifeLine() {
        return isSubToLifeLine;
    }

    public void setIsSubToLifeLine(choices isSubToLifeLine) {
        this.isSubToLifeLine = isSubToLifeLine;
    }

    public double getAdjToLifeline() {
        return adjToLifeline;
    }

    public void setAdjToLifeline(double adjToLifeline) {
        this.adjToLifeline = adjToLifeline;
    }

    public double getAdjToSc() {
        return adjToSc;
    }

    public void setAdjToSc(double adjToSc) {
        this.adjToSc = adjToSc;
    }

    public enum choices {Y, N}

    public choices getIsSubToSurCharge() { return isSubToSurCharge; }

    public void setIsSubToSurCharge(choices isSubToSurCharge) { this.isSubToSurCharge = isSubToSurCharge; }
}
