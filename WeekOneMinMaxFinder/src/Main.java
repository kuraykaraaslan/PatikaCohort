import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of inputs from the user
        System.out.print("Enter the number of values: ");
        int n = scanner.nextInt();

        // Check if n is valid
        if (n <= 0) {
            System.out.println("Invalid input");
            return;
        }

        // Check if n is 1
        if (n == 1) {
            System.out.print("Enter the 1st number: ");
            int number = scanner.nextInt();
            System.out.println("Largest number: " + number);
            System.out.println("Smallest number: " + number);
            return;
        }

        // Input the first number
        System.out.print("Enter the 1st number: ");
        int firstNumber = scanner.nextInt();

        // Initialize min and max with the first number
        int min = firstNumber;
        int max = firstNumber;

        // Input the remaining numbers and update min-max
        for (int i = 2; i <= n; i++) {
            System.out.print("Enter the " + i + "th number: ");
            int currentNumber = scanner.nextInt();

            // Update checks
            if (currentNumber > max) {
                max = currentNumber;
            } else if (currentNumber < min) {
                min = currentNumber;
            }
        }
        
        // Print the largest and smallest numbers
        System.out.println("Largest number: " + max);
        System.out.println("Smallest number: " + min);

        scanner.close();
    }
}