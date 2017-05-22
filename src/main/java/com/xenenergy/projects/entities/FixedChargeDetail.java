package com.xenenergy.projects.entities;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by xesi on 19/05/2017.
 */
@Entity
@Table(name = "arm_fix_charge_detail")
public class FixedChargeDetail {

    @Id
    @Column(name = "ID")
    private long id;
    @Column(name = "ID_MASTER")
    private long idMaster;
    @Column(name = "FIX_CHARGE_NAME")
    private String fixChargeName;
    @Column(name = "PRINT_ORDER")
    private int printOrder = 0;
    @Column(name = "AMOUNT")
    private Double amount = 0.0000;
    @Column(name = "VAT_RATE")
    private Double vatRate = 0.0000;
    @Column(name = "VAT_AMT")
    private Double vatAmt = 0.0000;
    @Column(name = "SC_DISCOUNT_RATE")
    private Double scDiscountRate = 0.0000;
    @Column(name = "TOTAL_AMOUNT")
    @NumberFormat(style = NumberFormat.Style.NUMBER, pattern = "#0.0000")
    private Double totalAmount = 0.0000;
    @Column(name = "IS_SUB_TO_VAT")
    private String isSubToVat = "N";
    @Column(name = "IS_SUB_TO_LIFELINE")
    private String isSubToLiftime = "N";
    @Column(name = "IS_SUB_TO_SC_DISCOUNT")
    private String isSubToScDiscount = "N";
    @Column(name = "IS_ROUNDED_OFF")
    private String isRoundedOff = "N";

    public FixedChargeDetail() {
    }

    public FixedChargeDetail(long id, long idMaster, String fixChargeName, int printOrder, Double amount, Double vatRate, Double vatAmt, Double scDiscountRate, Double totalAmount, String isSubToVat, String isSubToLiftime, String isSubToScDiscount, String isRoundedOff) {
        this.id = id;
        this.idMaster = idMaster;
        this.fixChargeName = fixChargeName;
        this.printOrder = printOrder;
        this.amount = amount;
        this.vatRate = vatRate;
        this.vatAmt = vatAmt;
        this.scDiscountRate = scDiscountRate;
        this.totalAmount = totalAmount;
        this.isSubToVat = isSubToVat;
        this.isSubToLiftime = isSubToLiftime;
        this.isSubToScDiscount = isSubToScDiscount;
        this.isRoundedOff = isRoundedOff;
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

    public String getFixChargeName() {
        return fixChargeName;
    }

    public void setFixChargeName(String fixChargeName) {
        this.fixChargeName = fixChargeName;
    }

    public int getPrintOrder() {
        return printOrder;
    }

    public void setPrintOrder(int printOrder) {
        this.printOrder = printOrder;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getVatRate() {
        return vatRate;
    }

    public void setVatRate(Double vatRate) {
        this.vatRate = vatRate;
    }

    public Double getVatAmt() {
        return vatAmt;
    }

    public void setVatAmt(Double vatAmt) {
        this.vatAmt = vatAmt;
    }

    public Double getScDiscountRate() {
        return scDiscountRate;
    }

    public void setScDiscountRate(Double scDiscountRate) {
        this.scDiscountRate = scDiscountRate;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getIsSubToVat() {
        return isSubToVat;
    }

    public void setIsSubToVat(String isSubToVat) {
        this.isSubToVat = isSubToVat;
    }

    public String getIsSubToLiftime() {
        return isSubToLiftime;
    }

    public void setIsSubToLiftime(String isSubToLiftime) {
        this.isSubToLiftime = isSubToLiftime;
    }

    public String getIsSubToScDiscount() {
        return isSubToScDiscount;
    }

    public void setIsSubToScDiscount(String isSubToScDiscount) {
        this.isSubToScDiscount = isSubToScDiscount;
    }

    public String getIsRoundedOff() {
        return isRoundedOff;
    }

    public void setIsRoundedOff(String isRoundedOff) {
        this.isRoundedOff = isRoundedOff;
    }
}
