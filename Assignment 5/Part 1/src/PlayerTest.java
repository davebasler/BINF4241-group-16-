import org.junit.*;
import java.util.*;
import static org.junit.Assert.*;

public class PlayerTest {
    Player player;

    /**
     * Create an arbitrary Player object with the name "Aquaman" for tests
     * @param
     * @return void
     */
    @Before
    public void SetUp(){
        player = new Player("Aquaman");
    }

    /**
     * Test getter method for name of Player class
     * @param
     * @return void
     */
    @Test
    public void test_get_name(){
        assertEquals("wrong name","Aquaman",player.get_name());
    }

    /**
     * Tester method for the current field of a player of Player class
     * @param
     * @return void
     */
    @Test
    public void test_currentfield(){
        assertEquals("wrong field",1,player.get_currentfield());
    }

    /**
     * Testing if player of Player can win
     * @param
     * @return void
     */
    @Test
    public void test_is_winner(){
        assertEquals("winner must be true",true,player.is_winner());
    }

    /**
     * Testing if player of Player can move
     * @param
     * @return void
     */
    @Test
    public void test_move(){
        assertEquals("wrong new field",5,player.change_current_field(4));
    }

}
