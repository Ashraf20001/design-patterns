package org.dp.prototype;

public interface Shape {
    Shape clone();
    void draw();
}

class Circle implements  Shape{

    @Override
    public Shape clone() {
        return new Circle();
    }

    @Override
    public void draw() {
        System.out.println("Circle is drawn ...");
    }
}

class Square implements  Shape{

    @Override
    public Shape clone() {
        return new Square();
    }

    @Override
    public void draw() {
        System.out.println("Square is drawn ...");
    }
}
