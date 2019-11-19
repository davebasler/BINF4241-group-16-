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

    public boolean getStatus(){
        return this.isOn;
    }

    public void switchOn(){
        this.isOn = true;
    }

    public void SetUpProgram(){
        boolean tmp = true;
        while(tmp) {
            System.out.println("Choose one of the following programs: [1] glasses, [2] plates, [3] pans oe [4] mixed");
            Scanner scan = new Scanner(System.in);
            this.programType = scan.nextInt();
            switch(this.programType){
                case 1: this.glassesTimer = 50; tmp = false; break;
                case 2: this.platesTimer = 100; tmp = false; break;
                case 3: this.pansTimer = 150; tmp = false; break;
                case 4: this.mixedTimer = 200; tmp = false; break;
            }
        }
    }

    long start;
    public void startWashing() {
        if (this.isOn && this.programType != 0) {
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
            System.out.println("Can't Start yet because automated timer isn't set");
        }
    }

    public void checkTimer(){
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

    public void stopDishwasher(){
        long end = System.currentTimeMillis();
        float sec = (end - start) / 1000F;
        if(this.glassesTimer + this.pansTimer + this.platesTimer + this.mixedTimer - sec == 0){
            this.isWashing = false;
        }
        else{
            System.out.println("Can't stop program because it is still running!");
        }
    }
    public void switchOff(){
        this.isWashing = false;
        this.isOn = false;
    }
    public void set_status(boolean bool){
        this.isWashing = bool;
    }
}


