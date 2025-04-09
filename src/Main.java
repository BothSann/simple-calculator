import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculating = true;

        System.out.println("Welcome to Simple Calculator!");
        System.out.println("A simple calculator that performs basic arithmetic operations on two numbers.\n");

        while (continueCalculating) {
            try{
                System.out.print("Please enter the first number: ");
                double firstNumber = getValidNumber(scanner);

                System.out.print("Enter the operator (+, -, *, /): ");
                char operator = getValidOperator(scanner);

                System.out.print("Please enter the second number: ");
                double secondNumber = getValidNumber(scanner);

                if (operator == '/' && secondNumber == 0) {
                    System.out.println("Error: Cannot divide by zero.");
                    continue;
                }

                double result = performCalculation(firstNumber, secondNumber, operator);
                System.out.printf("Result: %.2f %c %.2f = %.2f%n", firstNumber, operator, secondNumber, result);

                System.out.print("Do you want to perform another calculation? (y/n): ");
                String response = scanner.next().toLowerCase();
                continueCalculating = response.equals("y")  || response.equals("yes");

            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                scanner.nextLine();
            }
        }

        System.out.println("Thank you for using Simple Calculator, Goodbye!");
        scanner.close();
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