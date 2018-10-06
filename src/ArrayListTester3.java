import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;
/**
 ************************************************************
 * DISCLAIMER: THIS ASSUMES THAT .GET FUNCTIONS CORRECTLY
 ************************************************************
 * @author bennettlopez
 */
public class ArrayListTester3
{
    private static ArrayList<Integer> _ArrayListInteger;
    private static ArrayList<String> _ArrayListString;

    private static ArrayList<Integer> _ArrayListComparedInteger;
    private static ArrayList<String> _ArrayListComparedString;

    
    public static void main(String[] args) {
        System.out.format("Unit Tests: %n%n");
        org.junit.runner.JUnitCore.main("ArrayListTestingUnit");
    }
    /**
     * TESTTING FOR INTEGERS
     */
    @BeforeClass
    public static void test_setUp() {
        _ArrayListInteger = new ArrayList<>();
        _ArrayListString = new ArrayList<>();

        _ArrayListComparedInteger = new ArrayList<>();
        _ArrayListComparedString = new ArrayList<>();
    }
    @Test
    public void test_Constructor() {
        assertThat(_ArrayListInteger, is(notNullValue()));
        assertThat(_ArrayListInteger, instanceOf(ArrayList.class));
        
        assertThat(_ArrayListString, is(notNullValue()));
        assertThat(_ArrayListString, instanceOf(ArrayList.class));

        assertThat(_ArrayListComparedInteger, is(notNullValue()));
        assertThat(_ArrayListComparedInteger, instanceOf(ArrayList.class));
        
        assertThat(_ArrayListComparedString, is(notNullValue()));
        assertThat(_ArrayListComparedString, instanceOf(ArrayList.class));
    }
    
    /**
     *************************************
     * 
     *        Baseline Method Tests
     * 
     **************************************
     */
    
    @Test
    public void test_Add() {
        // Fills the arrays with elements
       FillDefaultElements();
       // Assert that all the elements in the arrays are equal and true
       assertEquals(_ArrayListInteger.get(0), _ArrayListComparedInteger.get(0));
       assertEquals(_ArrayListInteger.get(1), _ArrayListComparedInteger.get(1));
       assertEquals(_ArrayListInteger.get(2), _ArrayListComparedInteger.get(2));
       assertEquals(_ArrayListInteger.get(3), _ArrayListComparedInteger.get(3));
       assertEquals(_ArrayListInteger.get(4), _ArrayListComparedInteger.get(4));
       
       assertEquals(_ArrayListString.get(0), _ArrayListComparedString.get(0));
       assertEquals(_ArrayListString.get(1), _ArrayListComparedString.get(1));
       assertEquals(_ArrayListString.get(2), _ArrayListComparedString.get(2));
       assertEquals(_ArrayListString.get(3), _ArrayListComparedString.get(3));
       assertEquals(_ArrayListString.get(4), _ArrayListComparedString.get(4));
       
       assertThat(_ArrayListString.get(3), not(equalTo(_ArrayListComparedString.get(4))));
       
       // Resets the arrys
       clearArraysLists();
    }
    @Test
    public void test_AddToIndex() {
       // Fills the arrays with elements
       FillDefaultElements();
       
       _ArrayListInteger.add(1, 99);
       _ArrayListComparedInteger.add(1, 99);
       _ArrayListString.add(1, "Hello");
       _ArrayListComparedString.add(1, "Hello");
       
       // Confirms that the additions are in the right spot
       assertEquals(_ArrayListInteger.get(1), _ArrayListComparedInteger.get(1));
       assertEquals(_ArrayListString.get(1), _ArrayListComparedString.get(1));
       
       // Confirm that the shifted elements are in the right position
        assertEquals(_ArrayListInteger.get(3), _ArrayListComparedInteger.get(3));
       assertEquals(_ArrayListString.get(3), _ArrayListComparedString.get(3));
       
       _ArrayListInteger.add(2, 0);
       _ArrayListComparedInteger.add(4, 88);
       _ArrayListString.add(2, "STRING");
       _ArrayListComparedString.add(4, "string");
       
        assertThat(_ArrayListString.get(2), not(equalTo(_ArrayListComparedString.get(4))));
         assertThat(_ArrayListString.get(2), not(equalTo(_ArrayListComparedString.get(4))));
       
       // Resets the arrys
       clearArraysLists();
    }
    @Test
    public void test_indexOf() {
       // Fills the arrays with elements
       FillDefaultElements();
       
       assertEquals(_ArrayListString.indexOf("One"), _ArrayListComparedString.indexOf("One"));
       assertEquals(_ArrayListString.indexOf("Two"), _ArrayListComparedString.indexOf("Two"));
       assertEquals(_ArrayListString.indexOf("Three"), _ArrayListComparedString.indexOf("Three"));
       assertEquals(_ArrayListString.indexOf("Four"), _ArrayListComparedString.indexOf("Four"));
       assertEquals(_ArrayListString.indexOf("Five"), _ArrayListComparedString.indexOf("Five"));
       
       assertEquals(_ArrayListInteger.indexOf(1), _ArrayListComparedInteger.indexOf(1));
       assertEquals(_ArrayListInteger.indexOf(2), _ArrayListComparedInteger.indexOf(2));
       assertEquals(_ArrayListInteger.indexOf(3), _ArrayListComparedInteger.indexOf(3));
       assertEquals(_ArrayListInteger.indexOf(4), _ArrayListComparedInteger.indexOf(4));
       assertEquals(_ArrayListInteger.indexOf(5), _ArrayListComparedInteger.indexOf(5));

       assertEquals(_ArrayListInteger.indexOf(200), -1);
       // Resets the arrys
       clearArraysLists();
    }
    @Test
    public void test_isEmpty() {
        _ArrayListInteger.add(1);
        _ArrayListComparedInteger.add(4);
        
        _ArrayListString.add("Thats My Whife");
        _ArrayListComparedString.add("But shes my wife");
        
            assertEquals(_ArrayListInteger.isEmpty(), _ArrayListComparedInteger.isEmpty());
            assertEquals(_ArrayListString.isEmpty(), _ArrayListComparedString.isEmpty());
            
       // Resets the arrys
       clearArraysLists();
       
       assertEquals(_ArrayListInteger.isEmpty(), _ArrayListComparedInteger.isEmpty());
       assertEquals(_ArrayListString.isEmpty(), _ArrayListComparedString.isEmpty());
    }
    @Test
    public void test_remove() {
        FillDefaultElements();
        
        _ArrayListInteger.remove(3);
        _ArrayListComparedInteger.remove(3);
        
        _ArrayListString.remove(3);
        _ArrayListComparedString.remove(3);
        
        // At removal site
        assertEquals(_ArrayListInteger.get(0), _ArrayListComparedInteger.get(0));
        // At one element below
        assertEquals(_ArrayListInteger.get(2), _ArrayListComparedInteger.get(2));
        // At one above
        assertEquals(_ArrayListInteger.get(3), _ArrayListComparedInteger.get(3));
        
        assertEquals(_ArrayListString.get(0), _ArrayListComparedString.get(0));
        // At one element below
        assertEquals(_ArrayListString.get(2), _ArrayListComparedString.get(2));
        // At one above
        assertEquals(_ArrayListString.get(3), _ArrayListComparedString.get(3));
        
        clearArraysLists();
    }
    @Test
    public void test_set() {
        FillDefaultElements();
        
        assertEquals(_ArrayListInteger.set(0, 1), _ArrayListComparedInteger.set(0, 1));
        assertEquals(_ArrayListInteger.get(0), _ArrayListComparedInteger.get(0));
        
        assertEquals(_ArrayListString.set(0, "hello"), _ArrayListComparedString.set(0, "hello"));
    assertEquals(_ArrayListString.get(0), _ArrayListComparedString.get(0));
        
        clearArraysLists();
        
    }
    @Test
    public void test_size() {
         FillDefaultElements();
         
         assertEquals(_ArrayListInteger.size(), _ArrayListComparedInteger.size());
         assertEquals(_ArrayListString.size(), _ArrayListComparedString.size());
         
         clearArraysLists();
    }
    
