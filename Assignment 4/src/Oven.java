import java.util.Scanner;

public class Oven implements Device {

    private boolean isOn;
    private int timer;
    private int temperature;
    private int programType;
    private boolean isCooking;
    private Thread timerObj;
    public static long currentTimeMillis;

    public Oven() {
        this.isOn = false;
        this.timer = 0;
        this.temperature = 0;
        this.programType = 0;
        this.isCooking = false;

    }

    boolean getStatus() {
        return this.isOn;
    }

    public void switchOn() {
        this.isOn = true;
    }

    void setTimer() {
        boolean tmp = true;
        while (tmp) {
            System.out.println("Set time for the oven (greater than zero): ");
            Scanner scan = new Scanner(System.in);
            this.timer = scan.nextInt();
            if (this.timer > 0) {
                tmp = false;
            }
        }
    }

    void setTemperature() {
        boolean tmp = true;
        while (tmp) {
            System.out.println("Set the temperature for the oven (min. 60 degrees): ");
            Scanner scan = new Scanner(System.in);
            this.temperature = scan.nextInt();
            if (this.temperature >= 60) {
                tmp = false;
            }
        }
    }

    void SetUpProgram() {
        boolean tmp = true;
        while (tmp) {
            System.out.println("Choose one of the following programs: [1] ventilated, [2] grill or [3] top bottom heating");
            Scanner scan = new Scanner(System.in);
            this.programType = scan.nextInt();
            if (1 <= this.programType && this.programType <= 3) {
                tmp = false;
            }
        }
    }

    private long start;

    void startCooking() {
        if (this.isOn && this.temperature >= 60 && this.timer > 0 && this.programType != 0) {
            timerObj = new Timer(this.timer * 1000, this);
            timerObj.start();
            this.isCooking = true;
            start = System.currentTimeMillis();
        } else {
            System.out.println("Can't Start yet because temperature, timer and program aren't all set yet.");
        }
    }

    void checkTimer() {
        if (this.isCooking) {
            long end = System.currentTimeMillis();
            float sec = (end - start) / 1000F;
            System.out.println(sec + " seconds");
        } else {
            System.out.println(this.timer + " seconds");
        }
    }


    void interruptTheProgram() {
        if (this.getStatus()) {


            if (this.getStatus() && this.isCooking) {

                this.isCooking = false;
                long end = System.currentTimeMillis();
                float sec = (end - start) / 1000F;
                this.timer = (int) (this.timer - sec);
                timerObj.interrupt();
            } else {
                System.out.println("Can't interrupt Program because it isn't running!");
            }
        }
    }

        public void switchOff () {
            if (this.isCooking) {
                timerObj.interrupt();
            }
            this.isCooking = false;
            this.isOn = false;

        }

        public void set_status(boolean bool){
            this.isCooking = bool;
        }
    }
