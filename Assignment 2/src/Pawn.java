public class Pawn extends Figure {

    private FigureType type;

    public Pawn(Color color) {
        super(color);
        this.type = FigureType.PAWN;
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

