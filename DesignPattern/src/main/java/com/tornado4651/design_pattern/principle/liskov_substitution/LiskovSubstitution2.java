package com.tornado4651.design_pattern.principle.liskov_substitution;

public class LiskovSubstitution2 {
    public static void main(String[] args) {
        A2 a = new A2();
        System.out.println("11 - 8 = " + a.func1(11,8));

        System.out.println("----------------");

        // 因为B类不再继承A类，所以不会出现调用理解错误
        B2 b = new B2();
        System.out.println("12 + 5 = " + b.func1(12,5));
        System.out.println("(12 + 5) * 10 = " + b.func2(12,5));
        System.out.println("12 - 5 = " + b.func3(12,5));
    }
}

abstract class Base{
    public abstract int func1(int a, int b);
}

class A2 extends Base{
    public int func1(int a, int b) {
        return a - b;
    }
}

class B2 extends Base{
    // 将A2和B2"组合"起来，虽然A2和B2同级了，但是还能使用A2的方法
    private A2 a = new A2();
    public int func1(int a, int b) {
        return a + b;
    }
    public int func2(int a, int b) {
        return func1(a,b)*10;
    }
    // 通过组合的方式调用方法
    public int func3(int a, int b){
        return this.a.func1(a,b);
    }
}