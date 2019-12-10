import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.assertEquals;


class TestDrawPile {

    DrawPile drawPile;
    Card normalCard;
    GameState gameState;
    /**
     * create new DrawPile, NormalCard and GameState
     * @param
     * @return void
     */
    @Before
    public void setUp(){
        DrawPile = new drawPile();
        normalCard = new NormalCard(YELLOW,2);
        gameState = new GameState();

    }
    /**
     * test for case where DrawPile is empty
     * @param
     * @return void
     */
    @Test(expected = EmptyStackException.class)
    public void test_draw_empty(){
        drawPile.draw();
    }
    /**
     * test if one card is drawn correctly.
     * @param
     * @return void
     */
    @Test
    public void test_draw_one_card() {
        drawPile.push(normalCard);
        assertEquals("Wrong card",drawPile.draw(),normalCard);
    }
    /**
     * test if shuffle method keeps the same amount of cards in the DrawPile
     * @param
     * @return void
     */
    @Test
    public void test_shuffle(){
        for(int i = 1;i<=9;i++){
            if(i%2!=0) {
                Card card = new NormalCard(RED, i);
            }
            else{
                Card card = new NormalCard(GREEN, i);
            }
            drawPile.push(card);
        }
        int length_of_pile = 9;
        drawPile.shuffle();
        assertEquals("Shuffle fails",drawPile.length(),length_of_pile);

    }
    /**
     * test if push method works correctly.
     * @param
     * @return void
     */
    @Test
    public void test_push(){
        drawPile.push(normalCard);
        assertEquals("Card not pushed",gameState.draw(),normalCard);
    }
}