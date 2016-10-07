package com.intellecom.crm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by mkrasnyi on 06.10.2016.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.intellecom.crm.*")
public class WebAppConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/res/**").addResourceLocations("WEB-INF/resource/css/", "WEB-INF/resource/js/", "WEB-INF/resource/img/", "WEB-INF/resource/fonts/").setCachePeriod(1000);
        registry.addResourceHandler("/accounting/res/**").addResourceLocations("WEB-INF/resource/css/", "WEB-INF/resource/js/", "WEB-INF/resource/img/", "WEB-INF/resource/fonts/").setCachePeriod(1000);
        registry.addResourceHandler("/admin/res/**").addResourceLocations("WEB-INF/resource/css/", "WEB-INF/resource/js/", "WEB-INF/resource/img/", "WEB-INF/resource/fonts/").setCachePeriod(1000);
    }

    @Bean(name="viewResolver")
    public InternalResourceViewResolver setupViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);

        return resolver;
    }

}
