import java.util.Scanner;

public class Main {

    public static void main(String [] args){
        Smartphone smartphone = new Smartphone();

        //set properties for Oven
        Oven oven = new Oven();
        OvenCommandOn ovenOn = new OvenCommandOn(oven);
        OvenCommandOff ovenOff = new OvenCommandOff(oven);
        OvenCommandCheckTime checkTime = new OvenCommandCheckTime(oven);
        OvenCommandStartCooking start = new OvenCommandStartCooking(oven);
        OvenCommandSetTemperature setTemp = new OvenCommandSetTemperature(oven);
        OvenCommandSetProgram setProgram = new OvenCommandSetProgram(oven);
        OvenCommandSetTime setTime= new OvenCommandSetTime(oven);
        OvenCommandInterrupt interrupt = new OvenCommandInterrupt(oven);

        smartphone.setSwitchOnSlots(0,ovenOn);
        smartphone.setSwitchOffSlots(0,ovenOff);
        smartphone.setTemperatureSlots(0,setTemp);
        smartphone.setCheckTimerSlots(0,checkTime);
        smartphone.setStartSlots(0,start);
        smartphone.setUpProgramSlots(0,setProgram);
        smartphone.setTimerSlots(0,setTime);
        smartphone.setStopSlots(0,interrupt);

        //set properties for Microwave
        Microwave microwave = new Microwave();
        MicrowaveCommandOn microwaveOn = new MicrowaveCommandOn(microwave);
        MicrowaveCommandOff microwaveOff = new MicrowaveCommandOff(microwave);
        MicrowaveCommandCheckTime microwaveCheckTime = new MicrowaveCommandCheckTime(microwave);
        MicrowaveCommandStartCooking microwaveStart = new MicrowaveCommandStartCooking(microwave);
        MicrowaveCommandSetTemperature microwaveSetTemp = new MicrowaveCommandSetTemperature(microwave);
        MicrowaveCommandSetTime microwaveSetTime= new MicrowaveCommandSetTime(microwave);
        MicrowaveCommandInterrupt microwaveInterrupt = new MicrowaveCommandInterrupt(microwave);

        smartphone.setSwitchOnSlots(1,microwaveOn);
        smartphone.setSwitchOffSlots(1,microwaveOff);
        smartphone.setTemperatureSlots(1,microwaveSetTemp);
        smartphone.setCheckTimerSlots(1,microwaveCheckTime);
        smartphone.setStartSlots(1,microwaveStart);
        smartphone.setTimerSlots(1,microwaveSetTime);
        smartphone.setStopSlots(1,microwaveInterrupt);

        //set properties for Microwave
        Dishwasher dishwasher = new Dishwasher();
        DishwasherCommandOn dishwasherOn = new DishwasherCommandOn(dishwasher);
        DishwasherCommandOff dishwasherOff = new DishwasherCommandOff(dishwasher);
        DishwasherCommandCheckTime dishwasherCheckTime = new DishwasherCommandCheckTime(dishwasher);
        DishwasherCommandStartWashing dishwasherStart = new DishwasherCommandStartWashing(dishwasher);
        DishwasherCommandStopWashing dishwasherStop = new DishwasherCommandStopWashing(dishwasher);
        DishwasherCommandSetProgram dishwasherSetProgram = new DishwasherCommandSetProgram(dishwasher);

        smartphone.setSwitchOnSlots(2,dishwasherOn);
        smartphone.setSwitchOffSlots(2,dishwasherOff);
        smartphone.setCheckTimerSlots(2,dishwasherCheckTime);
        smartphone.setStartSlots(2,dishwasherStart);
        smartphone.setStopSlots(2,dishwasherStop);
        smartphone.setUpProgramSlots(2,dishwasherSetProgram);

        //Set properties for WashingMachine
        WashingMachine washingMachine = new WashingMachine();
        WashingMachineCommandOn washingMachineOn = new WashingMachineCommandOn(washingMachine);
        WashingMachineCommandOff washingMachineOff = new WashingMachineCommandOff(washingMachine);
        WashingMachineCommandSetTemperature washingMachineSetTemp = new WashingMachineCommandSetTemperature(washingMachine);
        WashingMachineCommandSetProgram washingMachineCommandSetProgram = new WashingMachineCommandSetProgram(washingMachine);
        WashingMachineCommandTurnOff WashingMachineCommandTurnOff = new WashingMachineCommandTurnOff(washingMachine);
        WashingMachineCommandStartWashing washingMachineCommandStartWashing = new WashingMachineCommandStartWashing(washingMachine);

        smartphone.setSwitchOnSlots(3,washingMachineOn);
        smartphone.setSwitchOffSlots(3,washingMachineOff);
        smartphone.setTemperatureSlots(3,washingMachineSetTemp);
        smartphone.setUpProgramSlots(3,washingMachineCommandSetProgram);
        smartphone.setStopSlots(3, WashingMachineCommandTurnOff);
        smartphone.setStartSlots(3, washingMachineCommandStartWashing);

        //Set properties for CleaningRobot
        CleaningRobot cleaningRobot = new CleaningRobot();
        CleaningRobotCommandOn cleaningRobotOn = new CleaningRobotCommandOn(cleaningRobot);
        CleaningRobotCommandOff cleaningRobotOff = new CleaningRobotCommandOff(cleaningRobot);
        CleaningRobotCommandSetTime cleaningRobotSetTime = new CleaningRobotCommandSetTime(cleaningRobot);
        CleaningRobotCommandStartCleaning cleaningRobotStartCleaning = new CleaningRobotCommandStartCleaning(cleaningRobot);
        CleaningRobotCommandCheckPercentage cleaningRobotCheckPercentage = new CleaningRobotCommandCheckPercentage(cleaningRobot);
        CleaningRobotCommandCheckBatteryStatus cleaningRobotCheckBatteryStatus = new CleaningRobotCommandCheckBatteryStatus(cleaningRobot);
        CleaningRobotCommandCheckBatteryChargingStatus cleaningRobotCheckBatteryChargingStatus = new CleaningRobotCommandCheckBatteryChargingStatus(cleaningRobot);
        CleaningRobotCommandOutstandingCleaning cleaningRobotOutstandingCleaning = new CleaningRobotCommandOutstandingCleaning(cleaningRobot);
        CleaningRobotEndCleaning cleaningRobotEndCleaning = new CleaningRobotEndCleaning(cleaningRobot);

        smartphone.setSwitchOnSlots(4, cleaningRobotOn);
        smartphone.setSwitchOffSlots(4, cleaningRobotOff);
        smartphone.setTimerSlots(4, cleaningRobotSetTime);
        smartphone.setStartSlots(4, cleaningRobotStartCleaning);
        smartphone.setCheckPercentageSlots(4, cleaningRobotCheckPercentage);
        smartphone.setCheckBatteryStatusSlots(4, cleaningRobotCheckBatteryStatus);
        smartphone.setCheckBatteryChargingStatusSlots(4, cleaningRobotCheckBatteryChargingStatus);
        smartphone.setCompleteOutstandingCleaningSlots(4, cleaningRobotOutstandingCleaning);
        smartphone.setStopSlots(4, cleaningRobotEndCleaning);



        while(true) {
            System.out.println("Select Device: [O] Oven -- [M] Microwave -- [D] Dishwasher -- [W] Washing Machine -- [C] Cleaning Robot");
            Scanner scan = new Scanner(System.in);
            String input = scan.next();
            if(input.equals("O")){
                if(!oven.getStatus()) {
                    System.out.println("Choose function: [On] Turn On");
                    input = scan.next();
                    if(input.equals("On")){
                        smartphone.pressSwitchOnButton(0);
                    }
                }
                else{
                    System.out.println("Choose function: [Off] Turn Off -- [Temp] Set Temperature -- [Time] Set Timer -- [P] Set Program -- [S] Start -- [C] Check Timer -- [I] Interrupt");
                    input = scan.next();
                    if(input.equals("Off")){
                        smartphone.pressSwitchOffButton(0);
                    }
                    if(input.equals("Temp")){
                        smartphone.pressTemperatureButton(0);
                    }
                    if(input.equals("Time")){
                        smartphone.pressTimerButton(0);
                    }
                    if(input.equals("P")){
                        smartphone.pressProgramButton(0);
                    }
                    if(input.equals("S")){
                        smartphone.pressStartButton(0);
                    }
                    if(input.equals("C")){
                        smartphone.pressCheckTimerButton(0);
                    }
                    if(input.equals("I")){
                        smartphone.pressStopButton(0);
                    }
                }
            }else if(input.equals("M")){
                if(!microwave.getStatus()) {
                    System.out.println("Choose function: [On] Turn On");
                    input = scan.next();
                    if(input.equals("On")){
                        smartphone.pressSwitchOnButton(1);
                    }
                }
                else{
                    System.out.println("Choose function: [Off] Turn Off -- [Temp] Set Temperature -- [Time] Set Timer -- [S] Start -- [C] Check Timer -- [I] Interrupt");
                    input = scan.next();
                    if(input.equals("Off")){
                        smartphone.pressSwitchOffButton(1);
                    }
                    if(input.equals("Temp")){
                        smartphone.pressTemperatureButton(1);
                    }
                    if(input.equals("Time")){
                        smartphone.pressTimerButton(1);
                    }
                    if(input.equals("S")){
                        smartphone.pressStartButton(1);
                    }
                    if(input.equals("C")){
                        smartphone.pressCheckTimerButton(1);
                    }
                    if(input.equals("I")){
                        smartphone.pressStopButton(1);
                    }
                }
            }else if(input.equals("D")) {
                if (!dishwasher.getStatus()) {
                    System.out.println("Choose function: [On] Turn On");
                    input = scan.next();
                    if (input.equals("On")) {
                        smartphone.pressSwitchOnButton(2);
                    }
                } else {
                    System.out.println("Choose function: [Off] Turn Off --  [P] Set Program -- [S] Start -- [C] Check Timer -- [St] Stop");
                    input = scan.next();
                    if (input.equals("Off")) {
                        smartphone.pressSwitchOffButton(2);

                    }
                    if (input.equals("P")) {
                        smartphone.pressProgramButton(2);
                    }
                    if (input.equals("S")) {
                        smartphone.pressStartButton(2);
                    }
                    if (input.equals("C")) {
                        smartphone.pressCheckTimerButton(2);
                    }
                    if (input.equals("St")) {
                        smartphone.pressStopButton(2);
                    }
                }
            }else if(input.equals("W")){
                if(!washingMachine.getStatus()) {
                    System.out.println("Choose function: [On] Turn On");
                    input = scan.next();
                    if(input.equals("On")){
                        smartphone.pressSwitchOnButton(3);
                    }
                }
                else{
                    System.out.println("Choose function: [Off] Switch Off -- [Degree] Set Degree --  [P] Set Program -- [T] Turn off -- [S] Start Machine");
                    input = scan.next();
                    if(input.equals("Off")){
                        smartphone.pressSwitchOffButton(3);
                    }
                    if(input.equals("Degree")){
                        smartphone.pressTemperatureButton(3);
                    }

                    if(input.equals("P")){
                        smartphone.pressProgramButton(3);
                    }
                    if(input.equals("T")){
                        smartphone.pressStopButton(3);
                    }
                    if(input.equals("S")){
                        smartphone.pressStartButton(3);
                    }

                }
            }else if(input.equals("C")){
                if(!cleaningRobot.getStatus()) {
                    System.out.println("Choose function: [On] Turn On");
                    input = scan.next();
                    if(input.equals("On")){
                        smartphone.pressSwitchOnButton(4);
                    }
                }else{
                    System.out.println("Choose function: [Off] Switch Off -- [Time] Set Time --  [S] Start -- " +
                            "[Compl] Check percentage of completion -- [Bttr] Battery Status -- " +
                            "[Chrg] charging status -- [Outcl] Do outstanding cleaning -- [St] stop");

                    input = scan.next();
                    if(input.equals("Off")){
                        smartphone.pressSwitchOffButton(4);
                    }
                    if(input.equals("Time")){
                        smartphone.pressTimerButton(4);
                    }
                    if(input.equals("S")){
                        smartphone.pressStartButton(4);
                    }
                    if(input.equals("Compl")){
                        smartphone.pressCheckPercentageButton(4);
                    }
                    if(input.equals("Bttr")){
                        smartphone.pressCheckBatteryStatusButton(4);
                    }
                    if(input.equals("Chrg")){
                        smartphone.pressCheckBatteryChargingButton(4);
                    }
                    if(input.equals("Outcl")){
                        smartphone.pressCompleteOutstandingCleaningSlots(4);
                    }
                    if(input.equals("St")){
                        smartphone.pressStopButton(4);
                    }
                }
            }

/*
            System.out.println("Enter time: ");
            scan = new Scanner(System.in);
            int time = scan.nextInt();

            Thread timer = new Timer(time,new Oven());
            timer.start();

            System.out.println("Check if thread has terminated or is sleeping (enter any number to check)");
            scan.nextInt();

            StackTraceElement[] ste = timer.getStackTrace();

            if (ste.length == 0) {
                System.out.println("thread has terminated");
            }

            if(ste[0].getClassName().equals("java.lang.Thread")
                    && ste[0].getMethodName().equals("sleep")){
                System.out.println("thread is sleeping");
            }

            // zum the thread bzw. timer onterbreche ===> timer.interrupt();

 */
        }
    }
}
