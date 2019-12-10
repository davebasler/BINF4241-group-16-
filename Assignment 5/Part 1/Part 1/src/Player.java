public class Player {
    public java.lang.System System;
    private String name;
    private int currentfield;
    private boolean winner;

    public Player(String name) {
        this.name = name;
        this.currentfield=1;
        this.winner=false;
    }

    public String get_name(){
        return this.name;
    }

    public int get_currentfield(){
        return this.currentfield;
    }

    public boolean is_winner(){
        this.winner=true;
        return true;
    }
    public int change_current_field(int num){
        this.currentfield += num;
        return this.currentfield;
    }





}
