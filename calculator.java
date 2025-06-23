import java.util.Scanner;

public class calculator {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        char operator;
        int n1, n2;
        char choice;

        do {
            System.out.println("Enter any operator (+, -, *, /): ");
            operator = input.next().charAt(0);

            System.out.println("Enter the first number: ");
            n1 = input.nextInt();

            System.out.println("Enter the second number: ");
            n2 = input.nextInt();

            int result = 0;
            boolean valid = true;

            switch (operator) {
                case '+':
                    result = n1 + n2;
                    break;
                case '-':
                    result = n1 - n2;
                    break;
                case '*':
                    result = n1 * n2;
                    break;
                case '/':
                    if (n2 != 0) {
                        result = n1 / n2;
                    } else {
                        System.out.println("Error: Division by zero is not allowed.");
                        valid = false;
                    }
                    break;
                default:
                    System.out.println("Entered operator is not valid.");
                    valid = false;
            }

            if (valid) {
                System.out.println("The result is: " + n1 + " " + operator + " " + n2 + " = " + result);
            }

            System.out.println("Do you want to continue? (y/n): ");
            choice = input.next().charAt(0);

        } while (choice == 'y' || choice == 'Y');

        System.out.println("Calculator exited.");
        input.close();
    }
}
