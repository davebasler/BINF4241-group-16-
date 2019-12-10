import java.util.List;

public class BoardStatus {
    public String get_current_status(int size_of_board, int player_number, List<Square> squares, List<Player> players) {
        //status of the game board
        String field = "";
        for (int k = 0; k < size_of_board; k++) {
            int index = squares.get(k).get_index();
            String str_index = String.valueOf(index);
            if (squares.get(k).get_type() == "ladder") {
                int leads_to_field = squares.get(k).get_leads_to_field();
                String str_leadsto = String.valueOf(leads_to_field);
                field = field + "[" + str_index + "->" + str_leadsto + "]";
            } else if (squares.get(k).get_type() == "snake") {
                int leads_to_field = squares.get(k).get_leads_to_field();
                String str_leadsto = String.valueOf(leads_to_field);
                field = field + "[" + str_leadsto + "<-" + str_index + "]";
            } else {
                field = field + "[" + str_index;
                for (int j = 0; j < player_number; j++) {
                    if (index == players.get(j).get_currentfield()) {
                        field = field + "<" + players.get(j).get_name() + ">";
                    }
                }
                field = field + "]";
            }
        }
        return field;
    }
}
