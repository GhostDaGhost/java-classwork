
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author AV
 */
public class TestCustomerData {

	/**
	 * All tests for PesronData class
	 * 
	 * @return total score for AggregationClass part of assignment
	 */
	public static boolean tests(PrintWriter out) {

		out.println("\r\n----CustomerData Class TEST SETS -------------------------------------------------------\r\n");
		boolean t1 = testSet01CustomerDataClass(out);
		boolean t2 = testSet02CustomerDataClass(out);

		return t1 && t2;
	}

	/**
	 * Set of unit tests for no-argument constructor, constructor, accessors
	 * 
	 * @param outputStream stream to direct output into
	 * @return number of points earned for this unit. 0 is returned if even one of
	 *         the tests failed
	 */
	public static boolean testSet01CustomerDataClass(PrintWriter outputStream) {
		int count = 0;
		int expectedCount = 7;

		CustomerData p1 = new CustomerData();

// Test #1
		if (p1.getFirstName().equals("") && p1.getLastName().equals("") && p1.getPhone().equals("")
				&& p1.getAddress().equals("") && p1.getMailingList() == false && p1.getCustomerNumber() == 0
				&& p1.getTransactions().size() == 0) {
			outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for no-argument constructor, and accessor methods",
					"PASSED");
			count++;
		} else {
			outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for no-argument constructor, and accessor methods",
					"FAILED");
		}

// Test #2 -- constructor tests 
		ArrayList<Long> list = new ArrayList<Long>();
		list.add(1L);
		list.add(2L);
		list.add(3L);
		CustomerData p2 = new CustomerData("Tom", "Sumerson", "2233 456 Ave NE, Sometown, 98765", "765-123-45-67", 15,
				false, list);
		
		if (p2.toString().equals("First name: Tom; Last name: Sumerson; Address: 2233 456 Ave NE, Sometown, 98765; Phone: 765-123-45-67; Customer number: 15; Mailing list: false; Transactions: [1, 2, 3]")) {
			outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for constructor with parameters", "PASSED");
			count++;
		} else {
			outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for constructor with parameters", "FAILED");
		}

// Test #3 -- Deep copy of the ArrayList field
		list.add(4L); // p2 must be unchanged by this 
		if (p2.toString().equals("First name: Tom; Last name: Sumerson; Address: 2233 456 Ave NE, Sometown, 98765; Phone: 765-123-45-67; Customer number: 15; Mailing list: false; Transactions: [1, 2, 3]")) {
			outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for deep copy of the ArrayList field", "PASSED");
			count++;
		} else {
			outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for deep copy of the ArrayList field", "FAILED");
		}

// Test #4 -- getters test
		
		if(p2.getFirstName().equals("Tom") 
				&& p2.getLastName().equals("Sumerson") 
				&& p2.getPhone().equals("765-123-45-67") 
				&& p2.getAddress().equals("2233 456 Ave NE, Sometown, 98765")
				&& p2.getCustomerNumber() == 15 
				&& p2.getMailingList() == false 
				&& p2.getTransactions().toString().equals("[1, 2, 3]"))
		{
			outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for accessors", "PASSED");
			count++;
		} else {
			outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for accessors", "FAILED");
		}
		
// Test #5 -- getTransactions() deep copy test	
		
		ArrayList<Long> list3 = p2.getTransactions();
		list3.add(100L);
		if(p2.toString().equals("First name: Tom; Last name: Sumerson; Address: 2233 456 Ave NE, Sometown, 98765; Phone: 765-123-45-67; Customer number: 15; Mailing list: false; Transactions: [1, 2, 3]"))
		{
			outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for getTransactions() deep copy", "PASSED");
			count++;
		} else {
			outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for getTransactions() deep copy", "FAILED");
		}		
		ArrayList<Long> list1 = new ArrayList<Long>();
		list1.add(1L);
		list1.add(2L);
		list1.add(3L);
		p2 = new CustomerData("Tom", "Sumerson", "2233 456 Ave NE, Sometown, 98765", "765-123-45-67", 15, false, list1);

