public class Knight extends Figure {

    private FigureType type;

    public Knight(Color color){
        super(color);
        this.type = FigureType.KNIGHT;
    }

    public String get_type() {
      //in order to seperate from King
        return "Night";
    }

    public String get_colour() {
        return this.color.toString();
    }

    @Override
    public boolean is_legal(int row_old, int column_old, int row_new, int column_new) {
        boolean var = false;
        if (row_new == row_old +2 && column_new == column_old +1){
            var = true;
        }
        if (row_new == row_old +2 && column_new == column_old -1){
            var = true;
        }
        if (row_new == row_old -2 && column_new == column_old +1){
            var = true;
        }
        if(row_new == row_old -2 && column_new == column_old -1){
            var = true;
        }
        if(column_new == column_old +2 && row_new == row_old +1){
            var = true;
        }
        if (column_new == column_old +2 && row_new == row_old -1){
            var = true;
        }
        if (column_new == column_old -2 && row_new == row_old +1){
            var = true;
        }
        if (column_new == column_old -2 && row_new == row_old -1){
            var = true;
        }

        return var;
    }
    @Override
    public boolean is_path_legal(GameBoard gameboard, int row_old, int column_old, int row_new, int column_new) {
        return true;
    }
}
