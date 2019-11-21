public class WashingMachineCommands {
}


class WashingMachineCommandOn implements Command{
    private WashingMachine washingMachine;

    public WashingMachineCommandOn(WashingMachine washingMachine){
        this.washingMachine = washingMachine;
    }

    public void execute(){
        washingMachine.switchOn();
    }
}

class WashingMachineCommandOff implements Command{
    private WashingMachine washingMachine;

    public WashingMachineCommandOff(WashingMachine washingMachine){
        this.washingMachine = washingMachine;
    }

    public void execute(){
        washingMachine.switchOff();
    }
}

class WashingMachineCommandStart implements Command{
    private WashingMachine washingMachine;

    public WashingMachineCommandStart(WashingMachine washingMachine){
        this.washingMachine = washingMachine;
    }

    public void execute(){
        washingMachine.startWashing();
    }
}

class WashingMachineCommandSetTemperature implements Command{
    private WashingMachine washingMachine;

    public WashingMachineCommandSetTemperature(WashingMachine washingMachine){
        this.washingMachine = washingMachine;
    }

    public void execute(){
        washingMachine.selectDegrees();
    }
}

class WashingMachineCommandSetProgram implements Command{
    private WashingMachine washingMachine;

    public WashingMachineCommandSetProgram(WashingMachine washingMachine){
        this.washingMachine = washingMachine;
    }

    public void execute(){
        washingMachine.SelectTypeOfWashing();
    }
}

class WashingMachineCommandTurnOff implements Command{
    private WashingMachine washingMachine;

    public WashingMachineCommandTurnOff(WashingMachine washingMachine){
        this.washingMachine = washingMachine;
    }

    public void execute(){
        washingMachine.turnOff();
    }
}



