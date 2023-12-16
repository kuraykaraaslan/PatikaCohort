import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter N value
        System.out.print("Enter N value: ");
        int n = scanner.nextInt();

        // Call the recursive method with the entered N value
        pattern(n, n);

        scanner.close();
    }

    // Recursive method to follow the specified rule
    public static void pattern(int originalN, int currentN) {
        // Print the current value
        System.out.print(currentN + " ");

        // Base case: Terminate the process when the specified conditions are met
        if (currentN <= 0) {
            return;
        }

        // Recursive case: Subtract 5 successively
        pattern(originalN, currentN - 5);

        // Start adding 5 when the number becomes negative or 0
        if (currentN <= 0) {
            pattern(originalN, currentN + 5);
        }
    }
}