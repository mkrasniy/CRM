package com.intellecom.crm.model;

import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.Table;

/**
 * Created by MKrasnyi on 10.05.2016.
 */

@Entity(name = "Account")
@Table(name="VW_ABONENTLIST_CRM")
@Immutable
public class Account {
    @Id
    private String ACCOUNTNUMBER;

    private String BILLINGAREANAME;
    private String ACTIVATION;
    private String EMAILADDRESS;
    private String ACCOUNTNAME;
    private String ACCOUNTUSERNAME;
    private String PARENT;
    private String PASSW;
    private float AMOUNT;
    private float AMOUNT_NEED;
    private String ACCOUNTSTATUSNAME;
    private String REPLY_GROUP;
    private String SERVICE;
    private String  RENT;
    private String CPENAME;
    private String CPEID;
    private String STATIC_IP;
    private String EXP_DATE;
    private String USED_TRAF_MBYTES;
    private String MANAGER;
    private String HPHONENO;
    private String OPHONENO;
    private String MPHONENO;
    private String FPHONENO;
    private String TECH;
    private String CANOPY_CHARGE;
    private Boolean IS_EXP;
    private String BILLINGADRESS;
    private String PERMANENTADRESS;
    private String PREFBS;
    private String MAC;

    public Account() {
    }

    public String getPREFBS() {
        return PREFBS;
    }

    public void setPREFBS(String PREFBS) {
        this.PREFBS = PREFBS;
    }

    public String getMAC() {
        return MAC;
    }

    public void setMAC(String MAC) {
        this.MAC = MAC;
    }

    public String getBILLINGADRESS() {
        return BILLINGADRESS;
    }

    public void setBILLINGADRESS(String BILLINGADRESS) {
        this.BILLINGADRESS = BILLINGADRESS;
    }

    public String getPERMANENTADRESS() {
        return PERMANENTADRESS;
    }

    public void setPERMANENTADRESS(String PERMANENTADRESS) {
        this.PERMANENTADRESS = PERMANENTADRESS;
    }

    public Boolean getIS_EXP() {
        return IS_EXP;
    }

    public void setIS_EXP(Boolean IS_EXP) {
        this.IS_EXP = IS_EXP;
    }

    public String getCANOPY_CHARGE() {
        return CANOPY_CHARGE;
    }

    public void setCANOPY_CHARGE(String CANOPY_CHARGE) {
        this.CANOPY_CHARGE = CANOPY_CHARGE;
    }

    public String getTECH() {
        return TECH;
    }

    public void setTECH(String TECH) {
        this.TECH = TECH;
    }

    public String getBILLINGAREANAME() {
        return BILLINGAREANAME;
    }

    public void setBILLINGAREANAME(String BILLINGAREANAME) {
        this.BILLINGAREANAME = BILLINGAREANAME;
    }

    public String getACTIVATION() {
        return ACTIVATION;
    }

    public void setACTIVATION(String ACTIVATION) {
        this.ACTIVATION = ACTIVATION;
    }

    public String getEMAILADDRESS() {
        return EMAILADDRESS;
    }

    public void setEMAILADDRESS(String EMAILADDRESS) {
        this.EMAILADDRESS = EMAILADDRESS;
    }

    public String getACCOUNTNUMBER() {
        return ACCOUNTNUMBER;
    }

    public void setACCOUNTNUMBER(String ACCOUNTNUMBER) {
        this.ACCOUNTNUMBER = ACCOUNTNUMBER;
    }

    public String getACCOUNTNAME() {
        return ACCOUNTNAME;
    }

    public void setACCOUNTNAME(String ACCOUNTNAME) {
        this.ACCOUNTNAME = ACCOUNTNAME;
    }

    public String getACCOUNTUSERNAME() {
        return ACCOUNTUSERNAME;
    }

    public void setACCOUNTUSERNAME(String ACCOUNTUSERNAME) {
        this.ACCOUNTUSERNAME = ACCOUNTUSERNAME;
    }

    public String getPARENT() {
        return PARENT;
    }

    public void setPARENT(String PARENT) {
        this.PARENT = PARENT;
    }

    public String getPASSW() {
        return PASSW;
    }

    public void setPASSW(String PASSW) {
        this.PASSW = PASSW;
    }

    public float getAMOUNT() {
        return AMOUNT;
    }

    public void setAMOUNT(float AMOUNT) {
        this.AMOUNT = AMOUNT;
    }

    public float getAMOUNT_NEED() {
        return AMOUNT_NEED;
    }

    public void setAMOUNT_NEED(float AMOUNT_NEED) {
        this.AMOUNT_NEED = AMOUNT_NEED;
    }

    public String getACCOUNTSTATUSNAME() {
        return ACCOUNTSTATUSNAME;
    }

    public void setACCOUNTSTATUSNAME(String ACCOUNTSTATUSNAME) {
        this.ACCOUNTSTATUSNAME = ACCOUNTSTATUSNAME;
    }

    public String getREPLY_GROUP() {
        return REPLY_GROUP;
    }

    public void setREPLY_GROUP(String REPLY_GROUP) {
        this.REPLY_GROUP = REPLY_GROUP;
    }

    public String getSERVICE() {
        return SERVICE;
    }

    public void setSERVICE(String SERVICE) {
        this.SERVICE = SERVICE;
    }

    public String getRENT() {
        return RENT;
    }

    public void setRENT(String RENT) {
        this.RENT = RENT;
    }

    public String getCPENAME() {
        return CPENAME;
    }

    public void setCPENAME(String CPENAME) {
        this.CPENAME = CPENAME;
    }

    public String getCPEID() {
        return CPEID;
    }

    public void setCPEID(String CPEID) {
        this.CPEID = CPEID;
    }

    public String getSTATIC_IP() {
        return STATIC_IP;
    }

    public void setSTATIC_IP(String STATIC_IP) {
        this.STATIC_IP = STATIC_IP;
    }

    public String getEXP_DATE() {
        return EXP_DATE;
    }

    public void setEXP_DATE(String EXP_DATE) {
        this.EXP_DATE = EXP_DATE;
    }

    public String getUSED_TRAF_MBYTES() {
        return USED_TRAF_MBYTES;
    }

    public void setUSED_TRAF_MBYTES(String USED_TRAF_MBYTES) {
        this.USED_TRAF_MBYTES = USED_TRAF_MBYTES;
    }

    public String getMANAGER() {
        return MANAGER;
    }

    public void setMANAGER(String MANAGER) {
        this.MANAGER = MANAGER;
    }

    public String getHPHONENO() {
        return HPHONENO;
    }

    public void setHPHONENO(String HPHONENO) {
        this.HPHONENO = HPHONENO;
    }

    public String getOPHONENO() {
        return OPHONENO;
    }

    public void setOPHONENO(String OPHONENO) {
        this.OPHONENO = OPHONENO;
    }

    public String getMPHONENO() {
        return MPHONENO;
    }

    public void setMPHONENO(String MPHONENO) {
        this.MPHONENO = MPHONENO;
    }

    public String getFPHONENO() {
        return FPHONENO;
    }

    public void setFPHONENO(String FPHONENO) {
        this.FPHONENO = FPHONENO;
    }
}
