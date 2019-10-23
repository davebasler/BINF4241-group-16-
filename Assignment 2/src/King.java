public class King extends Figure {

    private FigureType type;

    public King(Color color){
        super(color);
        this.type = FigureType.KING;
    }

    public String get_type() {
        return this.type.toString();
    }

    public String get_colour() {
        return this.color.toString();
    }

    @Override
    public boolean is_legal(int row_old, int column_old, int row_new, int column_new) {
        return Math.abs(row_new - row_old) == 1 && column_new==column_old || Math.abs(column_new-column_old) == 1 && row_new == row_old
                || (Math.abs(row_new - row_old) == 1 && Math.abs(column_new-column_old) == 1);

    }
    @Override
    public boolean is_path_legal(GameBoard gameboard, int row_old, int column_old, int row_new, int column_new) {
        return true;
    }
}
