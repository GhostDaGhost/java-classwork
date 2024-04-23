
import java.io.PrintWriter;

/**
 *
 * @author AV
 */
public class TestCircle {

	public static boolean tests(PrintWriter out)
	{
		
		out.println("\r\n----Circle Class TEST SETS -------------------------------------------------------\r\n");
		boolean t1 = testSet01CircleClass(out);
		boolean t2 = testSet02CircleClass(out);

		return t1 && t2;  
	}

	/**
	 * Set of unit tests for no-argument constructor, constructor, accessors,
	 * mutators, getArea()
	 * 
	 * @param outputStream stream to direct output into
	 * @return number of points earned for this unit. 0 is returned if even one of
	 *         the tests failed
	 */
	public static boolean testSet01CircleClass(PrintWriter outputStream) {
		int count = 0;
		int expectedCount = 7;
		
		Circle c1 = new Circle();
// Test #1

		BasicShape s = c1; // compilation breaks here if Circle is not inherited from BasicShape
		
		if (c1.toString().equals("Center: (1,1); Radius: 1.0; Color: (255,255,255)")) {
			outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for no-argument constructor",
					"PASSED");
			count++;
		} else
			outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for no-argument constructor",
					"FAILED");

// Test #2 - getColor() & other getters 
		int[] color = c1.getColor(); 
		color[0] = 33;
		
		if (c1.toString().equals("Center: (1,1); Radius: 1.0; Color: (255,255,255)")
				&& c1.getCenterX() == 1
				&& c1.getCenterY() ==1
				&& c1.getRadius() == 1
				&& color.length == 3 && color[0] == 33 && color[1] == 255 && color[2] == 255) {
			outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for accessor methods and deep copy for getColor()",
					"PASSED");
			count++;
		} else
			outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for accessor methods and deep copy for getColor()",
					"FAILED");
// Test #3 - setters
		c1.setCenterX(55);
		c1.setCenterY(66);
		c1.setRadius(7);
		int[] color1 = { 11, 22, 33 };
		c1.setColor(color1);
		
		if (c1.toString().equals(("Center: (55,66); Radius: 7.0; Color: (11,22,33)"))) {
			outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for mutator methods", "PASSED");
			count++;
		} else
			outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for mutator methods", "FAILED");

