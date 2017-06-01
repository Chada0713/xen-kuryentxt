package com.xenenergy.projects.entities;

import javax.persistence.*;

@Entity
@Table(name = "arm_account")
public class Account {

    @Id
    @Column(name = "ID")
    private long id;
    @Column(name = "DATE_REC_CREATED")
    private String dateRecCreated;
    @Column(name = "TIME_REC_CREATED")
    private String timeRecCreated;
    @Column(name = "ID_AREA")
    private long idArea;
    @Column(name = "ID_RDM")
    private long idRdm;
    @Column(name = "ID_ROUTE")
    private long idRoute;
    @Column(name = "ROUTE_CODE")
    private String routeCode;
    @Column(name = "ACCOUNT_NO")
    private long accountNo;
    @Column(name = "OLD_ACCOUNT_NO")
    private String oldAccountNo;
    @Column(name = "SEQUENCE_NO")
    private int seqNo = 0;
    @Column(name = "OLD_SEQUENCE_NO")
    private int oldSequenceNo = 0;
    @Column(name = "CURRENT_METER_NO")
    private String meterNo;
    @Column(name = "METER_MULTIPLIER")
    private int meterMultiplier;
    @Column(name = "SERIAL_NO")
    private String serialNo;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "MI")
    private String mi;
    @Column(name = "ACCOUNT_NAME")
    private String accountName;
    @Column(name = "ADDRESSLN1")
    private String addressLn1;
    @Column(name = "ADDRESSLN2")
    private String addressLn2;
    @Column(name = "PREV02_READING")
    private Long prev02Reading;
    @Column(name = "PREV01_READING")
    private Long prev01Reading;
    @Column(name = "CURRENT_READING")
    private int curRdg;
    @Column(name = "ID_RATE_MASTER")
    private long idRateMaster;
    @Column(name = "IS_SENIOR_CITIZEN")
    private String isSeniorCitizen;
    @Column(name = "IS_ACTIVE")
    private String isPrivate;
    @Column(name = "IS_DOWNLOADED")
    private String isDownloaded;

    public Account() {
    }

    public Account(long id, String dateRecCreated, String timeRecCreated, long idArea, long idRdm, long idRoute, String routeCode, long accountNo, String oldAccountNo, int seqNo, int oldSequenceNo, String meterNo, int meterMultiplier, String serialNo, String lastName, String firstName, String mi, String accountName, String addressLn1, String addressLn2, Long prev02Reading, Long prev01Reading, int curRdg, long idRateMaster, String isSeniorCitizen, String isPrivate, String isDownloaded) {
        this.id = id;
        this.dateRecCreated = dateRecCreated;
        this.timeRecCreated = timeRecCreated;
        this.idArea = idArea;
        this.idRdm = idRdm;
        this.idRoute = idRoute;
        this.routeCode = routeCode;
        this.accountNo = accountNo;
        this.oldAccountNo = oldAccountNo;
        this.seqNo = seqNo;
        this.oldSequenceNo = oldSequenceNo;
        this.meterNo = meterNo;
        this.meterMultiplier = meterMultiplier;
        this.serialNo = serialNo;
        this.lastName = lastName;
        this.firstName = firstName;
        this.mi = mi;
        this.accountName = accountName;
        this.addressLn1 = addressLn1;
        this.addressLn2 = addressLn2;
        this.prev02Reading = prev02Reading;
        this.prev01Reading = prev01Reading;
        this.curRdg = curRdg;
        this.idRateMaster = idRateMaster;
        this.isSeniorCitizen = isSeniorCitizen;
        this.isPrivate = isPrivate;
        this.isDownloaded = isDownloaded;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDateRecCreated() {
        return dateRecCreated;
    }

    public void setDateRecCreated(String dateRecCreated) {
        this.dateRecCreated = dateRecCreated;
    }

    public String getTimeRecCreated() {
        return timeRecCreated;
    }

    public void setTimeRecCreated(String timeRecCreated) {
        this.timeRecCreated = timeRecCreated;
    }

    public long getIdArea() {
        return idArea;
    }

    public void setIdArea(long idArea) {
        this.idArea = idArea;
    }

    public long getIdRdm() {
        return idRdm;
    }

    public void setIdRdm(long idRdm) {
        this.idRdm = idRdm;
    }

    public long getIdRoute() {
        return idRoute;
    }

    public void setIdRoute(long idRoute) {
        this.idRoute = idRoute;
    }

    public String getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    public long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(long accountNo) {
        this.accountNo = accountNo;
    }

    public String getOldAccountNo() {
        return oldAccountNo;
    }

    public void setOldAccountNo(String oldAccountNo) {
        this.oldAccountNo = oldAccountNo;
    }

    public int getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(int seqNo) {
        this.seqNo = seqNo;
    }

    public int getOldSequenceNo() {
        return oldSequenceNo;
    }

    public void setOldSequenceNo(int oldSequenceNo) {
        this.oldSequenceNo = oldSequenceNo;
    }

    public String getMeterNo() {
        return meterNo;
    }

    public void setMeterNo(String meterNo) {
        this.meterNo = meterNo;
    }

    public int getMeterMultiplier() {
        return meterMultiplier;
    }

    public void setMeterMultiplier(int meterMultiplier) {
        this.meterMultiplier = meterMultiplier;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMi() {
        return mi;
    }

    public void setMi(String mi) {
        this.mi = mi;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAddressLn1() {
        return addressLn1;
    }

    public void setAddressLn1(String addressLn1) {
        this.addressLn1 = addressLn1;
    }

    public String getAddressLn2() {
        return addressLn2;
    }

    public void setAddressLn2(String addressLn2) {
        this.addressLn2 = addressLn2;
    }

    public Long getPrev02Reading() {
        return prev02Reading;
    }

    public void setPrev02Reading(Long prev02Reading) {
        this.prev02Reading = prev02Reading;
    }

    public Long getPrev01Reading() {
        return prev01Reading;
    }

    public void setPrev01Reading(Long prev01Reading) {
        this.prev01Reading = prev01Reading;
    }

    public int getCurRdg() {
        return curRdg;
    }

    public void setCurRdg(int curRdg) {
        this.curRdg = curRdg;
    }

    public long getIdRateMaster() {
        return idRateMaster;
    }

    public void setIdRateMaster(long idRateMaster) {
        this.idRateMaster = idRateMaster;
    }

    public String getIsSeniorCitizen() {
        return isSeniorCitizen;
    }

    public void setIsSeniorCitizen(String isSeniorCitizen) {
        this.isSeniorCitizen = isSeniorCitizen;
    }

    public String getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(String isPrivate) {
        this.isPrivate = isPrivate;
    }

    public String getIsDownloaded() {
        return isDownloaded;
    }

    public void setIsDownloaded(String isDownloaded) {
        this.isDownloaded = isDownloaded;
    }
}
