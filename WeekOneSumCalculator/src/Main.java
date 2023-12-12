import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Variables to store the sum of even and multiples of 4
        int multiplesOf4Sum = 0;

        // Prompt the user for input until a single number is entered
        System.out.println("Enter numbers (enter a non-integer to finish): ");
        while (true) {

            int inputNumber = scanner.nextInt();

            // Check if the number is even
            if (inputNumber % 2 != 0) {
                break;

            }

            // Check if the number is a multiple of 4
            if (inputNumber % 4 == 0) {
                multiplesOf4Sum += inputNumber;
            }

        }

        // Display the sum of multiples of 4
        System.out.println("Sum of multiples of 4: " + multiplesOf4Sum);

        scanner.close();
    }
}