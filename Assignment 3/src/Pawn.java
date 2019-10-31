public class Pawn extends Figure {

    private FigureType type;
    private int timer;

    Pawn(Color color) {
        super(color);
        this.type = FigureType.PAWN;
        this.timer = 0;
    }

    public int get_timer(){
        return this.timer;
    }
    public void set_timer(int time){
        this.timer = time;
    }

    public String get_type() {
        return this.type.toString();
    }

    public String get_colour() {
        return this.color.toString();
    }

    public Boolean is_legal_eat_diagonal(int row_old, int column_old, int row_new, int column_new){
        if(this.get_colour().equals(Color.WHITE.toString())){
            return (row_new - row_old) == (-1) && Math.abs(column_new-column_old) == 1;
        }
        else{
            return (row_new - row_old) == 1 && Math.abs(column_new-column_old) == 1;
        }
}

    public Boolean is_legal_en_passant(int row_old, int column_old, int row_new, int column_new, GameBoard gameboard){
        if(gameboard.squares[row_old][column_old].get_figure().get_colour()==Color.BLACK.toString()) {
            if (gameboard.squares[row_old][column_old-1].get_figure() != null) {
                if (gameboard.squares[row_old][column_old - 1].get_figure().get_colour() == Color.WHITE.toString()
                && gameboard.squares[row_old][column_old-1].get_figure().get_type() == FigureType.PAWN.toString()
                && 1==Math.abs((gameboard.squares[row_old][column_old-1].get_figure().get_timer())-(gameboard.squares[row_old][column_old].get_figure().get_timer()))){
                    return true;
                }
            }
            else if(gameboard.squares[row_old][column_old+1].get_figure() != null) {
                if (gameboard.squares[row_old][column_old +1].get_figure().get_colour() == Color.WHITE.toString()
                        && gameboard.squares[row_old][column_old+1].get_figure().get_type() == FigureType.PAWN.toString()
                        && 1==Math.abs((gameboard.squares[row_old][column_old+1].get_figure().get_timer())-(gameboard.squares[row_old][column_old].get_figure().get_timer()))){
                    return true;
                }
            }
        }
       else {
            if (gameboard.squares[row_old][column_old-1].get_figure() != null) {
                if (gameboard.squares[row_old][column_old - 1].get_figure().get_colour() == Color.BLACK.toString()
                        && gameboard.squares[row_old][column_old-1].get_figure().get_type() == FigureType.PAWN.toString()
                        && 1==Math.abs((gameboard.squares[row_old][column_old-1].get_figure().get_timer())-(gameboard.squares[row_old][column_old].get_figure().get_timer()))){
                    return true;
                }
            }
            else if(gameboard.squares[row_old][column_old+1].get_figure() != null) {
                if (gameboard.squares[row_old][column_old +1].get_figure().get_colour() == Color.BLACK.toString()
                        && gameboard.squares[row_old][column_old+1].get_figure().get_type() == FigureType.PAWN.toString()
                        && 1==Math.abs((gameboard.squares[row_old][column_old+1].get_figure().get_timer())-(gameboard.squares[row_old][column_old].get_figure().get_timer()))){
                    return true;
                }
            }
        }
       return false;
    }

    /*
    Here the is_legal(...) method is special, because it looks that the pawn can only move one field forward.
    The only exception is in the first move, where he can jump two fields ahead.
     */

    @Override
    public boolean is_legal(int row_old, int column_old, int row_new, int column_new) {
        if (this.color == color.BLACK && row_new > row_old && row_old==1) {
            return Math.abs(row_new - row_old) == 2 && column_new == column_old || Math.abs(row_new - row_old) == 1 && column_new == column_old;
        }

        if (this.color == color.WHITE && row_new < row_old && row_old==6) {
            return Math.abs(row_new - row_old) == 2 && column_new == column_old || Math.abs(row_new - row_old) == 1 && column_new == column_old;
        }

        if (this.color == Color.BLACK && row_new > row_old) {
            return Math.abs(row_new - row_old) == 1 && column_new == column_old;
        }
        if (this.color == Color.WHITE && row_new < row_old) {
            return Math.abs(row_new - row_old) == 1 && column_new == column_old;
        }

        return false;

    }

    @Override
    public boolean is_path_legal(GameBoard gameboard, int row_old, int column_old, int row_new, int column_new) {
        if (row_new > row_old) {
            for (int i = row_old + 1; i < row_new; i++) {
                if (gameboard.squares[i][column_new].is_occupied()) {
                    return false;
                }
            }
            return true;
        }

        if (row_new < row_old) {
            for (int i = row_old - 1; i > row_new; i--) {
                if (gameboard.squares[i][column_new].is_occupied()) {
                    return false;
                }
            }
            return true;
        }
        return true;


    }

}

