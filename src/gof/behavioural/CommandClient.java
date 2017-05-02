package gof.behavioural;

/**
 * Created by sgovil on 5/1/17.
 */
interface Command {
    public void execute();
}

class Light {
    private boolean on;

    public void SwitchOn() {
        this.on = true;
    }

    public void SwitchOff() {
        this.on = false;
    }
}

class LightsOn implements Command {

    Light light;
    public LightsOn(Light light){
        this.light = light;
    }

    public void execute(){
        light.SwitchOn();
    }
}

class LightsOff implements Command {

    Light light;
    public LightsOff(Light light)
    {
        this.light = light;
    }

    public void execute(){
        light.SwitchOff();
    }
}

class RemoteControl {
    private Command command;

    public void SetCommand(Command command) {
        this.command = command;
    }

    public void PressButton(){
        command.execute();
    }
}

public class CommandClient {
    public static void main(String [] args)
    {
        RemoteControl control = new RemoteControl();
        Light light = new Light();

        Command lightson = new LightsOn(light);
        Command lightsoff = new LightsOff(light);

        control.SetCommand(lightson);
        control.PressButton();

        control.SetCommand(lightsoff);
        control.PressButton();
    }
}


