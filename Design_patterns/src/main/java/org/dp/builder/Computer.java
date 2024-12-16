package org.dp.builder;

public class Computer {
    private String hardDisk;
    private String ramSize;

    private Boolean isGraphicsCardEnabled;

    private  Computer(ComputerBuilder builder){  // Should be private because it avoids the computer object creation by itself.
        this.hardDisk =builder. hardDisk;
        this.ramSize = builder.ramSize;
        this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
    }

    public String getHardDisk() {          // Should contain only getters
        return hardDisk;
    }

    public String getRamSize() {           // Should contain only getters
        return ramSize;
    }

    public Boolean getGraphicsCardEnabled() { // Should contain only getters
        return isGraphicsCardEnabled;
    }

    public static  class ComputerBuilder{
        private String hardDisk;
        private String ramSize;

        private Boolean isGraphicsCardEnabled;

        public ComputerBuilder ( String hardDisk, String ramSize){
            this.hardDisk = hardDisk;
            this.ramSize = ramSize;
        }

        public ComputerBuilder setGraphicsCardEnabled(Boolean graphicsCardEnabled) {
            this.isGraphicsCardEnabled = graphicsCardEnabled;
            return this;
        }

        public Computer build(){
            return new Computer(this);
        }
    }

}
