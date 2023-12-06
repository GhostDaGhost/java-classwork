/**
    * @author Alexander Arizola
*/
public class DynamicArray {
    private int[] array;
    private int size;

    /**
        * This is the constructor with a parameter.
        * @param capacity The parameter defines the capacity (length) of initial array.
        * @throws IllegalArgumentException If the capacity is below zero.
    */
    public DynamicArray(int capacity) throws IllegalArgumentException {
        if (capacity < 0) { // ENSURE CAPACITY IS NOT LESS THAN ZERO
            throw new IllegalArgumentException("The capacity cannot be below zero!");
        }

        // FULFILL VARIABLES
        this.array = new int[capacity];
        this.size = 0;
    }

    /**
        * This is the constructor without a parameter.
    */
    public DynamicArray() {
        this.array = new int[3];
        this.size = 0;
    }

    /**
        * This is the copy constructor
        * @param otherDynamicArray The parameter defines the other dynamic array to copy.
        * @throws IllegalArgumentException If the object is null.
    */
    public DynamicArray(DynamicArray otherDynamicArray) throws IllegalArgumentException {
        if (otherDynamicArray == null) { // NULL CHECK
            throw new IllegalArgumentException("A null object cannot be referenced to copy.");
        }

        // FULFILL VARIABLES WITH DATA TO COPY
        this.array = new int[otherDynamicArray.array.length];
        this.size = otherDynamicArray.size;
    }

    /**
        * This is a method that returns the number of "occupied" elements in the array.
        * @return The number of "occupied" elements in the array.
    */
    public int getSize() {
        return this.size;
    }

    /**
        * This is a method that returns the actual size (length) of the partially-filled array.
        * @return The actual size (length) of the partially-filled array.
    */
    public int getCapacity() {
        return this.array.length;
    }

    /**
        * This is a method that returns the entire partially-filled array.
        * @return The entire partially-filled array.
    */
    public int[] getArray() {
        return new int[this.array.length];
    }

    /**
        * This is a method that returns an "occupied" part of the partially-filled array.
        * @return The "occupied" part of the partially-filled array.
    */
    public int[] toArray() {
        int[] newArray = new int[size];

        // GET NEW ARRAY
        System.arraycopy(array, 0, newArray, 0, size);
        return newArray;
    }

    /**
        * This adds a new element to the end of the array and increments the size field.
        * @param num The parameter to represent the new element.
    */
    public void push(int num) {
        if (this.size == this.array.length) {
            resizeArray(this.array.length * 2);
        }

        // EDIT THE ARRAY
        this.array[this.size++] = num;
    }

    /**
        * This removes the last element of the array and returns it. Decrements the size field.
        * @return The last element of array.
        * @throws RuntimeException If the array is empty a RuntimeException with the message “Array is empty” must be thrown.
    */
    public int pop() throws RuntimeException {
        if (this.size == 0) {
            throw new RuntimeException("Array is empty");
        }

        // SHRINK ARRAY IF CAPACITY IS LARGER
        final int value = this.array[--this.size];
        if (this.size > 0 && this.size == this.array.length / 4) {
            resizeArray(this.array.length / 2);
        }

        // RETURN LAST ELEMENT OF ARRAY
        return value;
    }

    /**
        * This returns element of the array with the requested index.
        * @return The last element of array.
        * @throws IndexOutOfBoundsException If the index provided is too large or negative, the IndexOutOfBoundsException is thrown with the message “Illegal index”.
    */
    public int get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Illegal index");
        }

        // RETURNS ELEMENT OF THE ARRAY WITH THE REQUESTED INDEX
        return this.array[index];
    }

    /**
        * This returns the index of the first occurrence of the given number. Returns -1 when the number is not found.
        * @return The index of the first occurrence of the given number.
    */
    public int indexOf(int key) {
        for (int i = 0; i < this.size; i++) {
            if (this.array[i] == key) {
                return i;
            }
        }
        return -1;
    }

    /**
        * This adds a new element (passed as parameter num) to the location of the array specified by index parameter.
        * @param index The first parameter.
        * @param num The second parameter.
        * @throws IndexOutOfBoundsException If the index is larger than size of the array or less than 0, IndexOutOfBoundsException is thrown.
    */
    public void add(int index, int num) throws IndexOutOfBoundsException {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Illegal index");
        }

        // RESIZE ARRAY
        if (this.size == this.array.length) {
            resizeArray(this.array.length * 2);
        }

        // SHIFT ELEMENTS
        for (int i = this.size; i > index; i--) {
            this.array[i] = this.array[i - 1];
        }

        // FULFILL VARIABLES
        this.array[index] = num;
        this.size++;
    }

    /**
        * This returns the value of an element at the specified position in this array.
        * @param index The first parameter.
        * @throws IndexOutOfBoundsException If the index value passed into the method is more or equal to the size or less than 0 the IndexOutOfBoundsException must be thrown.
    */
    public int remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Illegal index");
        }

        // SHIFT ELEMENTS
        final int value = this.array[index];
        for (int i = index; i < this.size - 1; i++) {
            this.array[i] = this.array[i + 1];
        }

        // SHRINK ARRAY
        this.size--;
        if (this.size > 0 && this.size == this.array.length / 4) {
            resizeArray(this.array.length / 2);
        }

        // RETURNS THE VALUE OF AN ELEMENT AT THE SPECIFIED POSITION IN THE ARRAY
        return value;
    }

    /**
        * This checks if array is empty.
    */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
        * This displays array as a string.
    */
    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder("[");

        // ITERATE THROUGH
        for (int i = 0; i < this.size; i++) {
            result.append(this.array[i]);
            if (i < this.size - 1) {
                result.append(", ");
            }
        }

        // FINALIZE STRING BUILDING
        result.append("]");
        return result.toString();
    }

    /**
        * This compares two DynamicArray objects element-by-element.
        * @param otherDynamicArray The other object to compare.
    */
    public boolean equals(DynamicArray otherDynamicArray) {
        if (otherDynamicArray == this) {
            return true;
        }

        if (otherDynamicArray == null || otherDynamicArray.size != this.size) {
            return false;
        }

        for (int i = 0; i < this.size; i++) {
            if (otherDynamicArray.array[i] != this.array[i]) {
                return false;
            }
        }

        return true;
    }

    /**
        * This resizes arrays as a helper method.
        * @param newCapacity The new capacity.
    */
    private void resizeArray(int newCapacity) {
        int[] newArray = new int[newCapacity];

        // GET NEW ARRAY
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }
}
