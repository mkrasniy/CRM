package com.intellecom.crm.config;

import com.sun.xml.internal.ws.api.server.ThreadLocalContainerResolver;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by mkrasnyi on 29.09.2016.
 */
@Configuration
@EnableTransactionManagement
@ComponentScan("com.intellecom.crm")
@PropertySource("classpath:db.properties")
@EnableJpaRepositories("com.intellecom.repositories")
public class DataConfig {

    private static final String PROP_DATABASE_DRIVER = "db.driver";
    private static final String PROP_DATABASE_PASSWORD = "db.password";
    private static final String PROP_DATABASE_URL = "db.url";
    private static final String PROP_DATABASE_USERNAME = "db.username";
    private static final String PROP_HIBERNATE_DIALECT = "db.hibernate.dialect";
    private static final String PROP_HIBERNATE_SHOW_SQL = "db.hibernate.show_sql";
    private static final String PROP_ENTITYMANAGER_PACKAGES_TO_SCAN = "db.entitymanager.packages.to.scan";
    private static final String PROP_HIBERNATE_HBM2DDL_AUTO = "db.hibernate.hbm2ddl.auto";

    @Resource
    Environment env;

    @Bean
    public DataSource oraDataSource() {
        BasicDataSource ds = new BasicDataSource();

        ds.setDriverClassName(PROP_DATABASE_DRIVER);
        ds.setUrl(PROP_DATABASE_URL);
        ds.setUsername(PROP_DATABASE_USERNAME);
        ds.setPassword(PROP_DATABASE_PASSWORD);
        ds.setInitialSize(5);

        return ds;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean lf = new LocalContainerEntityManagerFactoryBean();
        lf.setDataSource(oraDataSource());
        lf.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        lf.setPackagesToScan(env.getRequiredProperty(PROP_ENTITYMANAGER_PACKAGES_TO_SCAN));
        lf.setJpaProperties(getHibernateProperties());

        return lf;
    }

    @Bean
    public JpaTransactionManager txMan(){
        JpaTransactionManager jtxm = new JpaTransactionManager();
        jtxm.setEntityManagerFactory(entityManagerFactory().getObject());
        return jtxm;
    }
    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put(PROP_HIBERNATE_DIALECT, env.getRequiredProperty(PROP_HIBERNATE_DIALECT));
        properties.put(PROP_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROP_HIBERNATE_SHOW_SQL));
        properties.put(PROP_HIBERNATE_HBM2DDL_AUTO, env.getRequiredProperty(PROP_HIBERNATE_HBM2DDL_AUTO));

        return properties;
    }


}
