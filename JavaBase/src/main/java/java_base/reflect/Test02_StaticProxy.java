package java_base.reflect;


/**
 * 公共接口
 */
interface ClothFactory {
    // 生产衣服
    void produceClothe();

    // 生产裤子
    void producePaints();
}

/**
 * 静态代理应用：
 * 使用静态代理工厂（ProxyFactory）代理实体工厂（AdidasFactory、NikeFactory）
 * 特点，静态代理工厂在定义之初就要实现和实体工厂相同的接口，否则无法代理。
 * 这样做理解性强，但是灵活性不高，无法代理其他接口的实现类
 */
public class Test02_StaticProxy {
    public static void main(String[] args) {
        // 先创建一个被代理类对象
        ClothFactory nikeFactory = new NikeFactory();
        ClothFactory adidasFactory = new AdidasFactory();
        // 创建代理类工厂，并在创建时指定要代理的对象
        ProxyFactory proxyFactory1 = new ProxyFactory(nikeFactory);
        ProxyFactory proxyFactory2 = new ProxyFactory(adidasFactory);
        // 使用代理对象执行相应方法
        proxyFactory1.produceClothe();
        proxyFactory1.producePaints();
        System.out.println("**********************");
        proxyFactory2.produceClothe();
        proxyFactory2.producePaints();
    }
}

/**
 * 代理工厂类
 */
class ProxyFactory implements ClothFactory {
    private ClothFactory target;

    public ProxyFactory(ClothFactory target) {
        this.target = target;
    }

    @Override
    public void produceClothe() {
        target.produceClothe();
    }

    @Override
    public void producePaints() {
        target.producePaints();
    }
}


/**
 * 被代理类，Nike工厂
 */
class NikeFactory implements ClothFactory {

    @Override
    public void produceClothe() {
        System.out.println("nike 工厂制造 衣服");
    }

    @Override
    public void producePaints() {
        System.out.println("nike 工厂生产 裤子");
    }
}


/**
 * 被代理类，Adidas工厂
 */
class AdidasFactory implements ClothFactory {

    @Override
    public void produceClothe() {
        System.out.println("adidas 工厂制造 衣服");
    }

    @Override
    public void producePaints() {
        System.out.println("adidas 工厂生产 裤子");
    }
}