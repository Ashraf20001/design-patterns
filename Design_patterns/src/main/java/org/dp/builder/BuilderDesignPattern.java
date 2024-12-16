package org.dp.builder;

public class BuilderDesignPattern {
    public static void main(String[] args) {
        Computer computer = new Computer.ComputerBuilder("1TB", "i5")
                .setGraphicsCardEnabled(true).build();
    }
}
