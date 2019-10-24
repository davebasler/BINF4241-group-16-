public class Bishop extends Figure {

    private FigureType type;

    Bishop(Color color) {
        super(color);
        this.type = FigureType.BISHOP;
    }

    public String get_type() {
        return this.type.toString();
    }

    public String get_colour() {
        return this.color.toString();
    }

    @Override
    public boolean is_legal(int row_old, int column_old, int row_new, int column_new) {
        return Math.abs(column_new - column_old) == Math.abs(row_new - row_old);
    }

    @Override
    public boolean is_path_legal(GameBoard gameboard, int row_old, int column_old, int row_new, int column_new) {

        if (column_old < column_new && row_old < row_new) {
            int j = column_old;
            for (int i = row_old + 1; i < row_new; i++) {
                j++;
                if (gameboard.squares[i][j].is_occupied()) {
                    return false;
                }
            }
            return true;
        }


        if (column_old > column_new && row_old < row_new) {
            int j = column_old;
            for (int i = row_old + 1; i < row_new; i++) {
                j--;
                if (gameboard.squares[i][j].is_occupied()) {
                    return false;
                }
            }
            return true;
        }

        if (column_old > column_new && row_old > row_new) {
            int j = column_old;
            for (int i = row_old - 1; i > row_new; i--) {
                j--;
                if (gameboard.squares[i][j].is_occupied()) {
                    return false;
                }
            }
            return true;
        }

        if (column_old < column_new && row_old > row_new) {
            int j = column_old;
            for (int i = row_old - 1; i > row_new; i--) {
                j++;
                if (gameboard.squares[i][j].is_occupied()) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }
}
