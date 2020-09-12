package design_pattern.principle.dependency_inversion;

public class DependencyInversion1 {
    public static void main(String[] args) {
        Person jack = new Person();
        jack.receive(new Email());
    }
}

/**
 * 获取消息方式1：参数直接使用类传参
 *      优点：容易想到，容易理解
 *      缺点，不灵活，当接受类型不是Email时，还需要别的对应接受方法
 * 改进方法：引入一个抽象接口IReceiver，这样将Person的receive方法与OReceiver发生依赖
 *         这样一来将所有具体信息类实现IReceiver就可以了
 */
class Person{
    public void receive(Email email){
        System.out.println("接受到电子邮件电子：" + email.getInfo());
    }
}

class Email{
    public String getInfo(){
        return "hello,world!";
    }
}