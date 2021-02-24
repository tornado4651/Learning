package com.tornado4651.spring.ioc.dao;

import com.tornado4651.spring.ioc.service.UserService;

public class UserDao {
    private UserService userService;

    public UserDao() {
    }

    public UserDao(UserService userService) {
        this.userService = userService;
    }

    public void test() {
        System.out.println("UserDao test.....");
        userService.test();
    }
}
