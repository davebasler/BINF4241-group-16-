public class OvenCommands {
}

class OvenCommandOn implements Command{
    private Oven oven;

    OvenCommandOn(Oven oven){
        this.oven = oven;
    }

    public void execute(){
        oven.switchOn();
    }
}

class OvenCommandOff implements Command{
    private Oven oven;

    OvenCommandOff(Oven oven){
        this.oven = oven;
    }

    public void execute(){
        oven.switchOff();
    }
}

class OvenCommandSetTemperature implements Command{
    private Oven oven;

    OvenCommandSetTemperature(Oven oven){
        this.oven = oven;
    }

    public void execute(){
        oven.setTemperature();
    }
}

class OvenCommandSetTime implements Command{
    private Oven oven;

    OvenCommandSetTime(Oven oven){
        this.oven = oven;
    }

    public void execute(){
        oven.setTimer();
    }
}

class OvenCommandSetProgram implements Command{
    private Oven oven;

    OvenCommandSetProgram(Oven oven){
        this.oven = oven;
    }

    public void execute(){
        oven.SetUpProgram();
    }
}

class OvenCommandInterrupt implements Command{
    private Oven oven;

    OvenCommandInterrupt(Oven oven){
        this.oven = oven;
    }

    public void execute(){
        oven.interruptTheProgram();
    }
}

class OvenCommandStartCooking implements Command{
    private Oven oven;

    OvenCommandStartCooking(Oven oven){
        this.oven = oven;
    }

    public void execute(){
        oven.startCooking();
    }
}

class OvenCommandCheckTime implements Command{
    private Oven oven;

    OvenCommandCheckTime(Oven oven){
        this.oven = oven;
    }

    public void execute(){
        oven.checkTimer();
    }
}