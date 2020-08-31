package design_pattern.principle.interface_segregation;

public class InterfaceSegregation1 {
    public static void main(String[] args) {
        A a = new A();
        a.depend1(new B());
        a.depend2(new B());
        a.depend3(new B());
        C c = new C();
        c.depend1(new D());
        c.depend4(new D());
        c.depend5(new D());
    }
}

interface MyInterface{
    void method1();
    void method2();
    void method3();
    void method4();
    void method5();
}

/**
 * B类实现interface1
 */
class B implements MyInterface{

    @Override
    public void method1() {
        System.out.println("B实现了interface1的method1");
    }

    @Override
    public void method2() {
        System.out.println("B实现了interface1的method2");
    }

    @Override
    public void method3() {
        System.out.println("B实现了interface1的method3");
    }

    @Override
    public void method4() {
        System.out.println("B实现了interface1的method4");
    }

    @Override
    public void method5() {
        System.out.println("B实现了interface1的method5");
    }
}

/**
 * D类实现interface1
 */
class D implements MyInterface{

    @Override
    public void method1() {
        System.out.println("D实现了interface1的method1");
    }

    @Override
    public void method2() {
        System.out.println("D实现了interface1的method2");
    }

    @Override
    public void method3() {
        System.out.println("D实现了interface1的method3");
    }

    @Override
    public void method4() {
        System.out.println("D实现了interface1的method4");
    }

    @Override
    public void method5() {
        System.out.println("D实现了interface1的method5");
    }
}

class A{
    public void depend1(MyInterface interface1){
        interface1.method1();
    }
    public void depend2(MyInterface interface1){
        interface1.method2();
    }
    public void depend3(MyInterface interface1){
        interface1.method3();
    }
}

class C{

    public void depend1(MyInterface interface1){
        interface1.method1();
    }
    public void depend4(MyInterface interface1){
        interface1.method4();
    }
    public void depend5(MyInterface interface1){
        interface1.method5();
    }
}