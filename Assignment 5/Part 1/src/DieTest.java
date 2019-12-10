import org.junit.Before;
import org.junit.Test;
import org.junit.*;
import java.util.*;
import static org.junit.Assert.*;


import static org.junit.Assert.assertEquals;

public class DieTest {
    Die die;

    /**
     * create new Die object
     * @param
     * @return void
     */
    @Before
    public void SetUp(){
        die = new Die();
    }
    /**
     * test if random number of Die object is between 1 and 6
     * @param
     * @return void
     */
    @Test
    public void test_is_in_bounds(){
        int random = die.getNum();
        int high = 6;
        int low = 1;
        assertTrue("Error, random is too high", high >= random);
        assertTrue("Error, random is too low",  low  <= random);
    }
}
