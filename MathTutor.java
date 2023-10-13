import java.util.Scanner;

/**
* @author Alexander Arizola
*/
public class MathTutor {
    public static void main(String[] args) {
        int userChoice = 0;

        // LOOP THE MENU INPUT UNTIL QUIT IS EXECUTED
        Scanner keyboardInput = new Scanner(System.in);
        while (userChoice != 3) {
            System.out.println("Math Tutor");
            System.out.println("1. Addition problem");
            System.out.println("2. Subtraction problem");
            System.out.println("3. Quit");
            System.out.print("Enter your choice (1 - 3): ");

            // ASK USER FOR THEIR CHOICE AND DEPENDING ON THE CHOICE, START SOLVING OR EXIT
            userChoice = keyboardInput.nextInt();
            switch (userChoice) {
                case 1:
                    int add_num1 = (int) (Math.random() * 1000);
                    int add_num2 = (int) (Math.random() * 1000);
                    int correctAddAnswer = add_num1 + add_num2;

                    // MAKES SURE THE NUMBERS ARE APPEARING IN CORRECT ORDER
                    if (add_num2 > add_num1) {
                        int oldNum1 = add_num1;
                        add_num1 = add_num2;
                        add_num2 = oldNum1;
                    }

                    // SHOW EQUATION
                    System.out.printf("%5d\n", add_num1);
                    System.out.printf("+%4d\n", add_num2);
                    System.out.println("------");
                    System.out.print("Enter your answer: ");

                    // VALIDATE USER'S ANSWER
                    int userAddAnswer = keyboardInput.nextInt();
                    if (userAddAnswer == correctAddAnswer) {
                        System.out.println("Congratulations! Your answer is correct.");
                    } else {
                        System.out.println("Incorrect! The correct answer is " + correctAddAnswer);
                    }
                    break;
                case 2:
                    int sub_num1 = (int) (Math.random() * 1000);
                    int sub_num2 = (int) (Math.random() * 1000);

                    // MAKES SURE THE NUMBERS ARE APPEARING IN CORRECT ORDER
                    if (sub_num2 > sub_num1) {
                        int oldNum1 = sub_num1;
                        sub_num1 = sub_num2;
                        sub_num2 = oldNum1;
                    }

                    // GET CORRECT ANSWER TO CHECK LATER
                    int correctSubAnswer = sub_num1 - sub_num2;

                    // SHOW EQUATION
                    System.out.printf("%5d\n", sub_num1);
                    System.out.printf("-%4d\n", sub_num2);
                    System.out.println("------");
                    System.out.print("Enter your answer: ");
            
                    int userSubAnswer = keyboardInput.nextInt();
                    if (userSubAnswer == correctSubAnswer) {
                        System.out.println("Congratulations! Your answer is correct.");
                    } else {
                        System.out.println("Incorrect! The correct answer is " + correctSubAnswer);
                    }
                    break;
                case 3:
                    System.out.println("Closing Math Tutor.");
                    break;
                default:
                    System.out.println("ERROR: Invalid choice. Please follow the menu's instructions and choose a valid option (1 - 3).");
            }
        }
    }  
}
