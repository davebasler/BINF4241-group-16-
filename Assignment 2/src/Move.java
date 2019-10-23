import java.util.*;

public class Move {
    boolean is_check=false;
    boolean is_checkmate=false;
    Eat eat = new Eat();
    PossibleMoves possiblemoves = new PossibleMoves();

    public String move_figure(GameBoard gameboard, QuestionColumnDigit question, Player active_player){
        String active_player_name = active_player.get_name();
        Color active_player_color = active_player.get_color();

        question.get_input(active_player_name);
        int old_column = question.get_old_column();
        int old_row = question.get_old_row();
        int new_column = question.get_new_column();
        int new_row = question.get_new_row();

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
                if (gameboard.squares[old_row][old_column].get_figure().get_colour() != active_player_color.toString()) {
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
                        !eat.can_eat(gameboard, old_row, old_column, new_row, new_column)) {

                    //special case if pawn can eat enemy diagonally
                    if (gameboard.squares[old_row][old_column].get_figure().get_type().equals(FigureType.PAWN.toString())
                            && gameboard.squares[new_row][new_column].get_figure() != null) {
                        if (gameboard.squares[new_row][new_column].get_figure().get_colour() != gameboard.squares[old_row][old_column].get_figure().get_colour()
                                && gameboard.squares[old_row][old_column].get_figure().is_legal_eat_diagonal(old_row, old_column, new_row, new_column)) {
                            break;
                        }
                    }
                    temp = true;

                    System.out.println("You can't move this figure to this field!");
                    question.get_input(active_player_name);
                    new_column = question.get_new_column();
                    old_row = question.get_old_row();
                }
                while(is_check){
                    Figure temp_figure = null;
                    if(gameboard.squares[new_row][new_column].get_figure()==null){
                        temp_figure = gameboard.squares[old_row][old_column].remove_figure();
                        gameboard.squares[new_row][new_column].add_figure(temp_figure);
                    }

                    possiblemoves.update_figure_list(gameboard);
                    possiblemoves.update_player_list(gameboard, Color.BLACK);
                    possiblemoves.update_player_list(gameboard, Color.WHITE);


                    gameboard.PrintGameboardStatus();
                    if(active_player_color==Color.BLACK) {

                        is_check = possiblemoves.is_check(gameboard, Color.WHITE);

                    }
                    else{

                        is_check = possiblemoves.is_check(gameboard, Color.BLACK);
                    }
                    if(is_check) {
                        gameboard.squares[new_row][new_column].remove_figure();
                        gameboard.squares[old_row][old_column].add_figure(temp_figure);
                        temp = true;
                        System.out.println("Illegal move because King is still in chess!");
                        question.get_input(active_player_name);
                        old_column = question.get_old_column();
                        old_row = question.get_old_row();
                        new_column = question.get_new_column();
                        new_row = question.get_new_row();
                    }
                    else{
                        gameboard.squares[new_row][new_column].remove_figure();
                        gameboard.squares[old_row][old_column].add_figure(temp_figure);
                    }
                }
            }
        }





        if(gameboard.squares[new_row][new_column].get_figure()==null){
            gameboard.squares[new_row][new_column].add_figure(gameboard.squares[old_row][old_column].remove_figure());
        }

        else {
            eat.eat_figure(gameboard,old_row,old_column,new_row,new_column,active_player);
        }

        if (gameboard.squares[new_row][new_column].get_figure().get_type().equals(FigureType.PAWN.toString())) {


            if (gameboard.squares[new_row][new_column].get_figure().get_colour().equals(Color.WHITE.toString()) && new_row == 0 ||
                    (gameboard.squares[new_row][new_column].get_figure().get_colour().equals(Color.BLACK.toString()) && new_row == 7)) {
                switch_pawn(gameboard, new_row, new_column, active_player_color);
            }
        }
        possiblemoves.update_figure_list(gameboard);
        possiblemoves.update_player_list(gameboard,active_player_color);
        is_check = possiblemoves.is_check(gameboard,active_player_color);
        if(is_check){
            is_checkmate = possiblemoves.is_checkmate(gameboard,active_player_color);
        }

        if(is_checkmate){
            return active_player_name;
        }else{
            return "";
        }
    }

    public void print_eaten_figures(){
        List<String> toprint_list_white = new ArrayList<>();
        List<String> toprint_list_black = new ArrayList<>();
        for(Figure figure_white: eat.eaten_white_figures){
            toprint_list_white.add(figure_white.get_type());
        }
        for(Figure figure_black: eat.eaten_black_figures){
            toprint_list_black.add(figure_black.get_type());
        }
        System.out.print("Eaten white figures: ");
        System.out.print(toprint_list_white+ "     ");
        System.out.print("Eaten black figures:  ");
        System.out.println(toprint_list_black);


    }
    public void switch_pawn(GameBoard gameboard, int new_row, int new_column, Color current_player_color) {
        String figure = "Figgdich";
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
    }


