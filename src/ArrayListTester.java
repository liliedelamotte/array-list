import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

/**
 * This class tests the implementation of ArrayList.
 *
 */
public class ArrayListTester {

    private static ArrayList<String> _firstArrayList;
    private static ArrayList<String> _secondArrayList;
    private static int ARRAY_LENGTH = 10;


    /**
     * Creates several ArrayList instances to test.
     */
    @BeforeClass
    public void setUp() {
        _firstArrayList = new ArrayList<String>();
        _firstArrayList.add("Apple");
        _firstArrayList.add("Banana");
        _firstArrayList.add("Orange");
        
        _secondArrayList = new ArrayList<String>(ARRAY_LENGTH);
    }


    /**
     * Tests that an instance of an ArrayList is created properly if no length
     * argument is given.
     */
    @Test
    public void test_ArrayList_constructor_noGivenLength() {

        assertThat(_firstArrayList, instanceOf(ArrayList.class));

    }


    /**
     * Tests that an instance of an ArrayList is created properly if a length
     * argument is given.
     */
    @Test
    public void test_ArrayList_constructor_givenLength() {
        
        assertTrue(_secondArrayList.size() == ARRAY_LENGTH);
        
    }


    /**
     * Tests the addition of an element to an ArrayList with a specified index.
     */
    @Test
    public void test_add_validIndex() {

        assertThat(_firstArrayList.add(2, "Grape"));

    }


    /**
     * Tests the illegal addition of an element to an ArrayList with a
     * specified index.
     */
    @Test (expected = IllegalArgumentException.class)
    public void test_add_invalidIndex() {
        
        _firstArrayList.add(100, "Blueberry");
        
    }


    /**
     * Tests the valid addition of an element to an ArrayList.
     */
    @Test
    public void test_add_noIndex() {

        assertThat(_firstArrayList.add("Blackberry"));

    }


    @Test
    public void test_clear() {

    }


    /**
     * Tests the implementation of ArrayList's element retrieval method given a
     * valid index.
     */
    @Test
    public void test_get_validIndex() {

        assertTrue(_firstArrayList.get(0).contentEquals("Apple"));

    }


    /**
     * Test the implementation of ArrayList's element retrieval method given an
     * invalid index.
     */
    @Test (expected = IllegalArgumentException.class)
    public void test_get_invalidIndex() {

        _firstArrayList.get(100);

    }


    /**
     * Tests the implementation of ArrayList's index retrieval method given a
     * valid element.
     */
    @Test
    public void test_getIndexOf_validElement() {

        assertTrue(_firstArrayList.indexOf("Apple") == 0);

    }


    /**
     * Tests the implementation of ArrayLists's index retrieval method given an
     * invalid element.
     */
    @Test
    public void test_indexOf_invalidElement() {

        assertThat(_firstArrayList.indexOf("Cherry"));

    }


    /**
     * Tests the accuracy of the isEmpty checker on a non-empty array.
     */
    @Test
    public void test_isEmpty() {

        assertFalse(_firstArrayList.isEmpty());

    }


    /**
     * Removes an element from the list and then tests to see if it can be found.
     */
    @Test (expected = IllegalArgumentException.class)
    public void test_remove() {

        _firstArrayList.remove(0);
        _firstArrayList.indexOf("Apple");

    }


    /**
     * Tests that a valid element is set to a valid index.
     */
    @Test
    public void test_set_validIndex() {

        _firstArrayList.set(0, "Apple");
        assertTrue(_firstArrayList.indexOf("Apple") == 0);

    }


    /**
     * 
     */
    @Test (expected = IllegalArgumentException.class)
    public void test_set_invalidIndex() {

        _firstArrayList.set(10, "Raspberry");

    }


    @Test
    public void test_size() {
        
    }

}
