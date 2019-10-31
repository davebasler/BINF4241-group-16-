import java.util.*;

class Move {
    private boolean is_check=false;
    private boolean is_checkmate=false;

    private PossibleMoves possiblemoves = new PossibleMoves();
    private List<Figure> eaten_black_figures = new ArrayList<Figure>();
    private List<Figure> eaten_white_figures = new ArrayList<Figure>();

    /*
  input: GameBoard, QuestionColumnDigit, Player
  output: String
  checks if the proposed move is legal, then executes the move, checks if the resulting board has a check or a checkmate
  situation. If the latter is true, the game is over and this method returns the name of the winner.
   */
    String move_figure(GameBoard gameboard, UserInput user_input, Player active_player) {
        String active_player_name = active_player.get_name();
        Color active_player_color = active_player.get_color();
        boolean rochade_legal = false;

        //get user input
        user_input.get_input(active_player_name);
        int old_row = user_input.get_old_row();
        int old_column = user_input.get_old_column();
        int new_column = user_input.get_new_column();
        int new_row = user_input.get_new_row();

        //special case if small rochade (user input: 0-0)
        if (old_row == -1) {
            System.out.println("Small Rochade");
            rochade_legal = small_rochade(gameboard, active_player_color);
            if (!rochade_legal) {
                user_input.get_input(active_player_name);
                old_row = user_input.get_old_row();
                old_column = user_input.get_old_column();
                new_column = user_input.get_new_column();
                new_row = user_input.get_new_row();
            }
        }

        //special case if big rochade (user input: 0-0-0)
        else if (old_row == -2) {
            System.out.println("Big Rochade");
            rochade_legal = big_rochade(gameboard, active_player_color);
            if (!rochade_legal) {
                user_input.get_input(active_player_name);
                old_row = user_input.get_old_row();
                old_column = user_input.get_old_column();
                new_column = user_input.get_new_column();
                new_row = user_input.get_new_row();
            }
        }

        //normal part if no rochade before
        if (!rochade_legal) {
            Boolean temp = true;
            while (temp) {
                temp = false;

                //check if there is a figure on the old square
                if (!gameboard.squares[old_row][old_column].is_occupied()) {
                    System.out.println("There isn't a valid figure on this field!");
                    user_input.get_input(active_player_name);
                    old_column = user_input.get_old_column();
                    old_row = user_input.get_old_row();
                    temp = true;
                }

                //check if the figure on the old square is the current players color
                if (!temp) {
                    if (!gameboard.squares[old_row][old_column].get_figure().get_colour().equals(active_player_color.toString())) {
                        System.out.println("There isn't a valid figure on this field!");
                        user_input.get_input(active_player_name);
                        old_column = user_input.get_old_column();
                        old_row = user_input.get_old_row();
                        temp = true;
                    }
                }
                new_column = user_input.get_new_column();
                new_row = user_input.get_new_row();

                /*
                check if proposed new square can legally be reached by using the figures is_legal and is_legal_path
                methods
                */
                if (!temp) {
                    if (!gameboard.squares[old_row][old_column].get_figure().is_legal(old_row, old_column, new_row, new_column) ||
                            !gameboard.squares[old_row][old_column].get_figure().is_path_legal(gameboard, old_row, old_column, new_row, new_column) ||
                            (old_column == new_column && old_row == new_row) ||
                            !can_eat(gameboard, old_row, old_column, new_row, new_column)) {

                        //special case if pawn can eat enemy diagonally
                        if (gameboard.squares[old_row][old_column].get_figure().get_type().equals(FigureType.PAWN.toString())
                                && gameboard.squares[new_row][new_column].get_figure() != null) {
                            if (!gameboard.squares[new_row][new_column].get_figure().get_colour().equals(gameboard.squares[old_row][old_column].get_figure().get_colour())
                                    && gameboard.squares[old_row][old_column].get_figure().is_legal_eat_diagonal(old_row, old_column, new_row, new_column)) {
                                break;
                            }
                        }

                        //En passant
                        if (gameboard.squares[old_row][old_column].get_figure().get_type().equals(FigureType.PAWN.toString())
                                && gameboard.squares[new_row][new_column].get_figure() == null) {
                            if (gameboard.squares[old_row][old_column].get_figure().is_legal_en_passant(old_row, old_column, new_row, new_column, gameboard)
                                    && gameboard.squares[old_row][old_column].get_figure().is_legal_eat_diagonal(old_row, old_column, new_row, new_column)) {
                                if (old_column > new_column) {
                                    eat_en_passant(gameboard, old_row, old_column - 1, active_player);
                                    break;
                                } else {
                                    eat_en_passant(gameboard, old_row, old_column + 1, active_player);
                                    break;
                                }
                            }
                        }

                        temp = true;

                        System.out.println("You can't move this figure to this field!");
                        user_input.get_input(active_player_name);
                        new_column = user_input.get_new_column();
                        old_row = user_input.get_old_row();
                    }
                }

                //check that king doesn't commit suicide
                if (!temp) {
                    is_check = possiblemoves.is_suicide(active_player_color, gameboard, new_row, new_column, old_row, old_column);
                    if (is_check) {
                        temp = true;
                        is_check = false;
                        System.out.println("Your King can't commit suicide!");
                        user_input.get_input(active_player_name);
                        old_column = user_input.get_old_column();
                        old_row = user_input.get_old_row();
                        new_column = user_input.get_new_column();
                        new_row = user_input.get_new_row();
                    }
                }

                /*
                if the king is currently in check, the new user input will only be accepted upon escaping the check
                situation with the proposed move
                */
                while (is_check) {
                    Figure temp_figure;
                    Figure eaten_figure_temp = null;
                    if (gameboard.squares[new_row][new_column].get_figure() == null) {
                        temp_figure = gameboard.squares[old_row][old_column].remove_figure();
                        gameboard.squares[new_row][new_column].add_figure(temp_figure);
                    } else {
                        temp_figure = gameboard.squares[old_row][old_column].remove_figure();
                        eaten_figure_temp = gameboard.squares[new_row][new_column].remove_figure();
                        gameboard.squares[new_row][new_column].add_figure(temp_figure);
                    }

                    possiblemoves.update_figure_list(gameboard);
                    possiblemoves.update_player_list(gameboard, Color.BLACK);
                    possiblemoves.update_player_list(gameboard, Color.WHITE);

                    if (active_player_color == Color.BLACK) {
                        is_check = possiblemoves.is_check(gameboard, Color.WHITE);
                    } else {
                        is_check = possiblemoves.is_check(gameboard, Color.BLACK);
                    }
                    if (is_check) {
                        if (eaten_figure_temp == null) {
                            gameboard.squares[new_row][new_column].remove_figure();
                            gameboard.squares[old_row][old_column].add_figure(temp_figure);
                        } else {
                            gameboard.squares[new_row][new_column].remove_figure();
                            gameboard.squares[new_row][new_column].add_figure(eaten_figure_temp);
                            gameboard.squares[old_row][old_column].add_figure(temp_figure);
                        }
                        temp = true;
                        System.out.println("Illegal move because King is still in chess!");
                        user_input.get_input(active_player_name);
                        old_column = user_input.get_old_column();
                        old_row = user_input.get_old_row();
                        new_column = user_input.get_new_column();
                        new_row = user_input.get_new_row();
                    } else {
                        if (eaten_figure_temp == null) {
                            gameboard.squares[new_row][new_column].remove_figure();
                            gameboard.squares[old_row][old_column].add_figure(temp_figure);
                        } else {
                            gameboard.squares[new_row][new_column].remove_figure();
                            gameboard.squares[new_row][new_column].add_figure(eaten_figure_temp);
                            gameboard.squares[old_row][old_column].add_figure(temp_figure);
                        }
                    }
                }
            }
        }

        if (!rochade_legal) {

        //player either eats enemy figure or moves to new square
            if (gameboard.squares[new_row][new_column].get_figure() == null) {
                gameboard.squares[new_row][new_column].add_figure(gameboard.squares[old_row][old_column].remove_figure());
            } else {
                eat_figure(gameboard, old_row, old_column, new_row, new_column, active_player);
            }

            //check if pawn is at the end of the gameboard for promotion
            if (gameboard.squares[new_row][new_column].get_figure().get_type().equals(FigureType.PAWN.toString())) {
                if (gameboard.squares[new_row][new_column].get_figure().get_colour().equals(Color.WHITE.toString()) && new_row == 0 ||
                        (gameboard.squares[new_row][new_column].get_figure().get_colour().equals(Color.BLACK.toString()) && new_row == 7)) {
                    switch_pawn(gameboard, new_row, new_column, active_player_color);
                }
            }

            //En passant move
            int time = active_player.set_timer();
            if (gameboard.squares[new_row][new_column].get_figure().get_type().equals(FigureType.PAWN.toString())) {
                gameboard.squares[new_row][new_column].get_figure().set_timer(time);
            }
        }
            possiblemoves.update_figure_list(gameboard);
            possiblemoves.update_player_list(gameboard, active_player_color);
            is_check = possiblemoves.is_check(gameboard, active_player_color);
            if (is_check) {
                is_checkmate = possiblemoves.is_checkmate(gameboard, active_player_color);
            }

            if (is_checkmate) {
                return active_player_name;
            } else {
                return "";
            }
        }


