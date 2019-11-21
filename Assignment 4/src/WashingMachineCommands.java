public class WashingMachineCommands {
}


class WashingMachineCommandOn implements Command{
    private WashingMachine washingMachine;

    WashingMachineCommandOn(WashingMachine washingMachine){
        this.washingMachine = washingMachine;
    }

    public void execute(){
        washingMachine.switchOn();
    }
}

class WashingMachineCommandOff implements Command{
    private WashingMachine washingMachine;

    WashingMachineCommandOff(WashingMachine washingMachine){
        this.washingMachine = washingMachine;
    }

    public void execute(){
        washingMachine.switchOff();
    }
}

class WashingMachineCommandSetTemperature implements Command{
    private WashingMachine washingMachine;

    WashingMachineCommandSetTemperature(WashingMachine washingMachine){
        this.washingMachine = washingMachine;
    }

    public void execute(){
        washingMachine.selectDegrees();
    }
}

class WashingMachineCommandStartWashing implements Command {
    private WashingMachine washingMachine;

    WashingMachineCommandStartWashing(WashingMachine washingMachine) {
        this.washingMachine = washingMachine;
    }

    public void execute() {
        washingMachine.startWashingMachine();
    }
}


    class WashingMachineCommandSetProgram implements Command {
        private WashingMachine washingMachine;

        WashingMachineCommandSetProgram(WashingMachine washingMachine) {
            this.washingMachine = washingMachine;
        }

        public void execute() {
            washingMachine.SelectTypeOfWashing();
        }
    }

    class WashingMachineCommandTurnOff implements Command {
        private WashingMachine washingMachine;

        WashingMachineCommandTurnOff(WashingMachine washingMachine) {
            this.washingMachine = washingMachine;
        }

        public void execute() {
            washingMachine.turnOff();
        }

}



