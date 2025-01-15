package org.dp.creational.simplefactory;

public interface WheelInterface {
    void setDiameter(float diameter);
    float getDiameter();
}


class MrfWhell implements  WheelInterface{
    private float diameter;

    public MrfWhell(float diameter){
        this.diameter = diameter;
    }


    @Override
    public void setDiameter(float diameter) {
        this.diameter = diameter;
    }

    @Override
    public float getDiameter() {
        return this.diameter;
    }

    @Override
    public String toString() {
        return "MrfWhell{" +
                "diameter=" + diameter +
                '}';
    }
}

class JkWheel implements WheelInterface{
    private float diameter;

    public JkWheel(float diameter){
        this.diameter = diameter;
    }


    @Override
    public void setDiameter(float diameter) {
        this.diameter = diameter;
    }

    @Override
    public float getDiameter() {
        return this.diameter;
    }

    @Override
    public String toString() {
        return "JkWheel{" +
                "diameter=" + diameter +
                '}';
    }
}