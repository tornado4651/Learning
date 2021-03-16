package com.tornado4651.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("user")
public class UserController {


    @GetMapping("hello")
    public String hello() {
        log.info("hello接口被访问！");
        return "hello,world";
    }

}
