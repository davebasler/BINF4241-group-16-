import java.util.ArrayList;
import java.util.List;

public class Game {
    public void GameLoop(List<Square> squares, int player_number, List<Player> players, int size_of_board){
        //Game Loop
        boolean game_finished = false;
        Die die = new Die();
        BoardStatus status = new BoardStatus();
        String field;

        while(!game_finished){
            int roll_number;
            int new_field_number;
            //boolean status_of_square;
            for(int i=0;i<player_number;i++){
                field = status.get_current_status(size_of_board,player_number,squares,players);
                roll_number = die.getNum();
                Player active_player = players.get(i);
               /* int current_field=active_player.get_currentfield();
                squares.get(current_field).occupied_change(false);*/
                new_field_number= active_player.change_current_field(roll_number);
                if(new_field_number>size_of_board){
                    new_field_number = active_player.change_current_field(-2*(new_field_number-size_of_board));
                }
                if(squares.get(new_field_number-1).get_type()=="ladder"){
                    new_field_number = active_player.change_current_field(2);
                }
                if(squares.get(new_field_number-1).get_type()=="snake"){
                    new_field_number = active_player.change_current_field(-5);
                }
               /* if(squares.get(new_field_number).is_occupied()){
                    new_field_number = active_player.change_current_field(1-new_field_number);
                }*/

                field = active_player.get_name()+" rolls "+roll_number+": "+field;
                System.out.println(field);

                //check if player won
                if(new_field_number==size_of_board){
                    game_finished=true;
                    active_player.is_winner();
                    //System.out.println(active_player.get_name()+" rolls "+roll_number+": ");
                    //System.out.println(new_field_number);
                    field = "Final State: "+status.get_current_status(size_of_board,player_number,squares,players);
                    System.out.println(field);
                    System.out.println(active_player.get_name()+" wins!");
                    break;
                }


            }
        }
    }
}
