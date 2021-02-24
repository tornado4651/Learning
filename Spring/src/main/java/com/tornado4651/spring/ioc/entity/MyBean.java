package com.tornado4651.spring.ioc.entity;

import org.springframework.beans.factory.InitializingBean;

public class MyBean implements InitializingBean {
    private String type01;

    public void myInit() {
        System.out.println("通过自定义方法myInit初始化bean。。。");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("通过实现InitializingBean接口自定义bean的初始化方法。。。。。");
    }

    public void myDestroy() {
        System.out.println("通过自定义方法myDestroy()销毁bean对象。。。。。。。");
    }
}
