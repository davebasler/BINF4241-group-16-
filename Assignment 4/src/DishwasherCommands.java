public class DishwasherCommands {
}

class DishwasherCommandOn implements Command{
    private Dishwasher dishwasher;

    public DishwasherCommandOn(Dishwasher dishwasher){
        this.dishwasher = dishwasher;
    }

    public void execute(){
        dishwasher.switchOn();
    }
}

class DishwasherCommandOff implements Command{
    private Dishwasher dishwasher;

    public DishwasherCommandOff(Dishwasher dishwasher){
        this.dishwasher = dishwasher;
    }

    public void execute(){
        dishwasher.switchOff();
    }
}

class DishwasherCommandSetProgram implements Command{
    private Dishwasher dishwasher;

    public DishwasherCommandSetProgram(Dishwasher dishwasher){
        this.dishwasher = dishwasher;
    }

    public void execute(){
        dishwasher.SetUpProgram();
    }
}

class DishwasherCommandStopWashing implements Command{
    private Dishwasher dishwasher;

    public DishwasherCommandStopWashing(Dishwasher dishwasher){
        this.dishwasher = dishwasher;
    }

    public void execute(){
        dishwasher.stopDishwasher();
    }
}

class DishwasherCommandStartWashing implements Command{
    private Dishwasher dishwasher;

    public DishwasherCommandStartWashing(Dishwasher dishwasher){
        this.dishwasher = dishwasher;
    }

    public void execute(){
        dishwasher.startWashing();
    }
}

class DishwasherCommandCheckTime implements Command {
    private Dishwasher dishwasher;

    public DishwasherCommandCheckTime(Dishwasher dishwasher) {
        this.dishwasher = dishwasher;
    }

    public void execute() {
        dishwasher.checkTimer();
    }
}

