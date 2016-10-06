package com.intellecom.crm.dao;

import java.util.List;

import com.intellecom.crm.model.CustomerInform;
/**
 * Created by MKrasnyi on 05.05.2016.
 */
public interface CustomerInformDAO {

     List<CustomerInform> list();

     List<CustomerInform> listTen();

     List<CustomerInform> listOnHold(int start, int stop);

     int add_rate(String acc, Integer type, String staff, Integer rate, String comm, String OnHold);
}
