import java.util.Scanner;

/**
* @author Alexander Arizola
*/
public class GreatestAndLeast {
    public static void main(String[] args) {
        Scanner keyboardInput = new Scanner(System.in);

        // INITIALIZE VARIABLES SUCH AS THE GREATEST AND LEAST NUMBERS
        int greatestNumber = 0;
        int leastNumber = 0;

        // VARIABLE TO CONTROL WHETHER OR NOT USER EVEN INPUTTED NUMBERS (FOR -99'S MESSAGE)
        boolean numbersWereInputted = false;

        // LOOP FOR INPUT UNTIL -99 IS ENTERED
        int userNumberInput = 0;
        while (true) {
            System.out.println("Enter a positive integer number. Enter -99 to stop input.");
            System.out.print("=>");

            // INTERCEPT USER'S INPUT FOR THE NUMBER
            userNumberInput = keyboardInput.nextInt();

            // IF NUMBER IS -99, THEN BREAK FROM THE LOOP AFTER GIVING RESULTS
            if (userNumberInput == -99) {
                if (!numbersWereInputted) {
                    System.out.println("No numbers were entered");
                } else {
                    System.out.println("the largest number: "+ greatestNumber +" ; the smallest number: " + leastNumber);
                }

                // BREAK FROM LOOP AS PER INSTRUCTED IN THE EVENT OF -99
                break;
            } else if (userNumberInput < 0 && userNumberInput != -99) {
                System.out.println("ERROR: negative integers other than -99 are not allowed.");
            } else {
                if (!numbersWereInputted) {
                    greatestNumber = userNumberInput;
                    leastNumber = userNumberInput;

                    // FLAG THAT WE HAVE INDEED ENTERED NUMBERS FOR -99'S MESSAGE TO CHANGE
                    numbersWereInputted = true;
                } else {
                    if (userNumberInput > greatestNumber) {
                        greatestNumber = userNumberInput;
                    }

                    if (userNumberInput < leastNumber) {
                        leastNumber = userNumberInput;
                    }
                }
            }
        }
    }
}
