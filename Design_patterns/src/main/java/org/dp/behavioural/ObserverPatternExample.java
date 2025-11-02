package org.dp.behavioural;

import java.util.ArrayList;
import java.util.List;

public class ObserverPatternExample {
    public static void main(String[] args) {
        TVObserver tvObserver = new TVObserver();
        RadioObserver radioObserver = new RadioObserver();

        WeatherStation weatherStation = new WeatherStation();
        weatherStation.addObservers(tvObserver);
        weatherStation.addObservers(radioObserver);
        weatherStation.setWeather("Rainy");


    }
}


interface Subject{
    void addObservers(Observer observer);
    void removeObservers(Observer observer);
    void notifyObservers();
}

interface Observer{
    void update(String state);
}

class WeatherStation implements Subject{

   private final List<Observer> observers = new ArrayList<>();
   String state;

    @Override
    public void addObservers(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObservers(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer: observers){
            observer.update(this.state);
        }
    }

    public void setWeather(String state){
        this.state = state;
        notifyObservers();
    }
}

class TVObserver implements Observer{

    String state;

    @Override
    public void update(String state) {
        this.state = state;
        displayObserver();
    }

    private void displayObserver() {
        System.out.println("TV observer state is updated "+state);
    }


}

class RadioObserver implements Observer{
    String state;


    @Override
    public void update(String state) {
        this.state = state;
        displayObserver();
    }

    private void displayObserver() {
        System.out.println("Radio observer state is updated "+state);
    }


}


/*
        The problem statement of this pattern is if the observable (subject) got changed, its observers
        must be notified immediately.
 */

