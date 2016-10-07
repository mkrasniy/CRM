package com.intellecom.crm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by mkrasnyi on 07.10.2016.
 */
@Configuration
@EnableWebSecurity
@Import(DataConfig.class)
@ComponentScan("com.intellecom.crm.*")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataConfig dataConfig;

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataConfig.dataSourceMain())
                .usersByUsernameQuery("select username,password, enabled from users where username=?")
                .authoritiesByUsernameQuery("select username, role from user_roles where username =?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/admin**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/accounting**").access("hasRole('ROLE_USER')")
                .antMatchers("/accounting/**").access("hasRole('ROLE_USER')")
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/").permitAll()
                .and()
                    .formLogin().loginPage("/login")
                    .defaultSuccessUrl("/admin/listCustomers")
                    .failureUrl("/login?error")
                    .usernameParameter("username").passwordParameter("password")
                .and()
                    .logout().logoutSuccessUrl("/login?logout")
                .and()
                    .exceptionHandling().accessDeniedPage("/403")
                .and()
                    .csrf();

        super.configure(http);
    }

}
