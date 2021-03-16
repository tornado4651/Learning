package com.tornado4651.design_pattern.singleton.ehan3;

public class SingletonDemo {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance);
        System.out.println(instance2);
    }
}

/**
 * 懒汉式单例模式，同步代码块
 */
class Singleton{
    private static Singleton instance;

    private Singleton(){}

    // 懒汉式：提供一个共有的方法，当使用到该方法时，才去创建instance
    // 加入同步处理的代码，解决线程安全问题
    public static Singleton getInstance(){
        if (instance == null){
            synchronized(Singleton.class){
                instance = new Singleton();
            }
        }
        return instance;
    }
}
