public class GameBoard {

    Square[][] squares = new Square[8][8];

    /* Square[][] InitializeGameboard() initializes the gameboard with 8x8 (black and white) squares and spawns the
    figures on the corresponding field.
    */
    Square[][] InitializeGameboard() {
        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < 8; j++){
                    if (j%2==0){
                squares[i][j] = new Square(Color.WHITE);
                      }
                    else{
                        squares[i][j] = new Square(Color.BLACK);
                    }
                }
            }
            else {
                for (int j = 0; j < 8; j++){
                    if (j%2==0){
                        squares[i][j] = new Square(Color.BLACK);
                    }
                    else{
                        squares[i][j] = new Square(Color.WHITE);
                    }
                }
            }

        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(i == 0 && (j==0||j==7)){
                    squares[i][j].add_figure(new Tower(Color.BLACK));
                }
                else if(i == 0 && (j==1||j==6)){
                    squares[i][j].add_figure(new Knight(Color.BLACK));
                }
                else if(i == 0 && (j==2||j==5)) {
                    squares[i][j].add_figure(new Bishop(Color.BLACK));
                }
                else if(i == 0 && j==3) {
                    squares[i][j].add_figure(new Queen(Color.BLACK));
                }
                else if(i == 0 && j==4) {
                    squares[i][j].add_figure(new King(Color.BLACK));
                }
                else if(i == 1 && (0<=j || j< 8)) {
                    squares[i][j].add_figure(new Pawn(Color.BLACK));
                }
                else if(i == 7 && (j==0||j==7)){
                    squares[i][j].add_figure(new Tower(Color.WHITE));
                }
                else if(i == 7 && (j==1||j==6)){
                    squares[i][j].add_figure(new Knight(Color.WHITE));
                }
                else if(i == 7 && (j==2||j==5)) {
                    squares[i][j].add_figure(new Bishop(Color.WHITE));
                }
                else if(i == 7 && j==4) {
                    squares[i][j].add_figure(new King(Color.WHITE));
                }
                else if(i == 7 && j==3) {
                    squares[i][j].add_figure(new Queen(Color.WHITE));
                }
                else if(i == 6 && (0<=j || j< 8)) {
                    squares[i][j].add_figure(new Pawn(Color.WHITE));
                }

            }

        }
        return squares;
    }

    /*
    Prints the state of the board with all figures that may have changed their position.
    */
    void PrintGameboardStatus(){
        System.out.println(".     a   b   c   d   e   f   g   h      .");
        System.out.println();
        for(int i = 0;i<8;i++){
            System.out.print((8 - i) +"    " );
            for(int j = 0;j<8;j++){
                if(!squares[i][j].is_occupied()){
                    System.out.print("[  ]");
                }
                else{
                    System.out.print("[" + squares[i][j].get_figure().get_colour().charAt(0) +
                            squares[i][j].get_figure().get_type().charAt(0) + "]");
                }}
            System.out.print("    " + (8 - i));
            System.out.println();
        }
        System.out.println();
        System.out.println(".     a   b   c   d   e   f   g   h      .");
        System.out.println();
    }
}
