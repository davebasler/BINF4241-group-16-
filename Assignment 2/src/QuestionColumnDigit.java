import java.util.Scanner;

public class QuestionColumnDigit {
    private int old_row; private int old_column; private int new_row; private int new_column;
    public void get_input(String player_name) {
        boolean temp2 = true;
        String input = "a2a3";
        while (temp2) {
            Scanner scan = new Scanner(System.in);
            System.out.println(player_name + " please enter your move: ");
            input = scan.next();
            int letter1 = (int) input.charAt(0);
            int digit1 = (int) input.charAt(1);
            int letter2 = (int) input.charAt(2);
            int digit2 = (int) input.charAt(3);
            if (letter1 >= 97 && letter1 < 105 && digit1 >= 48&& digit1 < 57 && letter2 >= 97 && letter2 < 105 && digit2 >= 48 && digit2 < 57) {
                temp2 = false;
            }
            else{
                System.out.println("Come on we told you the rules! Try again!");
            }

        }

            Converter convert = new Converter();

            old_column = convert.convert(input.charAt(0));
            char temp = input.charAt(1);

            int char_as_int = Integer.parseInt(String.valueOf(temp));
            old_row = Math.abs(char_as_int - 8);
            new_column = convert.convert(input.charAt(2));
            temp = input.charAt(3);
            char_as_int = Integer.parseInt(String.valueOf(temp));
            new_row = Math.abs(char_as_int - 8);

        }


    public int get_old_row(){
        return old_row;
    }
    public int get_old_column(){
        return old_column;
    }
    public int get_new_row(){
        return new_row;
    }
    public int get_new_column(){
        return new_column;
    }

    /*public void move_figure_to(){
        Scanner scan2 = new Scanner(System.in);
        System.out.println("On which position do you want to place your figure?: ");
        String input2 = scan2.next();

        Converter convert = new Converter();
        new_column = convert.convert(input2.charAt(0));
        char temp = input2.charAt(1);
        int char_as_int = Integer.parseInt(String.valueOf(temp));
        new_row = Math.abs(char_as_int-8);
    }
    */
}

