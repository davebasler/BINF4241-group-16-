public class Player {
    private String name;
    private Color color;
    private int eaten_pieces;
    private static int timer=0;

    public Player(String name, Color color){
        this.name = name;
        this.color = color;
        this.eaten_pieces = 0;
    }

    public String get_name(){
        return this.name;
    }

    public Color get_color(){
        return this.color;
    }

    public void add_eaten_piece(){
        this.eaten_pieces++;
    }

    public int set_timer(){
        timer++;
        return timer;
    }
}
