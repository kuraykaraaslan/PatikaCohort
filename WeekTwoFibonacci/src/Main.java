import java.util.Scanner;

public class Main {

    // Function to calculate the nth Fibonacci number
    static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        // Create an array to store previously calculated Fibonacci numbers
        int[] memory = new int[n + 1];
        memory[0] = 0; // Base case: Fibonacci number at index 0 is 0
        memory[1] = 1; // Base case: Fibonacci number at index 1 is 1

        // Calculate Fibonacci numbers iteratively
        for (int i = 2; i <= n; i++) {
            memory[i] = memory[i - 1] + memory[i - 2];
        }

        // Return the Fibonacci number at index n
        return memory[n];
    }

    public static void main(String[] args) {

        // Create a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");

        // Read the input number from the user
        int x = scanner.nextInt();

        // Print the nth Fibonacci number
        System.out.println(fibonacci(x));

        // Close the scanner to release resources
        scanner.close();
    }
}


