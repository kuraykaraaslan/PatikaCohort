import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();

        System.out.print("Enter the value of r: ");
        int r = scanner.nextInt();

        // Check n >= r
        if (n < r) {
            System.out.println("Invalid input");
        }

        // Check n >= 0
        else if (n < 0) {
            System.out.println("Invalid input");
        }

        // Check r >= 0
        else if (r < 0) {
            System.out.println("Invalid input");
        }

        // Calculate nCr
        int nCr = factorial(n) / (factorial(r) * factorial(n - r));

        // Display the result
        System.out.println("nCr = " + nCr);

        // Close the scanner
        scanner.close();
    }

    // Calculate factorial
    public static int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; ++i) {
            result *= i;
        }
        return result;
    }
}

