import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameBoard gameboard = new GameBoard();
        gameboard.InitializeGameboard();
        gameboard.PrintGameboardStatus();

        System.out.println("Welcome to Chess!");

        Scanner scan = new Scanner(System.in);
        String player_name;

        List<Player> players = new ArrayList<>();

        System.out.println("Enter your name (Player 1 - BLACK): ");
        player_name = scan.next();
        Player player = new Player(player_name, Color.BLACK);
        players.add(player);
        System.out.println("Enter your name (Player 2 - WHITE): ");
        player_name = scan.next();
        player = new Player(player_name, Color.WHITE);
        players.add(player);

        gameboard.PrintGameboardStatus();



        Move move = new Move();
        QuestionColumnDigit question = new QuestionColumnDigit();
        //Square square = new Square(Color.BLACK);

        gameboard.PrintGameboardStatus();

        boolean game_over = false;
        String winner_name="";
        while(!game_over){
            for(int i=0; i<2;i++){
                Player active_player = players.get(i);


                winner_name = move.move_figure(gameboard, question, active_player);


                gameboard.PrintGameboardStatus();
                move.print_eaten_figures();
                if(!winner_name.equals("")){
                    System.out.println(winner_name+" wins!");
                    game_over=true;
                    break;
                }

            }
        }

    }
}

