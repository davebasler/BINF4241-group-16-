import java.util.ArrayList;

public abstract class Figure {

    public Color color;
    public ArrayList<Figure> figure_list;

    public Figure(Color color) {
        this.color = color;
        this.figure_list = new ArrayList<>();
    }

    public abstract String get_type();

    public abstract String get_colour();

    public ArrayList get_list(){
        return this.figure_list;
    }


    public abstract boolean is_legal(int row_old, int column_old, int row_new, int column_new);

    public abstract boolean is_path_legal(GameBoard gameboard, int row_old, int column_old, int row_new, int column_new);

    //special method for pawn when it can eat another player diagonally
    public Boolean is_legal_eat_diagonal(int row_old, int column_old, int row_new, int column_new) {
        return null;
    }

    //special methods for pawn and en passant
    public int get_timer(){
        return 0;
    }
    public void set_timer(int time){
    }
    public Boolean is_legal_en_passant(int row_old, int column_old, int row_new, int column_new, GameBoard gameboard){
        return null;
    }
}