    /*
    input: none
    output: none
    prints the current list of eaten figures of both players
    */
    void print_eaten_figures(){
        List<String> toprint_list_white = new ArrayList<>();
        List<String> toprint_list_black = new ArrayList<>();
        for(Figure figure_white: eaten_white_figures){
            toprint_list_white.add(figure_white.get_type());
        }
        for(Figure figure_black: eaten_black_figures){
            toprint_list_black.add(figure_black.get_type());
        }
        System.out.print("Eaten white figures: ");
        System.out.print(toprint_list_white+ "     ");
        System.out.print("Eaten black figures:  ");
        System.out.println(toprint_list_black);
    }

    /*
    input: GameBoard, int, int, Color
    output: none
    Promotion: if a pawn reaches end of gameboard, the player can choose a queen, tower, knight or bishop to replace the
    pawn.
    */
    private void switch_pawn(GameBoard gameboard, int new_row, int new_column, Color current_player_color) {
        String figure = "";
        boolean condition = false;
        while(!condition) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Choose a player you want to change with your pawn: ");
            figure = scan.nextLine();
            if (figure.equals("Bishop") || figure.equals("Night") || figure.equals("Queen") || figure.equals("Tower")) {
                condition = true;
            }
        }

        gameboard.squares[new_row][new_column].remove_figure();
            switch (figure) {
                case "Bishop":
                    gameboard.squares[new_row][new_column].add_figure(new Bishop(current_player_color));
                    break;
                case "Night":
                    gameboard.squares[new_row][new_column].add_figure(new Knight(current_player_color));
                    break;
                case "Queen":
                    gameboard.squares[new_row][new_column].add_figure(new Queen(current_player_color));
                    break;
                case "Tower":
                    gameboard.squares[new_row][new_column].add_figure(new Tower(current_player_color));
                    break;
            }
        }

    /*
     input: GameBoard, int, int, int, int
     output: boolean
     returns true if figure can eat an enemy figure on the proposed square
     */
    private boolean can_eat(GameBoard gameboard, int row_old, int column_old, int row_new, int column_new){
        if(gameboard.squares[row_new][column_new].get_figure()!=null){
            if(gameboard.squares[row_old][column_old].get_figure().get_colour().equals(gameboard.squares[row_new][column_new].get_figure().get_colour())){
                return false;
            }
            //Special case for pawn. It forbids the pawn to eat figures that are in front of him.
            else if((gameboard.squares[row_old][column_old].get_figure().get_type().equals(FigureType.PAWN.toString()))
                    &&(column_old==column_new)){
                return false;
            }
            else
            {
                return true;
            }
        }
        else{
            return true;
        }
    }

    /*
     input: GameBoard, int, int, Player
     output: none
     special case for pawn figure: pawn eats the enemy figure when in a en passant situation
     */
    private void eat_en_passant(GameBoard gameboard, int row_old, int column_old, Player active_player){
        Figure temp = gameboard.squares[row_old][column_old].remove_figure();
        active_player.add_eaten_piece();
        if(temp.get_colour().equals(Color.BLACK.toString())){
            eaten_black_figures.add(temp);
        }
        else{
            eaten_white_figures.add(temp);
        }
    }

     /*
     input: GameBoard, int, int, int, int, Player
     output: none
     player eats the enemy figure on the new square and moves its own figure from the old to the new square
     */
    private void eat_figure(GameBoard gameboard, int row_old, int column_old, int row_new, int column_new, Player active_player){
        Figure temp = gameboard.squares[row_new][column_new].remove_figure();
        gameboard.squares[row_new][column_new].add_figure(gameboard.squares[row_old][column_old].remove_figure());
        active_player.add_eaten_piece();
        if(temp.get_colour().equals(Color.BLACK.toString())){
            eaten_black_figures.add(temp);
        }
        else{
            eaten_white_figures.add(temp);
        }
    }

    /*
    input: GameBoard, Color
    output: boolean
    checks if the small rochade is legal, if so it executes the rochade and returns true, else nothing happens
    and it returns false
    */
    public boolean small_rochade(GameBoard gameboard, Color player_color){
        if(player_color==Color.BLACK){
            if(gameboard.squares[0][4].get_figure()!=null && gameboard.squares[0][7].get_figure()!=null){
                if(gameboard.squares[0][4].get_figure().get_type()==FigureType.KING.toString() &&
                        gameboard.squares[0][4].get_figure().get_colour()==Color.BLACK.toString()) {
                    if (gameboard.squares[0][7].get_figure().get_type() == FigureType.TOWER.toString() &&
                            gameboard.squares[0][7].get_figure().get_colour() == Color.BLACK.toString()) {
                        if (gameboard.squares[0][5].get_figure() == null) {
                            if (gameboard.squares[0][6].get_figure() == null) {
                                //check if king commits suicide
                                if (!possiblemoves.is_suicide(player_color, gameboard, 0,6,0,4)) {
                                    gameboard.squares[0][6].add_figure(gameboard.squares[0][4].remove_figure());
                                    gameboard.squares[0][5].add_figure(gameboard.squares[0][7].remove_figure());
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        else{
            if(gameboard.squares[7][4].get_figure()!=null && gameboard.squares[7][7].get_figure()!=null) {
                if (gameboard.squares[7][4].get_figure().get_type() == FigureType.KING.toString() &&
                        gameboard.squares[7][4].get_figure().get_colour() == Color.WHITE.toString()) {
                    if (gameboard.squares[7][7].get_figure().get_type() == FigureType.TOWER.toString() &&
                            gameboard.squares[7][7].get_figure().get_colour() == Color.WHITE.toString()) {
                        if (gameboard.squares[7][5].get_figure() == null) {
                            if (gameboard.squares[7][6].get_figure() == null) {
                                //check if king commits suicide
                                if (!possiblemoves.is_suicide(player_color, gameboard, 7, 6, 7, 4)) {
                                    gameboard.squares[7][6].add_figure(gameboard.squares[7][4].remove_figure());
                                    gameboard.squares[7][5].add_figure(gameboard.squares[7][7].remove_figure());
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /*
    input: GameBoard, Color
    output: boolean
    checks if the big rochade is legal, if so it executes the rochade and returns true, else nothing happens
    and it returns false
    */
    public boolean big_rochade(GameBoard gameboard, Color player_color){
        if(player_color==Color.BLACK){
            if(gameboard.squares[0][4].get_figure()!=null && gameboard.squares[0][0].get_figure()!=null){
                if(gameboard.squares[0][4].get_figure().get_type()==FigureType.KING.toString() &&
                        gameboard.squares[0][4].get_figure().get_colour()==Color.BLACK.toString()) {
                    if (gameboard.squares[0][0].get_figure().get_type() == FigureType.TOWER.toString() &&
                            gameboard.squares[0][0].get_figure().get_colour() == Color.BLACK.toString()) {
                        if (gameboard.squares[0][1].get_figure() == null) {
                            if (gameboard.squares[0][2].get_figure() == null) {
                                if (gameboard.squares[0][3].get_figure() == null) {
                                    if (!possiblemoves.is_suicide(player_color, gameboard, 0, 2, 0, 4)) {
                                        gameboard.squares[0][2].add_figure(gameboard.squares[0][4].remove_figure());
                                        gameboard.squares[0][3].add_figure(gameboard.squares[0][0].remove_figure());
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        else{
            if(gameboard.squares[7][4].get_figure()!=null && gameboard.squares[7][0].get_figure()!=null){
                if(gameboard.squares[7][4].get_figure().get_type()==FigureType.KING.toString() &&
                        gameboard.squares[7][4].get_figure().get_colour()==Color.WHITE.toString()) {
                    if (gameboard.squares[7][0].get_figure().get_type() == FigureType.TOWER.toString() &&
                            gameboard.squares[7][0].get_figure().get_colour() == Color.WHITE.toString()) {
                        if (gameboard.squares[7][1].get_figure() == null) {
                            if (gameboard.squares[7][2].get_figure() == null) {
                                if (gameboard.squares[7][3].get_figure() == null) {
                                    if (!possiblemoves.is_suicide(player_color, gameboard, 7, 2, 7, 4)) {
                                        gameboard.squares[7][2].add_figure(gameboard.squares[7][4].remove_figure());
                                        gameboard.squares[7][3].add_figure(gameboard.squares[7][0].remove_figure());
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
