import java.util.ArrayList;

public class FigureIterator implements Iterator {

    ArrayList<Square> squares;
    int position = 0;

   public FigureIterator(ArrayList<Square> squares){
       this.squares = squares;
   }
    @Override
    public boolean hasNext() {
        if(position >= squares.size() || squares.get(position) == null){
            return false;

        }else{
            return true;
        }
    }

    @Override
    public Object next() {
        Square square = squares.get(position);
        position += 1;
        return square;
    }
}
