import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get an integer from the user
        System.out.print("Enter an integer: ");
        int integerNumber = scanner.nextInt();

        // Get a decimal number from the user
        System.out.print("Enter a decimal number: ");
        double decimalNumber = scanner.nextDouble();

        // Convert the integer to a decimal number and print the result
        double integerToDouble = integerNumber;
        System.out.println("Converted integer to decimal: " + integerToDouble);

        // Convert the decimal number to an integer and print the result
        int decimalToInt = (int) decimalNumber;
        System.out.println("Converted decimal to integer: " + decimalToInt);

        // Close the scanner
        scanner.close();
    }
}