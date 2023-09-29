
import java.util.Scanner;
/**
 *
 * @author Alexander Arizola
 */
public class CircleArea {
    public static void main(String[] args) {
        // ********* Problem 2: Circle Area Problem ***********
        
        // TODO Implement the following step-by-step plan
        
        // 1. Declare double constant PI to hold 3.14
        // 2. Declare a double variable to store radius
        // 3. Declare a double variable to store area   
        // 4. Prompt the user to enter radius. 
        // 5. Input radius and store it in variable
        // 6. Calculate circle area. Find the formula on the web if you don't remember it
        // 7. Output the circle's radius and area values in user-friendly fashion

        // ********* End of Circle Area Problem code area ***********
        final double mathPI = 3.14;
        double circleRadius;
        double circleArea;

        // create scanner object to read input
        Scanner keyboard = new Scanner(System.in);

        // Prompt user to enter the radius and then store it into the appropriate variable.
        System.out.print("Enter circle radius: ");
        circleRadius = keyboard.nextDouble();

        // Calculate circle area using a formula and store it into the appropriate variable.
        circleArea = mathPI * circleRadius * circleRadius;

        // Print out the area and radius we've entered and calculated.
        System.out.println("Radius: " + circleRadius);
        System.out.println("Area: " + circleArea);
    }
}
