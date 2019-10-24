import java.util.Scanner;

class UserInput{
    private int old_row; private int old_column; private int new_row; private int new_column;

    /*
    input: String
    output: none
    gets the input from the players in each round.
    checks if the input format is valid. if not it starts over by asking for another input.
     */
    void get_input(String player_name) {
        boolean temp2 = true;
        String input = "a2a3";
        old_row = 0;
        while (temp2) {
            Scanner scan = new Scanner(System.in);
            System.out.println(player_name + " please enter your move: ");
            input = scan.next();
            if(input.equals("0-0")){  //small rochade
                old_row = -1;
                break;
            }
            else if(input.equals("0-0-0")){ //big rochade
                old_row=-2;
                break;
            }
            else {
                if (input.length() == 4) {
                    int letter1 = (int) input.charAt(0);
                    int digit1 = (int) input.charAt(1);
                    int letter2 = (int) input.charAt(2);
                    int digit2 = (int) input.charAt(3);
                    if (letter1 >= 97 && letter1 < 105 && digit1 >= 48 && digit1 < 57 && letter2 >= 97 && letter2 < 105 && digit2 >= 48 && digit2 < 57) {
                        temp2 = false;
                    } else {
                        System.out.println("Please enter the move according to the rules!");
                    }
                } else {
                    System.out.println("Please enter 4 characters!");
                }
            }

        }
        if(old_row!=-1&&old_row!=-2) {
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
    }


    int get_old_row(){
        return old_row;
    }

    int get_old_column(){
        return old_column;
    }

    int get_new_row(){
        return new_row;
    }
    int get_new_column(){
        return new_column;
    }
}

