package com.tornado4651.java_base.test;

class A {
    static {
        System.out.println("2");
    }

    public A() {
        System.out.println("1");
    }
}

class B extends A {
    static {
        System.out.println("b");
    }

    public B() {
        System.out.println("a");
    }
}


public class TestClass {
    private static int x = 100;

    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        testClass.x++;
        TestClass testClass2 = new TestClass();
        testClass2.x++;
        testClass = new TestClass();
        testClass.x++;
        --TestClass.x;

        System.out.println(x--);
    }
}
