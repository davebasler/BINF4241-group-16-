import java.util.Scanner;

public class CleaningRobot implements  Device, Device2{

    private boolean isOn;
    private boolean isInBase;
    private int timer;
    private int outstandingCleaning; //Remaining time for cleaning completion if battery is empty before cleaning completion
    private int batteryStatus;
    private boolean isCharging;
    private Thread timerObj1;   //timer for cleaning
    private Thread timerObj2; //recharge 20 seconds
    public static long currentTimeMillis;

    public CleaningRobot(){
        this.isOn = false;
        this.isInBase = true;
        this.timer = 0;
        this.batteryStatus = 20;  //works as a timer. 20 is max battery charge.
        this.isCharging = false; //Needs always to charge 20 seconds to have full charge. Then, isCharging is set to false.
        this.outstandingCleaning = 0;

    }


    public boolean getStatus(){
        return this.isOn;
    }

    public void switchOn(){
        this.isOn = true;
    }

    public void setTimer(){
        this.outstandingCleaning = 0;  //relevant for line 72. Because if you do not want to continue with outstanding cleaning you have to set it equal 0!!!
        boolean tmp = true;
        while(tmp) {
            System.out.println("Set time for the cleaning robot (greater than zero): ");
            Scanner scan = new Scanner(System.in);
            this.timer = scan.nextInt();
            if(this.timer > 0){
                tmp = false;
            }
        }
    }

    long startCleaning;
    public void startCleaning() {
        if (this.isOn && this.isInBase && this.batteryStatus == 20 && this.timer > 0) {
            if (this.timer > this.batteryStatus) {
                this.outstandingCleaning = this.timer - 20; //If timer is longer than battery time
                timerObj1 = new Timer2(false,20 * 1000,0,false, this);
                timerObj1.start();
                startCleaning = System.currentTimeMillis();
                this.isInBase = false;


            } else {
                //this.batteryStatus = this.batteryStatus - this.timer;    //If battery time is longer than timer
                timerObj1 = new Timer2(false,this.timer * 1000,0, false,this);
                timerObj1.start();
                startCleaning = System.currentTimeMillis();
            }
        }else{
            System.out.println("Please set first the timer!!");
        }
    }

    public void checkPercentageOfCleaningCompletion(){
        if(!this.isInBase) {
            long end = System.currentTimeMillis();
            int percentage = (int) (((end - startCleaning)/(long)this.timer)*100)/1000;
            System.out.println(percentage + "% has been cleaned");
        }
        else if(this.isInBase && this.outstandingCleaning!=0){
            int percentage = (this.outstandingCleaning/this.timer)*100;
            System.out.println(percentage + "Device is currently in base. " + percentage + "% has been cleaned");
            //System.out.println("Device is currently in base.");
        }
        else{
            System.out.println("You have never started the cleaning");
        }
    }

    public void checkBatteryStatus(){
        if(!this.isInBase) {
            long end = System.currentTimeMillis();
            int batteryStatus = (int) (((20000 - (end-startCleaning))/1000)); //20 is the max battery charge as defined above
            System.out.println("The current battery status is: " + batteryStatus + " of 20");
        }
        else{
            System.out.println("Device is in base. Please check its battery charging status");
        }
    }

    public void checkBatteryChargingStatus(){
        if(this.isCharging){
            System.out.println("Charging status: Battery is charging");
        }
        else{
            System.out.println("Charging status: Battery is not charging - it has full charge");
        }
    }

    public void completeOutstandingCleaning(){
        if(this.outstandingCleaning != 0){
            this.timer = outstandingCleaning;
            this.outstandingCleaning = 0;
            startCleaning();
        }
        else{
            System.out.println("No outstanding cleaning!!");
        }
    }

    public void switchOff() {
        this.isInBase = true;
        this.isOn = false;
    }
    public void endCleaning(){


    }




    @Override
    public void set_status(boolean bool) {
        this.isInBase = bool;

        if(this.batteryStatus!=20){
            timerObj2 = new Timer2(true,20 * 1000,20, true,this);
            timerObj2.start();
            this.batteryStatus = 20;

        }
    }

    public void set_battery(int num){
        this.batteryStatus = num;
    }

    public void set_charging_status(boolean bool){
        this.isCharging = bool;
    }

}
