// ldelamotte17@georgefox.edu
// Program 4
// 2018-10-06

/**
 * This class represents an ArrayList, which is an array with greater
 * functionality.
 *
 * @param <E>, the type of which an ArrayList is created.
 */
public class ArrayList<E> {

    private Object[] _arrayList;
    private int _elementsInUse;
    private E _oldValue;

    private static final int DEFAULT_CAPACITY = 10;
    private static final int ARRAY_GROWTH_FACTOR = 2;
    private static final int NEW_SIZE_WHEN_INITIAL_SIZE_IS_ZERO = 1;
    private static int ELEMENT_EXISTENCE = -1;


    /**
     * Creates an empty ArrayList with an initial capacity of 10.
     */
    public ArrayList() {

        this(DEFAULT_CAPACITY);

    }


    /**
     * Creates an ArrayList with a specified capacity.
     *
     * @param initialCapacity, the specified size of an ArrayList
     */
    public ArrayList(int initialCapacity) throws IllegalArgumentException {

        // checks for negative capacities
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: "
                    + initialCapacity);
        }

        // creates a new ArrayList with desired capacity
        _arrayList = new Object[initialCapacity];

    }


    /**
     * Adds an element to a certain location in an ArrayList.
     *
     * @param index, the location to place a new element.
     * @param element, the Object to be added.
     * @throws IndexOutOfBoundsException
     */
    public void add(int index, E element) throws IndexOutOfBoundsException {

        // creates a placeholder array
        Object[] tempArray;
        // creates a variable to hold the new size of ArrayList
        int newLength;

        // checks  range to see if desired index exists
        checkRangeToAddElement(index);

        // elements are shifted to the right to add the new element
        if (size() < _arrayList.length) {
            shiftElementsAndAddNewElement(index, element);
        }

        // ArrayList is extended, elements are shifted and the new element is
        // added
        else {

            // if the current size is greater than zero, the new size is
            // double the old
            if (_arrayList.length > 0) {
                newLength = _arrayList.length * ARRAY_GROWTH_FACTOR;
            }

            else {
                newLength = NEW_SIZE_WHEN_INITIAL_SIZE_IS_ZERO;
            }

            // a temporary ArrayList is created with the new size needed
            tempArray = new Object[newLength];

            // all elements are copied over to the temporary ArrayList
            for (int i = 0; i < size(); i++) {
                tempArray[i] = _arrayList[i];
            }

            // information from the temporary ArrayList is copied over to the
            // main ArrayList
            _arrayList = tempArray;

            // elements are shifted to the right to add the new element
            shiftElementsAndAddNewElement(index, element);

        }
    }


    /**
     * Adds an element to the end of an ArrayList.
     *
     * @param element, the Object to be added
     * @return true
     */
    public boolean add(E element) {

        // adds element to the end of the ArrayList
        add(size(), element);
        return true;

    }


    /**
     * Clears ArrayList completely.
     */
    public void clear() {

        // resets the number of elements currently in use
        _elementsInUse = 0;

    }


    /**
     * Takes in an index and returns the element from that index.
     *
     * @param index, the location of the element to be retrieved.
     * @return the element at the specified location.
     * @throws IndexOutOfBoundsException
     */
    @SuppressWarnings("unchecked")
    public E get(int index) throws IndexOutOfBoundsException {

        checkRange(index);
        return ((E) _arrayList[index]);

    }


    /**
     * Takes in an element and retrieves the index of the first occurrence of
     * that element in an ArrayList.
     *
     * @param element, the Object whose index is to be retrieved.
     * @return the index of the specified element or -1 if the element does not
     * exist in given ArrayList.
     */
    @SuppressWarnings("unchecked")
    public int indexOf(E element) {

        int indexOf = ELEMENT_EXISTENCE;
        E currentElement;

        // iterates through the ArrayList in attempt to find the requested
        // element's index
        for (int i = 0; i < size(); i++) {

            currentElement = (E) _arrayList[i];

            // checks to see if current element and element to find the index
            // of are both null
            if (element == currentElement) {
                indexOf = i;
            }
            // checks to see if elements are the same Object
            else if (currentElement.equals(element)) {
                indexOf = i;
            }

        }

        return indexOf;

    }


    /**
     * Returns true if the ArrayList contains no elements.
     *
     * @return true if the ArrayList contains no elements.
     */
    public boolean isEmpty() {

        return (size() == 0);

    }


    /**
     * Removes the element at the specified location in an ArrayList.
     * All subsequent elements are shifted to the left by one space.
     *
     * @param index, the location at which an element should be removed.
     * @return the value that was removed from the ArrayList.
     * @throws IndexOutOfBoundsException
     */
    public E remove(int index) throws IndexOutOfBoundsException {

        checkRange(index);

        // stores the value to be replaced in a new variable to return
        _oldValue = get(index);

        // moves all elements to the right of the removed elements one index to
        // the left
        while (index < size()) {
            _arrayList[index] = _arrayList[index++];
            index++;
        }

        _elementsInUse--;

        return _oldValue;
    }


    /**
     * Replaces an new element with an old one at a specified index.
     *
     * @param index, the location of the element to replace.
     * @param element, the element to be stored at the specified location.
     * @return the element previously location at the specified location.
     * @throws IndexOutOfBoundsException
     */
    public E set(int index, E element) throws IndexOutOfBoundsException {

        checkRange(index);

        // stores the value to be replaced in a new variable to return
        _oldValue = get(index);
        // places the new element at desired index
        _arrayList[index] = element;

        return _oldValue;

    }


    /**
     * Gets and returns the number of elements within the ArrayList.
     *
     * @return the number of elements within the ArrayList
     */
    public int size() {

        return _elementsInUse;

    }


    /**
     * Checks if given index is in the the range of the ArrayList. Negative
     * indices will be caught as well.
     *
     * @param index, the location at which information is needed
     * @throws IndexOutOfBoundsException
     */
    private void checkRange(int index) throws IndexOutOfBoundsException {

        // throws an exception if index at which information is needed is less
        // than zero or greater than the length of the ArrayList
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index does not exist within "
                    + "the ArrayList.");
        }

    }


    /**
     * Checks to see if the index at which a new element is to be added exists.
     *
     * @param index, the desired location of a new element
     * @throws IndexOutOfBoundsException
     */
    private void checkRangeToAddElement(int index)
            throws IndexOutOfBoundsException {

        // throws an exception if index to add element is less than zero or
        // greater than the length of the occupied elements in the ArrayList
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index does not exist "
                    + "within occupied bounds of the ArrayList.");
        }

    }


    /**
     * Moves all elements to the right to make space for the new element.
     *
     * @param index, the location of the new element coming in
     * @param element, the object being added
     */
    private void shiftElementsAndAddNewElement(int index, E element) {

        // iterates through the array and moves elements to the right
        for (int i = size(); i > index; i--) {
            _arrayList[i] = _arrayList[i - 1];
        }

        // places new element at desired index
        _arrayList[index] = element;
        _elementsInUse++;
    }

}
