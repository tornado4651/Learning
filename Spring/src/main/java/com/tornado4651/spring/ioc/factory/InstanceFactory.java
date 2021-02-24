package com.tornado4651.spring.ioc.factory;

import com.tornado4651.spring.ioc.entity.User;

/**
 * 实例化工厂类
 */
public class InstanceFactory {

    /**
     * 实例化方法：非静态
     */
    public User createUser() {
        User user = new User();
        // 自定义其他bean操作
        return user;
    }
}
