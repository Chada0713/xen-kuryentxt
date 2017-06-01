package com.xenenergy.projects.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by xenuser on 5/18/2017.
 */
@Entity
@Table(name = "arm_rate_master_charge_header")
public class ChargeType {

    @Id
    @Column(name = "ID")
    private long id;
    @Column(name = "ID_RATE_MASTER")
    private long idRateMaster;
    @Column(name = "PRINT_ORDER")
    private int printOrder;
    @Column(name = "CHARGE_TYPE_CODE")
    private String chargeTypeCode;
    @Column(name = "CHARGE_TYPE_NAME")
    private String chargeTypeName;

    public ChargeType() {
    }

    public ChargeType(long id, long idRateMaster, int printOrder, String chargeTypeCode, String chargeTypeName) {
        this.id = id;
        this.idRateMaster = idRateMaster;
        this.printOrder = printOrder;
        this.chargeTypeCode = chargeTypeCode;
        this.chargeTypeName = chargeTypeName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdRateMaster() {
        return idRateMaster;
    }

    public void setIdRateMaster(long idRateMaster) {
        this.idRateMaster = idRateMaster;
    }

    public int getPrintOrder() {
        return printOrder;
    }

    public void setPrintOrder(int printOrder) {
        this.printOrder = printOrder;
    }

    public String getChargeTypeCode() {
        return chargeTypeCode;
    }

    public void setChargeTypeCode(String chargeTypeCode) {
        this.chargeTypeCode = chargeTypeCode;
    }

    public String getChargeTypeName() {
        return chargeTypeName;
    }

    public void setChargeTypeName(String chargeTypeName) {
        this.chargeTypeName = chargeTypeName;
    }
}
