import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.EmptyStackException;

import static org.junit.Assert.assertEquals;


class TestPlayer {

    ArrayList cards;
    int age;
    String name;
    Player player;
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
        age = 12;
        name = "Lars";
        gameState = new GameState();
        discardPile = new DiscardPile();
        drawPile = new DrawPile();


        cards = new ArrayList();
        for(int i = 1;i<=7;i++){
            if(i%2!=0) {
                Card card = new NormalCard(RED, i);
            }
            else{
                Card card = new NormalCard(BLUE, i);
            }
            cards.add(card);
        }

        player = new Player(name,age,cards);
    }
    /**
     * test if getter method for name works.
     * @param
     * @return void
     */
    @Test
    public void test_getName(){
        assertEquals("Wrong name!", player.getName(),"Lars");
    }
    /**
     * test for case where an invalid card is tried to be placed on the DiscardPile
     * @param
     * @return void
     */
    @Test(expected = NullPointerException.class)
    public void test_placeCard_invalid(){
        Card card1 = new NormalCard(GREEN,2);
        player.placeCard(card1);
    }
    /**
     * test for a valid card to be place on the DiscardPile
     * @param
     * @return void
     */
    @Test
    public void test_placeCard_valid(){
        player.placeCard(cards.get(0));
        cards.remove(0);
        assertEquals("Card not placed correctly",gameState.getCurrentGameState(),
                "Current Card: RED, 1\nLars Cards: BLUE 2, RED 3, BLUE 4, RED 5, BLUE 6, RED 7");
    }
    /**
     * test for when a new Card is drawn from the DrawPile.
     * @param
     * @return void
     */
    @Test
    public void test_drawCard(){
        Card card2 = new NormalCard(YELLOW, 5);
        drawPile.push(card2);
        player.drawCard();
        assertEquals("Draw did not work",gameState.getCurrentGameState(),
                "Current Card: RED, 1\nLars Cards: RED 1, BLUE 2, RED 3, BLUE 4, RED 5, BLUE 6, RED 7, YELLOW 5");
    }
    /**
     * test for when a two new Card are drawn from the DrawPile.
     * @param
     * @return void
     */
    @Test
    public void test_drawTwoCard(){
        Card card3 = new NormalCard(YELLOW, 6);
        Card card4 = new NormalCard(GREEN, 7);
        drawPile.push(card3);
        drawPile.push(card4);
        player.drawTwoCards();
        assertEquals("Draw did not work",gameState.getCurrentGameState(),
                "Current Card: RED, 1\nLars Cards: RED 1, BLUE 2, RED 3, BLUE 4, RED 5, BLUE 6, RED 7, GREEN 7, YELLOW 6");
    }
    /**
     * test for when a four new Card are drawn from the DrawPile.
     * @param
     * @return void
     */
    @Test
    public void test_drawFourCards(){
        Card card5 = new NormalCard(GREEN, 1);
        Card card6 = new NormalCard(RED, 2);
        Card card7 = new NormalCard(BLUE, 8);
        Card card8 = new NormalCard(YELLOW, 9);
        drawPile.push(card5);
        drawPile.push(card6);
        drawPile.push(card7);
        drawPile.push(card8);
        player.drawFourCards();
        assertEquals("Draw did not work",gameState.getCurrentGameState(),
                "Current Card: RED, 1\nLars Cards: RED 1, BLUE 2, RED 3, BLUE 4, RED 5, BLUE 6, RED 7, " +
                        "YELLOW 9, BLUE 8, RED 2, GREEN 1");
        
    }
    /**
     * test for a challenge where the player who challenges the previous player is wrong
     * @param
     * @return void
     */
    @Test
    public void test_challenge_legal(){
        discardPile.push(new Card(GREEN,2));
        ArrayList cards2 = new ArrayList();
        cards2.add(new NormalCard(RED,3));
        cards2.add(new NormalCard(BLUE,7));
        cards2.add(new ActionCard(SPECIALCOLOR,wild4));
        Player prev_player=new Player("Renato",14,cards2);
        prev_player.placeCard(cards2.get(2));
        assertEquals("challenge should be false because prev_player moved legally!",player.challenge(),false);
    }
    /**
     * test for a challenge where the player who challenges the previous player is right
     * @param
     * @return void
     */
    @Test
    public void test_challenge_illegal(){
        discardPile.push(new Card(GREEN,2));
        ArrayList cards2 = new ArrayList();
        cards2.add(new NormalCard(RED,3));
        cards2.add(new NormalCard(BLUE,2));
        cards2.add(new ActionCard(SPECIALCOLOR,wild4));
        Player prev_player=new Player("Renato",14,cards2);
        prev_player.placeCard(cards2.get(2));
        assertEquals("challenge should be true because prev_player moved ilegally!",player.challenge(),true);
    }
    /**
     * test where a player forgets to say uno and then can't win.
     * @param
     * @return void
     */
    @Test
    public void test_uno_false(){
        ArrayList cards3 = new ArrayList();
        cards3.add(new NormalCard(RED,3));

        Player uno_player=new Player("Abraham",15,cards3);
        uno_player.placeCard(cards3.get(0));
        assertEquals("player shouldn't be able to place card because he didn't say uno!",2,cards3.length());
    }
    /**
     * test where a player sais uno and then is allowed to win.
     * @param
     * @return void
     */
    @Test
    public void test_uno_false(){
        ArrayList cards4 = new ArrayList();
        cards4.add(new NormalCard(RED,3));

        Player uno_player2=new Player("Abraham",15,cards4);
        uno_player2.sayUno();
        uno_player2.placeCard(cards4.get(0));
        assertEquals("player should be able to place card because he said uno!",0,cards4.length());
    }


}