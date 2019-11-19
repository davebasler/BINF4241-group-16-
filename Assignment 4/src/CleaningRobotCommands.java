public class CleaningRobotCommands {
}

class CleaningRobotCommandOn implements Command {
    private CleaningRobot cleaningRobot;

    public CleaningRobotCommandOn(CleaningRobot cleaningRobot) {
        this.cleaningRobot = cleaningRobot;
    }

    public void execute() {
        cleaningRobot.switchOn();
    }
}

class CleaningRobotCommandOff implements Command {
    private CleaningRobot cleaningRobot;

    public CleaningRobotCommandOff(CleaningRobot cleaningRobot) {
        this.cleaningRobot = cleaningRobot;
    }

    public void execute() {
        cleaningRobot.switchOff();
    }
}

class CleaningRobotCommandSetTime implements Command {
    private CleaningRobot cleaningRobot;

    public CleaningRobotCommandSetTime(CleaningRobot cleaningRobot) {
        this.cleaningRobot = cleaningRobot;
    }

    public void execute() {
        cleaningRobot.setTimer();
    }
}

class CleaningRobotCommandStartCleaning implements Command {
    private CleaningRobot cleaningRobot;

    public CleaningRobotCommandStartCleaning(CleaningRobot cleaningRobot) {
        this.cleaningRobot = cleaningRobot;
    }

    public void execute() {
        cleaningRobot.startCleaning();
    }
}

class CleaningRobotCommandCheckPercentage implements Command {
    private CleaningRobot cleaningRobot;

    public CleaningRobotCommandCheckPercentage(CleaningRobot cleaningRobot) {
        this.cleaningRobot = cleaningRobot;
    }

    public void execute() {
        cleaningRobot.checkPercentageOfCleaningCompletion();
    }
}

class CleaningRobotCommandCheckBatteryStatus implements Command {
    private CleaningRobot cleaningRobot;

    public CleaningRobotCommandCheckBatteryStatus (CleaningRobot cleaningRobot) {
        this.cleaningRobot = cleaningRobot;
    }

    public void execute() {
        cleaningRobot.checkBatteryStatus();
    }
}

class CleaningRobotCommandCheckBatteryChargingStatus implements Command {
    private CleaningRobot cleaningRobot;

    public CleaningRobotCommandCheckBatteryChargingStatus  (CleaningRobot cleaningRobot) {
        this.cleaningRobot = cleaningRobot;
    }

    public void execute() {
        cleaningRobot.checkBatteryChargingStatus();
    }
}

class CleaningRobotCommandOutstandingCleaning implements Command {
    private CleaningRobot cleaningRobot;

    public CleaningRobotCommandOutstandingCleaning  (CleaningRobot cleaningRobot) {
        this.cleaningRobot = cleaningRobot;
    }

    public void execute() {
        cleaningRobot.completeOutstandingCleaning();
    }
}

class CleaningRobotEndCleaning implements Command {
    private CleaningRobot cleaningRobot;

    public CleaningRobotEndCleaning  (CleaningRobot cleaningRobot) {
        this.cleaningRobot = cleaningRobot;
    }

    public void execute() {
        cleaningRobot.endCleaning();
    }
}


