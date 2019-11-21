import java.util.Scanner;

public class WashingMachine implements Device {


        private boolean isOn;
        private int doubleRinseTimer;
        private int intenseTimer;
        private int quickTimer;
        private int spinTimer;
        private int temperature;
        private int programType;
        private boolean isWashing;
        private Thread timerObj;
        public static long currentTimeMillis;
        private long start;


        WashingMachine(){
            this.isOn = false;
            this.doubleRinseTimer = 0;
            this.intenseTimer = 0;
            this.quickTimer = 0;
            this.spinTimer = 0;
            this.temperature = 0;
            this.programType = 0;
            this.isWashing = false;

        }

        boolean getStatus(){
            return this.isOn;
        }

        public void switchOn(){
            this.isOn = true;
        }

        void SelectTypeOfWashing(){
            boolean tmp = true;
            while(tmp) {
                System.out.println("Choose one of the following programs: [1] Double Rinse, [2] Intense, [3] Quick [4] Spin");
                Scanner scan = new Scanner(System.in);
                this.programType = scan.nextInt();
                switch(this.programType){
                    case 1: this.doubleRinseTimer = 50; tmp = false;this.intenseTimer =0; this.quickTimer = 0;this.spinTimer =0;break;
                    case 2: this.intenseTimer = 100; tmp = false;this.doubleRinseTimer =0; this.quickTimer = 0;this.spinTimer =0; break;
                    case 3: this.quickTimer = 150; tmp = false;this.intenseTimer =0; this.doubleRinseTimer = 0;this.spinTimer =0; break;
                    case 4: this.spinTimer = 200; tmp = false;this.intenseTimer =0; this.quickTimer = 0;this.doubleRinseTimer =0; break;
                }
            }
        }


    void startWashingMachine() {
        if (this.isOn && this.programType != 0) {
            if (this.doubleRinseTimer > 0) {
                timerObj = new Timer(this.doubleRinseTimer * 1000, this);
                timerObj.start();
                this.isWashing = true;
                start = System.currentTimeMillis();

            } else if (this.intenseTimer > 0) {
                timerObj = new Timer(this.intenseTimer * 1000, this);
                timerObj.start();
                this.isWashing = true;
                start = System.currentTimeMillis();

            } else if (this.quickTimer > 0) {
                timerObj = new Timer(this.quickTimer * 1000, this);
                timerObj.start();
                this.isWashing = true;
                start = System.currentTimeMillis();

            } else if (this.spinTimer > 0) {
                timerObj = new Timer(this.spinTimer * 1000, this);
                timerObj.start();
                this.isWashing = true;
                start = System.currentTimeMillis();
            }
        }else{
            System.out.println("Can't Start yet because automated timer isn't set");
        }
    }

    void selectDegrees(){
        boolean tmp = true;
        while(tmp) {
            System.out.println("Select degrees for the Washing machine (min 30): ");
            Scanner scan = new Scanner(System.in);
            this.temperature = scan.nextInt();
            if(this.temperature >= 30){
                tmp = false;
            }
        }
    }

    public void turnOff(){
            long end = System.currentTimeMillis();
            float sec = (end - start) / 1000F;
            if (!this.isWashing){
                System.out.println("Device is already turned off");
            }
            else if(this.spinTimer + this.quickTimer + this.intenseTimer + this.doubleRinseTimer - sec > 0){
                System.out.println("Program is still running");
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




