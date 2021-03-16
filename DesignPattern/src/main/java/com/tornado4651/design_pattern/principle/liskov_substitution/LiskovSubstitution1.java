package com.tornado4651.design_pattern.principle.liskov_substitution;

public class LiskovSubstitution1 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println("11 - 8 = " + a.func1(11,8));

        System.out.println("--------由于继承关系重写后带来的错误--------");

        // 由于继承关系重写后带来的错误
        B b = new B();
        System.out.println("12 - 5 = " + b.func1(12,5));
        System.out.println("(12 - 5) * 10 = " + b.func2(12,5));
    }
}

class A {
    public int func1(int a, int b) {
        return a - b;
    }
}

class B extends A {
    public int func1(int a, int b) {
        return a + b;
    }
    public int func2(int a, int b) {
        return func1(a,b)*10;
    }
}