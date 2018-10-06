
import static org.hamcrest.CoreMatchers.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ArrayListTester2
{
    public static void main(String[] args)
    {
        // Run the tests
        org.junit.runner.JUnitCore.main("ArrayListTest");
    }

    @Test
    public void testNewArrayList()
    {
        ArrayList<String> StringList = new ArrayList<>();
        ArrayList<Integer> IntegerList = new ArrayList<>();

        assertThat(StringList, notNullValue());
        assertThat(StringList, instanceOf(ArrayList.class));
        assertThat(IntegerList, notNullValue());
        assertThat(IntegerList, instanceOf(ArrayList.class));
    }

    @Test
    public void testNewArrayList_givenCapacity()
    {
        // Requires working size() method
        int size = 4;
        ArrayList<String> StringList = new ArrayList<>(size);

        assertThat(StringList, notNullValue());
        assertThat(StringList, instanceOf(ArrayList.class));
        assertThat(0, equalTo(StringList.size()));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testNewArrayList_givenNegativeCapacity()
    {
        new ArrayList<String>(-2);
    }

    @Test
    public void testAdd_element_index()
    {
        // Requires working size() method
        int size;

        String s1 = "";
        String s2 = "hgr";
        String s3 = "gfsd";

        ArrayList<String> l = new ArrayList<>();

        size = l.size();
        l.add(0, s1);
        assertThat(size + 1, equalTo(l.size()));

        size = l.size();
        l.add(1, s2);
        assertThat(size + 1, equalTo(l.size()));

        size = l.size();
        l.add(1, s3);
        assertThat(size + 1, equalTo(l.size()));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testAdd_element_negIndex()
    {
        ArrayList<String> l = new ArrayList<>();

        l.add(-1, "string");
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testAdd_element_indexTooBig()
    {
        ArrayList<String> l = new ArrayList<>();

        l.add(100, "string");
    }

    @Test
    public void testAdd_multiplier_initialSizeZero()
    {
        // Requires working size() method
        ArrayList<String> l = new ArrayList(0);

        assertThat(l.size(), equalTo(0));

        l.add("");

        assertThat(l.size(), equalTo(1));
    }

    @Test
    public void testAdd_allowsNullElement()
    {
        ArrayList<Object> l = new ArrayList<>();

        l.add(null);
        l.add(0, null);
    }

    @Test
    public void testClear()
    {
        // Requires working size() method
        ArrayList<String> l = new ArrayList<>();

        l.add("");
        l.add("");
        l.add("");

        assertThat(l.size(), equalTo(3));

        l.clear();

        assertThat(l.size(), equalTo(0));
    }

    @Test
    public void testGet()
    {
        String s0 = "tf";
        String s1 = "hge";
        String s2 = "hrte";

        ArrayList<String> l = new ArrayList<>();

        l.add(s0);
        l.add(s1);
        l.add(s2);

        assertThat(s0, equalTo(l.get(0)));
        assertThat(s1, equalTo(l.get(1)));
        assertThat(s2, equalTo(l.get(2)));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testGet_negativeIndex()
    {
        ArrayList<String> l = new ArrayList<>();

        l.get(-1);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testGet_indexOutOfBounds()
    {
        ArrayList<String> l = new ArrayList<>();

        l.add("g");

        l.get(3);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testGet_emptyArray()
    {
        ArrayList<String> l = new ArrayList<>();

        l.get(0);
    }

    @Test
    public void testIndexOf()
    {
        ArrayList<Integer> l = new ArrayList<>();

        for (int i = 0; i < 10000; i++)
        {
            l.add(i);
            assertThat(l.indexOf(i), equalTo(i));
        }
    }

    @Test
    public void testIndexOf_elementNotFound()
    {
        ArrayList<Integer> l = new ArrayList<>();

        for (int i = 0; i < 1000; i ++)
        {
            l.add(i);
        }

        int index = l.indexOf(1001);

        assertThat(index, equalTo(-1));
    }

    @Test
    public void testIndexOf_allowsNullElement()
    {
        ArrayList<Integer> l = new ArrayList<>();

        l.add(1);

        l.indexOf(null);
    }

    @Test
    public void testIsEmpty()
    {
        // Requires working add function
        ArrayList<String> l = new ArrayList<>();

        assertTrue(l.isEmpty());

        l.add("");

        assertFalse(l.isEmpty());
    }

    @Test
    public void testRemove()
    {
        // Requires working add() and size() methods
        ArrayList<String> l = new ArrayList<>();
        int size;

        l.add("");

        size = l.size();

        l.remove(0);

        assertThat(size, equalTo(1));
        assertThat(l.size(), equalTo(0));
        assertTrue(l.size() < size);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testRemove_negativeIndex()
    {
        ArrayList<String> l = new ArrayList<>();

        l.add("");

        l.remove(-1);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testRemove_indexTooBig()
    {
        ArrayList<String> l = new ArrayList<>();

        l.add("");

        l.remove(3);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testRemove_emptyArray()
    {
        ArrayList<String> l = new ArrayList<>();

        l.remove(0);
    }

    @Test
    public void testSet()
    {
        // Requires working add() and get() methods
        ArrayList<String> l = new ArrayList<>();
        int size;

        l.add("543");
        l.add("ytr");
        l.add("654");

        String t = "t";
        size = l.size();

        l.set(1, t);

        assertThat(t, equalTo(l.get(1)));
        assertThat(size, equalTo(l.size()));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testSet_negativeIndex()
    {
        ArrayList<String> l = new ArrayList<>();

        l.add("");

        l.set(-1, "");
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testSet_indexTooBig()
    {
        ArrayList<String> l = new ArrayList<>();

        l.add("");

        l.set(3, "hgfd");
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testSet_emptyArray()
    {
        ArrayList<Integer> l = new ArrayList<>();

        l.set(0, 0);
    }

    @Test
    public void testSet_allowsNullElement()
    {
        ArrayList<String> l = new ArrayList<>();

        l.add("");

        l.set(0, null);
    }

    @Test
    public void testSize()
    {
        // Requires working add() method
        ArrayList<Integer> l = new ArrayList<>();

        for (int i = 0; i < 10000; i ++)
        {
            assertThat(l.size(), equalTo(i));

            l.add(i);
        }
    }
}
