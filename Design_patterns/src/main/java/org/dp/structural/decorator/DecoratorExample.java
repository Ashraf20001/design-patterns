package org.dp.structural.decorator;

public class DecoratorExample {
    public static void main(String[] args) {
        Coffee plainCoffee = new PlainCoffee();
        MilkDecorator milkDecorator = new MilkDecorator(plainCoffee);
        System.out.println(milkDecorator.getDescription());

        // With Milk and cream
        CreamDecorator creamDecorator = new CreamDecorator(milkDecorator);
        System.out.println(creamDecorator.getDescription());
    }
}


interface Coffee {    // Common Interface
    String getDescription();
    Integer getCost();
}

class PlainCoffee implements Coffee{   // Concrete product of coffee

    /**
     *
     */
    @Override
    public String getDescription() {
        return "Plain Coffee";
    }

    /**
     *
     */
    @Override
    public Integer getCost() {
        return 20;
    }
}

/**
 *  Decorator class which is abstract in nature and it implements common interface.
 *  It contains the reference of concrete product interface to apply decoration / add-on functionality to
 *  concrete product.
 *  With this way , the original concrete product is unaffected and the decorator functionalities
 *  can be added to it seamlessly.
 */


abstract  class Decorator implements  Coffee {

    protected  Coffee coffeeDecorator;


    public Decorator(Coffee coffeeDecorator){
        this.coffeeDecorator = coffeeDecorator;
    }

    /**
     *
     */
    @Override
    public String getDescription() {
        return coffeeDecorator.getDescription();
    }

    /**
     *
     */
    @Override
    public Integer getCost() {
        return coffeeDecorator.getCost();
    }

}

class MilkDecorator extends Decorator{   // Concrete Decorator

    public MilkDecorator(Coffee coffeeDecorator) {
        super(coffeeDecorator);
    }

    @Override
    public String getDescription() {
       return super.getDescription()+" , Milk";
    }

    @Override
    public Integer getCost() {
        return super.getCost() + 5;
    }
}


class CreamDecorator extends Decorator {

    public CreamDecorator(Coffee coffeeDecorator) {
        super(coffeeDecorator);
    }

    @Override
    public String getDescription() {
        return super.getDescription()+" , Cream";
    }

    @Override
    public Integer getCost() {
        return super.getCost()+10;
    }
}


