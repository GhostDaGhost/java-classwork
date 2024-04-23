import java.io.PrintWriter;

public class TestRelatableMethods {
	
	public static boolean tests(PrintWriter out) {
		int total = 0;
		int expectedTotal = 10;
		out.println("\r\n----Relatable Methods and Polymorphic behaviour of classes TEST SETS -------------------------------------------------------\r\n");

		boolean t1= testSet01Relatable(out);

		return t1;
	}
	/**
	 * Set of unit tests for Relatable interface methods and their proper implementation as 
	 * BasicShape class methods
	 * 
	 * @param outputStream stream to direct output into
	 * @return number of points earned for this unit. 0 is returned if even one of
	 *         the tests failed
	 */
	public static boolean testSet01Relatable(PrintWriter outputStream) {
		int count = 0;
		int expectedCount = 2;

		// Test #1
		
		int[] color1 = {222, 223, 224};
		// circle and rectangle have equal areas
		BasicShape circle = new Circle(1, 2, 3, color1);
		BasicShape rectangle = new Rectangle(1, 2, 9, Math.PI, color1);
		
		if (!circle.equals(rectangle))  // compilation will fail here if boolean equals(Object) is not implemented in BasicShape and/or has incorrect signature
		{
			outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for boolean equals(Object) implementation in BasicShape",
					"PASSED");
			count++;
		} else {
			outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for boolean equals(Object) implementation in BasicShape",
					"FAILED");
		}

		rectangle = new Rectangle(1, 2, 3, 4, color1);
		if (circle.isGreater(rectangle)  // compilation will fail here if boolean isGreater(Object) and isLess(Object) are not implemented in BasicShape and/or have incorrect signature
				&& rectangle.isLess(circle)) 
		{
			outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for isLess() and isGreater() implementation in BasicShape",
					"PASSED");
			count++;
		} else {
			outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for isLess() and isGreater() implementation in BasicShape",
					"FAILED");
		}
		
		return count == expectedCount;
		
	}

}
