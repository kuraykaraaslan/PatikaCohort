import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the base value: ");
        int base = scanner.nextInt();

        System.out.print("Enter the exponent value: ");
        int exponent = scanner.nextInt();

        scanner.close();

        int result = calculatePower(base, exponent);
        System.out.println("Result: " + result);
    }

    // Recursive method
    public static int calculatePower(int base, int exponent) {
        // Base case: if the exponent is 0, return 1
        if (exponent == 0) {
            return 1;
        } else {
            // Recursive case: multiply the base by the result of the calculation
            // of the power with a decremented exponent
            return base * calculatePower(base, exponent - 1);
        }
    }
}
