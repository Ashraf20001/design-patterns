package org.dp.behavioural;

import java.util.ArrayList;
import java.util.List;

public class CommandPatternExample {
    public static void main(String[] args) {
        TV tv = new TV();
        Stereo stereo = new Stereo();

        Command turnOnOffCommand = new TurnOnOffCommand(tv, true);
        AdjustSettings adjustSettingsCommand = new AdjustSettings(stereo);
        Invoker remote = new Invoker();
        remote.setCommands(turnOnOffCommand);
        remote.setCommands(adjustSettingsCommand);

        remote.executeCommands();

    }
}

interface Command{
    void execute();
}

interface Device{
    void turnOn();
    void turnOff();
    void adjustSettings();
}

class TV implements Device{
    @Override
    public void turnOn() {
        System.out.println("Turn on TV ...");
    }

    @Override
    public void turnOff() {
        System.out.println("Turn off TV ...");
    }

    @Override
    public void adjustSettings() {
        System.out.println("Adjust TV settings ...");
    }
}

class Stereo implements Device{

    @Override
    public void turnOn() {
        System.out.println("Turn on Sterio ..");
    }

    @Override
    public void turnOff() {
        System.out.println("Turn off Sterio ..");
    }

    @Override
    public void adjustSettings() {
        System.out.println("Adjust Stereo settings ...");
    }
}

class TurnOnOffCommand implements Command{

    private final Device device;
    private Boolean toggle = false;

    public TurnOnOffCommand(Device device,Boolean toggle){
        this.device = device;
        this.toggle = toggle;
    }

    @Override
    public void execute() {
        if(toggle){
            device.turnOff();
        }else{
            device.turnOn();
        }
    }
}

class AdjustSettings implements Command {
    private final Device device;

    public  AdjustSettings(Device device){
        this.device = device;
    }

    @Override
    public void execute() {
        device.adjustSettings();
    }
}

class Invoker {
    private  List<Command> commands;

    public Invoker() {
        commands = new ArrayList<>();
    }

    public void setCommands(Command command){
        commands.add(command);
    }

    public void  executeCommands(){
        for (Command command: commands){
            command.execute();
        }
    }
}
