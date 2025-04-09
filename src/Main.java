import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Simple Calculator!\n");

        System.out.print("Please enter the first number:");
        double firstNumber = getValidNumber(scanner);

        System.out.print("Enter the operator (+,-,*,/): ");
        char operator = getValidOperator(scanner);

        System.out.print("Please enter the second number: ");
        double secondNumber = getValidNumber(scanner);

        double result = performCalculation(firstNumber, secondNumber, operator);

        System.out.printf("Result: %.2f %c %.2f = %.2f%n", firstNumber, operator, secondNumber, result);

    }

    public static double getValidNumber(Scanner scanner) {
        while (true) {
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            } else {
                System.out.print("Invalid input. Please enter a valid number:");
                scanner.next();
            }
        }
    }

    public static char getValidOperator (Scanner scanner) {
        while(true) {
            String input = scanner.next();
            if(input.length() == 1) {
                char operator = input.charAt(0);
                if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
                    return operator;
                }
                System.out.print("Invalid operator. Please enter +, -, *, or /: ");
            }
        }
    }

    public static double performCalculation (double firstNumber, double secondNumber, char operator) {
        return switch (operator) {
            case '+' -> firstNumber + secondNumber;
            case '-' -> firstNumber - secondNumber;
            case '*' -> firstNumber * secondNumber;
            case '/' -> firstNumber / secondNumber;
            default -> throw new IllegalArgumentException("Invalid operator" + operator);
        };
    }
}