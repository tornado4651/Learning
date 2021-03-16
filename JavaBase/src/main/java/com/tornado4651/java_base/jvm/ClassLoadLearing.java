package com.tornado4651.java_base.jvm;

public class ClassLoadLearing {
    private static int a = 12;
    private static int b = 10;// 但是可以后声明并重新赋值，

    static {
        a = 22;
        b = 100;
//        System.out.println(b); // 报错，不可以声明前调用
    }

    public static void main(String[] args) {
        System.out.println("a:" + a + "   b:" + b);// a:22  b:10
    }
}
