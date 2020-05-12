package com.tornado4651.design_pattern.singleton.ehan4;

public class SingletonDemo {
    public static void main(String[] args) {
        System.out.println("双重检查模式");
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2);
        System.out.println(instance);
        System.out.println(instance2);
    }
}

/**
 * 使用双重检查的懒汉式单例模式！
 */
class Singleton{
    // 注：volatile关键字，
    private static volatile Singleton instance;
    private Singleton(){}
    //
    public static Singleton getInstance(){
        // a、b线程同时到达该处，同时需要获取实例
        if (instance == null){
            // a、b同时进来，进行线程同步
            synchronized (Singleton.class){
                // a先进入，符合判断条件，获得实例
                // b后进入，不符合条件，直接返回instance
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
