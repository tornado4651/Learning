package com.tornado4651;

import com.tornado4651.spring.ioc.dao.AccountDao;
import com.tornado4651.spring.ioc.entity.MyBean;
import com.tornado4651.spring.ioc.entity.User;
import com.tornado4651.spring.ioc.service.AccountService;
import com.tornado4651.spring.ioc.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class IOCTest {
    /**
     * 测试1：测试三种不同实例化bean的方式
     * 对应配置文件spring.xml、spring02.xml、spring03.xml
     */
    @Test
    public void testGetBean() {
        // 1、构造bean工厂
        BeanFactory factory = new ClassPathXmlApplicationContext("ioc/spring.xml");
//        BeanFactory factory = new ClassPathXmlApplicationContext("spring02.xml");
//        BeanFactory factory = new ClassPathXmlApplicationContext("spring03.xml");
        // 2、使用bean工厂的getBean方法从IOC容器中获得bean实例化对象（空构造器）
        User user = (User) factory.getBean("user");
        // 3、测试可用性是否获得
        user.speak();
    }


    /**
     * 测试2：测试两种不同依赖注入的方法：
     * 对应配置文件springp04.xml、spring05.xml
     */
    @Test
    public void testDepandencyInvocation() {
        // 1、根据配置文件构造IOC容易：bean工厂
//        BeanFactory factory = new ClassPathXmlApplicationContext("spring04.xml");     //set方法注入
        BeanFactory factory = new ClassPathXmlApplicationContext("ioc/spring05.xml");       // 构造器方法注入
        // 2、从bean工厂中获取想要的实例化bean对象
        UserService userService = (UserService) factory.getBean("userService");
        // 3、测试获取到的bean对象可用性
        userService.test();
    }


    /**
     * 测试3：测试自动化装配
     * 对应配置文件spring06.xml
     */
    @Test
    public void testAutoAnnotation() {

        ApplicationContext context = new ClassPathXmlApplicationContext("ioc/spring06.xml");

        AccountService accountService = (AccountService) context.getBean("accountService");

        accountService.test();
    }

    /**
     * 测试4：测试bean的作用域（singleton 与 prototype）
     */
    @Test
    public void testScope() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc/spring08.xml");

        // 获取两次 单例作用域 的bean,是同一个对象
        AccountDao accountDao01 = (AccountDao) context.getBean("accountDao");
        AccountDao accountDao02 = (AccountDao) context.getBean("accountDao");
        System.out.println("accountDao01: " + accountDao01 + "\naccountDao02: " + accountDao02);

        // 获取两次 原型作用域 的bean，每次取出的对象不同
        AccountService accountService01 = (AccountService) context.getBean("accountService");
        AccountService accountService02 = (AccountService) context.getBean("accountService");
        System.out.println("AccountService01: " + accountService01 + "\nAccountService02: " + accountService02);
    }

    /**
     * 测试5：测试bean的生命周期
     * 定义 —— 初始化 —— 使用 —— 销毁
     */
    @Test
    public void testBeanLife() {
        // 这里产生了spring的ioc容器时，便已经实例化了bean
        AbstractApplicationContext abstractContext = new ClassPathXmlApplicationContext("ioc/spring09.xml");
        MyBean myBean = (MyBean) abstractContext.getBean("mybean");
        System.out.println("使用mybean: " + myBean);

        // 销毁bean，即关闭Spring IOC容器时自动执行指定的销毁方法
        abstractContext.close();
    }

}
