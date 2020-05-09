package com.tornado4651.design_pattern.principle.single_responsibility;

public class SingleResponsibility1 {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("摩托车");
        vehicle.run("汽车");
        vehicle.run("飞机");

    }
}

// 在该类的方法中，违反了单一职责原则
class Vehicle{
    public void run(String vehicle){
        System.out.println(vehicle+"在路上跑......");
    }
}