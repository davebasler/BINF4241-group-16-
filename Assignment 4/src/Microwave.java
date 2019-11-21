import java.util.Scanner;

public class Microwave implements Device{

    private boolean isOn;
    private int timer;
    private int temperature;
    private int programType;
    private boolean isBacking;
    private Thread timerObj;

    public boolean getStatus(){
        return this.isOn;
    }

    public void switchOn(){
        this.isOn = true;
    }

    public void setTimer(){
        boolean tmp = true;
        while(tmp) {
            System.out.println("Set time for the oven (greater than zero): ");
            Scanner scan = new Scanner(System.in);
            this.timer = scan.nextInt();
            if(this.timer > 0){
                tmp = false;
            }
        }
    }

    public void setTemperature(){
        boolean tmp = true;
        while(tmp) {
            System.out.println("Set the temperature for the oven (min. 60 degrees): ");
            Scanner scan = new Scanner(System.in);
            this.temperature = scan.nextInt();
            if(this.temperature >= 60){
                tmp = false;
            }
        }
    }

    long start;
    public void startBacking(){
        if(this.isOn && this.temperature >= 60 && this.timer > 0){
            timerObj = new Timer(this.timer*1000, this);
            timerObj.start();
            this.isBacking = true;
            start = System.currentTimeMillis();
        }
        else {
            System.out.println("Can't Start yet because temperature and timer aren't all set yet.");
        }
    }

    public void checkTimer(){
        if(this.isBacking) {
            long end = System.currentTimeMillis();
            float sec = (end - start) / 1000F;
            System.out.println(sec + " seconds");
        }
        else{
            System.out.println(this.timer + " seconds");
        }
    }

    public void interruptTheProgram(){
        if(this.getStatus()&&this.isBacking) {
            this.isBacking = false;
            long end = System.currentTimeMillis();
            float sec = (end - start) / 1000F;
            this.timer = (int) (this.timer - sec);
            timerObj.interrupt();
        }
        else{
            System.out.println("Can't interrupt Program because it isn't running!");
        }
    }

    public void switchOff(){
        if(this.isBacking) {
            timerObj.interrupt();
        }
        this.isBacking = false;
        this.isOn = false;
    }

    public void set_status(boolean bool){
        this.isBacking = bool;
    }


}
