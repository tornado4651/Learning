package com.tornado4651.spring.ioc.factory;

import com.tornado4651.spring.ioc.entity.User;

/**
 * 创建自定义静态工厂类
 */
public class StaticFactory {

    /**
     * 自定义静态方法，返回想要的实例化对象
     */
    public static User createUser() {
        User user = new User();
        // 对bean对象的其他操作
        return user;
    }

}
