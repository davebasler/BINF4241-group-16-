import org.junit.*;
import java.util.*;
import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.List;

public class BoardStatusTest {

    private int size_of_board;
    private int player_number;
    private List<Square> squares;
    private List<Player> players;
    BoardStatus boardStatus;
    /**
     * Create 2 ArrayLists of 16 square objects and 4 player objects. Create new BoardStatus object
     * @param
     * @return void
     */
    @Before
    public void setUp(){
        squares = new ArrayList<Square>();
        for(int index=1; index < 16; index++){
            if(index==1) {
                Square square = new StartSquare(index, 15);
                squares.add(square);
            }
            else if(index==15-1) {
                Square square = new EndSquare(index, 15);
                squares.add(square);
            }
            else if(index%5==0 && index < 13) {
                Square square = new Ladder(index, 15);
                squares.add(square);
            }
            else if(index%11==0 && index < 15) {
                Square square = new Snake(index, 15);
                squares.add(square);
            }
            else{
                Square square = new NormalSquare(index,15);
                squares.add(square);
            }
        }

        players = new ArrayList<Player>();
        for(int i= 0; i < 4; i++){
            Player player = new Player("Player"+i);
            players.add(player);
       }
        boardStatus = new BoardStatus();

    }
    /**
     * test for case that ArrayList squares is a null object
     * @param
     * @return void
     */
    @Test (expected = NullPointerException.class)
    public void testForNullListSquares(){
        squares = null;
        boardStatus.get_current_status(1,4,squares, players);
    }
    /**
     * test for case that ArrayList players is a null object
     * @param
     * @return void
     */
    @Test (expected = NullPointerException.class)
    public void testForNullListPlayers(){
        players = null;
        boardStatus.get_current_status(15,2,squares, players);
    }
    /**
     * test for case that ArrayList players has a null object in it
     * @param
     * @return void
     */
    @Test (expected = NullPointerException.class)
    public void testForNullElementInPlayers(){
        players.clear();
        players.add(null);
        boardStatus.get_current_status(15,1,squares, players);
    }
    /**
     * test for case that ArrayList squares has a null object in it
     * @param
     * @return void
     */
    @Test (expected = NullPointerException.class)
    public void testForNullElementInSquares(){
        squares.clear();
        squares.add(null);
        boardStatus.get_current_status(1,4,squares, players);
    }
    /**
     * test for case that current_status method receives an incomparable type
     * @param
     * @return void
     */
    @Test (expected = ClassCastException.class)
    @SuppressWarnings("unchecked")
    public void testMutuallyIncomparablePlayers(){
        List list = new ArrayList();
        list.add(1);
        boardStatus.get_current_status(15,1,squares, list);
    }
    /**
     * test for case that get_current_status method receives an incomparable type
     * @param
     * @return void
     */
    @Test (expected = ClassCastException.class)
    @SuppressWarnings("unchecked")
    public void testMutuallyIncomparableSquares(){
        List list = new ArrayList();
        list.add(1);
        boardStatus.get_current_status(1,4,list, players);

    }


   /* @Test (expected = IllegalArgumentException.class)
    public void testEmptyListPlayers(){
        squares.clear();
        boardStatus.get_current_status(10,0,squares, players);
    } */
    /**
     * test for case that get_current_status method receives valid inputs (4 players)
     * @param
     * @return void
     */
    @Test
    public void testForPlayer(){
        Object obj = boardStatus.get_current_status(15,4,squares, players);
        assertEquals("Two Players playing", "[1<Player0><Player1><Player2><Player3>][2][3][4][5->7][6][7][8][9][10->12][6<-11][12][13][14][15]", obj);
   }
    /**
     * test for case that get_current_status method receives valid inputs (2 players)
     * @param
     * @return void
     */
    @Test
    public void testTwoPlayer(){
        players.remove(3);
        players.remove(2);
        Object obj = boardStatus.get_current_status(15,2,squares, players);
        assertEquals("Two Players playing", "[1<Player0><Player1>][2][3][4][5->7][6][7][8][9][10->12][6<-11][12][13][14][15]", obj);
    }
    /**
     * test for case that get_current_status method receives valid inputs with a new Square added to the squares list
     * @param
     * @return void
     */
    @Test
    public void testOneSquare(){
        Square square = new StartSquare(0, 1);
        squares.add(square);
        Object obj = boardStatus.get_current_status(15,2,squares, players);
        assertEquals("Two Players playing", "[1<Player0><Player1>][2][3][4][5->7][6][7][8][9][10->12][6<-11][12][13][14][15]", obj);
    }

    }



