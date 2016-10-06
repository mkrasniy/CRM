package com.intellecom.crm.model;

/**
 * Created by MKrasnyi on 06.05.2016.
 */
public class CustomerRate {
    private int rn;
    private String accountnumber;
    private String accountname;
    private String bs;
    private String staff;
    private int rate;
    private int type;

    private String comm;
    private String dt;
    private int max_rn;

    public CustomerRate() {
    }

    public CustomerRate(int rn, String accountnumber, String accountname, String bs, String staff, int rate, int type, String comm, String dt, int max_rn) {
        this.rn = rn;
        this.accountnumber = accountnumber;
        this.accountname = accountname;
        this.bs = bs;
        this.staff = staff;
        this.rate = rate;
        this.type = type;
        this.comm = comm;
        this.dt = dt;
        this.max_rn = max_rn;
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

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getComm() {
        return comm;
    }

    public void setComm(String comm) {
        this.comm = comm;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public String getDt() {
        return dt;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
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
