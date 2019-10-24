public class Square {

    private Color color;
    private Figure figure;
    private FigureType type;

    Square(Color color){
        this.color = color;
        this.figure = null;
        this.type = FigureType.SQUARE;
    }

    public String get_type() {
        return this.type.toString();
    }

    boolean is_occupied(){
        return this.figure != null;
}

    void add_figure(Figure figure){
        this.figure = figure;
    }

    Figure remove_figure(){
        Figure temp = this.figure;
        this.figure = null;
        return temp;
    }

    Figure get_figure(){
        return this.figure;
    }
}


