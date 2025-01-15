package org.dp.creational.prototype;

public class PrototypeClient {
    private Shape shapeClient;

    public PrototypeClient(Shape shapeClient){
        this.shapeClient = shapeClient;
    }

    public Shape createShape(){
        return this.shapeClient.clone();
    }
}
