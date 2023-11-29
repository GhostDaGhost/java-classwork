import java.io.PrintStream;
import java.util.ArrayList;

// Author: Alexander Arizola
public class ArrayMethods {
    /**
        * This method checks if a rectangle array is sorted in ascending order.
        * @param nums The array of rectangle to check for sorting.
        * @return true if the array is sorted in ascending order, false otherwise.
        * @throws IllegalArgumentException if the array is empty.
    */
    public static boolean isSorted(Rectangle[] nums) throws IllegalArgumentException {
        if (nums.length == 0) {
            throw new IllegalArgumentException("The array cannot be empty!");
        }

        // ITERATE THROUGH RECTANGLE TO SEE IF IT IS NOT SORTED
        for (int i = 1; i < nums.length; i++) {
            if (!nums[i - 1].isLess(nums[i])) {
                return false;
            }
        }

        // RETURN TRUE SINCE ARRAY IS SORTED IN ASCENDING ORDER
        return true;
    }

    /**
        * This method takes two SORTED arrays of integers as parameters, merges them into the third array that is also SORTED.
        * @param nums1 The first sorted array.
        * @param nums2 The second sorted array.
        * @return A new array containing all elements from both input arrays in sorted order.
    */
    public static int[] mergeSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArray = new int[nums1.length + nums2.length];

