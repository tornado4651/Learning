package com.tornado4651.design_pattern.principle.interface_segregation;

public class Segregation2 {
    public static void main(String[] args) {
        A2 a = new A2();
        a.depend1(new B2());
        a.depend2(new B2());
        a.depend3(new B2());
        C2 c = new C2();
        c.depend1(new D2());
        c.depend4(new D2());
        c.depend5(new D2());
    }
}

interface Interface1{
    void method1();
}

interface Interface2{
    void method2();
    void method3();
}

interface Interface3{
    void method4();
    void method5();
}

/**
 * B类实现interface1
 */
class B2 implements Interface1,Interface2{

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
}

/**
 * D类实现interface1
 */
class D2 implements Interface1,Interface3{

    @Override
    public void method1() {
        System.out.println("D实现了interface1的method1");
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

class A2{
    public void depend1(Interface1 interface1){
        interface1.method1();
    }
    public void depend2(Interface2 interface2){
        interface2.method2();
    }
    public void depend3(Interface2 interface2){
        interface2.method3();
    }
}

class C2{

    public void depend1(Interface1 interface1){
        interface1.method1();
    }
    public void depend4(Interface3 interface3){
        interface3.method4();
    }
    public void depend5(Interface3 interface3){
        interface3.method5();
    }
}