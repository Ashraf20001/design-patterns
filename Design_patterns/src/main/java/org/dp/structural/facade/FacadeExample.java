package org.dp.structural.facade;

public class FacadeExample {

    public static void main(String[] args) {
        DrawingPlatform drawingPlatform = new DrawingPlatform();
        drawingPlatform.drawAnimal();
        drawingPlatform.drawBird();
    }


}

// Facade interface
interface Facade{
    void drawAnimal();
    void drawBird();
}

// Animal Drawing subsystem
class AnimalDrawing {
    public void drawHead(){
        System.out.println("Head is drawn ...");
    }
    public void drawBody(){
        System.out.println("Body is drawn ...");
    }
    public void drawTail(){
        System.out.println("Tail is drawn ...");
    }
}


// Bird Drawing subsystem
class BirdDrawing {
    public void drawHead(){
        System.out.println("Head is drawn ...");
    }
    public void drawBody(){
        System.out.println("Body is drawn ...");
    }
    public void drawWings(){
        System.out.println("Wings are drawn ...");
    }
}

// Facade Implementation to draw animal and bird
class DrawingPlatform implements Facade{
    AnimalDrawing animalDrawing = new AnimalDrawing();
    BirdDrawing birdDrawing = new BirdDrawing();
    @Override
    public void drawAnimal() {
        animalDrawing.drawHead();
        animalDrawing.drawBody();
        animalDrawing.drawTail();
    }

    @Override
    public void drawBird() {
        birdDrawing.drawHead();
        birdDrawing.drawBody();
        birdDrawing.drawWings();
    }
}
