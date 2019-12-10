import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NormalSquareTest {
    NormalSquare square;

    /**
     * Create an arbitrary NormalSquare object for tests
     * @param
     * @return void
     */

    @Before
    public void SetUp(){
        square = new NormalSquare(5,1);
    }

    /**
     * Test getter method for index of NormalSquare class
     * @param
     * @return void
     */
    @Test
    public void test_get_index(){
        assertEquals("wrong index",5,square.get_index());
    }

    /**
     * Test getter method for type of NormalSquare class
     * @param
     * @return void
     */
    @Test
    public void test_get_type(){
        assertEquals("wrong type","normal",square.get_type());
    }
    /**
     * Test getter method for leads_to_field method of NormalSquare class
     * @param
     * @return void
     */
    @Test
    public void test_leads_to_field(){
        assertEquals("wrong type",0, square.get_leads_to_field());
    }

    /**
     * Tests if a NormalSquare class object can be occupied
     * @param
     * @return void
     */
    @Test
    public void test_occupied(){
        assertEquals("is occupied but should not be.",false, square.is_occupied());
    }

    /**
     * Tests if the occupied status of a NormalSquare class object can be changed
     * @param
     * @return void
     */
    @Test
    public void test_occupied_change(){
        square.occupied_change(true);
        assertEquals("is not occupied but should not be.",true, square.is_occupied());
    }

}
