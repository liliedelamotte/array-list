// ldelamotte17@georgefox.edu

/**
 * This class represents an ArrayList, which is an array with greater
 * functionality.
 *
 * @param <E>, the type of which to create an ArrayList of.
 */
public class ArrayList<E> {

    private Object[] _arrayList;
    private static final int DEFAULT_CAPACITY = 10;
    // private static final Object[] EMPTY_ARRAYLIST = {};
    private int _size;
    private boolean _isEmpty;
    private E _oldValue;
    private int _numMoved;
    private int _indexOf;

    /** 
     * Creates an empty ArrayList with an initial capacity of 10.
     */
    public ArrayList() {

        _size = DEFAULT_CAPACITY;
        // super();
        _arrayList = new Object[_size];
        // this._arrayList = EMPTY_ARRAYLIST;

    }


    /**
     * Creates an ArrayList with a specified capacity.
     *
     * @param initialCapacity, the specified size of an ArrayList.
     */
    public ArrayList(int initialCapacity) throws IllegalArgumentException {

        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: "
                    + initialCapacity);
        }

        _size = initialCapacity;
        this._arrayList = new Object[_size];

    }


    /**
     * Adds an element to a certain location in an ArrayList.
     *
     * @param index, the location to place a new element.
     * @param element, the Object to be added.
     * @throws IndexOutOfBoundsException
     */
    public void add(int index, E element) throws IndexOutOfBoundsException {

        checkRange(index - 1);

        _size++;
        System.arraycopy(_arrayList, index, _arrayList, index + 1,
                _size - index);

    }


    /**
     * Adds an element to the end of an ArrayList.
     *
     * @param element, the Object to be added.
     * @return true WHAT IS THIS SUPPOSED TO RETURN? --------------------------------------------
     */
    public boolean add(E element) {

        _size++;
        _arrayList[_size++] = element;
        return true;

    }


    /**
     * Replaces all elements in an ArrayList with null. Size does not change.
     * DOES THE SIZE NEED TO CHANGE HERE? -------------------------------------------------------
     */
    public void clear() {

        for (int i = 0; i < _size; i++) {
            _arrayList[i] = null;
        }

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
     * SHOULD THIS METHOD THROW AN ERROR? WHAT IF SOMEONE SENDS IN A NONEXISTENT ELEMENT? ---------------
     * Takes in an element and retrieves the index of the first occurrence of
     * that element in an ArrayList.
     *
     * @param element, the Object whose index is to be retrieved.
     * @return the index of the specified element or -1 if the element does not
     * exist in given ArrayList.
     */
    public int indexOf(E element) {

        _indexOf = -1;

        if (element == null) {
            for (int i = 0; i < _size; i++) {
                if (_arrayList[i] == null) {
                    _indexOf = i;
                }
            }
        }

        else if (element != null) {
            for (int i = 0; i < _size; i++) {
                if (element.equals(_arrayList[i])) {
                    _indexOf = i;
                }
            }
        }

        return _indexOf;

    }


    /**
     * Returns true if the ArrayList contains no elements.
     *
     * @return true if the ArrayList contains no elements.
     */
    public boolean isEmpty() {

        _isEmpty = (_size == 0);
        return _isEmpty;

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

        _oldValue = (get(index));
        _numMoved = _size - index - 1;

        if (_numMoved > 0) {
            System.arraycopy(_arrayList, index + 1, _arrayList, index,
                    _numMoved);
        }

        _arrayList[--_size] = null;

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

        _oldValue = (get(index));
        _arrayList[index] = element;

        return _oldValue;

    }


    /**
     * Gets and returns the number of elements within this ArrayList
     *
     * @return the number of elements within this ArrayList
     */
    public int size() {

        return _size;

    }


    /**
     * Checks if given index is in the the range of the ArrayList. Negative
     * indices will be caught as well.
     * @param index
     * @throws IndexOutOfBoundsException
     */
    private void checkRange(int index) throws IndexOutOfBoundsException {

        if (index >= _size || index < 0) {
            throw new IndexOutOfBoundsException();

        }


    }
}
