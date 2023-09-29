import java.util.Scanner;

/**
* @author Alexander Arizola
*/
public class InterestEarned {
    public static void main(String[] args) {
        // declare variables
        double principal; // the balance in the savings account
        double interestRate; // the interest rate before conversion to percentage
        double percentInterestRate; // the interest rate percentage after conversion

        int times; // the number of times the interest is compounded during a year
        double interest; // the interest

        // create scanner object to read input
        Scanner keyboard = new Scanner(System.in);

        // Prompt user to enter the principal balance and then store it into the appropriate variable.
        System.out.print("Enter the principal balance: ");
        principal = keyboard.nextDouble();

        // Prompt user to enter the interest rate, divide it to turn into a percent and then store it into the appropriate variable.
        System.out.print("Enter the percent interest rate as a percentage value: ");
        interestRate = keyboard.nextDouble();
        percentInterestRate = interestRate / 100;

        // Prompt user to enter the amount of times to compound interest and then store it into the appropriate variable.
        System.out.print("Enter the times compounded per year: ");
        times = keyboard.nextInt();

        // Calculate interest
        interest = principal * Math.pow(1 + percentInterestRate / times, times) - principal;

        // output all values
        System.out.println("Interest rate: "+ interestRate + "%");
        System.out.println("Times compounded: " + times);
        System.out.println("Principal: $" + Math.round(principal * 100) / 100.0);
        System.out.println("Interest: $" + Math.round(interest * 100) / 100.0);
        System.out.println("Amount in savings: $" + Math.round((principal + interest) * 100) / 100.0);
    }  
}
