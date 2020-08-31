package design_pattern.singleton.staticinnerclass;

public class StaticInnerClassDemo {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println("instance: " + instance);
        System.out.println("instance2: " + instance2);
    }
}

/**
 * 使用静态内部类实现单例模式
 */
class Singleton{
    // 构造器私有化
    private Singleton(){}

    // 静态内部类，该类中有一个静态属性Singleton
    private static class SingletonInstance{
        private static final Singleton INSTAANCE = new Singleton();
    }

    //提供一个静态的共有方法，直接返回SingletonInstance.INSTANCE
    public static synchronized Singleton getInstance(){
        return SingletonInstance.INSTAANCE;
    }
}