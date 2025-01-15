package org.dp.structural.bridge;

public class BridgeClient {
    public static void main(String[] args) {
        Car car = new Car(new Produce(),new Assemble());
        car.manufacture();
    }
}
