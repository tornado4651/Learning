package com.tornado4651.springmvc.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * 自定义WebApplicationInitializer接口的实现类，
 * 程序启动时运行该实现类
 * 从而将Spring IOC容器加入到Web环境中
 */
public class MyWebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // 创建Spring MVC的转发器Dispatcher Servlet并配置mapping和启动
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet());
        dispatcher.addMapping("/");
        dispatcher.setLoadOnStartup(1);

        // 创建Spring Web的上下文环境
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        // 想环境中添加mvc配置类
        context.register(MVCConfiguration.class);
        // 设置servletContext上下文环境
        context.setServletContext(servletContext);
    }
}
