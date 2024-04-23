
import java.io.PrintWriter;

/**
 *
 * @author AV
 */
public class TestRectangle {

	public static boolean tests(PrintWriter out) {
		
		out.println("\r\n----Rectangle Class TEST SETS -------------------------------------------------------\r\n");
		boolean t1 = testSet01RectangleClass(out);	
		boolean t2 = testSet02RectangleClass(out);
		boolean t3 = testSet03RectangleClass(out);
		
		return t1 && t2 && t3;
	}

	/**
	 * Set of unit tests for no-argument constructor, constructor, accessors,
	 * mutators, getArea()
	 * 
	 * @param outputStream stream to direct output into
	 * @return number of points earned for this unit. 0 is returned if even one of
	 *         the tests failed
	 */
	public static boolean testSet01RectangleClass(PrintWriter outputStream) {
		int count = 0;
		int expectedCount = 7;
		
		Rectangle c1 = new Rectangle();
		BasicShape s = c1; // compilation breaks here if Rectangle is not inherited from BasicShape
// Test #1
		if (c1.toString().equals("Left Upper Corner: (1,1); Width: 1.0; Length: 1.0; Color: (255,255,255)")) {
			outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for no-argument constructor",
					"PASSED");
			count++;
		} else
			outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for no-argument constructor",
					"FAILED");
// Test #2
		
		int[] color = c1.getColor();
		color[0] = 33; // for check on deep copying
		if (c1.toString().equals("Left Upper Corner: (1,1); Width: 1.0; Length: 1.0; Color: (255,255,255)")
				&&c1.getCornerX() == 1 
				&& c1.getCornerY() == 1 
				&& c1.getLength() == 1 
				&& c1.getWidth() == 1
				&& color.length == 3 && color[0] == 33 && color[1] == 255 && color[2] == 255) {
			outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for accessor methods and deep copy for getColor()",
					"PASSED");
			count++;
		} else
			outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for accessor methods and deep copy for getColor()",
					"FAILED");
// Test #3 --setters
		c1.setCornerX(55);
		c1.setCornerY(66);
		c1.setLength(7);
		c1.setWidth(10);
		int[] color1 = { 11, 22, 33 };
		c1.setColor(color1);
		
		if (c1.toString().equals("Left Upper Corner: (55,66); Width: 10.0; Length: 7.0; Color: (11,22,33)")) {
			outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for mutator methods", "PASSED");
			count++;
		} else
			outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for mutator methods", "FAILED");

// Test #4 -- deep copy of the array with setColor()
		color1[0] = 100;
		if (c1.toString().equals("Left Upper Corner: (55,66); Width: 10.0; Length: 7.0; Color: (11,22,33)")) {
			outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for deep copy of array with setColor()", "PASSED");
			count++;
		} else
			outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for deep copy of array with setColor()", "FAILED");

// Test #5 setColor() - exception (2 points)
		try {
			int[] color2 = { 555, -1, 345 };
			c1.setColor(color2);
			outputStream.printf("%-80s%-10s\r\n", "Test Set 01: setColor() exception test 1", "FAILED");
		} catch (IllegalArgumentException e) {
			outputStream.printf("%-80s%-10s\r\n", "Test Set 01: setColor() exception test 1", "PASSED");
			count++;
		}
		int[] color3 = c1.getColor(); // taking a shortcut ;)
		for (int i = 0; i < 3; i++) {
			if (color3[i] < 0 || color3[i] > 255)
				outputStream.printf("%-80s%-10s\r\n", "Test Set 01: setColor() exception test 2", "FAILED");
		}
		outputStream.printf("%-80s%-10s\r\n", "Test Set 01: setColor() exception test 2", "PASSED");
		count++;
// Test #6 setLength() and setWidth() - exception (2 points)
		try {

			c1.setLength(-5);
			outputStream.printf("%-80s%-10s\r\n", "Test Set 01: setLength() exception", "FAILED");
		} catch (IllegalArgumentException e) {
			outputStream.printf("%-80s%-10s\r\n", "Test Set 01: setLength() exception", "PASSED");
			count++;
		}
		try {

			c1.setWidth(-5);
			outputStream.printf("%-80s%-10s\r\n", "Test Set 01: setWidth() exception", "FAILED");
		} catch (IllegalArgumentException e) {
			outputStream.printf("%-80s%-10s\r\n", "Test Set 01: setWidth() exception", "PASSED");
			count++;
		}
		

		return  count == expectedCount;
			
	}

	/**
	 * Set of unit tests for no-argument constructor, constructor, accessors,
	 * mutators, getArea()
	 * 
	 * @param outputStream stream to direct output into
	 * @return number of points earned for this unit. 0 is returned if even one of
	 *         the tests failed
	 */
	public static boolean testSet02RectangleClass(PrintWriter outputStream) {
		int count = 0;
		int expectedCount = 8;

		
// Test #1 - constructor with parameters
		int[] color1 = {11, 22, 33};
		Rectangle c1 = new Rectangle(55, 66, 7, 10, color1);
		
		if (c1.toString().equals("Left Upper Corner: (55,66); Width: 10.0; Length: 7.0; Color: (11,22,33)") ) {
			outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test #1 for constructor", "PASSED");
			count++;
		} else
			outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test #1 for constructor", "FAILED");

// Test #2 - deep copy of array
		color1[0] = 200;

		if (c1.toString().equals("Left Upper Corner: (55,66); Width: 10.0; Length: 7.0; Color: (11,22,33)")) {
			outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test #2 for constructor - deep copy of array",
					"PASSED");
			count++;
		} else
			outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test #2 for constructor - deep copy of array",
					"FAILED");

