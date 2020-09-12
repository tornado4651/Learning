package design_pattern.principle.dependency_inversion;

public class DependencyInversion2 {
    public static void main(String[] args) {
        Person2 jack = new Person2();
        // 由于使用的接口依赖反转，所以使用的时候不需要作出任何改变，传入具体的实现类即可
        jack.receive(new Email2());
        jack.receive(new Weixin());
    }
}

/**
 * 改进方法：引入一个抽象接口IReceiver，这样将Person的receive方法与OReceiver发生依赖
 *         这样一来将所有具体信息类实现IReceiver就可以了
 * 方式2：创建一个接口，将Person的参数设置为对接口的依赖
 */
interface IReceiver{
    String getInfo();
}

class Person2{
    public void receive(IReceiver iReceiver){
        System.out.println("接受到" + iReceiver.getInfo());
    }
}

class Email2 implements IReceiver{
    public String getInfo(){
        return "电子邮件：hello,world!";
    }
}
class Weixin implements IReceiver{
    public String getInfo(){
        return "微信消息：hello,world!";
    }
}