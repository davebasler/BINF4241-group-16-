import java.util.*;

class Move {
    private boolean is_check=false;
    private boolean is_checkmate=false;

    private PossibleMoves possiblemoves = new PossibleMoves();
    private List<Figure> eaten_black_figures = new ArrayList<Figure>();
    private List<Figure> eaten_white_figures = new ArrayList<Figure>();

    String move_figure(GameBoard gameboard, QuestionColumnDigit question, Player active_player){
        String active_player_name = active_player.get_name();
        Color active_player_color = active_player.get_color();

        question.get_input(active_player_name);
        int old_row = question.get_old_row();
        int old_column = question.get_old_column();
        int new_column = question.get_new_column();
        int new_row = question.get_new_row();

        if(old_row==-1){
            System.out.println("Small Rochade");
        }
        else if(old_row==-2){
            System.out.println("Big Rochade");  //insert rochade function here
        }
        else {
            Boolean temp = true;
            while (temp) {
                temp = false;
                if (!gameboard.squares[old_row][old_column].is_occupied()) {
                    System.out.println("There isn't a valid figure on this field!");
                    question.get_input(active_player_name);
                    old_column = question.get_old_column();
                    old_row = question.get_old_row();
                    temp = true;
                }

                if (!temp) {
                    if (!gameboard.squares[old_row][old_column].get_figure().get_colour().equals(active_player_color.toString())) {
                        System.out.println("There isn't a valid figure on this field!");
                        question.get_input(active_player_name);
                        old_column = question.get_old_column();
                        old_row = question.get_old_row();
                        temp = true;
                    }
                }
                new_column = question.get_new_column();
                new_row = question.get_new_row();
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
                            if (gameboard.squares[old_row][old_column].get_figure().is_legal_en_passant(old_row, old_column, new_row, new_column,gameboard)
                                    && gameboard.squares[old_row][old_column].get_figure().is_legal_eat_diagonal(old_row, old_column, new_row, new_column)) {
                                if(old_column>new_column){
                                    eat_en_passant(gameboard, old_row, old_column - 1, active_player);
                                    break;
                                }
                                else{
                                    eat_en_passant(gameboard, old_row, old_column + 1, active_player);
                                    break;
                                }
                            }
                        }

                        temp = true;

                        System.out.println("You can't move this figure to this field!");
                        question.get_input(active_player_name);
                        new_column = question.get_new_column();
                        old_row = question.get_old_row();
                    }
                }

                //check that king doesn't commit suicide
                if(!temp){
                        is_check = possiblemoves.is_suicide(active_player_color,gameboard,new_row,new_column,old_row,old_column);
                        if (is_check) {
                            temp = true;
                            is_check = false;
                            System.out.println("Your King can't commit suicide!");
                            question.get_input(active_player_name);
                            old_column = question.get_old_column();
                            old_row = question.get_old_row();
                            new_column = question.get_new_column();
                            new_row = question.get_new_row();
                        }
                        }


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

                    //gameboard.PrintGameboardStatus();

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
                        question.get_input(active_player_name);
                        old_column = question.get_old_column();
                        old_row = question.get_old_row();
                        new_column = question.get_new_column();
                        new_row = question.get_new_row();
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

            if (gameboard.squares[new_row][new_column].get_figure() == null) {
                gameboard.squares[new_row][new_column].add_figure(gameboard.squares[old_row][old_column].remove_figure());
            } else {
                eat_figure(gameboard, old_row, old_column, new_row, new_column, active_player);
            }

            if (gameboard.squares[new_row][new_column].get_figure().get_type().equals(FigureType.PAWN.toString())) {
                if (gameboard.squares[new_row][new_column].get_figure().get_colour().equals(Color.WHITE.toString()) && new_row == 0 ||
                        (gameboard.squares[new_row][new_column].get_figure().get_colour().equals(Color.BLACK.toString()) && new_row == 7)) {
                    switch_pawn(gameboard, new_row, new_column, active_player_color);
                }
            }

            //En passant
        int time= active_player.set_timer();
        if (gameboard.squares[new_row][new_column].get_figure().get_type().equals(FigureType.PAWN.toString())) {
            gameboard.squares[new_row][new_column].get_figure().set_timer(time);
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

    private boolean can_eat(GameBoard gameboard, int row_old, int column_old, int row_new, int column_new){

        if(gameboard.squares[row_new][column_new].get_figure()!=null){
            if(gameboard.squares[row_old][column_old].get_figure().get_colour().equals(gameboard.squares[row_new][column_new].get_figure().get_colour())){
                return false;
            }
            else if((gameboard.squares[row_old][column_old].get_figure().get_type().equals(FigureType.PAWN.toString()))   //Special case for pawn. It forbids the pawn to eat figures that are in front of him.
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


    }


