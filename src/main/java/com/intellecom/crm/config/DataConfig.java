package com.intellecom.crm.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by mkrasnyi on 29.09.2016.
 */
@Configuration
@ComponentScan("com.intellecom.crm.*")
@PropertySource("classpath:db.properties")
public class DataConfig extends WebMvcConfigurerAdapter {

    private static final String PROP_DATABASE_DRIVER = "db.driver";
    private static final String PROP_DATABASE_PASSWORD = "db.password";
    private static final String PROP_DATABASE_URL = "db.url";
    private static final String PROP_DATABASE_USERNAME = "db.username";

    private static final String PROP_DATABASE_CRM_DRIVER = "db_crm.driver";
    private static final String PROP_DATABASE_CRM_PASSWORD = "db_crm.password";
    private static final String PROP_DATABASE_CRM_URL = "db_crm.url";
    private static final String PROP_DATABASE_CRM_USERNAME = "db_crm.username";

    private static final String PROP_DATABASE_MAIN_DRIVER = "db_main.driver";
    private static final String PROP_DATABASE_MAIN_PASSWORD = "db_main.password";
    private static final String PROP_DATABASE_MAIN_URL = "db_main.url";
    private static final String PROP_DATABASE_MAIN_USERNAME = "db_main.username";

    @Resource
    Environment env;

    @Bean
    public DataSource dataSourceMain(){
        BasicDataSource ds = new ConfDS(PROP_DATABASE_MAIN_DRIVER,PROP_DATABASE_MAIN_URL,PROP_DATABASE_MAIN_USERNAME,PROP_DATABASE_MAIN_PASSWORD,3);
        return ds;
    }

    @Bean
    public DataSource oraDataSource() {
        BasicDataSource ds = new ConfDS(PROP_DATABASE_DRIVER,PROP_DATABASE_URL,PROP_DATABASE_USERNAME,PROP_DATABASE_PASSWORD,2);

        return ds;
    }

    @Bean
    public DataSource dataSourceCRM(){
        BasicDataSource ds = new ConfDS(PROP_DATABASE_CRM_DRIVER,PROP_DATABASE_CRM_URL,PROP_DATABASE_CRM_USERNAME,PROP_DATABASE_CRM_PASSWORD,2);

        return ds;
    }


    class ConfDS extends BasicDataSource {
    public ConfDS(String driver, String url, String uname, String pwd, int initSize) {
        super.setDriverClassName(driver);
        super.setUrl(url);
        super.setUsername(uname);
        super.setPassword(pwd);
        super.setInitialSize(initSize);
    }
}
}
