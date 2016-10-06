package com.intellecom.crm.dao;

import com.intellecom.crm.model.AccountHistory;

import java.util.List;

/**
 * Created by MKrasnyi on 11.05.2016.
 */
public interface AccountHistoryDAO {
    List<AccountHistory> listHistory(String accountnumber);
}
