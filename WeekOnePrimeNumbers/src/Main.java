import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This program generates a list of prime numbers from 2 to 49.
 */

class Main {
    public static void main(String[] args) {

        // Create an empty ArrayList to store prime numbers
        List<Integer> primeNumbers = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        // Prompt user for number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Iterate over numbers from 2 to 49
        for (int i = 2; i <= number; i++) {
            boolean isPrime = true;

            // Check if the number is divisible by any number in the primeNumbers list
            for (int j : primeNumbers) {

                if (i % j == 0) {
                    // If it is divisible, then mark it as non-prime and break out of the loop
                    isPrime = false;
                    break;
                }
            }

            // If the number is prime, add it to the primeNumbers list
            if (isPrime) {
                primeNumbers.add(i);
            }
        }

        // Print the list of prime numbers
        System.out.println(primeNumbers);
    }
}