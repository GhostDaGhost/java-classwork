import java.util.Scanner;

/**
* @author Alexander Arizola
*/
public class NumericPatternMenu {
    public static int validateInt(String prompt, Scanner keyboard) {
        int userInputVal = 0;

        // LOOP UNTIL WE GET A VALID INPUT
        while (true) {
            try {
                System.out.print(prompt);
                String input = keyboard.next();

                // TURN INPUT INTO NUMBER AND BREAK LOOP
                userInputVal = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("ERROR. Number entered is not an integer.");
                keyboard.nextLine();
            }
        }

        // RETURN USER'S VALID INPUT
        return userInputVal;
    }

    // GRABBED THE SAME CODE I WROTE FOR TWOMETHODSA04
    public static String numericPattern(int size, boolean direction) throws IllegalArgumentException {
		if (size <= 0) { // VALIDATE SIZE PARAMETER
			throw new IllegalArgumentException("The size must be positive and not a zero!");
		}

		// START CREATING THE PATTERN
		String numberPattern = "";
		if (direction) { // WHEN DIRECTION IS TRUE, INCREMENT FIRST HALF OF NUMBERS AND THEN DECREMENT IN THE END
            for (int i = 1; i <= size; i++) {
				numberPattern = numberPattern + i;
            }

            for (int i = size - 1; i >= 1; i--) {
				numberPattern = numberPattern + i;
            }
		} else { // WHEN DIRECTION IS FALSE, DECREMENT FIRST HALF OF NUMBERS AND THEN INCREMENT IN THE END
            for (int i = size; i >= 1; i--) {
                numberPattern = numberPattern + i;
            }

            for (int i = 2; i <= size; i++) {
                numberPattern = numberPattern + i;
            }
		}

		// RETURN PATTERN AND ENSURE IT IS A STRING WHEN FINISHED
        return numberPattern;
    }

    // SOMEHOW FAILING THE INCORRECT INPUT TEST... COULD USE TIPS PLEASE.
    public static void main(String[] args) {
        Scanner keyB = new Scanner(System.in);

        // RUN LOOP UNTIL NUMBER 3 IS CHOSEN
        while (true) {
            System.out.println("Numeric Pattern Display");
            System.out.println("1. Print Type I pattern (like 12321)");
            System.out.println("2. Print Type II pattern (like 32123)");
            System.out.println("3. Quit");
            System.out.print("Enter your choice (1 - 3): ");

            // VALIDATE USER'S INPUT AND MAKE PATTERN IF CHOSEN 1 OR 2
            int userChoice = validateInt("", keyB);
            if (userChoice == 1 || userChoice == 2) {
                int size = 0;

                // ENSURE SIZE IS NOT ZERO OR NEGATIVE
                while (size <= 0) {
                    size = validateInt("Please enter the size of the pattern. The size must be a positive integer: ", keyB);
                    if (size <= 0) {
                        System.out.println("ERROR. Number entered is not positive.");
                    }
                }

                // START CREATING ASSIGNED PATTERN
                String newPattern = numericPattern(size, userChoice == 1);
                System.out.println(newPattern);
            } else if (userChoice == 3) {
                System.out.println("Quitting!");
                break;
            } else {
                System.out.println("ERROR. Number entered is not a valid selection.");
            }
        }
    }
}
