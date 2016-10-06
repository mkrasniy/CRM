package com.intellecom.crm.model;

/**
 * Created by MKrasnyi on 11.05.2016.
 */
public class AccountHistory {
    private String CHANGEDATE;
    private String ACCOUNTNUMBER;
    private String ATTRIBUTENAME;
    private String CHANGEREASON;
    private String CHANGEVALUE;
    private String OLDVALUE;
    private String CHANGEBYSTAFFNAME;

    public AccountHistory() {
    }

    public AccountHistory(String CHANGEDATE, String ACCOUNTNUMBER, String ATTRIBUTENAME, String CHANGEREASON, String CHANGEVALUE, String OLDVALUE, String CHANGEBYSTAFFNAME) {
        this.CHANGEDATE = CHANGEDATE;
        this.ACCOUNTNUMBER = ACCOUNTNUMBER;
        this.ATTRIBUTENAME = ATTRIBUTENAME;
        this.CHANGEREASON = CHANGEREASON;
        this.CHANGEVALUE = CHANGEVALUE;
        this.OLDVALUE = OLDVALUE;
        this.CHANGEBYSTAFFNAME = CHANGEBYSTAFFNAME;
    }

    public String getCHANGEDATE() {
        return CHANGEDATE;
    }

    public void setCHANGEDATE(String CHANGEDATE) {
        this.CHANGEDATE = CHANGEDATE;
    }

    public String getACCOUNTNUMBER() {
        return ACCOUNTNUMBER;
    }

    public void setACCOUNTNUMBER(String ACCOUNTNUMBER) {
        this.ACCOUNTNUMBER = ACCOUNTNUMBER;
    }

    public String getATTRIBUTENAME() {
        return ATTRIBUTENAME;
    }

    public void setATTRIBUTENAME(String ATTRIBUTENAME) {
        this.ATTRIBUTENAME = ATTRIBUTENAME;
    }

    public String getCHANGEREASON() {
        return CHANGEREASON;
    }

    public void setCHANGEREASON(String CHANGEREASON) {
        this.CHANGEREASON = CHANGEREASON;
    }

    public String getCHANGEVALUE() {
        return CHANGEVALUE;
    }

    public void setCHANGEVALUE(String CHANGEVALUE) {
        this.CHANGEVALUE = CHANGEVALUE;
    }

    public String getOLDVALUE() {
        return OLDVALUE;
    }

    public void setOLDVALUE(String OLDVALUE) {
        this.OLDVALUE = OLDVALUE;
    }

    public String getCHANGEBYSTAFFNAME() {
        return CHANGEBYSTAFFNAME;
    }

    public void setCHANGEBYSTAFFNAME(String CHANGEBYSTAFFNAME) {
        this.CHANGEBYSTAFFNAME = CHANGEBYSTAFFNAME;
    }
}
