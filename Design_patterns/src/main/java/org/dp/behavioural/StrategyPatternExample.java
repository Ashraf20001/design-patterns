package org.dp.behavioural;

public class StrategyPatternExample {
    public static void main(String[] args) {
        SortingContext sortingContext = new SortingContext(new BubbleSortAlg());
        sortingContext.doSort();
        // Run time changing the sorting context behaviour
        sortingContext.setStrategy(new QuickSortAlg());
        sortingContext.doSort();
    }
}

interface Strategy{
    void process();
}

class SortingContext{
    private Strategy strategy;
    public SortingContext(Strategy strategy){
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy){
        this.strategy = strategy;
    }

    public void doSort(){
        this.strategy.process();
    }
}

class BubbleSortAlg implements  Strategy{

    @Override
    public void process() {
        System.out.println("Bubble sorting.......");
    }
}

class QuickSortAlg implements Strategy{

    @Override
    public void process() {
        System.out.println("Quick sorting.......");
    }
}


