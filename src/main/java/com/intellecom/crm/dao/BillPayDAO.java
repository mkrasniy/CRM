package com.intellecom.crm.dao;

import com.intellecom.crm.model.BillPay;

import java.util.List;

/**
 * Created by MKrasnyi on 10.05.2016.
 */
public interface BillPayDAO {
    public List<BillPay> getBillPay(String accnumber);
}
