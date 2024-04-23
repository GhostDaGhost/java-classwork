

import java.io.PrintWriter;

/**
 *
 * @author AV
 */
public class TestPersonData {

/**
* All tests for PesronData class
* @return total score for AggregationClass  part of assignment
*/
	public static boolean tests(PrintWriter out)
    { 
		out.println("\r\n----PersonData Class TEST SETS -------------------------------------------------------\r\n");
        boolean t1= testSet01PersonDataClass(out);
 
        return t1;   
    }
  /**
  * Set of unit tests for no-argument constructor, constructor, accessors, mutators; toString(), equals(), clone()
  * @param outputStream stream to direct output into
  * @return number of points earned for this unit. 0 is returned if even one of the tests failed
  */   
    public static boolean testSet01PersonDataClass(PrintWriter outputStream)
    {
        int count = 0;
        int expectedCount = 5;

        PersonData p1 = new PersonData();
// Test #1
        if(p1.getFirstName().equals("") 
        		&& p1.getLastName().equals("") 
        		&& p1.getPhone().equals("") 
        		&& p1.getAddress().equals("")) 
        {
            outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for no-argument constructor, and accessor methods",  "PASSED");
            count++;
        }
        else  outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for no-argument constructor, and accessor methods",  "FAILED");
// Test #2
        p1.setFirstName("Sam");
        p1.setLastName("Smith");
        p1.setPhone("111-222-33-44");// phone number in our class is not beign checked for validity
        p1.setAddress("1122 123 Ave NW, Somecity, 23456"); // address string is not validated either
        if(p1.getFirstName().equals("Sam") 
        		&& p1.getLastName().equals("Smith") 
        		&& p1.getPhone().equals("111-222-33-44") 
        		&& p1.getAddress().equals("1122 123 Ave NW, Somecity, 23456"))
        {
            outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for mutator methods",  "PASSED");
            count++;
        }
        else  outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for mutator methods",  "FAILED"); 
// Test #3
        PersonData p2 = new PersonData("Tom", "Sumerson","2233 456 Ave NE, Sometown, 98765","765-123-45-67"); 
        if(p2.getFirstName().equals("Tom") 
        		&& p2.getLastName().equals("Sumerson") 
        		&& p2.getPhone().equals("765-123-45-67") 
        		&& p2.getAddress().equals("2233 456 Ave NE, Sometown, 98765"))
        {
            outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for constructor with parameters",  "PASSED");
            count++;
        }
        else  outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for constructor with parameters",  "FAILED"); 
 
        String fName = "Tom ";
        String lName = "Sumerson ";
        String addr = "2233 456 Ave NE, Sometown, 98765";
        String tel = "765-123-45-67";
        p1 = new PersonData(fName.trim(), lName.trim(),addr,tel); 



 // Test #4
        PersonData equalObj = new PersonData("Tom", "Sumerson","2233 456 Ave NE, Sometown, 98765","765-123-45-67"); 
        PersonData nonEqualObj1 = new PersonData("om", "Sumerson","2233 456 Ave NE, Sometown, 98765","765-123-45-67");
        PersonData nonEqualObj2 = new PersonData("Tom", "umerson","2233 456 Ave NE, Sometown, 98765","765-123-45-67");
        PersonData nonEqualObj3 = new PersonData("Tom", "Sumerson","233 456 Ave NE, Sometown, 98765","765-123-45-67");
        PersonData nonEqualObj4 = new PersonData("Tom", "Sumerson","2233 456 Ave NE, Sometown, 98765","65-123-45-67");
        String str = "Sample Object";
        Object someObj = str;
        
        if(p1.equals(equalObj) 
        		&& !p1.equals(someObj)
        		&& !p1.equals(nonEqualObj1)
        		&& !p1.equals(nonEqualObj2)
        		&& !p1.equals(nonEqualObj3)
        		&& !p1.equals(nonEqualObj4))
        {
            outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for equals() method",  "PASSED");
            count++;
        }
        else  outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for equals() method",  "FAILED"); 

 // Test #5
        p2 = p1.clone(); 
        
        if(p2.toString().equals(p1.toString())
        		&& p2.getObjState() == p1.getObjState())
        {
            outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for clone() method",  "PASSED");
            count++;
        }
        else  outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for clone() method",  "FAILED"); 
        
        return count==expectedCount;
    }
    
}
