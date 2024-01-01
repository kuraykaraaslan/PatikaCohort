import java.util.Arrays;

public class MyList<T> {
    private Object[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    // Default constructor
    public MyList() {
        this(DEFAULT_CAPACITY);
    }

    // Parameterized constructor
    public MyList(int capacity) {
        this.array = new Object[capacity];
        this.size = 0;
    }

    // Returns the number of elements in the list
    public int size() {
        return size;
    }

    // Returns the capacity of the array
    public int getCapacity() {
        return array.length;
    }

    // Adds an element to the list
    public void add(T data) {
        if (size == array.length) {
            ensureCapacity();
        }
        array[size++] = data;
    }

    // Expands the array
    private void ensureCapacity() {
        int newCapacity = array.length * 2;
        array = Arrays.copyOf(array, newCapacity);
    }

    // Returns the element at the specified index
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return (T) array[index];
    }

    // Removes the element at the specified index
    public T remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        T removedData = (T) array[index];

        // Shift the elements to the left after removing the index
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        size--;

        return removedData;
    }

    // Sets the element at the specified index to the given data
    public T set(int index, T data) {
        if (index < 0 || index >= size) {
            return null;
        }

        T oldValue = (T) array[index];
        array[index] = data;

        return oldValue;
    }

    // Returns a string representation of the elements in the list
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            result.append(array[i]);
            if (i < size - 1) {
                result.append(",");
            }
        }
        result.append("]");
        return result.toString();
    }

    // Returns the index of the first occurrence of the specified element, or -1 if not found
    public int indexOf(T data) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    // Returns the index of the last occurrence of the specified element, or -1 if not found
    public int lastIndexOf(T data) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    // Checks if the list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Returns an array containing all of the elements in this list in proper sequence
    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }

    // Removes all of the elements from this list, making it empty
    public void clear() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    // Returns a sublist from start index to finish index
    public MyList<T> sublist(int start, int finish) {
        MyList<T> subList = new MyList<>(finish - start + 1);
        for (int i = start; i <= finish; i++) {
            subList.add(this.get(i));
        }
        return subList;
    }

    // Checks if the list contains the specified element
    public boolean contains(T data) {
        return indexOf(data) != -1;
    }
}
