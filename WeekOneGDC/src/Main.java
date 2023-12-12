import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int number1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int number2 = scanner.nextInt();

        // Calculate GCD (Greatest Common Divisor)
        int gcd = calculateGCD(number1, number2);

        // Calculate LCM (Least Common Multiple)
        int lcm = calculateLCM(number1, number2, gcd);

        // Print the results
        System.out.println("GCD: " + gcd);
        System.out.println("LCM: " + lcm);

        scanner.close();
    }

    // Method to calculate GCD using the Euclidean algorithm
    public static int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Method to calculate LCM using the formula: LCM = (n1 * n2) / GCD
    public static int calculateLCM(int a, int b, int gcd) {
        return (a * b) / gcd;
    }
}