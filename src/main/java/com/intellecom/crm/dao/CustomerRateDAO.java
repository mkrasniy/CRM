package com.intellecom.crm.dao;


import java.util.List;

import com.intellecom.crm.model.CustomerRate;

/**
 * Created by MKrasnyi on 06.05.2016.
 */
public interface CustomerRateDAO {

     List<CustomerRate> list(int start, int end);

}