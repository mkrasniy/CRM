package com.intellecom.crm.dao;

import com.intellecom.crm.model.Account;

import java.util.List;

/**
 * Created by MKrasnyi on 10.05.2016.
 */
public interface AccountDAO {
     Account getAccount(String accnumber);
     List<Account> searchAccount(int type, String value);
}
