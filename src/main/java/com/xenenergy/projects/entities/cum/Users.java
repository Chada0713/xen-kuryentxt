package com.xenenergy.projects.entities.cum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Daryll Sabate on 5/29/2017.
 */
@Entity
@Table(name = "users")
public class Users {

    @Id
    @Column(name = "ID")
    private int id;
    @Column(name = "ID_USER_ROLE")
    private int idUserRole;
    @Column(name = "ID_DU")
    private int idDu;
    @Column(name = "USER_PASSWORD")
    private String userPass;
    @Column(name = "USER_FIRSTNAME")
    private String userFirstName;
    @Column(name = "USER_LASTNAME")
    private String userLastName;
    @Column(name = "USER_EMAIL_ADDRESS")
    private String emailAdd;
    @Column(name = "USER_LEVEL")
    private String userLevel;
    @Column(name = "LOGIN_TRIES")
    private int loginTries;
    @Column(name = "IS_LOCKED")
    private String isLocked;
    @Column(name = "FORCE_CHANGE_PASSWORD")
    private String forceChangePass;
    @Column(name = "IS_EMAIL_VALIDATED")
    private String isEmailValidated;
    @Column(name = "ACTIVATION_CODE")
    private String activationCode;
    @Column(name = "SEND_ACTIVATION_CODE")
    private String sendActivationCode;
    @Column(name = "RESET_PASSWORD")
    private String resetPass;
    @Column(name = "RESET_PASSWORD_CODE")
    private String resetPassCode;
    @Column(name = "RESET_DATE_REQUESTED")
    private Date resetDateReq;

    public Users() {
    }

    public Users(int id, int idUserRole, int idDu, String userPass, String userFirstName, String userLastName, String emailAdd, String userLevel, int loginTries, String isLocked, String forceChangePass, String isEmailValidated, String activationCode, String sendActivationCode, String resetPass, String resetPassCode, Date resetDateReq) {
        this.id = id;
        this.idUserRole = idUserRole;
        this.idDu = idDu;
        this.userPass = userPass;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.emailAdd = emailAdd;
        this.userLevel = userLevel;
        this.loginTries = loginTries;
        this.isLocked = isLocked;
        this.forceChangePass = forceChangePass;
        this.isEmailValidated = isEmailValidated;
        this.activationCode = activationCode;
        this.sendActivationCode = sendActivationCode;
        this.resetPass = resetPass;
        this.resetPassCode = resetPassCode;
        this.resetDateReq = resetDateReq;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUserRole() {
        return idUserRole;
    }

    public void setIdUserRole(int idUserRole) {
        this.idUserRole = idUserRole;
    }

    public int getIdDu() {
        return idDu;
    }

    public void setIdDu(int idDu) {
        this.idDu = idDu;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getEmailAdd() {
        return emailAdd;
    }

    public void setEmailAdd(String emailAdd) {
        this.emailAdd = emailAdd;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public int getLoginTries() {
        return loginTries;
    }

    public void setLoginTries(int loginTries) {
        this.loginTries = loginTries;
    }

    public String getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(String isLocked) {
        this.isLocked = isLocked;
    }

    public String getForceChangePass() {
        return forceChangePass;
    }

    public void setForceChangePass(String forceChangePass) {
        this.forceChangePass = forceChangePass;
    }

    public String getIsEmailValidated() {
        return isEmailValidated;
    }

    public void setIsEmailValidated(String isEmailValidated) {
        this.isEmailValidated = isEmailValidated;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public String getSendActivationCode() {
        return sendActivationCode;
    }

    public void setSendActivationCode(String sendActivationCode) {
        this.sendActivationCode = sendActivationCode;
    }

    public String getResetPass() {
        return resetPass;
    }

    public void setResetPass(String resetPass) {
        this.resetPass = resetPass;
    }

    public String getResetPassCode() {
        return resetPassCode;
    }

    public void setResetPassCode(String resetPassCode) {
        this.resetPassCode = resetPassCode;
    }

    public Date getResetDateReq() {
        return resetDateReq;
    }

    public void setResetDateReq(Date resetDateReq) {
        this.resetDateReq = resetDateReq;
    }
}
