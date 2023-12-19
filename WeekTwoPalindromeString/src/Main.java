import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Ask the user for the word
        System.out.println("Enter a word: ");
        String word = scanner.nextLine();

        // Split the word into characters
        char[] characters = word.toCharArray();

        int length = characters.length;

        // Create a new array to store the reversed word
        char[] reversed = new char[length];

        // Loop through the characters in the word
        for (int i = 0; i < length; i++) {
            // Get the character at the current index
            char character = characters[i];

            // Add the character to the reversed array
            reversed[length - i - 1] = character;
        }

        boolean isPalindrome = true;

        // Loop through the characters in the word
        for (int i = 0; i < length; i++) {
            // Check if the characters are not equal
            if (characters[i] != reversed[i]) {
                // The word is not a palindrome
                isPalindrome = false;
                break;
            }
        }

        // Check if the word is a palindrome
        System.out.println("The word is " + (isPalindrome ? "" : "not ") + "a palindrome");
    }
}
