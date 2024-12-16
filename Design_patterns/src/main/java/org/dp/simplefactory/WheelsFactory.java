package org.dp.simplefactory;

public class WheelsFactory {

    public WheelInterface getWheel(float diameter){
        if(diameter>5){
            return new MrfWhell(diameter);
        }
        return new JkWheel(diameter);
    }
}
