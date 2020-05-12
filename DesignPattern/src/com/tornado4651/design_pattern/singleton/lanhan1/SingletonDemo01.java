package com.tornado4651.design_pattern.singleton.lanhan1;

public class SingletonDemo01 {
    public static void main(String[] args) {
        // 在使用Singleton的方法时，已经实例化了Singleton类
        // 也就实例化了静态成员instance。
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());

    }
}

/**
 * "饿汉式（之静态常量式）"的"单例模式"
 */
class Singleton{
    // 将成员变量直接实例化
    // static保证单一，不会分配其他内存地址
    // final保证不会被改写
    private final static Singleton instance = new Singleton();
    // 将构造器私有化，防止创建多个实例
    private Singleton(){
    }
    // 对外提供一个公共接口，获取实例
    // static修饰，保证能够调用静态成员
    public static Singleton getInstance(){
        return instance;
    }
}
