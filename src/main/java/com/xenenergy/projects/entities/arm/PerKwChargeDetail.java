package com.xenenergy.projects.entities.arm;

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
    @Column(name = "AMOUNT")
    @NumberFormat(style = NumberFormat.Style.NUMBER, pattern = "#0.0000")
    private double amount = 0.0000;
    @Column(name = "VAT_RATE")
    @NumberFormat(style = NumberFormat.Style.NUMBER, pattern = "#0.00")
    private double vatRate = 0.00;
    @Column(name = "VAT_AMT")
    @NumberFormat(style = NumberFormat.Style.NUMBER, pattern = "#0.0000")
    private double vatAmt = 0.000;
    @Column(name = "TOTAL_AMOUNT")
    @NumberFormat(style = NumberFormat.Style.NUMBER, pattern = "#0.0000")
    private double totalAmt = 0.0000;
    @Column(name = "FIXED_ADDTL")
    @NumberFormat(style = NumberFormat.Style.NUMBER, pattern = "#0.0000")
    private double fixedAddtl = 0.0000;

    public enum choices {Y, N}

    @Column(name = "IS_SUB_TO_VAT")
    @Enumerated(value = EnumType.STRING)
    private choices isSubToVat = choices.Y;
    @Column(name = "IS_SUB_TO_LIFELINE")
    @Enumerated(value = EnumType.STRING)
    private choices isSubToLifeLine = choices.Y;
    @Column(name = "IS_SUB_TO_SC_DISCOUNT")
    @Enumerated(value = EnumType.STRING)
    private choices isSubToScDisc = choices.Y;
    @Column(name = "IS_ROUNDED_OFF")
    @Enumerated(value = EnumType.STRING)
    private choices isRoundedOff = choices.Y;
    @Column(name = "IS_ZERO_IF_SENIOR")
    @Enumerated(value = EnumType.STRING)
    private choices isZeroSC = choices.Y;
    @Column(name = "IS_SUB_TO_VAT_OTHERS")
    @Enumerated(value = EnumType.STRING)
    private choices isSubToVatOthers = choices.Y;

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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getVatRate() {
        return vatRate;
    }

    public void setVatRate(double vatRate) {
        this.vatRate = vatRate;
    }

    public double getVatAmt() {
        return vatAmt;
    }

    public void setVatAmt(double vatAmt) {
        this.vatAmt = vatAmt;
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

    public choices getIsSubToVat() {
        return isSubToVat;
    }

    public void setIsSubToVat(choices isSubToVat) {
        this.isSubToVat = isSubToVat;
    }

    public choices getIsSubToLifeLine() {
        return isSubToLifeLine;
    }

    public void setIsSubToLifeLine(choices isSubToLifeLine) {
        this.isSubToLifeLine = isSubToLifeLine;
    }

    public choices getIsSubToScDisc() {
        return isSubToScDisc;
    }

    public void setIsSubToScDisc(choices isSubToScDisc) {
        this.isSubToScDisc = isSubToScDisc;
    }

    public choices getIsRoundedOff() {
        return isRoundedOff;
    }

    public void setIsRoundedOff(choices isRoundedOff) {
        this.isRoundedOff = isRoundedOff;
    }

    public choices getIsZeroSC() {
        return isZeroSC;
    }

    public void setIsZeroSC(choices isZeroSC) {
        this.isZeroSC = isZeroSC;
    }

    public choices getIsSubToVatOthers() {
        return isSubToVatOthers;
    }

    public void setIsSubToVatOthers(choices isSubToVatOthers) {
        this.isSubToVatOthers = isSubToVatOthers;
    }
}
