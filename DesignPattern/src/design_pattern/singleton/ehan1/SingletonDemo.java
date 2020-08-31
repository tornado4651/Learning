package design_pattern.singleton.ehan1;

public class SingletonDemo {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance);
        System.out.println(instance2);
    }
}

/**
 * 懒汉式单例模式，线程安全
 */
class Singleton{
    private static Singleton instance;

    private Singleton(){}

    // 懒汉式：提供一个共有的方法，当使用到该方法时，才去创建instance
    public static synchronized Singleton getInstance(){
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
