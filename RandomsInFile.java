import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.io.*;

/**
* @author Alexander Arizola
*/
public class RandomsInFile {
    public static int awaitForValue(String typeOfInteger, Scanner keyboardInput) {
        int returnInt = 0;

        // ASK FOR USER'S INPUT AND CATCH THEIR RESULT
        while (true) {
            try {
                System.out.print("Enter the "+ typeOfInteger +" value as a positive integer: ");
                returnInt = keyboardInput.nextInt();

                // VALIDATE INPUT
                if (returnInt <= 0) {
                    throw new IllegalArgumentException("Number entered was not positive.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input ERROR. Number entered was not an integer.");

                // THIS "NEXT LINE" PREVENTS THIS ERROR FROM LOOPING
                keyboardInput.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("Input ERROR. " + e.getMessage());
            }
        }

        // RETURN INT
        return returnInt;
    }

    public static void main(String[] args) {
        Scanner keyboardInput = new Scanner(System.in);

        // INITIATE VARIABLES SUCH AS MINIMUM AND MAXIMUM INTEGERS
        int minimum = awaitForValue("minimum", keyboardInput);
        int maximum = awaitForValue("maximum", keyboardInput);
 
        // MAKE SURE THAT LOWER LIMIT IS SMALLER THAN UPPER LIMIT
        if (minimum > maximum) {
            int oldMinimum = minimum;
            minimum = maximum;
            maximum = oldMinimum;
        }

        // HAVE USER CHOOSE THE FILE NAME
        System.out.print("Enter the filename to write into: ");
        String newFileName = keyboardInput.next();

        // EXCEPTION CATCHER AND OPEN FILE TO WRITE INTO IT
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(newFileName));

            // NUMBER GENERATION
            Random randomizer = new Random();
            for (int i = 0; i < 100; i++) {
                writer.println(randomizer.nextInt(maximum - minimum + 1) + minimum);
            }

            // CLOSE FILE AND OUTPUT SUCCESS
            writer.close();
            System.out.println("Data written to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
