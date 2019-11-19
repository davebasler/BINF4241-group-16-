public class MicrowaveCommands {
}

class MicrowaveCommandOn implements Command{
    private Microwave microwave;

    public MicrowaveCommandOn(Microwave microwave){
        this.microwave = microwave;
    }

    public void execute(){
        microwave.switchOn();
    }
}

class MicrowaveCommandOff implements Command{
    private Microwave microwave;

    public MicrowaveCommandOff(Microwave microwave){
        this.microwave = microwave;
    }

    public void execute(){
        microwave.switchOff();
    }
}

class MicrowaveCommandSetTemperature implements Command{
    private Microwave microwave;

    public MicrowaveCommandSetTemperature(Microwave microwave){
        this.microwave = microwave;
    }

    public void execute(){
        microwave.setTemperature();
    }
}

class MicrowaveCommandSetTime implements Command{
    private Microwave microwave;

    public MicrowaveCommandSetTime(Microwave microwave){
        this.microwave = microwave;
    }

    public void execute(){
        microwave.setTimer();
    }
}



class MicrowaveCommandInterrupt implements Command{
    private Microwave microwave;

    public MicrowaveCommandInterrupt(Microwave microwave){
        this.microwave = microwave;
    }

    public void execute(){
        microwave.interruptTheProgram();
    }
}

class MicrowaveCommandStartCooking implements Command{
    private Microwave microwave;

    public MicrowaveCommandStartCooking(Microwave microwave){
        this.microwave = microwave;
    }

    public void execute(){
        microwave.startBacking();
    }
}

class MicrowaveCommandCheckTime implements Command{
    private Microwave microwave;

    public MicrowaveCommandCheckTime (Microwave microwave){
        this.microwave = microwave;
    }

    public void execute(){
        microwave.checkTimer();
    }
}
