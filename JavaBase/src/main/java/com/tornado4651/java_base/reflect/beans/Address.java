package com.tornado4651.java_base.reflect.beans;

public class Address {
    public String City;
    public String building;

    public Address(String city, String building) {
        City = city;
        this.building = building;
    }

    public Address() {
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    @Override
    public String toString() {
        return "Address{" +
                "City='" + City + '\'' +
                ", building='" + building + '\'' +
                '}';
    }
}
