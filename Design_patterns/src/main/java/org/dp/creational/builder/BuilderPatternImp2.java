package org.dp.creational.builder;

public class BuilderPatternImp2 {
    public static void main(String[] args) {
        RoyalEnfield royalEnfield = new RoyalEnfield();
        BikeDirector bikeDirectorForBikeBuilding = new BikeDirector();
        bikeDirectorForBikeBuilding.construct(royalEnfield,"60hp","13km");
        System.out.println(royalEnfield);
    }
}

class MotorBike{
    private String engine;
    private String mileage;

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return "MotorBike{" +
                "engine='" + engine + '\'' +
                ", mileage='" + mileage + '\'' +
                '}';
    }
}

interface  BikeBuilder{
   BikeBuilder buildEngine(String engine);
   BikeBuilder buildMileage(String mileage);
   MotorBike build();
}

class RoyalEnfield implements BikeBuilder{

    private final MotorBike motorBike;

    public RoyalEnfield(){
        this.motorBike = new MotorBike();
    }

    @Override
    public BikeBuilder buildEngine(String engine) {
        motorBike.setEngine(engine);
        return this;
    }

    @Override
    public BikeBuilder buildMileage(String mileage) {
        motorBike.setMileage(mileage);
        return this;
    }

    @Override
    public MotorBike build() {
        return motorBike;
    }

    @Override
    public String toString() {
        return "RoyalEnfield{" +
                "motorBike=" + motorBike.toString() +
                '}';
    }
}

class BikeDirector{
    public void construct(BikeBuilder builder,String engine, String mileage){
            builder.buildEngine(engine);
            builder.buildMileage(mileage);
            builder.build();
    }
}