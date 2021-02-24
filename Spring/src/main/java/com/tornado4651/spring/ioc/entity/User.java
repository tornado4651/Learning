package com.tornado4651.spring.ioc.entity;

public class User {
    private String name;
    private Integer age;

    public User() {
        System.out.println("asdfasfd");
    }

    public void speak() {
        System.out.println("user说话。。。");
    }
}
