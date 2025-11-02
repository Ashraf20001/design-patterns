package org.dp.behavioural;

public class MediatorExample {
    public static void main(String[] args) {
        AirPlaneTower airPlaneTower = new AirPlaneTower();
        Colleague colleague1 = new Colleague1(airPlaneTower);
        colleague1.take0ff();
        colleague1.takeOn();
    }
}

interface Colleague{
    void takeOn();
    void take0ff();
    void requestInvoke(String message);
}

interface Mediator{
    void takeOnRequest(Colleague colleague);
    void takeOffRequest(Colleague colleague);
}

// Concrete Mediator
class AirPlaneTower implements Mediator{


    @Override
    public void takeOnRequest(Colleague colleague) {
        colleague.requestInvoke("Taken on request");
    }

    @Override
    public void takeOffRequest(Colleague colleague) {
        colleague.requestInvoke("Take off request");
    }
}

// Colleague1
class Colleague1 implements Colleague{
    private  Mediator mediator;

    public Colleague1(Mediator mediator){
        this.mediator = mediator;
    }


    @Override
    public void takeOn() {
        mediator.takeOnRequest(this);
    }

    @Override
    public void take0ff() {
        mediator.takeOffRequest(this);
    }

    @Override
    public void requestInvoke(String message) {
        System.out.println("College 1 "+message);
    }
}
/*
    The Mediator Design Pattern simplifies communication between multiple objects in a system by centralizing their interactions through a mediator.
    Instead of objects interacting directly, they communicate via a mediator,
    reducing dependencies and making the system easier to manage.

 */