package com.tornado4651.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 使用xml配置文件配置切面，无需aop相关注解
 */
@Component
@Aspect
public class DemoCut02 {
    /**
     * 定义目标接入点
     */
    @Pointcut(value = "execution(* com.tornado4651.spring.aop.service..*.*(..))")
    public void cut() {
    }

    /**
     * 前置通知
     */
    @Before(value = "cut()")
    public void before() {
        System.out.println("前置通知。。。");
    }

    /**
     * 返回通知
     */
    @AfterReturning(value = "cut()")
    public void afterReturn() {
        System.out.println("返回通知。。。");
    }

    /**
     * 最终通知
     */
    @After(value = "cut()")
    public void after() {
        System.out.println("最终通知。。。");
    }

    /**
     * 异常通知
     */
    @AfterThrowing(value = "cut()", throwing = "exception")
    public void afterThrow(Exception exception) {
        System.out.println("异常通知。。。");
    }

    /**
     * 环绕通知
     */
    @Around(value = "cut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        Object result = null;
        System.out.println("环绕通知——前置通知。。。。");
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕通知——异常通知。。。");
        } finally {
            System.out.println("环绕通知——最终通知。。。");
        }
        System.out.println("环绕通知——返回通知。。。");
        return result;

    }
}