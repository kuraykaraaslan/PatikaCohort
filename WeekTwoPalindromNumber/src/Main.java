import java.util.Scanner;

public class Main {

    // Method to check if a number is a palindrome
    static void isPalindrome() {
        // Create a new instance of Scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a number
        System.out.print("Enter a number: ");

        // Read the entered number
        int number = scanner.nextInt();

        // Close the Scanner to free system resources
        scanner.close();

        // Temporary variable to store the entered number
        int temp = number;

        // Variable to store the reverse of the entered number
        int reverseNumber = 0;

        // Variable to store the last digit of the number while reversing it
        int lastNumber;

        // Loop until the temporary variable becomes 0
        while (temp != 0) {
            // Get the last digit of the number
            lastNumber = temp % 10;

            // Add the last digit to the reverse number
            reverseNumber = (reverseNumber * 10) + lastNumber;

            // Remove the last digit from the temporary variable
            temp /= 10;
        }

        // Check if the entered number is equal to its reverse
        if (number == reverseNumber) {
            // Print a message indicating that the number is a palindrome
            System.out.println("It is a palindrome number");
        } else {
            // Print a message indicating that the number is not a palindrome
            System.out.println("It is not a palindrome number");
        }
    }

    // Main method, the entry point of the program
    public static void main(String[] args) {
        // Call the isPalindrome method to check if a number is a palindrome
        isPalindrome();
    }
}
