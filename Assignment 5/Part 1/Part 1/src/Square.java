public class Square {
    public String type;
    public int index;
    public int leads_to_field;
    public boolean occupied;

    public Square(int index,int size){
        this.index = index;
        this.occupied = false;
    }

    public int get_index(){
        return this.index;
    }

    public String get_type(){
        return this.type;
    }
    public int get_leads_to_field(){
        return this.leads_to_field;
    }

    }



