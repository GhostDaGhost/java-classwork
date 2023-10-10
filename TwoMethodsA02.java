/**
* @author Alexander Arizola
*/
public class TwoMethodsA02
 {
    /**
        * Method checks if a triangle with given lengths of sides is a right triangle
        * @param a triangle side
        * @param b triangle side
        * @param c triangle side
        * @return true if the triangle is right, false if it is not
    */
    public static boolean isRightTri(int a, int b, int c)
    {
        // determines if the triangle is right (one of its angles is 90 degrees)
        return (a * a + b * b == c * c) || (a * a + c * c == b * b) || (b * b + c * c == a * a);
    }

    /**
        * The method takes hour, minute, and "am", "pm" components of the time stamp of the moment when car crosses the bridge and calculates the toll rate.
        * If any of the time stamp components are invalid, -1 is being returned as an error code.
        * @param hour hour component of the time stamp 
        * @param min minute component of the time stamp
        * @param amPm either string "am" or "pm", component of the time stamp
        * @return the toll rate  
     */
    public static double toll520Bridge(int hour, int min, String amPm)
    {
        // Error handler if the input is wrong. Give error code.
        if (!(amPm.equals("am") || amPm.equals("pm")) || hour < 0 || hour > 12 || min < 0 || min >= 60) {
            return -1;
        }
    
        // Calculates and returns the toll on the 520 bridge on weekends and holidays with a Good To Go! Pass.
        if ((hour == 12 && amPm.equals("am")) || (hour < 5 && amPm.equals("am"))) {
            return 1.25;
        } else if ((hour == 12 && amPm.equals("pm")) || (hour < 5 && amPm.equals("pm"))) {
            return 2.65;
        } else if ((hour == 5 && amPm.equals("am")) || (hour == 7 && amPm.equals("am"))) {
            return 1.40;
        } else if ((hour == 7 && min >= 0 && amPm.equals("am")) || (hour == 8 && min <= 59 && amPm.equals("am"))) {
            return 2.05;
        } else if ((hour == 9 && min >= 0 && amPm.equals("am")) || (hour == 10 && min <= 59 && amPm.equals("am"))) {
            return 2.05;
        } else if ((hour == 11 && min >= 0 && amPm.equals("am")) || (hour == 4 && min <= 59 && amPm.equals("pm"))) {
            return 2.65;
        } else if ((hour == 3 && min <= 55 && amPm.equals("pm"))) {
            return 2.65;
        } else if ((hour == 6 && amPm.equals("pm")) || (hour == 7 && min >= 0 && amPm.equals("pm"))) {
            return 2.05;
        } else if ((hour == 7 && min >= 0 && amPm.equals("pm")) || (hour == 8 && min <= 59 && amPm.equals("pm"))) {
            return 2.05;
        } else if ((hour == 9 && min >= 0 && amPm.equals("pm")) || (hour == 10 && min <= 59 && amPm.equals("pm"))) {
            return 1.40;
        } else if ((hour == 11 && min >= 0 && amPm.equals("pm"))) {
            return 1.25;
        }

        // Default value. It will never get here.
        return -5;
    }

    public static void testIsRightTri()
    {
    	System.out.println("\r\n----Tests for isRightTri()------------------------------------------------------------\r\n");
    	
         // Test 1 //
        if(isRightTri(3, 4, 5)) {
        	System.out.printf("%-80s%-10s\n", "isRightTri() TEST 01 -- isRightTri(3, 4, 5) - right triangle",  "PASSED");
        }
        else {
        	System.out.printf("%-80s%-10s\n", "isRightTri() TEST 01 -- isRightTri(3, 4, 5) - right triangle",  "FAILED");
        }
   
        // Test 2 //     
        if(isRightTri(4, 5, 3)) {
        	System.out.printf("%-80s%-10s\n", "isRightTri() TEST 02 -- isRightTri(4, 5, 3) - right triangle",  "PASSED");
        }
        else {
        	System.out.printf("%-80s%-10s\n", "isRightTri() TEST 02 -- isRightTri(4, 5, 3) - right triangle",  "FAILED");
        }
        
        // Test 3 //     
        if(isRightTri(5, 4, 3)) {
        	System.out.printf("%-80s%-10s\n", "isRightTri() TEST 03 -- isRightTri(5, 4, 3) - right triangle",  "PASSED");
        }
        else {
        	System.out.printf("%-80s%-10s\n", "isRightTri() TEST 03 -- isRightTri(5, 4, 3) - right triangle",  "FAILED");
        }
        
        // Test 4 //     
        if(isRightTri(3, 5, 4)) {
        	System.out.printf("%-80s%-10s\n", "isRightTri() TEST 04 -- isRightTri(3, 4, 5) - right triangle",  "PASSED");
        }
        else {
        	System.out.printf("%-80s%-10s\n", "isRightTri() TEST 04 -- isRightTri(3, 4, 5) - right triangle",  "FAILED");
        }
        
        // Test 5 //     
        if(isRightTri(5, 3, 4)) {
        	System.out.printf("%-80s%-10s\n", "isRightTri() TEST 05 -- isRightTri(5, 3, 4) - right triangle",  "PASSED");
        }
        else {
        	System.out.printf("%-80s%-10s\n", "isRightTri() TEST 05 -- isRightTri(5, 3, 4) - right triangle",  "FAILED");
        }
        
        // Test 6 //     
        if(isRightTri(4, 3, 5)) {
        	System.out.printf("%-80s%-10s\n", "isRightTri() TEST 06 -- isRightTri(4, 3, 5) - right triangle",  "PASSED");
        }
        else {
        	System.out.printf("%-80s%-10s\n", "isRightTri() TEST 06 -- isRightTri(4, 3, 5) - right triangle",  "FAILED");
        }
        
        // Test 7 //     
        if(!isRightTri(4, 4, 5)) {
        	System.out.printf("%-80s%-10s\n", "isRightTri() TEST 07 -- isRightTri(4, 4, 5) - NOT rigth trianlge",  "PASSED");
        }
        else {
        	System.out.printf("%-80s%-10s\n", "isRightTri() TEST 07 -- isRightTri(4, 4, 5)  - NOT rigth trianlge",  "FAILED");
        }
    }
    
    public static void testToll520Bridge()
    {
    	System.out.println("\r\n----Tests for toll520Bridge()---------------------------------------------------------\r\n");
    	
        // Test 1 //  
        if(toll520Bridge(5, 20, "aa") == -1) {
        	System.out.printf("%-80s%-10s\n", "toll520Bridge() TEST 01 -- incorrect range of amPm argument must return -1",  "PASSED");
        }
        else {
        	System.out.printf("%-80s%-10s\n", "toll520Bridge() TEST 01 -- incorrect range of amPm argument must return -1",  "FAILED");
        }
        
        // Test 2 //  
        if(toll520Bridge(5, 65, "am") == -1) {
        	System.out.printf("%-80s%-10s\n", "toll520Bridge() TEST 02 -- incorrect range of minutes argument must return -1",  "PASSED");
        }
        else {
        	System.out.printf("%-80s%-10s\n", "toll520Bridge() TEST 02 -- incorrect range of minutes argument must return -1",  "FAILED");
        }
        
        // Test 3 //  
        if(toll520Bridge(15, 15, "am") == -1) {
        	System.out.printf("%-80s%-10s\n", "toll520Bridge() TEST 03 -- incorrect range of hours argument must return -1",  "PASSED");
        }
        else {
        	System.out.printf("%-80s%-10s\n", "toll520Bridge() TEST 03 -- incorrect range of hours argument must return -1",  "FAILED");
        }
        
        // Test 4 //  
        if(toll520Bridge(12, 0, "am")==1.25
        		&& toll520Bridge(12, 1, "am")==1.25
        		&& toll520Bridge(4, 59, "am")==1.25
        		&& toll520Bridge(3, 35, "am")==1.25) {
        	System.out.printf("%-80s%-10s\n", "toll520Bridge() TEST 04 -- calls that must return 1.25",  "PASSED");
        }
        else {
        	System.out.printf("%-80s%-10s\n", "toll520Bridge() TEST 04 -- calls that must return 1.25",  "FAILED");
        }
        
        // Test 5 //  
        if(toll520Bridge(5, 0, "am")==1.4 
        		&& toll520Bridge(5, 1, "am")==1.4
        		&& toll520Bridge(7, 59, "am")==1.4 
        		&& toll520Bridge(6, 03, "am")==1.4) {
        	System.out.printf("%-80s%-10s\n", "toll520Bridge() TEST 05 -- calls that must return 1.40 in am",  "PASSED");
        }
        else {
        	System.out.printf("%-80s%-10s\n", "toll520Bridge() TEST 05 -- calls that must return 1.40 in am",  "FAILED");
        }
        
        // Test 6 //  
        if(toll520Bridge(8, 0, "am")==2.05 
        		&& toll520Bridge(10, 59, "am")==2.05 
        		&& toll520Bridge(9, 15, "am")==2.05) {
        	System.out.printf("%-80s%-10s\n", "toll520Bridge() TEST 06 -- calls that must return 2.05 in am",  "PASSED");
        }
        else {
        	System.out.printf("%-80s%-10s\n", "toll520Bridge() TEST 06 -- calls that must return 2.05 in am",  "FAILED");
        }
        
        // Test 7 //  
        if(toll520Bridge(11, 0, "am")==2.65 
        		&& toll520Bridge(4, 59, "pm")==2.65 
        		&& toll520Bridge(3, 55, "pm")==2.65) {
        	System.out.printf("%-80s%-10s\n", "toll520Bridge() TEST 07 -- calls that must return 2.65",  "PASSED");
        }
        else {
        	System.out.printf("%-80s%-10s\n", "toll520Bridge() TEST 07 -- calls that must return 2.65",  "FAILED");
        }
        
        // Test 8 //  
        if(toll520Bridge(6, 0, "pm")==2.05 
        		&& toll520Bridge(8, 59, "pm")==2.05 
        		&& toll520Bridge(6, 15, "pm")==2.05) {
        	System.out.printf("%-80s%-10s\n", "toll520Bridge() TEST 08 -- calls that must return 2.05 in pm",  "PASSED");
        }
        else {
        	System.out.printf("%-80s%-10s\n", "toll520Bridge() TEST 08 -- calls that must return 2.05 in pm",  "FAILED");
        }
        
        // Test 9 //  
        if(toll520Bridge(9, 0, "pm")==1.4 
        		&& toll520Bridge(10, 59, "pm")==1.4 
        		&& toll520Bridge(9, 3, "pm")==1.4) {
        	System.out.printf("%-80s%-10s\n", "toll520Bridge() TEST 09 -- calls that must return 1.40 in pm",  "PASSED");
        }
        else {
        	System.out.printf("%-80s%-10s\n", "toll520Bridge() TEST 09 -- calls that must return 1.40 in pm",  "FAILED");
        }
        
        // Test 10 //  
        if(toll520Bridge(11, 0, "pm")==1.25 
        		&& toll520Bridge(11, 59, "pm")==1.25 
        		&& toll520Bridge(11, 40, "pm")==1.25) {
        	System.out.printf("%-80s%-10s\n", "toll520Bridge() TEST 10 -- calls that must return 1.25 in pm",  "PASSED");
        }
        else {
        	System.out.printf("%-80s%-10s\n", "toll520Bridge() TEST 10 -- calls that must return 1.25 in pm",  "FAILED");
        }
    }
        
 
     /** Method main()contains all the tests 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
  
        testIsRightTri();
        System.out.println("\n--------------------------------------------------------\n");
        testToll520Bridge();
        
    }    
}
