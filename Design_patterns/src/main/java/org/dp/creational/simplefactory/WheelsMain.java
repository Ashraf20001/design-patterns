package org.dp.creational.simplefactory;

public class WheelsMain {
    public static void main(String[] args) {
        WheelsFactory wheelsFactory = new WheelsFactory();
        WheelInterface wheel = wheelsFactory.getWheel(3);
        System.out.println(wheel.toString());
    }
}