// Test #3 constructor - exception (2 points)
		try {
			int[] color2 = { 555, -1, 345 };
			c1 = new Rectangle(55, 66, 7, 10, color2);
			outputStream.printf("%-80s%-10s\r\n", "Test Set 02: constructor exception test 1", "FAILED");
		} catch (IllegalArgumentException e) {
			outputStream.printf("%-80s%-10s\r\n", "Test Set 02: constructor exception test 1", "PASSED");
			count++;
		}

		int[] color4 = c1.getColor(); // taking a shortcut ;)
		for (int i = 0; i < 3; i++) {
			if (color4[i] < 0 || color4[i] > 255)
				outputStream.printf("%-80s%-10s\r\n", "Test Set 02: constructor exception test 2", "FAILED");
		}
		outputStream.printf("%-80s%-10s\r\n", "Test Set 02: constructor exception test 2", "PASSED");
		count++;

// Test #4 constructor - exception for negative length and width - 2 points
		try {
			c1 = new Rectangle(55, 66, -7, 10, color1);
			outputStream.printf("%-80s%-10s\r\n", "Test Set 02: constructor negative length exception", "FAILED");
		} catch (IllegalArgumentException e) {
			outputStream.printf("%-80s%-10s\r\n", "Test Set 02: constructor negative length exception", "PASSED");
			count++;
		}
		try {
			c1 = new Rectangle(55, 66, 7, -10, color1);
			outputStream.printf("%-80s%-10s\r\n", "Test Set 02: constructor negative width exception", "FAILED");
		} catch (IllegalArgumentException e) {
			outputStream.printf("%-80s%-10s\r\n", "Test Set 02: constructor negative width exception", "PASSED");
			count++;
		}
		
		int[] color11 = { 22, 33, 44 };
		BasicShape p1 = new Rectangle(55, 66, 7, 10, color11);

// Test #5- getArea()

		if (p1.getArea() == 70) {
			outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for getArea() method", "PASSED");
			count++;
		} else
			outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for getArea() method", "FAILED");

// Test #6 - relatable interface methods
		BasicShape c2 = new Rectangle(55, 33, 7, 10, color11);
		BasicShape c3 = new Rectangle(22, 34, 8, 20, color11);

		if (c1.equals(c2) && p1.isLess(c3) && c3.isGreater(c1)) {
			outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for methods of Relatable interface", "PASSED");
			count++;
		} else
			outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for methods of Relatable interface", "FAILED");

// Test #7 - clone()
		
		Rectangle c4 = c1.clone();

		if (c4.toString().equals("Left Upper Corner: (55,66); Width: 10.0; Length: 7.0; Color: (11,22,33)")
				&& c4.getObjState() == c1.getObjState()) {
			outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for clone()", "PASSED");
			count++;
		} else
			outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for clone()", "FAILED");

// Test #8- clone() - deep copy of array
		
		int[] color12 = {1, 1, 1};
		c1.setColor(color12);
		if (c4.toString().equals("Left Upper Corner: (55,66); Width: 10.0; Length: 7.0; Color: (11,22,33)")) {
			outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for clone() - deep copy of color array", "PASSED");
			count++;
		} else
			outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for clone() - deep copy of color array", "FAILED");

		
		return  count == expectedCount;
	}
	
	
	public static boolean testSet03RectangleClass(PrintWriter outputStream) {
		// Test #1
		int count = 0;
		int expectedCount = 2;
		
		int[] color1 = {222, 223, 224};
		
		BasicShape circle = new Circle(1, 2, 3, color1);
		BasicShape rectangle = new Rectangle(1, 2, 9, Math.PI, color1); // circle and rectangle have equal areas
		
		if (!circle.equals(rectangle))  // compilation will fail here if boolean equals(Object) is not implemented in BasicShape and/or has incorrect signature
		{
			outputStream.printf("%-80s%-10s\r\n", "Test Set 03: Test for boolean equals(Object) implementation in BasicShape",
					"PASSED");
			count++;
		} else {
			outputStream.printf("%-80s%-10s\r\n", "Test Set 03: Test for boolean equals(Object) implementation in BasicShape",
					"FAILED");
			
		}
		// Test #2
		rectangle = new Rectangle(1, 2, 3, 4, color1);
		if (circle.isGreater(rectangle)  // compilation will fail here if boolean isGreater(Object) and isLess(Object) are not implemented in BasicShape and/or have incorrect signature
				&& rectangle.isLess(circle)) 
		{
			outputStream.printf("%-80s%-10s\r\n", "Test Set 03: Test for isLess() and isGreater() implementation in BasicShape",
					"PASSED");
			count++;
		} else {
			outputStream.printf("%-80s%-10s\r\n", "Test Set 03: Test for isLess() and isGreater() implementation in BasicShape",
					"FAILED");
		}	
			return  count == expectedCount;		
			
	}	
		
	/**
	 * Compares two arrays of integers
	 * 
	 * @param one first array to compare
	 * @param two second array to compare
	 * @return returns true if arrays are the same, false if not
	 */
	public static boolean equalArrays(int[] one, int[] two) {
		if (one.length != two.length)
			return false;
		for (int i = 0; i < one.length; i++) {
			if (one[i] != two[i])
				return false;
		}
		return true;
	}
}
