package com.intellecom.crm.model;

/**
 * Created by MKrasnyi on 11.05.2016.
 */
public class BillPay {
    private String REALCUSTOMER;
    private String DOCUMENTNAME;
    private String DOC_TYP;
    private String REAL_DAT_STR;
    private float PSUM;
    private String COMMENTS;
    private float BALANCE;

    public BillPay() {
    }



    public String getREALCUSTOMER() {
        return REALCUSTOMER;
    }

    public void setREALCUSTOMER(String REALCUSTOMER) {
        this.REALCUSTOMER = REALCUSTOMER;
    }

    public String getDOCUMENTNAME() {
        return DOCUMENTNAME;
    }

    public void setDOCUMENTNAME(String DOCUMENTNAME) {
        this.DOCUMENTNAME = DOCUMENTNAME;
    }

    public String getDOC_TYP() {
        return DOC_TYP;
    }

    public void setDOC_TYP(String DOC_TYP) {
        this.DOC_TYP = DOC_TYP;
    }

    public String getREAL_DAT_STR() {
        return REAL_DAT_STR;
    }

    public void setREAL_DAT_STR(String REAL_DAT_STR) {
        this.REAL_DAT_STR = REAL_DAT_STR;
    }


    public float getPSUM() {
        return PSUM;
    }

    public void setPSUM(float PSUM) {
        this.PSUM = PSUM;
    }

    public float getBALANCE() {
        return BALANCE;
    }

    public void setBALANCE(float BALANCE) {
        this.BALANCE = BALANCE;
    }

    public String getCOMMENTS() {
        return COMMENTS;
    }

    public void setCOMMENTS(String COMMENTS) {
        this.COMMENTS = COMMENTS;
    }


}
