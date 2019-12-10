import org.junit.*;
import java.util.*;
import static org.junit.Assert.*;

public class Main_GameTest {
    int num; int size_of_board;
    private List<Square> squares;
    private List<Player> players;
    BoardStatus boardStatus = new BoardStatus();
    /**
     * create initial game conditions by creating new ArrayLists with player objects and square objects.
     * @param
     * @return void
     */
    @Before
    public void setUp(){
        num = 2;
        size_of_board= 17;

       squares = new ArrayList<Square>();
        for(int index=1; index < size_of_board+1; index++){
            if(index==1) {
                Square square = new StartSquare(index, size_of_board);
                squares.add(square);
            }
            else if(index==size_of_board-1) {
                Square square = new EndSquare(index, size_of_board);
                squares.add(square);
            }
            else if(index%5==0 && index < size_of_board-2) {
                Square square = new Ladder(index, size_of_board);
                squares.add(square);
            }
            else if(index%11==0 && index < size_of_board) {
                Square square = new Snake(index, size_of_board);
                squares.add(square);
            }
            else{
                Square square = new NormalSquare(index,size_of_board);
                squares.add(square);
            }
        }
        players = new ArrayList<Player>();
        for(int i= 0; i < num; i++){
            Player player = new Player("Player"+i);
            players.add(player);
        }

    }
    /**
     * test if their is a winner after execution of game loop
     * @param
     * @return void
     */
    @Test
    public void test_game_for_winner(){
        Game game = new Game();
        game.GameLoop(squares,num,players,size_of_board);
        int counter = 0;
        for(Player player:players){
            if(player.get_currentfield()==size_of_board){
                counter++;
            }
        }
        assertEquals("no winner!",1,counter);
    }
    /**
     * test for invalid input size where an Exception is expected
     * @param
     * @return void
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void test_invalid_input_size() {
        Game game = new Game();
        game.GameLoop(squares, num, players, -2);
    }
    /**
     * test if squares is a null object where an Exception is expected
     * @param
     * @return void
     */
    @Test(expected = NullPointerException.class)
    public void test_null_list() {
        Game game = new Game();
        squares = null;
        game.GameLoop(squares, num,players, size_of_board);
    }
    /**
     * test if players is a null object where an Exception is expected
     * @param
     * @return void
     */
    @Test(expected = NullPointerException.class)
    public void test__null_playerlist() {
        Game game = new Game();
        players = null;
        game.GameLoop(squares, num,players, size_of_board);
    }
    /**
     * test if squares has a null object where an Exception is expected
     * @param
     * @return void
     */
    @Test(expected = NullPointerException.class)
    public void test_nullelement_in_squares() {
        Game game = new Game();
        squares.clear();
        squares.add(null);
        game.GameLoop(squares, num,players, size_of_board);
    }
    /**
     * test if players has a null object where an Exception is expected
     * @param
     * @return void
     */
    @Test(expected = NullPointerException.class)
    public void test_nullelement_in_players() {
        Game game = new Game();
        players.clear();
        players.add(null);
        game.GameLoop(squares, num,players, size_of_board);
    }
}
