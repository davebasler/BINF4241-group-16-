class Player{
    private String name;
    private Color color;
    private int eaten_pieces;
    private static int timer=0;


    /*
    input: String, Color
    output: none
    Initialization of the player with its color, name and number of eaten players
     */
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

    /*
    input: none
    output: none
    Increases number of eaten figures by 1
     */
    void add_eaten_piece(){
        this.eaten_pieces++;
    }

    /*
    input: none
    output: int
    timer counts the amount of rounds played (used for en passant)
     */
    public int set_timer(){
        timer++;
        return timer;
    }

}
