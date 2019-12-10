public class Snake extends Square {
    public Snake(int index, int size) {
        super(index, size);
        this.type = "snake";
        this.leads_to_field = index-5;
    }
}
