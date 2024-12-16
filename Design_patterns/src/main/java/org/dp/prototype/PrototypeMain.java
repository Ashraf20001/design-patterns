package org.dp.prototype;

public class PrototypeMain {
    public static void main(String[] args) {

        Circle circle = new Circle();  // Shape Concrete object (Prototype) which we want to use for our object creation

        PrototypeClient prototypeClient = new PrototypeClient(circle);  // Prototype client for creating our concrete object

        Shape shape = prototypeClient.createShape();         // Object created through our prototype client

        shape.draw();

    }
}
