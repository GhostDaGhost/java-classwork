/**
* @author Alexander Arizola
*/
public class TwoMethodsA03 {
	/**
	 * Method finds and returns the largest digit in a given number
	 * 
	 * @param num the number to analyze
	 * @return the largest digit
	 */
	public static int getLargestDigit(int num) {
		int largestNum = 0;

        // IF IT IS A NEGATIVE NUMBER, CONVERT IT TO POSITIVE
        if (num < 0) {
        	num = num * -1;
        }

		// CUT DOWN THE NUMBER AND CACHE THE LARGEST REMAINDER DIGIT
		while (num > 0) {
            int remainderDigit = num % 10;

            num = num / 10;
			if (remainderDigit > largestNum) {
				largestNum = remainderDigit;
			}
		}

		// RETURN LARGE DIGIT OF A NUMBER
		return largestNum;
	}

	/**
	 * Method calculates and returns the sum of fractions in form of a string 2/1 + 3/2 + 4/3 + .... + (a+1)/a = sum
	 * Sum is rounded to 5 digits after decimal point
	 * @param a the limit of the fraction pattern
	 * @return the sum of fractions; returns empty string if the parameter value is less than 1
	 *        
	 */
	public static String fractionSum(int a) {
		if (a <= 0) { // RETURN EMPTY STRING IF PARAMETER VALUE IS LESS THAN 1
			return "";
		}

		// INITIATE VARIABLES
		double answer = 0.0;
		String pattern = "";

		// START CREATING THE PATTERN
		for (int i = 1; i <= a; i++) {
			// SETUP THE EQUATION AND DO MATH TO ADD TO THE PATTERN
			double equation = (i + 1.0) / i;
			answer += equation;

			// APPEND OR CREATE PATTERN STRING
            pattern += i + 1 + "/" + i;
            if (i < a) {
                pattern += " + ";
            }
        }

		// FINALIZE PATTERN BEFORE RETURNING IT
        pattern += " = " + String.format("%.5f", answer);
		return pattern;
	}

	/**
	 * A set of tests for getLagrestDigit() method
	 */
	public static void testGetLargestDigit() {
		
		System.out.println("\r\n----Tests for getLargestDigit()-------------------------------------------------------\r\n");
		
		// Test 1 //
		if (getLargestDigit(0) == 0 
				&& getLargestDigit(9) == 9) {			
			System.out.printf("%-80s%-10s\n", "getLargestDigit() TEST 01 - single digit positive argument",  "PASSED");
			
		}
		else {
			System.out.printf("%-80s%-10s\n", "getLargestDigit() TEST 01 - single digit positive argument",  "FAILED");
		}

		// Test 2 //
		if (getLargestDigit(-5) == 5) {
			System.out.printf("%-80s%-10s\n", "getLargestDigit() TEST 02 - single digit negative argument",  "PASSED");
			
		}
		else {
			System.out.printf("%-80s%-10s\n", "getLargestDigit() TEST 02 - single digit negative argument",  "FAILED");
		}

		// Test 3 //
		if (getLargestDigit(9881) == 9 
				&& getLargestDigit(12348) == 8
				&& getLargestDigit(33) == 3) {
			System.out.printf("%-80s%-10s\n", "getLargestDigit() TEST 03 - multiple digit positive argument",  "PASSED");
		
		}
		else {
			System.out.printf("%-80s%-10s\n", "getLargestDigit() TEST 03 - multiple digit positive argument",  "FAILED");	
			
		}

		//  Test 4 //
		if (getLargestDigit(-5565) == 6 
				&& getLargestDigit(-9881) == 9 
				&& getLargestDigit(-12348) == 8
				&& getLargestDigit(-33) == 3) {
			System.out.printf("%-80s%-10s\n", "getLargestDigit() TEST 04 - multiple digit negative argument",  "PASSED");
			
		}
		else {
			System.out.printf("%-80s%-10s\n", "getLargestDigit() TEST 04 - multiple digit negative argument",  "FAILED");	
		}

	}

	public static void testFractionSum() {
		
		System.out.println("\r\n----Tests for fractionSum()-----------------------------------------------------------\r\n");
		//  Test 1 //
		if (fractionSum(-55).equals("") && fractionSum(0).equals("")) {
			System.out.printf("%-80s%-10s\n", "fractionSum() TEST 01 - argument less than 1",  "PASSED");
			
		}
		else {
			System.out.printf("%-80s%-10s\n", "fractionSum() TEST 01 - argument less than 1",  "FAILED");
		}

		//  Test 2 //
		
		if (fractionSum(1).equals("2/1 = 2.00000")) {
			System.out.printf("%-80s%-10s\n", "fractionSum() TEST 02 - argument 1",  "PASSED");
			
		}
		else {
			System.out.printf("%-80s%-10s\n", "fractionSum() TEST 02 - argument 1",  "FAILED");
		}

		//  Test 3 //
		if (fractionSum(2).equals("2/1 + 3/2 = 3.50000")
				&& fractionSum(3).equals("2/1 + 3/2 + 4/3 = 4.83333")
				&& fractionSum(6).equals("2/1 + 3/2 + 4/3 + 5/4 + 6/5 + 7/6 = 8.45000")
				&& fractionSum(10).equals("2/1 + 3/2 + 4/3 + 5/4 + 6/5 + 7/6 + 8/7 + 9/8 + 10/9 + 11/10 = 12.92897")) {
			
		
			System.out.printf("%-80s%-10s\n", "fractionSum() TEST 03 - argument other than 1",  "PASSED");
			
		}
		else {
			System.out.printf("%-80s%-10s\n", "fractionSum() TEST 03 - argument other than 1",  "FAILED");
		}

	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		testGetLargestDigit();
		testFractionSum();
	}

}
