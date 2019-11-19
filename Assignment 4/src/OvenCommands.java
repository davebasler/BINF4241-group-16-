public class OvenCommands {
}

class OvenCommandOn implements Command{
    private Oven oven;

    public OvenCommandOn(Oven oven){
        this.oven = oven;
    }

    public void execute(){
        oven.switchOn();
    }
}

class OvenCommandOff implements Command{
    private Oven oven;

    public OvenCommandOff(Oven oven){
        this.oven = oven;
    }

    public void execute(){
        oven.switchOff();
    }
}

class OvenCommandSetTemperature implements Command{
    private Oven oven;

    public OvenCommandSetTemperature(Oven oven){
        this.oven = oven;
    }

    public void execute(){
        oven.setTemperature();
    }
}

class OvenCommandSetTime implements Command{
    private Oven oven;

    public OvenCommandSetTime(Oven oven){
        this.oven = oven;
    }

    public void execute(){
        oven.setTimer();
    }
}

class OvenCommandSetProgram implements Command{
    private Oven oven;

    public OvenCommandSetProgram(Oven oven){
        this.oven = oven;
    }

    public void execute(){
        oven.SetUpProgram();
    }
}

class OvenCommandInterrupt implements Command{
    private Oven oven;

    public OvenCommandInterrupt(Oven oven){
        this.oven = oven;
    }

    public void execute(){
        oven.interruptTheProgram();
    }
}

class OvenCommandStartCooking implements Command{
    private Oven oven;

    public OvenCommandStartCooking(Oven oven){
        this.oven = oven;
    }

    public void execute(){
        oven.startCooking();
    }
}

class OvenCommandCheckTime implements Command{
    private Oven oven;

    public OvenCommandCheckTime (Oven oven){
        this.oven = oven;
    }

    public void execute(){
        oven.checkTimer();
    }
}