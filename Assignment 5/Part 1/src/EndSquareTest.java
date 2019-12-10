import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EndSquareTest {
    EndSquare square;
    /**
     * Create an arbitrary EndSquare object for tests
     * @param
     * @return void
     */
    @Before
    public void SetUp(){
        square = new EndSquare(5,1);
    }
    /**
     * Test getter method for type of EndSquare class
     * @param
     * @return void
     */
    @Test
    public void test_get_index(){
        assertEquals("wrong index",5,square.get_index());
    }
    /**
     * Test getter method for type of EndSquare class
     * @param
     * @return void
     */
    @Test
    public void test_get_type(){
        assertEquals("wrong type","end",square.get_type());
    }
    /**
     * Test getter method for leads_to_field method of EndSquare class
     * @param
     * @return void
     */
    @Test
    public void test_leads_to_field(){
        assertEquals("wrong type",0, square.get_leads_to_field());
    }
}
