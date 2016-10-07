package com.intellecom.crm.config;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.RootLogger;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;



/**
 * Created by mkrasnyi on 06.10.2016.
 */
public class Initializer implements WebApplicationInitializer {
    private static final String DISPATCHER_SERVLET_NAME="dispatcher";
    private static final Logger log = Logger.getLogger(Initializer.class);
    @Override
    public void onStartup(ServletContext container) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();

        log.info("___________________REGISTERING CONFIGS_______________________");

        ctx.register(SecurityConfig.class,WebAppConfig.class,DataConfig.class,DAOConfig.class);

        log.info("__________________ADDING LISTENER_________________________");
        container.addListener(new ContextLoaderListener(ctx));

        ctx.setServletContext(container);

        ServletRegistration.Dynamic servlet = container.addServlet(DISPATCHER_SERVLET_NAME, new DispatcherServlet(ctx));
        log.info("________________ADDNG MAPPING______________________");
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
    }
}
