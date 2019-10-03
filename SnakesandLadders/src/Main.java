import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int player_number = 0;
        while(player_number <= 1 || player_number > 4 ){
            System.out.print("Enter number of players (2-4): ");
            player_number = scan.nextInt();
        }

        List<Player> players = new ArrayList<Player>();
        String player_name;
        for (int index=0; index < player_number; index++){
            System.out.print("Enter name of player "+index+": ");
            player_name = scan.next();
            Player player = new Player(player_name);
            players.add(player);
        }

        // Test names with 2 players
        System.out.println(players.get(0).get_name());
        System.out.println(players.get(1).get_name());

        int size_of_board;
        System.out.print("Enter size of board: ");
        size_of_board = scan.nextInt();

        /*// add all squares to an Array...problem with adding different types to array...

        List<NormalSquare> normalsquares = new ArrayList<NormalSquare>();
        List<Ladder> ladders = new ArrayList<Ladder>();
        List<Snake> snakes = new ArrayList<Snake>();
        for (int index=1; index <= size_of_board; index++){
            if(index==1){
                StartSquare startsquare= new StartSquare(1);
            }
            else if(index==size_of_board){
                EndSquare endsquare = new EndSquare(size_of_board);
            }
            else if(index%5==0){
                Ladder ladder = new Ladder(index);
                ladders.add(ladder);
            }
            else {
                NormalSquare normalsquare = new NormalSquare(index);
                normalsquares.add(normalsquare);
            }

        }
        //Test Array
        System.out.println(normalsquares.get(10).index);
        */
        StartSquare startsquare1 = new StartSquare(1);
        Ladder ladder2 = new Ladder(2);
        NormalSquare normalsquare3 = new NormalSquare(3);
        NormalSquare normalsquare4 = new NormalSquare(4);
        NormalSquare normalsquare5 = new NormalSquare(5);
        NormalSquare normalsquare6 = new NormalSquare(6);
        Ladder ladder7 = new Ladder(7);
        NormalSquare normalsquare8 = new NormalSquare(8);
        NormalSquare normalsquare9 = new NormalSquare(9);
        NormalSquare normalsquare10 = new NormalSquare(10);
        Snake snake11 = new Snake(11);
        EndSquare endsquare12 = new EndSquare(12);



    }
}
