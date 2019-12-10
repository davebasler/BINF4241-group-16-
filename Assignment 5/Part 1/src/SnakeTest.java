import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SnakeTest {
    Snake square;

    /**
     * Create an arbitrary Snake object for tests
     * @param
     * @return void
     */

    @Before
    public void SetUp(){
        square = new Snake(5,1);
    }

    /**
     * Test getter method for index of Snake class
     * @param
     * @return void
     */
    @Test
    public void test_get_index(){
        assertEquals("wrong index",5,square.get_index());
    }

    /**
     * Test getter method for type of Snake class
     * @param
     * @return void
     */
    @Test
    public void test_get_type(){
        assertEquals("wrong type","snake",square.get_type());
    }
    /**
     * Test getter method of leads_to_field of Snake class
     * @param
     * @return void
     */
    @Test
    public void test_leads_to_field(){
        assertEquals("wrong type",0, square.get_leads_to_field());
    }
}
