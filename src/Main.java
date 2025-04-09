import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Simple Calculator!");

        System.out.print("Please enter the first number:");
        double firstNumber = getValidNumber(scanner);


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
}