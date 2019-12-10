import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


 class TestDiscardPile {

     DiscardPile discardPile;
     Card normalCard;
     GameState gameState;

     /**
      * create new DiscardPile, NormalCard and GameState
      * @param
      * @return void
      */
    @Before
    public void setUp(){
        discardPile = new DiscardPile();
        normalCard = new NormalCard(BLUE,7);
        gameState = new GameState();
    }
     /**
      * test if push method works correctly.
      * @param
      * @return void
      */
    @Test
     public void test_push(){
        discardPile.push(normalCard);
        assertEquals("Card not pushed",gameState.printCurrentGameState(),"Current Card: BLUE, 7\nPlayer Cards: no cards");
    }

}