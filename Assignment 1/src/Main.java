import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the game 'Snakes and Ladders'!");

        Scanner scan = new Scanner(System.in);
        int player_number = 0;
        while(player_number <= 1 || player_number > 4){
            System.out.println("Enter the number of players (2-4): ");
            player_number = scan.nextInt();
        }

        List<Player> players = new ArrayList<Player>();
        String player_name;
        for(int index=0; index < player_number; index++){
            System.out.println("Enter the name of player "+index+": ");
            player_name = scan.next();
            Player player = new Player(player_name);
            players.add(player);
        }

        int size_of_board;
        System.out.println("Enter the amount of fields: ");
        size_of_board = scan.nextInt();
        //System.out.println(size_of_board);

        List<Square> squares = new ArrayList<Square>();
        for(int index=1; index < size_of_board+1; index++){
            if(index==1) {
                Square square = new StartSquare(index, size_of_board);
                squares.add(square);
            }
            else if(index==size_of_board-1) {
                Square square = new EndSquare(index, size_of_board);
                squares.add(square);
            }
            else if(index%5==0 && index < size_of_board-2) {
                Square square = new Ladder(index, size_of_board);
                squares.add(square);
            }
            else if(index%11==0 && index < size_of_board) {
                Square square = new Snake(index, size_of_board);
                squares.add(square);
            }
            else{
                Square square = new NormalSquare(index,size_of_board);
                squares.add(square);
            }
        }

        //Initial State
        BoardStatus initial_board_status = new BoardStatus();
        String field_initial_status = initial_board_status.get_current_status(size_of_board,player_number,squares,players);
        String field = "Initial state: "+field_initial_status;
        System.out.println(field);

        //game loop
        Game game = new Game();
        game.GameLoop(squares,player_number,players,size_of_board);
    }
}
