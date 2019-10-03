import java.util.Random;

public class Dice {


    public static int getnumber(){
        Random rand = new Random();

        int number = rand.nextInt(6);

        return number;

    }
}

