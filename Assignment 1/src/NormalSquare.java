public class NormalSquare extends Square{
    public NormalSquare(int index, int size) {
        super(index, size);
        this.type = "normal";
    }

    public boolean is_occupied(){
        return this.occupied;
    }
    public boolean occupied_change(boolean bool) {
        this.occupied = bool;
        return this.occupied;
    }
}
