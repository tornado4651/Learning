package com.tornado4651.spring.ioc.service;

import com.tornado4651.spring.ioc.dao.UserDao;

public class UserService {
    private UserDao userDao;

    public UserService() {
    }

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void test() {
        System.out.println("UserService test......");
        userDao.test();
    }
}
