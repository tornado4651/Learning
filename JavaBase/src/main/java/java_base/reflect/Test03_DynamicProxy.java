package java_base.reflect;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理实例：
 */
public class Test03_DynamicProxy {
    public static void main(String[] args) {
        // 创建实例
        ClothFactory nikeFactory = new NikeFactory();
        // 通过任意实例 获取 动态代理类
        ClothFactory proxyNikeFactory = (ClothFactory) DynamicProxyFactory.getProxyInstance(nikeFactory);
        // 通过动态代理类执行实例的方法。
        proxyNikeFactory.produceClothe();
        proxyNikeFactory.producePaints();
    }
}


/**
 * 动态代理工厂
 */
class DynamicProxyFactory {
    /*
        获取指定对象的代理实例
     */
    public static Object getProxyInstance(Object obj) {
        Myhandler myhandler = new Myhandler(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), myhandler);
    }
}


/**
 * 自定义的代理调用方法处理器
 */
class Myhandler implements InvocationHandler {
    // 存储"被代理类"的实例，方法调用时使用
    private final Object object;

    // 指定构造时就必须赋值"被代理类"
    public Myhandler(Object obj) {
        this.object = obj;
    }

    /*
        handler中主要方法，即通过反射机制，执行被代理类的方法
        形参说明：
            proxy：代理类对象
            method：所代理的方法
            args：代理方法的形参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行代理方法前的操作......");
        Object returnValue = method.invoke(object, args);
        System.out.println("执行代理方法前的操作......");
        return returnValue;
    }
}

