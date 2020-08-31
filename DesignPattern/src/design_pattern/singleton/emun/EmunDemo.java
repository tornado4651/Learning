package design_pattern.singleton.emun;

public class EmunDemo {
    public static void main(String[] args) {
        Singleton instance = Singleton.INSTANCE;
        Singleton instance2 = Singleton.INSTANCE;
        System.out.println(instance == instance2);
        instance.doSth();
    }
}

enum Singleton{
    INSTANCE;
    public void doSth(){
        System.out.println("Do SomeThing......");
    }
}
