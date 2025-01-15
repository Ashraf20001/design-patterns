package org.dp.structural.bridge;

public abstract class Vehicle {   // Bridge the abstraction and implementation

    protected Workshop workshop1;
    protected Workshop workshop2;

    protected Vehicle (Workshop workshop1, Workshop workshop2){
        this.workshop1 = workshop1;
        this.workshop2 = workshop2;
    }

    public abstract  void manufacture();

}


interface  Workshop{
    void work();
}

class Car extends Vehicle {

    protected Car(Workshop workshop1, Workshop workshop2) {
        super(workshop1, workshop2);
    }

    /**
     *
     */
    @Override
    public void manufacture() {
        System.out.print("Car");
        workshop1.work();
        workshop2.work();
    }
}

class Produce implements  Workshop {

    /**
     *
     */
    @Override
    public void work() {
        System.out.println("Produced");

    }
}
class Assemble implements  Workshop {

    /**
     *
     */
    @Override
    public void work() {
        System.out.println("And");
        System.out.println("Assembled");

    }
}
