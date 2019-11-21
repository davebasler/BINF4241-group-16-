public class DishwasherCommands {
}

class DishwasherCommandOn implements Command{
    private Dishwasher dishwasher;

    DishwasherCommandOn(Dishwasher dishwasher){
        this.dishwasher = dishwasher;
    }

    public void execute(){
        dishwasher.switchOn();
    }
}

class DishwasherCommandOff implements Command{
    private Dishwasher dishwasher;

    DishwasherCommandOff(Dishwasher dishwasher){
        this.dishwasher = dishwasher;
    }

    public void execute(){
        dishwasher.switchOff();
    }
}

class DishwasherCommandSetProgram implements Command{
    private Dishwasher dishwasher;

    DishwasherCommandSetProgram(Dishwasher dishwasher){
        this.dishwasher = dishwasher;
    }

    public void execute(){
        dishwasher.SetUpProgram();
    }
}

class DishwasherCommandStopWashing implements Command{
    private Dishwasher dishwasher;

    DishwasherCommandStopWashing(Dishwasher dishwasher){
        this.dishwasher = dishwasher;
    }

    public void execute(){
        dishwasher.stopDishwasher();
    }
}

class DishwasherCommandStartWashing implements Command{
    private Dishwasher dishwasher;

    DishwasherCommandStartWashing(Dishwasher dishwasher){
        this.dishwasher = dishwasher;
    }

    public void execute(){
        dishwasher.startWashing();
    }
}

class DishwasherCommandCheckTime implements Command {
    private Dishwasher dishwasher;

    DishwasherCommandCheckTime(Dishwasher dishwasher) {
        this.dishwasher = dishwasher;
    }

    public void execute() {
        dishwasher.checkTimer();
    }
}

