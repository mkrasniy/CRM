package com.intellecom.crm.config;

import com.intellecom.crm.dao.*;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.sql.SQLException;

/**
 * Created by mkrasnyi on 07.10.2016.
 */

@Configuration
@ComponentScan("com.intellecom.crm.*")
public class DAOConfig extends WebMvcConfigurerAdapter {

    @Autowired
    DataConfig dataConfig;

    @Bean
    public CustomerInformDAO customerInformDAO() {
        CustomerInformDAOImpl  c = null;
        try {
            c = new CustomerInformDAOImpl((BasicDataSource) dataConfig.oraDataSource());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    @Bean
    public CustomerRateDAO customerRateDAO(){
        CustomerRateDAO c = null;
        try {
            c = new CustomerRateDAOImpl((BasicDataSource) dataConfig.oraDataSource());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }


    @Bean
    public AccountDAO accountDAO(){
        AccountDAO a = null;
        try {
            a = new AccountDAOImpl((BasicDataSource) dataConfig.oraDataSource(),(BasicDataSource)dataConfig.dataSourceCRM());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    @Bean
    public BillPayDAO billPayDAO(){
        BillPayDAO bp = null;
        try {
            bp = new BillPayDAOImpl((BasicDataSource)dataConfig.oraDataSource());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bp;
    }

    @Bean
    public AccountHistoryDAO accountHistoryDAO(){
        AccountHistoryDAO ah=null;
        try {
            ah = new AccountHistoryDAOImpl((BasicDataSource)dataConfig.oraDataSource());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ah;
    }
}