// Test #4 -- deep copy of the array with setColor()
		color1[0] = 100;
		if (c1.toString().equals(("Center: (55,66); Radius: 7.0; Color: (11,22,33)"))) {
			outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for deep copy of array with setColor()", "PASSED");
			count++;
		} else
			outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for deep copy of array with setColor()", "FAILED");

		// Test #5 setRadius() - exception
		try {

			c1.setRadius(-7);
			outputStream.printf("%-80s%-10s\r\n", "Test Set 01: setRadius() exception test", "FAILED");
		} catch (IllegalArgumentException e) {
			outputStream.printf("%-80s%-10s\r\n", "Test Set 01: setRadius() exception test", "PASSED");
			count++;
		}

		// Test #6 setColor() - exception (2 points)
		try {
			int[] color2 = { 555, -1, 345 };
			c1.setColor(color2);
			outputStream.printf("%-80s%-10s\r\n", "Test Set 01: setColor() exception test 1", "FAILED");
		} catch (IllegalArgumentException e) {
			outputStream.printf("%-80s%-10s\r\n", "Test Set 01: setColor() exception test 1", "PASSED");
			count++;
		}
		int[] color3 = c1.getColor(); // taking a shortcut ;)
		int n = 0;
		for (int i = 0; i < 3; i++) {
			if (color3[i] < 0 || color3[i] > 255) {
				outputStream.printf("%-80s%-10s\r\n", "Test Set 01: setColor() exception test 2", "FAILED");
				n++;
			}
		}
		if(n==0)
		{
			outputStream.printf("%-80s%-10s\r\n", "Test Set 01: setColor() exception test 2", "PASSED");
			count++;
		}
			
		
	      if (count==expectedCount) return true;
	       else return false;

	}

	/**
	 * Set of unit tests for no-argument constructor, constructor, accessors,
	 * mutators, getArea()
	 * 
	 * @param outputStream stream to direct output into
	 * @return number of points earned for this unit. 0 is returned if even one of
	 *         the tests failed
	 */
	public static boolean testSet02CircleClass(PrintWriter outputStream) {
		int count = 0;
		int expectedCount = 9;
		
		// Test #1 - constructor with parameters, simple
 
		int[] color1 = {1, 1, 1};
		Circle c1 = new Circle(55, 66, 7, color1);
		
		if (c1.getCenterX() == 55 
				&& c1.getCenterY() == 66 
				&& c1.getRadius() == 7 
				&& c1.toString().equals("Center: (55,66); Radius: 7.0; Color: (1,1,1)")) {
			outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test #1 for constructor", "PASSED");
			count++;
		} else {
			outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test #1 for constructor", "FAILED");
		}

		// Test #2 - deep copy of array
		color1[0] = 200;

		if (c1.toString().equals("Center: (55,66); Radius: 7.0; Color: (1,1,1)")) {
			outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test #2 for constructor - deep copy of array",
					"PASSED");
			count++;
		} else
			outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test #2 for constructor - deep copy of array",
					"FAILED");

		// Test #3 constructor - exception (2 points)
		try {
			int[] color2 = { 555, -1, 345 };
			c1 = new Circle(55, 66, 7, color2);
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

		// Test #4 constructor - exception for negative radius
		try {
			c1 = new Circle(55, 66, -7, color1);
			outputStream.printf("%-80s%-10s\r\n", "Test Set 02: constructor negative radius exception", "FAILED");
		} catch (IllegalArgumentException e) {
			outputStream.printf("%-80s%-10s\r\n", "Test Set 02: constructor negative radius exception", "PASSED");
			count++;
		}
		int[] color11 = { 22, 33, 44 };
		BasicShape c12 = new Circle(55, 66, 7, color11);
// Test #5 - getArea()

		if (c12.getArea() == Math.PI * Math.pow(7, 2)) // will fail to compile here if BasicShape does not have the abstract method

		{
			outputStream.printf("%-80s%-10s\r\n",
					"Test Set 02: Test for getArea() method and for inheritance from BasicShape ", "PASSED");
			count++;
		} else
			outputStream.printf("%-80s%-10s\r\n",
					"Test Set 02: Test for getArea() method and for inheritance from BasicShape", "FAILED");
// Test #6 - relatable interface methods
		BasicShape c2 = new Circle(55, 66, 7, color11);
		BasicShape c3 = new Circle(22, 34, 8, color11);

		if (c1.equals(c2) && c1.isLess(c3) && c3.isGreater(c1)) // will fail to compile here if BasicShape does not have
																// the methods implemented
		{
			outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for methods of Relatable interface", "PASSED");
			count++;
		} else
			outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for methods of Relatable interface", "FAILED");


		
		// Test #7 - clone()
		Circle c11 = new Circle(55, 66, 7, color11);
		Circle c4 = c11.clone();
		
		if (c4.getCenterX() == 55 
				&& c4.getCenterY() == 66 
				&& c4.getRadius() == 7
				&& equalArrays(c11.getColor(), c4.getColor())
				&& c4.getObjState() == c11.getObjState()) {
			outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for clone()", "PASSED");
			count++;
		} else
			outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for clone()", "FAILED");

// Test #8 - clone() - deep copy of array
		int[] tmp = {100, 100, 100};
		c11.setColor(tmp);
		
		if (c4.toString().equals("Center: (55,66); Radius: 7.0; Color: (22,33,44)")) {
			outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for clone() - deep copy of color array", "PASSED");
			count++;
		} else
			outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for clone() - deep copy of color array", "FAILED");


	      if (count==expectedCount) return true;
	      else return false;

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
