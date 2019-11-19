public class Timer extends Thread {
    private Device device;
    private int time;

    public Timer(int time, Device device){
        this.time = time;
        this.device = device;
    }

    public void run(){
        this.device.set_status(true);
        try{
                Thread.sleep(this.time);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        this.device.set_status(false);
        System.out.println("Timer finished");
    }
}

 class Timer2 extends Thread {
    private CleaningRobot device;
    private int time;
    private int battery;
    private boolean ischarging;
    private boolean isInBase;

    public Timer2(boolean isInBase, int time, int battery ,boolean ischarging, CleaningRobot device){
        this.time = time;
        this.device = device;
        this.battery = battery;
        this.ischarging = ischarging;
        this.isInBase = isInBase;


    }

    public void run(){
        this.device.set_status(isInBase);
        this.device.set_charging_status(this.ischarging);
        try{
            Thread.sleep(this.time);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        this.device.set_battery(battery);
        this.device.set_charging_status(!this.ischarging);
        this.device.set_status(true);
        System.out.println("Timer finished");
    }
}
