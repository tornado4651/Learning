package design_pattern.principle.single_responsibility;

public class SingleResponsibility2 {
    public static void main(String[] args) {
        RoadVehicle roadVehicle = new RoadVehicle();
        roadVehicle.run("摩托车");
        AirVehicle airVehicle = new AirVehicle();
        airVehicle.run("飞机");
        WaterVehicle waterVehicle = new WaterVehicle();
        waterVehicle.run("潜水艇");
    }
}

// 解决方法1：根据交通工具的不同，创造不同职责的类
class RoadVehicle{
    public void run(String vehicle){
        System.out.println(vehicle+"在公路上跑......");
    }
}

class AirVehicle{
    public void run(String vehicle){
        System.out.println(vehicle+"在天上飞......");
    }
}

class WaterVehicle{
    public void run(String vehicle){
        System.out.println(vehicle+"在水中运行......");
    }
}