package com.intellecom.crm.model;

/**
 * Created by MKrasnyi on 05.05.2016.
 */
public class CustomerInform {

        private int rn=1;
        private String accountnumber;
        private String accountname;
        private String bs;
        private String phoneHome;
        private String phoneOffice;
        private String phoneMobile;
        private String comm;
        private String type;
        private int max_rn=1;
        public CustomerInform() {
        }

    public CustomerInform(String accountnumber, String accountname, String bs, String phoneHome, String phoneOffice, String phoneMobile, String comm, String type) {
        this.accountnumber = accountnumber;
        this.accountname = accountname;
        this.bs = bs;
        this.phoneHome = phoneHome;
        this.phoneOffice = phoneOffice;
        this.phoneMobile = phoneMobile;
        this.comm = comm;
        this.type = type;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

    public String getPhoneHome() {
        return phoneHome;
    }

    public void setPhoneHome(String phoneHome) {
        this.phoneHome = phoneHome;
    }

    public String getPhoneOffice() {
        return phoneOffice;
    }

    public void setPhoneOffice(String phoneOffice) {
        this.phoneOffice = phoneOffice;
    }

    public String getPhoneMobile() {
        return phoneMobile;
    }

    public void setPhoneMobile(String phoneMobile) {
        this.phoneMobile = phoneMobile;
    }

    public String getComm() {
        return comm;
    }

    public void setComm(String comm) {
        this.comm = comm;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRn() {
        return rn;
    }

    public void setRn(int rn) {
        this.rn = rn;
    }

    public int getMax_rn() {
        return max_rn;
    }

    public void setMax_rn(int max_rn) {
        this.max_rn = max_rn;
    }
}
