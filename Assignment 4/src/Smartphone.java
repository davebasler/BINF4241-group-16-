import java.util.ArrayList;

public class Smartphone {

    private ArrayList<Command> switchOnSlots = new ArrayList<Command>();
    private ArrayList<Command> switchOffSlots= new ArrayList<Command>();
    private ArrayList<Command> setTimerSlot= new ArrayList<Command>();
    private ArrayList<Command>setTemperatureSlots= new ArrayList<Command>();
    private ArrayList<Command> setUpProgramSlots= new ArrayList<Command>();
    private ArrayList<Command> startSlots= new ArrayList<Command>();
    private ArrayList<Command> stopSlots= new ArrayList<Command>();
    private ArrayList<Command> checkTimerSlots= new ArrayList<Command>();
    private ArrayList<Command> checkPercentageSlots= new ArrayList<Command>();
    private ArrayList<Command> checkBatteryStatusSlots= new ArrayList<Command>();
    private ArrayList<Command> checkBatteryChargingStatusSlots= new ArrayList<Command>();
    private ArrayList<Command> completeOutstandingCleaningSlots= new ArrayList<Command>(); //<------------------ new

    public Smartphone(){
        Command noCommand = new NoCommand();
        for (int i = 0;i<5;i++){

            switchOnSlots.add(noCommand);
            switchOffSlots.add(noCommand);
            setTimerSlot.add(noCommand);
            setTemperatureSlots.add(noCommand);
            setUpProgramSlots.add(noCommand);
            startSlots.add(noCommand);
            stopSlots.add(noCommand);
            checkTimerSlots.add(noCommand);
            checkPercentageSlots.add(noCommand);
            checkBatteryStatusSlots.add(noCommand);
            checkBatteryChargingStatusSlots.add(noCommand);
            completeOutstandingCleaningSlots.add(noCommand); //<------------------- new
        }
    }

    public void setSwitchOnSlots(int slot, Command command){
        switchOnSlots.set(slot, command);
    }

    public void setSwitchOffSlots(int slot, Command command){
        switchOffSlots.set(slot, command);
    }

    public void setTimerSlots(int slot, Command command){
        setTimerSlot.set(slot, command);
    }

    public void setTemperatureSlots(int slot, Command command){
        setTemperatureSlots.set(slot, command);
    }

    public void setUpProgramSlots(int slot, Command command){
        setUpProgramSlots.set(slot, command);
    }

    public void setStartSlots(int slot, Command command){
        startSlots.set(slot, command);
    }

    public void setStopSlots(int slot, Command command){
        stopSlots.set(slot, command);
    }

    public void setCheckTimerSlots(int slot, Command command){
        checkTimerSlots.set(slot, command);
    }

    public void setCheckPercentageSlots(int slot, Command command){
        checkPercentageSlots.set(slot, command);
    }

    public void setCheckBatteryStatusSlots(int slot, Command command){
        checkBatteryStatusSlots.set(slot, command);
    }

    public void setCheckBatteryChargingStatusSlots(int slot, Command command){
        checkBatteryChargingStatusSlots.set(slot, command);
    }

    public void setCompleteOutstandingCleaningSlots(int slot, Command command){              //<------------------ new
        completeOutstandingCleaningSlots.set(slot, command);
    }

    public void pressSwitchOnButton(int slot){
        switchOnSlots.get(slot).execute();
    }

    public void pressSwitchOffButton(int slot){
        switchOffSlots.get(slot).execute();
    }

    public void pressTimerButton(int slot){
        setTimerSlot.get(slot).execute();
    }

    public void pressTemperatureButton(int slot){
        setTemperatureSlots.get(slot).execute();
    }

    public void pressProgramButton(int slot){
        setUpProgramSlots.get(slot).execute();
    }

    public void pressStartButton(int slot){
        startSlots.get(slot).execute();
    }

    public void pressStopButton(int slot){
        stopSlots.get(slot).execute();
    }

    public void pressCheckTimerButton(int slot){
        checkTimerSlots.get(slot).execute();
    }

    public void pressCheckPercentageButton(int slot){
        checkPercentageSlots.get(slot).execute();
    }

    public void pressCheckBatteryStatusButton(int slot){
        checkBatteryStatusSlots.get(slot).execute();
    }

    public void pressCheckBatteryChargingButton(int slot){
        checkBatteryChargingStatusSlots.get(slot).execute();
    }

    public void pressCompleteOutstandingCleaningSlots(int slot){    //<--------------------------- new
        completeOutstandingCleaningSlots.get(slot).execute();
    }


}