package com.intellecom.crm.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Created by mkrasnyi on 06.10.2016.
 */
public class Initializer implements WebApplicationInitializer {
    private static final String DISPATCHER_SERVLET_NAME="dispatcher";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();

        ctx.register(WebAppConfig.class);

        servletContext.add
    }
}
