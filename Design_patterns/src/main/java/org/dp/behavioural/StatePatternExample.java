package org.dp.behavioural;

public class StatePatternExample {
    public static void main(String[] args) {
        Product product = new Product();

        product.handleNext();

        product.handleNext();

        product.handleNext();

        System.out.println(product.getState());
    }
}

// Context which holds the state that must be modified on run time
class Product{
    private State state;

    public Product(){
        state= new OrderedState();
    }

    public State getState(){
        return state;
    }
    public void setState(State state){
        this.state = state;
    }
    public void handleNext(){
        this.state.next(this);
    }

    public void handlePrevious(){
        this.state.prev(this);
    }
}

interface State{
    void next(Product product);
    void prev(Product product);
}

class OrderedState implements State{

    @Override
    public void next(Product product) {
        product.setState(new PreparedState());
    }

    @Override
    public void prev(Product product) {
        System.out.println("Ordered state is initial state");
    }
}

class PreparedState implements State{

    @Override
    public void next(Product product) {
        product.setState(new DeliveredState());
    }

    @Override
    public void prev(Product product) {
        product.setState(new OrderedState());
    }
}

class DeliveredState implements State{

    @Override
    public void next(Product product) {
        System.out.println("Context reached it's final state");
    }

    @Override
    public void prev(Product product) {
        product.setState(new PreparedState());
    }
}

/*
    The problem statement of state design pattern is it changes the state of the context object.
    According to different conditions, the context object might have to change its state. So, in order to avoid
    multiple if else conditions and hard to maintain different state logic for different conditions, this state pattern comes
    into picture.
 */