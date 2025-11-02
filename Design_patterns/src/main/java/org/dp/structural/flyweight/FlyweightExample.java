package org.dp.structural.flyweight;

import java.util.Map;

public class FlyweightExample {
    public static void main(String[] args) {
        Font font1 = FlyweightFactory.getFont("Arial");
        Font font2 = FlyweightFactory.getFont("Times New Roman");
        Font font3 = FlyweightFactory.getFont("Arial");
        font1.writeText();
        font2.writeText();
        System.out.println(font1 == font3);
    }
}

// Flyweight Interface
interface Font{
    void writeText();
}

// Concrete Flyweight
class Arial implements Font{
    @Override
    public void writeText() {
        System.out.println("Writing Text in Arial Font");
    }
}

class TimesNewRoman implements Font{
    @Override
    public void writeText() {
        System.out.println("Writing Text in Times New Roman Font");
    }
}

// Flyweight Factory
class FlyweightFactory{

    private static final Map<String,Font> fontIntrinscState = new java.util.HashMap<>();

    public static Font getFont(String fontName){
        return fontIntrinscState.computeIfAbsent(fontName, k -> switch (k) {
            case "Arial" -> new Arial();
            case "Times New Roman" -> new TimesNewRoman();
            default -> null;
        });
    }
}


