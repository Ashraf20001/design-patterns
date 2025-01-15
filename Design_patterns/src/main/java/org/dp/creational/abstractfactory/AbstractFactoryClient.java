package org.dp.creational.abstractfactory;

public class AbstractFactoryClient {
    public static void main(String[] args) {
        IndiaFactory indiaFactory = new IndiaFactory();
        Car indiaFactoryCars = indiaFactory.createCars();
        Specifications indianSpecifications = indiaFactory.displaySpecs();

        indiaFactoryCars.assemble();
        indianSpecifications.display();
    }
}
