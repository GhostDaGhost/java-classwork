
import java.util.Scanner;
/**
 *
 * @author Alexander Arizola
 */
public class Swap {
    public static void main(String[] args) {
        //******** Problem 1: Logic Problem ********************
        // TODO This program has a logical error. Your goal is to fix it. 
        // SOLUTION: Two more variables were made in order to store the old values.
        
        double firstNumber; // to hold the first number
        double secondNumber; // to hold the second number

        double oldFirstNumber; // to hold the original first number
        double oldSecondNumber; // to hold the original second number

        // create scanner object to read input
        Scanner keyboard = new Scanner(System.in); 
        
        // Prompt user to enter the first number.
        System.out.print("Enter the first number:");
        // input the first number
        firstNumber = keyboard.nextDouble();
        oldFirstNumber = firstNumber;
        
        // Promt user to enter the second number.
        System.out.print("Enter the second number:");
        // input the second number
        secondNumber = keyboard.nextDouble();   
        oldSecondNumber = secondNumber;    
        
        // Echo print the input.
        System.out.println("You input the numbers as "+ firstNumber+" and " + secondNumber );
        
        // Now we will swap the values.
        firstNumber = oldSecondNumber;
        secondNumber = oldFirstNumber;
        
        // Output the values.
        System.out.println("After swapping, the values of the two numbers are "+ firstNumber+" and " + secondNumber );
    }
}
