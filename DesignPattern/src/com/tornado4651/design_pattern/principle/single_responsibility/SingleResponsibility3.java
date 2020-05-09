package com.tornado4651.design_pattern.principle.single_responsibility;

public class SingleResponsibility3 {
    public static void main(String[] args) {
        Vehicle2 vehicle2 = new Vehicle2();
        vehicle2.runRoad("汽车");
        vehicle2.runAir("飞机");
        vehicle2.runWater("潜水艇");
    }
}

// 解决方法2：
// 虽然没有在类的级别上使用单一原则，但是在方法的级别上运用了单一职责原则
class Vehicle2{
    public void runRoad(String vehicle){
        System.out.println(vehicle+"在路上运行。。。");
    }
    public void runAir(String vehicle){
        System.out.println(vehicle+"在天上运行。。。");
    }
    public void runWater(String vehicle){
        System.out.println(vehicle+"在水上运行。。。");
    }
}