import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        scanner.close();

        // Check if the number is prime
        boolean isPrime = isPrimeNumber(number);

        // Print the result
        System.out.println(number + (isPrime ? " is prime." : " is not prime."));
    }

    public static boolean isPrimeNumber(int number) {
        // Base cases
        if (number <= 1) {
            return false;
        }

        // Check if the number is divisible by any number less than or equal to its square root
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