    @Test
    public void test_funWithNulls() {
        _ArrayListInteger.add(null);
        _ArrayListInteger.add(null);
        _ArrayListInteger.add(null);
        _ArrayListInteger.add(null);
        _ArrayListInteger.add(null);
        _ArrayListInteger.add(null);
        _ArrayListInteger.add(null);
        _ArrayListInteger.add(null);
        _ArrayListInteger.add(null);
        _ArrayListInteger.add(null);
        
        _ArrayListString.add(null);
        _ArrayListString.add(null);
        _ArrayListString.add(null);
        _ArrayListString.add(null);
        _ArrayListString.add(null);
        _ArrayListString.add(null);
        _ArrayListString.add(null);
        _ArrayListString.add(null);
        _ArrayListString.add(null);
        _ArrayListString.add(null);
        
        _ArrayListComparedInteger.add(null);
        _ArrayListComparedInteger.add(null);
        _ArrayListComparedInteger.add(null);
        _ArrayListComparedInteger.add(null);
        _ArrayListComparedInteger.add(null);
        _ArrayListComparedInteger.add(null);
        _ArrayListComparedInteger.add(null);
        _ArrayListComparedInteger.add(null);
        _ArrayListComparedInteger.add(null);
        _ArrayListComparedInteger.add(null);
        
        _ArrayListComparedString.add(null);
        _ArrayListComparedString.add(null);
        _ArrayListComparedString.add(null);
        _ArrayListComparedString.add(null);
        _ArrayListComparedString.add(null);
        _ArrayListComparedString.add(null);
        _ArrayListComparedString.add(null);
        _ArrayListComparedString.add(null);
        _ArrayListComparedString.add(null);
        _ArrayListComparedString.add(null);
        
         _ArrayListInteger.add(3, 3);
         _ArrayListString.add(3, "hello");
         _ArrayListComparedInteger.add(3, 3);
         _ArrayListComparedString.add(3, "hello");
        
        
        
        
    }
    
     /**
     *************************************
     * 
     *      Method Tests (Exception Throwing)
     * 
     **************************************
     */
    
