package com.xenenergy.projects.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "arm_route_definition_master")
public class Rdm {

    @Id
    @Column(name = "ID")
    private long id;
    @Column(name = "TS")
    private Date ts;
    @Column(name = "RDM_NAME")
    private String rdmName;
    @Column(name = "ID_READER")
    private int idReader;
    @Column(name = "CONSUMER_COUNT")
    private int consumerCount;
    @Column(name = "IS_READY_FOR_USE")
    private String isReadyForUse;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRdmName() {
        return rdmName;
    }

    public void setRdmName(String rdmName) {
        this.rdmName = rdmName;
    }

    public int getIdReader() {
        return idReader;
    }

    public void setIdReader(int idReader) {
        this.idReader = idReader;
    }

    public int getConsumerCount() {
        return consumerCount;
    }

    public void setConsumerCount(int consumerCount) {
        this.consumerCount = consumerCount;
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    public String getIsReadyForUse() {
        return isReadyForUse;
    }

    public void setIsReadyForUse(String isReadyForUse) {
        this.isReadyForUse = isReadyForUse;
    }
}
