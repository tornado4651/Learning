package com.tornado4651.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

/**
 * 使用xml配置文件配置切面，无需aop相关注解
 */
@Component// 只需要一个Component注解将该切面放入Spring IOC容器中自动成为一个bean即可
public class DemoCut01 {
    /**
     * 定义目标接入点
     */
    public void target() {
    }

    /**
     * 前置通知
     */
    public void before() {
        System.out.println("前置通知。。。");
    }

    /**
     * 返回通知
     */
    public void afterReturn() {
        System.out.println("返回通知。。。");
    }

    /**
     * 最终通知
     */
    public void after() {
        System.out.println("最终通知。。。");
    }

    /**
     * 异常通知
     */
    public void afterThrow() {
        System.out.println("异常通知。。。");
    }

    /**
     * 环绕通知
     */
    public Object around(ProceedingJoinPoint joinPoint) {
        Object result = null;
        System.out.println("环绕通知——前置通知。。。");
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