    @Test
    public void test_InvlaidGetMethod() {
       // Fills the arrays with elements
       FillDefaultElements();
       try{
           _ArrayListInteger.get(-1);
       }
       catch(IndexOutOfBoundsException e){}
       
       try{
           _ArrayListString.get(-1);
       }
       catch(IndexOutOfBoundsException e){}
       
       try{
           _ArrayListComparedInteger.get(-1);
       }
       catch(IndexOutOfBoundsException e){}
       
       try{
           _ArrayListComparedString.get(-1);
       }
       catch(IndexOutOfBoundsException e){}
       
       
       clearArraysLists();
    }
    
    @Test
    public void test_invalidAddIndex() {
        FillDefaultElements();
        try {
            _ArrayListInteger.add(-1, 1);
        }
        catch(IndexOutOfBoundsException e) {}
        
         try {
            _ArrayListComparedInteger.add(-1, 1);
        }
        catch(IndexOutOfBoundsException e) {}
         
          try {
            _ArrayListString.add(-1, "HELLO");
        }
        catch(IndexOutOfBoundsException e) {}
          
        try {
            _ArrayListComparedString.add(-1, "HELLO");
        }
        catch(IndexOutOfBoundsException e) {}
        try {
            _ArrayListInteger.add(200, 1);
        }
        catch(IndexOutOfBoundsException e) {}
        
         try {
            _ArrayListComparedInteger.add(200, 1);
        }
        catch(IndexOutOfBoundsException e) {}
         
          try {
            _ArrayListString.add(200, "HELLO");
        }
        catch(IndexOutOfBoundsException e) {}
          
           try {
            _ArrayListComparedString.add(200, "HELLO");
        }
        catch(IndexOutOfBoundsException e) {}
        clearArraysLists();
    }
    
    @Test
    public void test_invlaidRemove() {
        FillDefaultElements();
        try {
            _ArrayListInteger.remove(-1);
        }
        catch(IndexOutOfBoundsException e) {}
        try {
            _ArrayListComparedInteger.remove(-1);
        }
        catch(IndexOutOfBoundsException e) {}
        try {
            _ArrayListString.remove(-1);
        }
        catch(IndexOutOfBoundsException e) {}
        try {
            _ArrayListComparedString.remove(-1);
        }
        catch(IndexOutOfBoundsException e) {}
        try {
            _ArrayListInteger.remove(500);
        }
        catch(IndexOutOfBoundsException e) {}
        try {
            _ArrayListComparedInteger.remove(500);
        }
        catch(IndexOutOfBoundsException e) {}
        try {
            _ArrayListString.remove(500);
        }
        catch(IndexOutOfBoundsException e) {}
        try {
            _ArrayListComparedString.remove(500);
        }
        catch(IndexOutOfBoundsException e) {}
        
        clearArraysLists();
    }
    
    @Test
    public void test_InvalidSet() {
        FillDefaultElements();
        try {
            _ArrayListInteger.set(-1, 1);
        }
        catch(IndexOutOfBoundsException e) {}
        try {
            _ArrayListComparedInteger.set(-1, 1);
        }
        catch(IndexOutOfBoundsException e) {}
        try {
            _ArrayListString.set(-1, "heleo");
        }
        catch(IndexOutOfBoundsException e) {}
        try {
            _ArrayListComparedString.set(-1, "heleo");
        }
        catch(IndexOutOfBoundsException e) {}
        try {
            _ArrayListInteger.set(500, 1);
        }
        catch(IndexOutOfBoundsException e) {}
        try {
            _ArrayListComparedInteger.set(500, 1);
        }
        catch(IndexOutOfBoundsException e) {}
        try {
            _ArrayListString.set(500, "heleo");
        }
        catch(IndexOutOfBoundsException e) {}
        try {
            _ArrayListComparedString.set(500, "heleo");
        }
        catch(IndexOutOfBoundsException e) {}
        clearArraysLists();
    }
     /**
     *************************************
     * 
     *      Private Helper Methods
     * 
     **************************************
     */
    
    private void FillDefaultElements()
    {
        
        _ArrayListString.add("One");
    _ArrayListString.add("Two");
    _ArrayListString.add("Three");
    _ArrayListString.add("Four");
    _ArrayListString.add("Five");

    _ArrayListComparedString.add("One");
    _ArrayListComparedString.add("Two");
    _ArrayListComparedString.add("Three");
    _ArrayListComparedString.add("Four");
    _ArrayListComparedString.add("Five");
        
        _ArrayListInteger.add(1);
        _ArrayListInteger.add(2);
        _ArrayListInteger.add(3);
        _ArrayListInteger.add(4);
        _ArrayListInteger.add(5);
        
        _ArrayListComparedInteger.add(1);
        _ArrayListComparedInteger.add(2);
        _ArrayListComparedInteger.add(3);
        _ArrayListComparedInteger.add(4);
        _ArrayListComparedInteger.add(5);
    }
    
    private void clearArraysLists() {
        
        _ArrayListString.clear();
        _ArrayListComparedString.clear();
        _ArrayListInteger.clear();
        _ArrayListComparedInteger.clear();
    }
}
