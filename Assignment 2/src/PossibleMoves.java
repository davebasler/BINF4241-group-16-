import java.util.ArrayList;
import java.util.List;

public class PossibleMoves {
    public List<Square> possible_moves_black = new ArrayList<Square>();
    public List<Square> possible_moves_white = new ArrayList<Square>();
    Eat eat = new Eat();

    public void update_figure_list(GameBoard gameboard) {
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
                                        eat.can_eat(gameboard, i, j, k, r)) {
                                    current_list.add(gameboard.squares[k][r]);
                                }
                            }
                            else {
                                if ((figure.is_legal(i, j, k, r) &&
                                        figure.is_path_legal(gameboard, i, j, k, r) &&
                                        (k != i || r != j)) &&
                                        eat.can_eat(gameboard, i, j, k, r)) {
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


    public ArrayList<Square> list= new ArrayList<Square>();

    public void update_player_list(GameBoard gameboard, Color current_player_color) {
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
            System.out.println("Number of possible moves of PLAYER WHITE: " + fig);
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
            System.out.println("Number of possible moves of PLAYER BLACK: " + fig);
        }
    }

    public boolean is_check(GameBoard gameboard, Color current_player_color){
        if(current_player_color==Color.BLACK){
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if(gameboard.squares[i][j].get_figure()!=null) {
                        if(gameboard.squares[i][j].get_figure().get_colour().equals(Color.WHITE.toString()) &&
                                gameboard.squares[i][j].get_figure().get_type().equals(FigureType.KING.toString())){
                            //System.out.println("CHESS!!!!");
                            for(Square square : possible_moves_black){
                                if(square==gameboard.squares[i][j]){
                                    System.out.println("CHESS!!!!");
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
            System.out.println("NOT CHESS!!!!");
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
                                    System.out.println("CHESS!!!!");
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
            System.out.println("NOT CHESS!!!!");
            return false;
        }
    }

    public ArrayList<Square> king_moves= new ArrayList<Square>();
    public ArrayList<Square> all_moves= new ArrayList<Square>();

    public boolean is_checkmate(GameBoard gameboard, Color current_player_color){
            if(current_player_color==Color.BLACK){
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if(gameboard.squares[i][j].get_figure()!=null) {
                            if(gameboard.squares[i][j].get_figure().get_colour().equals(Color.WHITE.toString()) &&
                                    gameboard.squares[i][j].get_figure().get_type().equals(FigureType.KING.toString())){
                                king_moves = gameboard.squares[i][j].get_figure().get_list();
                                for(Square square : king_moves){
                                    if(!possible_moves_black.contains(square)){
                                        System.out.println("NOT CHECKMATE!!!!");
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
                                                    System.out.println("NOT CHECKMATE!!!!");
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
                System.out.println("CHECKMATE!!!!");
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
                                        System.out.println("NOT CHECKMATE!!!!");
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
                                                System.out.println("NOT CHECKMATE!!!!");
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
                System.out.println("CHECKMATE!!!!");
                return true;
            }
    }
}
