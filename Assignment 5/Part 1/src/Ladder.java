public class Ladder extends Square {
    public Ladder(int index, int size) {
        super(index, size);
        this.type = "ladder";
        this.leads_to_field = index+2;
    }
}
