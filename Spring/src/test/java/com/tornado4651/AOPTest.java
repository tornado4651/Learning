package com.tornado4651;


import com.tornado4651.spring.aop.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {

    /**
     * 测试1：测试AOP切面（xml实现）
     */
    @Test
    public void testAop() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop/spring01.xml");
        UserService userService = applicationContext.getBean(UserService.class);
        userService.test();
    }

    /**
     * 测试2：测试AOP切面（注解实现）
     */
    @Test
    public void testAop02() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop/spring02.xml");
        UserService userService = applicationContext.getBean(UserService.class);
        userService.test();

    }
}
