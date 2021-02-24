package com.tornado4651.spring.ioc.service;

import com.tornado4651.spring.ioc.dao.AccountDao;

import javax.annotation.Resource;

public class AccountService {
    @Resource
    AccountDao accountDao;

    public void test() {
        System.out.println("AccountService......");
        accountDao.test();
    }
}
