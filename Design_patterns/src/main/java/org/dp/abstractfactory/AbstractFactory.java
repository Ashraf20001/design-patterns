package org.dp.abstractfactory;

public interface AbstractFactory {
    Car createCars();
    Specifications displaySpecs();
}

class IndiaFactory implements AbstractFactory{

    @Override
    public Car createCars() {
        return new Honda();
    }

    @Override
    public Specifications displaySpecs() {
        return new IndianCarsSpecs();
    }
}
class AmericanFactory implements AbstractFactory{

    @Override
    public Car createCars() {
        return new Jaguar();
    }

    @Override
    public Specifications displaySpecs() {
        return new AmericanCarsSpecs();
    }
}

interface Car{
    void assemble();
}

class Honda implements Car{

    @Override
    public void assemble() {
        System.out.println("Honda cars are assembled");
    }
}

class Jaguar implements Car{
    @Override
    public void assemble(){
        System.out.println("Jaguar cars are assembled");
    }
}

interface  Specifications{
    void display();
}


class IndianCarsSpecs implements Specifications{

    @Override
    public void display() {
        System.out.println("Indian cars specs are displayed now");
    }
}

class AmericanCarsSpecs implements Specifications{

    @Override
    public void display() {
        System.out.println("American cars specs are displayed now");
    }
}