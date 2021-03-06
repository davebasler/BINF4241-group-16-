import java.util.Scanner;

public class Dishwasher implements  Device {

    private boolean isOn;
    private int glassesTimer;
    private int platesTimer;
    private int pansTimer;
    private int mixedTimer;
    private int programType;
    private boolean isWashing;
    private Thread timerObj;
    public static long currentTimeMillis;


    public Dishwasher(){
        this.isOn = false;
        this.glassesTimer = 0;
        this.platesTimer = 0;
        this.pansTimer = 0;
        this.mixedTimer = 0;
        this.programType = 0;
        this.isWashing = false;

    }

    boolean getStatus(){
        return this.isOn;
    }

    public void switchOn(){
        this.isOn = true;
    }

    void SetUpProgram(){
        boolean tmp = true;
        while(tmp) {
            System.out.println("Choose one of the following programs: [1] glasses, [2] plates, [3] pans oe [4] mixed");
            Scanner scan = new Scanner(System.in);
            this.programType = scan.nextInt();
            switch(this.programType){
                case 1: this.glassesTimer = 50; tmp = false; this.platesTimer = 0;this.pansTimer =0;this.mixedTimer = 0; break;
                case 2: this.platesTimer = 100; tmp = false;this.glassesTimer = 0;this.pansTimer =0;this.mixedTimer = 0; break;
                case 3: this.pansTimer = 150; tmp = false;this.platesTimer = 0;this.glassesTimer =0;this.mixedTimer = 0; break;
                case 4: this.mixedTimer = 200; tmp = false; this.platesTimer = 0;this.pansTimer =0;this.glassesTimer = 0;break;
            }
        }
    }

    private long start;
    void startWashing() {
        if (this.isOn && this.programType != 0 && !this.isWashing) {
            if (this.glassesTimer > 0) {
                timerObj = new Timer(this.glassesTimer * 1000, this);
                timerObj.start();
                this.isWashing = true;
                start = System.currentTimeMillis();

            } else if (this.platesTimer > 0) {
                timerObj = new Timer(this.platesTimer * 1000, this);
                timerObj.start();
                this.isWashing = true;
                start = System.currentTimeMillis();

            } else if (this.pansTimer > 0) {
                timerObj = new Timer(this.pansTimer * 1000, this);
                timerObj.start();
                this.isWashing = true;
                start = System.currentTimeMillis();

            } else if (this.mixedTimer > 0) {
                timerObj = new Timer(this.mixedTimer * 1000, this);
                timerObj.start();
                this.isWashing = true;
                start = System.currentTimeMillis();
            }
        }else{
            System.out.println("Can't Start yet because automated timer isn't set or device is already running!");
        }
    }

    void checkTimer(){
        long end = System.currentTimeMillis();
        float sec = (end - start) / 1000F;

        if(this.programType != 0 && !this.isWashing) {
            if (this.glassesTimer > 0) {
                System.out.println("Required seconds for this program: " + this.glassesTimer);
            } else if (this.platesTimer > 0) {
                System.out.println("Required seconds for this program: " + this.platesTimer);
            } else if (this.pansTimer > 0) {
                System.out.println("Required seconds for this program: " + this.pansTimer);
            } else if (this.mixedTimer > 0) {
                System.out.println("Required seconds for this program: " + this.mixedTimer);
            }
        }
        else if(this.isWashing) {
            System.out.println(this.glassesTimer + this.platesTimer + this.pansTimer + this.mixedTimer - sec +  " seconds to go");
        }
    }

    void stopDishwasher(){
        long end = System.currentTimeMillis();
        float sec = (end - start) / 1000F;
        if(this.isWashing){
            this.isWashing = false;
            timerObj.interrupt();
        }
        else{
            System.out.println("Can't stop program because it isn't running!");
        }
    }
    public void switchOff(){
        if(this.isWashing) {
            timerObj.interrupt();
        }
        this.isWashing = false;
        this.isOn = false;
    }
    public void set_status(boolean bool){
        this.isWashing = bool;
    }
}


