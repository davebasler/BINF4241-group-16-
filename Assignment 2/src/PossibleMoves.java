import java.util.ArrayList;
import java.util.List;

class PossibleMoves {
    private List<Square> possible_moves_black = new ArrayList<Square>();
    private List<Square> possible_moves_white = new ArrayList<Square>();

    /*
    input: GameBoard
    output: none
    Updates each figures list of possible squares which it can move to currently.
     */
    void update_figure_list(GameBoard gameboard) {
        ArrayList current_list; Figure figure;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (gameboard.squares[i][j].get_figure() != null) {
                    figure = gameboard.squares[i][j].get_figure();
                    current_list = gameboard.squares[i][j].get_figure().get_list();
                    current_list.clear();
                    for (int k = 0; k < 8; k++) {
                        for (int r = 0; r < 8; r++) {
                            if (figure.get_type().equals(FigureType.PAWN.toString())) {
                                if(figure.is_legal_eat_diagonal(i,j,k,r)){
                                    if(gameboard.squares[k][r].get_figure()!=null){
                                        if(!figure.get_colour().equals(gameboard.squares[k][r].get_figure().get_colour())) {
                                            current_list.add(gameboard.squares[k][r]);
                                        }
                                    }
                                }
                                else if (figure.is_legal(i, j, k, r) &&
                                        figure.is_path_legal(gameboard, i, j, k, r) &&
                                        (k != i || r != j) &&
                                        can_eat(gameboard, i, j, k, r)) {
                                    current_list.add(gameboard.squares[k][r]);
                                }
                            }
                            else {
                                if ((figure.is_legal(i, j, k, r) &&
                                        figure.is_path_legal(gameboard, i, j, k, r) &&
                                        (k != i || r != j)) &&
                                        can_eat(gameboard, i, j, k, r)) {
                                    current_list.add(gameboard.squares[k][r]);
                                }
                            }
                        }
                    }
                    int fig = current_list.size();
                    //System.out.println("Number of possible moves of this figure: " + fig);
                }
            }
        }
    }


    private ArrayList<Square> list= new ArrayList<Square>();

    /*
    input: GameBoard, Color
    output: none
    Updates each players list of squares which can be reached currently.
     */
    void update_player_list(GameBoard gameboard, Color current_player_color) {
        list.clear();
        if (current_player_color == Color.WHITE) {
            possible_moves_white.clear();
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if(gameboard.squares[i][j].get_figure()!=null) {
                        if (gameboard.squares[i][j].get_figure().get_colour().equals(current_player_color.toString())) {
                            list.clear();
                            list = gameboard.squares[i][j].get_figure().get_list();
                            for (Square square : list) {
                                if(!possible_moves_white.contains(square)){
                                    possible_moves_white.add(square);
                                }
                            }
                        }
                    }
                }
            }
            int fig = possible_moves_white.size();
            //System.out.println("Number of possible moves of PLAYER WHITE: " + fig);
        }

        else{
            possible_moves_black.clear();
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if(gameboard.squares[i][j].get_figure()!=null) {
                        if (gameboard.squares[i][j].get_figure().get_colour().equals(current_player_color.toString())) {
                            list.clear();
                            list = gameboard.squares[i][j].get_figure().get_list();
                            for (Square square : list) {
                                if(!possible_moves_black.contains(square)){
                                    possible_moves_black.add(square);
                                }
                            }
                        }
                    }
                }
            }
            int fig = possible_moves_black.size();
            //System.out.println("Number of possible moves of PLAYER BLACK: " + fig);
        }
    }

    /*
    input: GameBoard, Color
    output: boolean
    Returns true if there is a check currently, false if not. If it's the black players the check is for the white king
    and vice versa.
    => iterates through each square to find the king, checks if the square which has the king is in the the list of
    possible player moves.
     */
    boolean is_check(GameBoard gameboard, Color current_player_color){
        if(current_player_color==Color.BLACK){
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if(gameboard.squares[i][j].get_figure()!=null) {
                        if(gameboard.squares[i][j].get_figure().get_colour().equals(Color.WHITE.toString()) &&
                                gameboard.squares[i][j].get_figure().get_type().equals(FigureType.KING.toString())){
                            for(Square square : possible_moves_black){
                                if(square==gameboard.squares[i][j]){
                                    //System.out.println("CHESS!!!!");
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
            //System.out.println("NOT CHESS!!!!");
            return false;
        }
        else{
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if(gameboard.squares[i][j].get_figure()!=null) {
                        if(gameboard.squares[i][j].get_figure().get_colour().equals(Color.BLACK.toString()) &&
                                gameboard.squares[i][j].get_figure().get_type().equals(FigureType.KING.toString())){
                            for(Square square : possible_moves_white){
                                if(square==gameboard.squares[i][j]){
                                    //System.out.println("CHESS!!!!");
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
            //System.out.println("NOT CHESS!!!!");
            return false;
        }
    }

    private ArrayList<Square> king_moves= new ArrayList<Square>();
    private ArrayList<Square> all_moves= new ArrayList<Square>();

    /*
    input: GameBoard, Color
    output: boolean
    returns true if there is a checkmate, false if not.
    => tests all possible moves by each figure of the respective color to see if there is a possibility to not have
    get out of the check situation
     */
    boolean is_checkmate(GameBoard gameboard, Color current_player_color){
            if(current_player_color==Color.BLACK){
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if(gameboard.squares[i][j].get_figure()!=null) {
                            if(gameboard.squares[i][j].get_figure().get_colour().equals(Color.WHITE.toString()) &&
                                    gameboard.squares[i][j].get_figure().get_type().equals(FigureType.KING.toString())){
                                king_moves = gameboard.squares[i][j].get_figure().get_list();
                                for(Square square : king_moves){
                                    if(!possible_moves_black.contains(square)){
                                        //System.out.println("NOT CHECKMATE!!!!");
                                        return false;
                                    }
                                }
                            }
                            else if(gameboard.squares[i][j].get_figure().get_colour().equals(Color.WHITE.toString())){
                                all_moves.clear();
                                all_moves = gameboard.squares[i][j].get_figure().get_list();
                                for (int k = 0; k < 8; k++) {
                                    for (int r = 0; r < 8; r++) {
                                        if(all_moves.contains(gameboard.squares[k][r])){
                                            if(gameboard.squares[k][r].get_figure()==null){
                                                Figure temp_figure = gameboard.squares[i][j].remove_figure();
                                                gameboard.squares[k][r].add_figure(temp_figure);
                                                update_figure_list(gameboard);
                                                update_player_list(gameboard,Color.WHITE);
                                                update_player_list(gameboard,Color.BLACK);
                                                boolean check_if_check = is_check(gameboard,current_player_color);
                                                if(!check_if_check){
                                                    gameboard.squares[k][r].remove_figure();
                                                    gameboard.squares[i][j].add_figure(temp_figure);
                                                    //System.out.println("NOT CHECKMATE!!!!");
                                                    return false;
                                                }
                                                gameboard.squares[k][r].remove_figure();
                                                gameboard.squares[i][j].add_figure(temp_figure);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                //System.out.println("CHECKMATE!!!!");
                return true;
            }
            else{
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if(gameboard.squares[i][j].get_figure()!=null) {
                            if(gameboard.squares[i][j].get_figure().get_colour().equals(Color.BLACK.toString()) &&
                                    gameboard.squares[i][j].get_figure().get_type().equals(FigureType.KING.toString())){
                                king_moves = gameboard.squares[i][j].get_figure().get_list();
                                for(Square square : king_moves){
                                    if(!possible_moves_white.contains(square)){
                                        //System.out.println("NOT CHECKMATE1!!!!");
                                        return false;
                                    }
                                }
                            }

                        else if(gameboard.squares[i][j].get_figure().get_colour().equals(Color.BLACK.toString())){
                            all_moves.clear();
                            all_moves = gameboard.squares[i][j].get_figure().get_list();
                            for (int k = 0; k < 8; k++) {
                                for (int r = 0; r < 8; r++) {
                                    if(all_moves.contains(gameboard.squares[k][r])) {
                                        if (gameboard.squares[k][r].get_figure() == null) {
                                            Figure temp_figure = gameboard.squares[i][j].remove_figure();
                                            gameboard.squares[k][r].add_figure(temp_figure);
                                            update_figure_list(gameboard);
                                            update_player_list(gameboard, Color.WHITE);
                                            update_player_list(gameboard, Color.BLACK);
                                            boolean check_if_check = is_check(gameboard, current_player_color);
                                            if (!check_if_check) {
                                                gameboard.squares[k][r].remove_figure();
                                                gameboard.squares[i][j].add_figure(temp_figure);
                                                //System.out.println("NOT CHECKMATE2!!!!");
                                                return false;
                                            }
                                            gameboard.squares[k][r].remove_figure();
                                            gameboard.squares[i][j].add_figure(temp_figure);
                                        }
                                    }
                                    }
                                }
                            }
                        }
                    }
                }
                //System.out.println("CHECKMATE3!!!!");
                return true;
            }
    }

    /*
    input: Color, GameBoard, int, int, int, int
    output: boolean
    returns true if a king suicide results of the proposed move, false if not.
     */
    boolean is_suicide(Color player_color, GameBoard gameboard, int new_row, int new_column, int old_row, int old_column){
        if(gameboard.squares[old_row][old_column].get_figure().get_type()==FigureType.KING.toString()){
        if(player_color==Color.BLACK){
            for(Square square: possible_moves_white){
                if(square==gameboard.squares[new_row][new_column]){
                    return true;
                }
            }
        }
        else{
            for(Square square: possible_moves_black){
                if(square==gameboard.squares[new_row][new_column]){
                    return true;
                }
            }
        }
        }
        else{
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

            update_figure_list(gameboard);
            update_player_list(gameboard, Color.BLACK);
            update_player_list(gameboard, Color.WHITE);


            boolean is_check;
            if (player_color == Color.BLACK) {
                is_check = is_check(gameboard, Color.WHITE);
            } else {
                is_check = is_check(gameboard, Color.BLACK);
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
               return true;
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
        return false;
    }

    /*
    input: GameBoard, int, int, int, int
    output: boolean
    Returns true if player can eat the figure on the proposed square it would move on.
    Special case for Pawn as it can not eat the figure in front of it.
     */
    private boolean can_eat(GameBoard gameboard, int row_old, int column_old, int row_new, int column_new){
        if(gameboard.squares[row_new][column_new].get_figure()!=null){
            if(gameboard.squares[row_old][column_old].get_figure().get_colour()==
                    gameboard.squares[row_new][column_new].get_figure().get_colour()){
                return false;
            }
            else if((gameboard.squares[row_old][column_old].get_figure().get_type()==FigureType.PAWN.toString())   //Special case for pawn. It forbids the pawn to eat figures that are in front of him.
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
}
