import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestGameState {

    ArrayList cards;
    ArrayList cards2;
    Player player;
    Player player2;
    GameState gameState;
    DiscardPile discardPile;
    DrawPile drawPile;
    /**
     * create new Player with ArrayList(cards), new GameState, new DiscardPile and DrawPile
     * @param
     * @return void
     */
    @Before
    public void setUp(){
        gameState = new GameState();
        discardPile = new DiscardPile();
        drawPile = new DrawPile();


        cards = new ArrayList();
        cards.add(new NormalCard(BLUE, 3));


        player = new Player("Hanspeter",35,cards);
        cards2 = new ArrayList();
        cards2.add(new NormalCard(RED, 5));
        cards2.add(new NormalCard(BLUE, 7));


        player2 = new Player("Elaine",27,cards2);c
    }
    /**
     * test the isOver method in a case where a player wins.
     * @param
     * @return void
     */
    @Test
    public void test_isOver(){
        player.sayUno();
        discardPile.push(new NormalCard(BLUE,5));
        player.placeCard(cards.get(0));
        assertEquals("player should have won!",true,gameState.isOver());
    }
    /**
     * test the isOver method in a case where a player doesn't win.
     * @param
     * @return void
     */
    @Test
    public void test_isOver_false(){
        discardPile.push(new NormalCard(BLUE,2));
        player2.placeCard(cards.get(1));
        assertEquals("player should not have won!",false,gameState.isOver());
    }
    /**
     * test the getter method for the currentColor.
     * @param
     * @return void
     */
    @Test
    public void test_getCurrentColor(){
        discardPile.push(new NormalCard(YELLOW,5));
        assertEquals("current color should be YELLOW!",YELLOW,gameState.getCurrentColor());
    }
    /**
     * test the getter method for the currentNumber.
     * @param
     * @return void
     */
    @Test
    public void test_getCurrentNumber(){
        discardPile.push(new NormalCard(GREEN,6));
        assertEquals("current number should be 6!",6,gameState.getCurrentNumber());
    }
    /**
     * test if the printCurrentGameState prints correctly during game loop.
     * @param
     * @return void
     */
    @Test
    public void test_print(){
        discardPile.push(new NormalCard(BLUE,5));
        assertEquals("wrong print output!","Current Card: BLUE, 5\nElaine's Cards: RED 5, BLUE 7",gameState.printCurrentGameState());
    }
    /**
     * test if the printCurrentGameState prints correctly when a player wins.
     * @param
     * @return void
     */
    @Test
    public void test_print_whenGameOver(){
        player.sayUno();
        discardPile.push(new NormalCard(BLUE,5));
        player.placeCard(cards.get(0));
        assertEquals("wrong print output!","Current Card: BLUE, 3\nHanspeter's Cards: no cards\nHanspeter has won!",gameState.printCurrentGameState());
    }


}
