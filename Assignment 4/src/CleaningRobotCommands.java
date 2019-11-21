public class CleaningRobotCommands {
}

class CleaningRobotCommandOn implements Command {
    private CleaningRobot cleaningRobot;

    CleaningRobotCommandOn(CleaningRobot cleaningRobot) {
        this.cleaningRobot = cleaningRobot;
    }

    public void execute() {
        cleaningRobot.switchOn();
    }
}

class CleaningRobotCommandOff implements Command {
    private CleaningRobot cleaningRobot;

    CleaningRobotCommandOff(CleaningRobot cleaningRobot) {
        this.cleaningRobot = cleaningRobot;
    }

    public void execute() {
        cleaningRobot.switchOff();
    }
}

class CleaningRobotCommandSetTime implements Command {
    private CleaningRobot cleaningRobot;

    CleaningRobotCommandSetTime(CleaningRobot cleaningRobot) {
        this.cleaningRobot = cleaningRobot;
    }

    public void execute() {
        cleaningRobot.setTimer();
    }
}

class CleaningRobotCommandStartCleaning implements Command {
    private CleaningRobot cleaningRobot;

    CleaningRobotCommandStartCleaning(CleaningRobot cleaningRobot) {
        this.cleaningRobot = cleaningRobot;
    }

    public void execute() {
        cleaningRobot.startCleaning();
    }
}

class CleaningRobotCommandCheckPercentage implements Command {
    private CleaningRobot cleaningRobot;

    CleaningRobotCommandCheckPercentage(CleaningRobot cleaningRobot) {
        this.cleaningRobot = cleaningRobot;
    }

    public void execute() {
        cleaningRobot.checkPercentageOfCleaningCompletion();
    }
}

class CleaningRobotCommandCheckBatteryStatus implements Command {
    private CleaningRobot cleaningRobot;

    CleaningRobotCommandCheckBatteryStatus(CleaningRobot cleaningRobot) {
        this.cleaningRobot = cleaningRobot;
    }

    public void execute() {
        cleaningRobot.checkBatteryStatus();
    }
}

class CleaningRobotCommandCheckBatteryChargingStatus implements Command {
    private CleaningRobot cleaningRobot;

    CleaningRobotCommandCheckBatteryChargingStatus(CleaningRobot cleaningRobot) {
        this.cleaningRobot = cleaningRobot;
    }

    public void execute() {
        cleaningRobot.checkBatteryChargingStatus();
    }
}

class CleaningRobotCommandOutstandingCleaning implements Command {
    private CleaningRobot cleaningRobot;

    CleaningRobotCommandOutstandingCleaning(CleaningRobot cleaningRobot) {
        this.cleaningRobot = cleaningRobot;
    }

    public void execute() {
        cleaningRobot.completeOutstandingCleaning();
    }
}

class CleaningRobotEndCleaning implements Command {
    private CleaningRobot cleaningRobot;

    CleaningRobotEndCleaning(CleaningRobot cleaningRobot) {
        this.cleaningRobot = cleaningRobot;
    }

    public void execute() {
        cleaningRobot.endCleaning();
    }
}


