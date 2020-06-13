package com.torando4651.leetcode;

public class Test {
    public static void main(String[] args) {
//        Map<String, String> params = new HashMap<String, String>();
//
//        params.put("name", "LJF");
//        params.put("age", "20");
//
//        System.out.println(params.keySet());
        A a = new A();
        a.getAname();
    }
}

class A{

    private String aname;

    public String getAname(){
        System.out.println("getAname");
        return aname;
    }
}