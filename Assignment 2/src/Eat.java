import java.util.ArrayList;
import java.util.List;

public class Eat {

    public List<Figure> eaten_black_figures = new ArrayList<Figure>();
    public List<Figure> eaten_white_figures = new ArrayList<Figure>();


    public boolean can_eat(GameBoard gameboard, int row_old, int column_old, int row_new, int column_new){

        if(gameboard.squares[row_new][column_new].get_figure()!=null){
            if(gameboard.squares[row_old][column_old].get_figure().get_colour()==
                    gameboard.squares[row_new][column_new].get_figure().get_colour()){
                return false;
            }
            else if((gameboard.squares[row_old][column_old].get_figure().get_type()==FigureType.PAWN.toString())   //Special case for pawn. It forbids the pawn to eat figures that are in front of him.
                    &&(column_old==column_new)){
                return false;
            }

            else
            {
                return true;
            }
        }

        else{
            return true;
        }


    }

    public void eat_en_passant(GameBoard gameboard, int row_old, int column_old, Player active_player){
        Figure temp = gameboard.squares[row_old][column_old].remove_figure();
        active_player.add_eaten_piece();
        if(temp.get_colour()==Color.BLACK.toString()){
            eaten_black_figures.add(temp);
        }
        else{
            eaten_white_figures.add(temp);
        }
    }

    public void eat_figure(GameBoard gameboard, int row_old, int column_old, int row_new, int column_new, Player active_player){
        Figure temp = gameboard.squares[row_new][column_new].remove_figure();
        gameboard.squares[row_new][column_new].add_figure(gameboard.squares[row_old][column_old].remove_figure());
        active_player.add_eaten_piece();
        if(temp.get_colour()==Color.BLACK.toString()){
            eaten_black_figures.add(temp);
        }
        else{
            eaten_white_figures.add(temp);
        }
    }
}


