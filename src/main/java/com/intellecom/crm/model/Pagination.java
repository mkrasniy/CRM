package com.intellecom.crm.model;

/**
 * Created by mkrasnyi on 27.09.2016.
 */
public class Pagination {
    public String class_;
    public String val;
    public String h;

    public Pagination(String class_, String val, String h) {
        this.class_ = class_;
        this.val = val;
        this.h = h;
    }

    public String getClass_() {
        return class_;
    }

    public String getVal() {
        return val;
    }

    public String getH() {
        return h;
    }
}