// Test #6 -- Mutators

		p2.setCustomerNumber(25);
		p2.setMailingList(true);
		ArrayList<Long> list2 = new ArrayList<Long>();
		list2.add(11L);
		list2.add(222L);
		list2.add(3333L);
		p2.setTransactions(list2);
		
		if (p2.toString().equals("First name: Tom; Last name: Sumerson; Address: 2233 456 Ave NE, Sometown, 98765; Phone: 765-123-45-67; Customer number: 25; Mailing list: true; Transactions: [11, 222, 3333]")) {
			outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for all mutator methods", "PASSED");
			count++;
		} else
			outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for all mutator methods", "FAILED");

		// Test #7 -- Deep copy of the ArrayList field when changed by mutator
		list2.add(44L);
		if (p2.toString().equals("First name: Tom; Last name: Sumerson; Address: 2233 456 Ave NE, Sometown, 98765; Phone: 765-123-45-67; Customer number: 25; Mailing list: true; Transactions: [11, 222, 3333]")) {
			outputStream.printf("%-80s%-10s\r\n",
					"Test Set 01: Test for deep copy of the ArrayList field when changed by mutator", "PASSED");
			count++;
		} else {
			outputStream.printf("%-80s%-10s\r\n",
					"Test Set 01: Test for deep copy of the ArrayList field when changed by mutator", "FAILED");
		}

		return count == expectedCount;

	}

	/**
	 * Set of unit tests for mutators, addTransaction(), toString() methods
	 * 
	 * @param outputStream stream to direct output into
	 * @return number of points earned for this unit. 0 is returned if even one of
	 *         the tests failed
	 */
	public static boolean testSet02CustomerDataClass(PrintWriter outputStream) {
		int count = 0;
		int expectedCount = 5;

		ArrayList<Long> list2 = new ArrayList<Long>();
		list2.add(11L);
		list2.add(222L);
		list2.add(3333L);
		CustomerData p2 = new CustomerData("Tom", "Sumerson", "2233 456 Ave NE, Sometown, 98765", "765-123-45-67", 25,
				true, list2);


// Test #1 addTransaction() - simple
		p2.addTransaction(11111L);
		
		if (p2.toString().equals("First name: Tom; Last name: Sumerson; Address: 2233 456 Ave NE, Sometown, 98765; Phone: 765-123-45-67; Customer number: 25; Mailing list: true; Transactions: [11, 222, 3333, 11111]")) {
			outputStream.printf("%-80s%-10s\r\n", "Test Set 02: addTransaction() method", "PASSED");
			count++;
		} else {
			outputStream.printf("%-80s%-10s\r\n", "Test Set 02: addTransaction() method", "FAILED");
		}

// Test #2 addTransaction() - exception
		try {
			p2.addTransaction(1111111111111111L);
			outputStream.printf("%-80s%-10s\r\n", "Test Set 02: addTransaction() exception", "FAILED");
		} catch (IllegalArgumentException e) {
			outputStream.printf("%-80s%-10s\r\n", "Test Set 02: addTransaction() exception", "PASSED");
			count++;
		}

		// Test #3 -- equals()
		ArrayList<Long> list = new ArrayList<Long>();
		list.add(1L);
		list.add(2L);
		list.add(3L);
		String fName = "Tom ";
		String lName = "Sumerson ";
		String addr = "2233 456 Ave NE, Sometown, 98765";
		String tel = "765-123-45-67";

		CustomerData equalObj = new CustomerData("Tom", "Sumerson", "2233 456 Ave NE, Sometown, 98765", "765-123-45-67",
				15, false, list);

		CustomerData p1 = new CustomerData(fName.trim(), lName.trim(), addr, tel, 15, false, list);
		


		CustomerData nonEqualObj1 = new CustomerData("om", "Sumerson", "2233 456 Ave NE, Sometown, 98765",
				"765-123-45-67", 15, false, list);
		CustomerData nonEqualObj2 = new CustomerData("Tom", "umerson", "2233 456 Ave NE, Sometown, 98765",
				"765-123-45-67", 15, false, list);
		CustomerData nonEqualObj3 = new CustomerData("Tom", "Sumerson", "233 456 Ave NE, Sometown, 98765",
				"765-123-45-67", 15, false, list);
		CustomerData nonEqualObj4 = new CustomerData("Tom", "Sumerson", "2233 456 Ave NE, Sometown, 98765",
				"65-123-45-67", 15, false, list);
		CustomerData nonEqualObj5 = new CustomerData("Tom", "Sumerson", "2233 456 Ave NE, Sometown, 98765",
				"765-123-45-67", 16, false, list);
		CustomerData nonEqualObj6 = new CustomerData("Tom", "Sumerson", "2233 456 Ave NE, Sometown, 98765",
				"765-123-45-67", 15, true, list);
		list.add(100L);
		CustomerData nonEqualObj7 = new CustomerData("Tom", "Sumerson", "2233 456 Ave NE, Sometown, 98765",
				"765-123-45-67", 15, false, list);
		PersonData someObj = new PersonData("Tom", "Sumerson", "2233 456 Ave NE, Sometown, 98765", "65-123-45-67");

		if (p1.equals(equalObj) && !p1.equals(someObj) && !p1.equals(nonEqualObj1) && !p1.equals(nonEqualObj2)
				&& !p1.equals(nonEqualObj3) && !p1.equals(nonEqualObj4) && !p1.equals(nonEqualObj5)
				&& !p1.equals(nonEqualObj6) && !p1.equals(nonEqualObj7)) {
			outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for equals() method", "PASSED");
			count++;
		} else
			outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for equals() method", "FAILED");

		// Test #4 -- clone()
		p2 = p1.clone();
		

		if (p2.toString().equals("First name: Tom; Last name: Sumerson; Address: 2233 456 Ave NE, Sometown, 98765; Phone: 765-123-45-67; Customer number: 15; Mailing list: false; Transactions: [1, 2, 3]")
				&& p2.getObjState() == p1.getObjState())
		{
			outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for clone() method", "PASSED");
			count++;
		}
		else 
		{
			outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for clone() method", "FAILED");
		}

// Test #5 -- clone() deep copy of list field
		
		p1.addTransaction(10000L);
		
		if (p2.toString().equals("First name: Tom; Last name: Sumerson; Address: 2233 456 Ave NE, Sometown, 98765; Phone: 765-123-45-67; Customer number: 15; Mailing list: false; Transactions: [1, 2, 3]")) {
			outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for clone() method with deep copy", "PASSED");
			count++;
		} else {
			outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for clone() method with deep copy", "FAILED");

		}	

		return count == expectedCount;

	}

}
