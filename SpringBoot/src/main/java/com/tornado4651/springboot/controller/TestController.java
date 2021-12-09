package com.tornado4651.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ljf
 * @date 2021年09月17日
 */
@RestController
public class TestController {

    private static int tickets = 100;

    @GetMapping("sleepTest")
    public String longSleep() throws InterruptedException {
        Thread.sleep(1000 * 30);
        return "票数余额：" + tickets;
    }


    @GetMapping("buyticket")
    public String buyTicket() {
        tickets -= 1;
        return "购买成功！票数余额：" + tickets;
    }

    @GetMapping("returnTickets")
    public String returnTicket() {
        tickets += 1;
        return "退票成功！票数余额：" + tickets;
    }

    @GetMapping("checkTickets")
    public String checkTicket() {
        return "票数余额：" + tickets;
    }

}
