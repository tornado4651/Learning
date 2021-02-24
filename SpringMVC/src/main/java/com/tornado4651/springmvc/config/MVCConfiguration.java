package com.tornado4651.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(value = "com.tornado4651.springmvc")
@EnableWebMvc
public class MVCConfiguration {
    @Bean
    public InternalResourceViewResolver getSourceResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();

        internalResourceViewResolver.setPrefix("/WEB-INF/jsp/");
        internalResourceViewResolver.setSuffix(".jsp");

        return internalResourceViewResolver;
    }
}
