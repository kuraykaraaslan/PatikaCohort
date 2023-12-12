import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get base and exponent from the user
        System.out.print("Enter the base: ");
        int base = scanner.nextInt();

        System.out.print("Enter the exponent: ");
        int exponent = scanner.nextInt();

        // Calculate the power and print the result
        int result = 1;

        for (int i = 0; i < exponent; i++) {
            result *= base;
        }

        System.out.println(base + "^" + exponent + " = " + result);

        // Close the scanner
        scanner.close();
    }
}