import java.util.Scanner;

/**
* @author Alexander Arizola
*/
public class RestaurantBill 
{
  public static void main(String[] args) {
    // declare variables
    final double taxPercent = 0.10;
  
    double billAmount;
    double tipPercentage;
    double taxAmount;
    double tipAmount;
    double totalBill;

    // create scanner object to read input
    Scanner keyboard = new Scanner(System.in);

    // ask for bill amount and then store it into the appropriate variable.
    System.out.print("Enter the bill amount: ");
    billAmount = keyboard.nextDouble();

    // ask for tip percentage, divide it to turn it into a percentage and then store it into the appropriate variable.
    System.out.print("Enter the tip percentage: ");
    tipPercentage = keyboard.nextDouble() / 100;

    // calculate the total costs
    taxAmount = billAmount * taxPercent;
    tipAmount = (billAmount + taxAmount) * tipPercentage;
    totalBill = billAmount + taxAmount + tipAmount;

    // output all fees and the total cost
    System.out.println("The meal cost is: $" + Math.round(billAmount * 100) / 100.0);
    System.out.println("The tax amount is: $" + Math.round(taxAmount * 100) / 100.0);
    System.out.println("The tip amount is: $" + Math.round(tipAmount * 100) / 100.0);
    System.out.println("The total bill is: $" + Math.round(totalBill * 100) / 100.0);
  }
}
