import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LadderTest {
    Ladder square;
    /**
     * Create an arbitrary Ladder object for tests
     * @param
     * @return void
     */
    @Before
    public void SetUp(){
        square = new Ladder(5,1);
    }
    /**
     * Test getter method for index of Ladder class
     * @param
     * @return void
     */
    @Test
    public void test_get_index(){
        assertEquals("wrong index",5,square.get_index());
    }
    /**
     * Test getter method for type of Ladder class
     * @param
     * @return void
     */
    @Test
    public void test_get_type(){
        assertEquals("wrong type","ladder",square.get_type());
    }
    /**
     * Test getter method of leads_to_field of Ladder class
     * @param
     * @return void
     */
    @Test
    public void test_leads_to_field(){
        assertEquals("wrong type",7, square.get_leads_to_field());
    }
}
