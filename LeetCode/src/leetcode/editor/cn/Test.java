package leetcode.editor.cn;


class Parent{
    int i = 100;
}

class  Son extends Parent {
    void say(){
        System.out.println(i);
    };
}


public class Test {
    public static void sayHello(){
        System.out.println("hello");
    }
    public static void main(String[] args){
        Test t = null;
        t.sayHello();
    }
}
