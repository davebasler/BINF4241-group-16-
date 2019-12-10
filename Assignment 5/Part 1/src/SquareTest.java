import org.junit.*;
import java.util.*;
import static org.junit.Assert.*;

public class SquareTest {
    Square square;

    /**
     * Create an arbitrary Square object for tests
     * @param
     * @return void
     */

    @Before
    public void SetUp(){
        square = new Square(5,1);
    }

    /*@Test (expected = ClassCastException.class)
    public void test_incompatable_input(){
        try {
            Square square2 = new Square("e",2);
        } catch(ClassCastException e) {
            return;
        }
        fail("ClassCastException expected");
    }*/

    /**
     * Test getter method for index of Square class
     * @param
     * @return void
     */
    @Test
    public void test_get_index(){
        assertEquals("wrong index",5,square.get_index());
    }

    /**
     * Test getter method for type of Square class
     * @param
     * @return void
     */
    @Test
    public void test_get_type(){
        assertEquals("wrong type",null,square.get_type());
    }

    /**
     * Test getter method of leads_to_field of Square class
     * @param
     * @return void
     */
    @Test
    public void test_leads_to_field(){
        assertEquals("wrong type",0, square.get_leads_to_field());
    }
}