        // MERGE ARRAYS
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[i]) {
                mergedArray[k++] = nums1[i++];
            } else {
                mergedArray[k++] = nums2[j++];
            }
        }

        // THIS ENSURES FIRST ARRAY HAS REMAINING ELEMENTS COPIED
        while (i < nums1.length) {
            mergedArray[k++] = nums1[i++];
        }

        // THIS ENSURES SECOND ARRAY HAS REMAINING ELEMENTS COPIED
        while (j < nums2.length) {
            mergedArray[k++] = nums2[j++];
        }

        // RETURN MERGED ARRAY
        return mergedArray;
    }
 
    /**
        * A method that takes an array of integers and returns true if every integer is appearing in the array only once. It returns false if there are any duplicates in the array.
        * @param nums The array of integers to be checked for uniqueness.
        * @return True if all elements are unique, false otherwise.
    */
    public static boolean allUniqueElements(int[] nums) {
        if (nums.length == 0) { // ENSURE ARRAY IS NOT EMPTY
            return false;
        }

        // ITERATE THROUGH THE ARRAY TO CHECK IF ARRAY ELEMENTS AREN'T UNIQUE
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return false;
                }
            }
        }

        // TRUE WHEN ARRAY ELEMENTS ARE UNIQUE
        return true;
    }

    /**
        * This method takes a two-dimensional array and converts it into a regular one-dimensional array. The new one-dimensional array is returned from the method.
        * @param nums The two-dimensional array to be converted.
        * @return The one-dimensional array obtained from the conversion.
    */
    public static int[] twoDConvert(int[][] nums) {
        if (nums.length == 0 || nums[0].length == 0) { // ENSURE OLD ARRAY ISN'T EMPTY
            return new int[0];
        }
    
        // CALCULATE THE TOTAL LENGTH OF THE NEW ONE-DIMENSIONAL ARRAY
        int[] newArray = new int[nums.length * nums[0].length];
        int index = 0;

        // COPY OLD ARRAY ELEMENTS INTO NEW ARRAY
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                newArray[index++] = nums[i][j];
            }
        }

        // RETURN NEW ONE-DIMENSIONAL ARRAY
        return newArray;
    }

    /**
        * The method takes an array of objects of type Rectangle. Among all the rectangle objects it finds those that are actually squares (length==width), and doubles the values of their length and width fields.
        * @param shapes An array of Rectangle objects to be processed.
    */
    public static void doubleSquares(Rectangle[] shapes) {
        for (Rectangle shape : shapes) {
            if (shape.getLength() == shape.getWidth()) {
                shape.setLength(shape.getLength() * 2);
                shape.setWidth(shape.getWidth() * 2);
            }
        }
    }

    /**
        * This method takes an ArrayList of integers and a range defined by two integer parameters named “from” and “to”. The method removes all values from ArrayList that fall in the range [from, to]. It must make no more than one pass through the ArrayList when removing the values.
        * @param a The ArrayList of integers to be modified.
        * @param from The inclusive lower bound of the range.
        * @param to The exclusive upper bound of the range.
        * @throws IllegalArgumentException If "from" is greater than "to".
    */
    public static void removeInRange(ArrayList<Integer> a, int from, int to) throws IllegalArgumentException {
        if (from > to) {
            throw new IllegalArgumentException("\"from\" value cannot be greater than \"to\" value.");
        }

        // DO NOT PROCEED IF ARRAY LIST IS EMPTY
        if (!a.isEmpty()) {
            for (int i = a.size() - 1; i >= 0; i--) {
                final int currentValue = a.get(i);
                if (currentValue >= from && currentValue < to) {
                    a.remove(i);
                }
            }
        }
    }

    /**
        * This method takes an ArrayList of strings and an integer k. The method modifies the ArrayList by repeating each string it originally contains k times.
        * @param a The ArrayList of strings to be modified.
        * @param k The number of times each string should be repeated.
        * @throws IllegalArgumentException If k is negative or zero.
    */
    public static void repeat(ArrayList<String> a, int k) {
        if (k <= 0) {
            throw new IllegalArgumentException("k cannot be negative or a zero!");
        }

        // ITERATE THROUGH ORIGINAL ARRAY
        for (int i = a.size() - 1; i >= 0; i--) {
            final String original = a.get(i);

            // REPEAT
            a.remove(i);
            for (int j = 0; j < k; j++) {
                a.add(i, original);
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 
        PrintStream out = System.out;
        testIsSorted(out);
        testMergeSortedArrays(out);
        testAllUniqueElements(out);
        testTwoDConvert(out);
        testDoubleSquares(out);
        testRemoveInRange(out);
        testRepeat(out);
    }
    /**
     * Runs all tests for isSorted() method
     * @param outputStream - output stream, used to print into the screen
     * 
     */
    public static void testIsSorted(PrintStream outputStream)
    {
        Rectangle[] unsorted = {new Rectangle(), new Rectangle(2, 3), new Rectangle(), new Rectangle(5, 5), new Rectangle()};
        Rectangle[] sorted = {new Rectangle(1, 2), new Rectangle(2, 3), new Rectangle(4, 5), new Rectangle(5, 5), new Rectangle(6, 7)};
        Rectangle[] one = {new Rectangle(1, 2)};
        Rectangle[] empty = {};
        System.out.println("\r\n----Tests for isSorted() -------------------------------------------------------\r\n");
 // Test #1   
        if(isSorted(sorted)==true && isSorted(unsorted)==false && isSorted(one)==true)
        {
            outputStream.printf("%-80s%-10s\r\n", "isSorted() TEST 01 -- regular functionality",  "PASSED");
            
        }
        else outputStream.printf("%-80s%-10s\r\n", "isSorted() TEST 01 -- regular functionality",  "FAILED");
 
// Test #2        
         try{
             boolean ignoreMe = isSorted(empty);
             outputStream.printf("%-80s%-10s\r\n", "isSorted() TEST 02: IllegalArgumentException",  "FAILED");
         }
         catch(IllegalArgumentException e)
         {
            outputStream.printf("%-80s%-10s\r\n", "isSorted() TEST 02: IllegalArgumentException",  "PASSED");
                         
         }
                
    }
    /**
     * Runs all tests for mergeSortedArrays()
     * @param outputStream - output stream, used to print into the screen
     * 
     */
    public static void testMergeSortedArrays(PrintStream outputStream)
    {

        int[] a1 = {2, 3, 5, 8, 12};
        int[] a2 = {1, 4, 9, 10, 17};
        int[] a22 = {4, 7, 9, 10, 11, 13, 15, 17, 18};
        int[] a3 = {1, 2, 3, 4, 5, 8, 9, 10, 12, 17};
        int[] a4 = {2, 3, 4, 5, 7, 8, 9, 10, 11, 12, 13, 15, 17, 18};
        int[] b1 = {3};
        int[] b2 = {7};
        int[] b3 = {3, 7};
        int[] empty = {};
        System.out.println("\r\n----Tests for mergeSortedArrays() -------------------------------------------------------\r\n");
 // Test #1 
        if(equal(mergeSortedArrays(a1, a2), a3))
        {
            outputStream.printf("%-80s%-10s\r\n", "mergeSortedArrays() TEST 01 - arrays of the same size",  "PASSED");
           
        }
        else outputStream.printf("%-80s%-10s\r\n", "mergeSortedArrays() TEST 01 - arrays of the same size",  "FAILED");

// Test #2 
        if(equal(mergeSortedArrays(a1, a22), a4) && equal(mergeSortedArrays(a22, a1), a4))
        {
            outputStream.printf("%-80s%-10s\r\n", "mergeSortedArrays() TEST 02 - arrays of different sizes",  "PASSED");
            
        }
        else outputStream.printf("%-80s%-10s\r\n", "mergeSortedArrays() TEST 02 - arrays of different sizes",  "FAILED");
 
// Test #3
        if(equal(mergeSortedArrays(b1, b2), b3))
        {
            outputStream.printf("%-80s%-10s\r\n", "mergeSortedArrays() TEST 03 - arrays of size 1",  "PASSED");
            
        }
        else outputStream.printf("%-80s%-10s\r\n", "mergeSortedArrays() TEST 03 - arrays of size 1",  "FAILED");

// Test #4
        if(equal(mergeSortedArrays(empty, b2), b2) && equal(mergeSortedArrays(empty, empty), empty))
        {
            outputStream.printf("%-80s%-10s\r\n", "mergeSortedArrays() TEST 04 - Empty arrays",  "PASSED");
            
        }
        else outputStream.printf("%-80s%-10s\r\n", "mergeSortedArrays() TEST 04 - Empty arrays",  "FAILED");
 

    }
  /**
   * Runs all the tests for allUniqueElements() method
   * @param outputStream - output stream, used to print into the screen
   * 
   */  
    public static void testAllUniqueElements(PrintStream outputStream)
    {

        int[] a1 = {2, 16, 3, 5, 8, 12};
        int[] a2 = {1, 4, 9, 10, 9, 17};
        int[] a3 = {3};
        int[] empty = {};
        System.out.println("\r\n----Tests for allUniqueElements() -------------------------------------------------------\r\n");
 // Test #1 
        if(allUniqueElements(a1))
        {
            outputStream.printf("%-80s%-10s\r\n", "allUniqueElements() TEST 01 - all unque elements",  "PASSED");
           
        }
        else outputStream.printf("%-80s%-10s\r\n", "allUniqueElements() TEST 01 - all unque elements",  "FAILED");

// Test #2 
        if(allUniqueElements(a2)==false)
        {
            outputStream.printf("%-80s%-10s\r\n", "allUniqueElements() TEST 02 - not all unique",  "PASSED");
           
        }
        else outputStream.printf("%-80s%-10s\r\n", "allUniqueElements() TEST 02 - not all unique",  "FAILED");
 
// Test #3
        if(allUniqueElements(a3))
        {
            outputStream.printf("%-80s%-10s\r\n", "allUniqueElements() TEST 03 - array of 1 element",  "PASSED");
           
        }
        else outputStream.printf("%-80s%-10s\r\n", "allUniqueElements() TEST 03 - array of 1 element",  "FAILED");

// Test #4
        if(allUniqueElements(empty)==false)
        {
            outputStream.printf("%-80s%-10s\r\n", "allUniqueElements() TEST 04 - Empty array",  "PASSED");
            
        }
        else outputStream.printf("%-80s%-10s\r\n", "allUniqueElements() TEST 04 - Empty array",  "FAILED");

    }
/**
 * Runs all the tests for twoDConvert() method
 * @param outputStream - output stream, used to print into the screen 
 */    
    public static void testTwoDConvert(PrintStream outputStream)
    {
 
        int[][] a= {{1, 2, 3}, 
                    {4, 5, 6}, 
                    {7, 8, 9}};
        int[] aConverted = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        int[][] c= {{1}, 
                    {4}, 
                    {7}};
        int[] cConverted = {1, 4, 7};
        int [][] b = {};
        int[] empty = {};
        System.out.println("\r\n----Tests for twoDConvert() -------------------------------------------------------\r\n");
// Test #1 
        if(equal(twoDConvert(a),aConverted))
        {
            outputStream.printf("%-80s%-10s\r\n", "twoDConvert() TEST 01 - regular array",  "PASSED");
            
        }
        else outputStream.printf("%-80s%-10s\r\n", "twoDConvert() TEST 01 - regular array",  "FAILED");
// Test #2 
        if(equal(twoDConvert(c),cConverted))
        {
            outputStream.printf("%-80s%-10s\r\n", "twoDConvert() TEST 02 - array of 1 row and 1 column",  "PASSED");
            
        }
        else outputStream.printf("%-80s%-10s\r\n", "twoDConvert() TEST 02 - array of 1 row and 1 column",  "FAILED");
// Test #3 
        if(equal(twoDConvert(b),empty))
        {
            outputStream.printf("%-80s%-10s\r\n", "twoDConvert() TEST 03 - Empty array",  "PASSED");
            
        }
        else outputStream.printf("%-80s%-10s\r\n", "twoDConvert() TEST 03 - Empty array",  "FAILED");

    }
    /**
     * Runs all the tests for doubleSquares() method
     * @param outputStream output stream, used to print into the screen 
     * 
     */
    public static void testDoubleSquares(PrintStream outputStream)
    {
      
        int size = 10;
        Rectangle[] shapes1 = new Rectangle[size];
        for(int i = 0; i<shapes1.length; i++)
        {
            if(i%3==0&& i!=0) shapes1[i] = new Rectangle(i+1, i+1); // building a square
            else shapes1[i] = new Rectangle(i+2, i+1); // building a regular rectangle
        }
        Rectangle[] shapes2 = new Rectangle[0];
        System.out.println("\r\n----Tests for doubleSquares() -------------------------------------------------------\r\n");
 // Test #1 
        doubleSquares(shapes1);
        boolean passed = true;
        for(int i = 0; (i<shapes1.length) && passed; i++)
        {
            if(i%3==0 && i!=0) 
            {
                if(shapes1[i].getLength()!=(i+1)*2 || shapes1[i].getWidth()!=(i+1)*2)
                {
                    passed = false;
                }
            }
            else 
            {
                if(shapes1[i].getLength()!=i+2 || shapes1[i].getWidth()!=i+1)
                {
                    passed = false;
                }
            }
        }        
        if(passed)
        {
            outputStream.printf("%-80s%-10s\r\n", "doubleSquares() TEST 01 - regular array containing squares",  "PASSED");
            
        }
        else outputStream.printf("%-80s%-10s\r\n", "doubleSquares() TEST 01 - regular array containing squares",  "FAILED");  
  // Test #2        
        doubleSquares(shapes2);
        if(shapes2.length==0)
        {
            outputStream.printf("%-80s%-10s\r\n", "doubleSquares() TEST 02 - Empty array",  "PASSED");
          
        }
        else outputStream.printf("%-80s%-10s\r\n", "doubleSquares() TEST 02 - Empty array",  "FAILED");  

    }
   /**
    * Runs all the tests for removeInRange() method
     * @param outputStream - output stream, used to print into the screen
    */ 
    public static void testRemoveInRange(PrintStream outputStream)
    {    

        int[] tmp = {8, 6, 1, 4, 25, 1, 3, 7, 6, 8, 77, 3, 16};
        int[] test01 = {25, 77, 16};
        ArrayList<Integer> listA = new ArrayList();
        ArrayList<Integer> listB = new ArrayList();
        ArrayList<Integer> listTest01 = new ArrayList();
        ArrayList<Integer> listTest04 = new ArrayList();
        for(int i = 0; i<tmp.length; i++)
        {
           listA.add(tmp[i]);
           listB.add(tmp[i]);
        }
        for(int i = 0; i<test01.length; i++)
        {
            listTest01.add(test01[i]);
            listTest04.add(test01[i]);
        }
        listTest04.remove(0);
        System.out.println("\r\n----Tests for removeInRange() -------------------------------------------------------\r\n");
// Test #1
        removeInRange(listA, 0, 10);
        if(listA.equals(listTest01))
        {
            outputStream.printf("%-80s%-10s\r\n", "removeInRange() TEST 01 - removing several values",  "PASSED");
          
        }
        else outputStream.printf("%-80s%-10s\r\n", "removeInRange() TEST 01 - removing several values",  "FAILED");
// Test #2
        removeInRange(listB, -1, 100);
        if(listB.isEmpty())
        {
            outputStream.printf("%-80s%-10s\r\n", "removeInRange() TEST 02 - removing all values",  "PASSED");
           
        }
        else outputStream.printf("%-80s%-10s\r\n", "removeInRange() TEST 02 - removing all values",  "FAILED");    
// Test #3
        removeInRange(listB, -1, 100);
        if(listB.isEmpty())
        {
            outputStream.printf("%-80s%-10s\r\n", "removeInRange() TEST 03 - remove from empty list",  "PASSED");
            
        }
        else outputStream.printf("%-80s%-10s\r\n", "removeInRange() TEST 03 - remove from empty list",  "FAILED");    
 // Test #4
        removeInRange(listA, 25, 25);
        if(listA.equals(listTest04))
        {
            outputStream.printf("%-80s%-10s\r\n", "removeInRange() TEST 04 - range consists of 1 value [3,3]",  "PASSED");
            
        }
        else outputStream.printf("%-80s%-10s\r\n", "removeInRange() TEST 04 - range consists of 1 value [3,3]",  "FAILED");           
        
        try{
          removeInRange(listA, 2, 1);
          outputStream.printf("%-80s%-10s\r\n", "removeInRange() TEST 05 - IllegalArgumentException",  "FAILED");
        }
        catch(IllegalArgumentException e)
        {
           outputStream.printf("%-80s%-10s\r\n", "removeInRange() TEST 05 - IllegalArgumentException",  "PASSED");
                      
        }
 
    }
 /**
  * Runs all the tests for repeat() method
  * @param outputStream - output stream, used to print into the screen
  */   
    public static void testRepeat(PrintStream outputStream)
    {

        
        ArrayList<String>listA = new ArrayList();
        listA.add("aa");
        listA.add("bb");
        listA.add("cc");
     
        ArrayList<String>listB = new ArrayList();
        String[] tmp = {"aa", "aa", "aa", "bb", "bb", "bb", "cc", "cc", "cc"};
        for(int i = 0; i<tmp.length; i++)
        {
            listB.add(tmp[i]);
        }
        System.out.println("\r\n----Tests for repeat() -------------------------------------------------------------\r\n");
// Test #1
        repeat(listA, 3);
       
        if(listA.equals(listB))
        {
            outputStream.printf("%-80s%-10s\r\n", "repeat() TEST 01 - regular repeat",  "PASSED");
            
        }
        else outputStream.printf("%-80s%-10s\r\n", "repeat() TEST 01 - regular repeat",  "FAILED");
 
// Test #2
        repeat(listA, 1);
       
        if(listA.equals(listB))
        {
            outputStream.printf("%-80s%-10s\r\n", "repeat() TEST 02 - repeat(list, 1)",  "PASSED");
            
        }
        else outputStream.printf("%-80s%-10s\r\n", "repeat() TEST 02 - repeat(list, 1)",  "FAILED");
 // Test #3
        try{
           repeat(listA, 0); 
           outputStream.printf("%-80s%-10s\r\n", "repeat() TEST 03 - IllegalArgumentException",  "FAILED");
        }
        catch(IllegalArgumentException e)
        {
            outputStream.printf("%-80s%-10s\r\n", "repeat() TEST 03 - IllegalArgumentException",  "PASSED");
            
        }
    }
            
/**
 * Compares two arrays of integers
 * @param one first array to compare
 * @param two second array to compare
 * @return returns true if arrays are the same, false if not
 */    
    public static boolean equal(int[] one, int[] two)
    {
        if(one.length!=two.length) return false;
        for(int i= 0; i<one.length; i++)  
        {
            if(one[i]!=two[i]) return false;
        }
        return true;
    }
 /**
  * Outputs into the screen an array of integers
  * @param a an array to print out
  */
    public static void printArray(int[] a)
    {
        if(a.length == 0) 
        { 
            System.out.println("[ ]");
            return;
        }  
         System.out.print("[");
         int i;
        for(i = 0; i<a.length-1; i++)
        {
            System.out.print(a[i]+", ");
        }
        System.out.print(a[i]+"]\n");
    }
    
    
}


