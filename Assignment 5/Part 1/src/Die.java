import java.util.Random;

public class Die {


    public int getNum() {
        Random rand = new Random();
        int num = rand.nextInt(6);
        num++;
        return num;
    }
}
