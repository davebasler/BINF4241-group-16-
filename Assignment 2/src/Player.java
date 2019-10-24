class Player {
    private String name;
    private Color color;
    private int eaten_pieces;
    private static int timer=0;

    Player(String name, Color color){
        this.name = name;
        this.color = color;
        this.eaten_pieces = 0;
    }

    String get_name(){
        return this.name;
    }

    Color get_color(){
        return this.color;
    }

    void add_eaten_piece(){
        this.eaten_pieces++;
    }

    int set_timer(){
        timer++;
        return timer;
    }
}
