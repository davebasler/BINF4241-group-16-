public class Queen extends Figure {

    private FigureType type;

    public Queen(Color color){
        super(color);
        this.type = FigureType.QUEEN;
    }

    public String get_type() {
        return this.type.toString();
    }

    public String get_colour() {
        return this.color.toString();
    }

    @Override
    public boolean is_legal(int row_old, int column_old, int row_new, int column_new) {
        return row_old==row_new || column_new==column_old || Math.abs(column_new-column_old)==Math.abs(row_new-row_old);
    }

    @Override
    public boolean is_path_legal(GameBoard gameboard, int row_old, int column_old, int row_new, int column_new) {
        if(column_new==column_old && row_old<row_new){
            for(int i=row_old+1;i<row_new;i++){
                if(gameboard.squares[i][column_new].is_occupied()){
                    return false;
                }
            }
            return true;
        }
        if(column_new==column_old && row_old>row_new){
            for(int i=row_old-1;i>row_new;i--){
                if(gameboard.squares[i][column_new].is_occupied()){
                    return false;
                }
            }
            return true;
        }
        if(row_new==row_old && column_old<column_new){
            for(int i=column_old+1;i<column_new;i++){
                if(gameboard.squares[row_new][i].is_occupied()){
                    return false;
                }
            }
            return true;
        }
        if(row_new==row_old && column_old>column_new){
            for(int i=column_old-1;i>column_new;i--){
                if(gameboard.squares[row_new][i].is_occupied()){
                    return false;
                }
            }
            return true;
        }
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
