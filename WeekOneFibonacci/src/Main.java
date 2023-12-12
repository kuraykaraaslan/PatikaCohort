import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        // Create a new instance of the Scanner class to read input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of elements for the Fibonacci series
        System.out.print("Enter the number of elements for the Fibonacci series: ");

        // Read the input provided by the user and store it in the variable numberOfElements
        int numberOfElements = scanner.nextInt();

        // Display the number of elements for the Fibonacci series
        System.out.println(numberOfElements + " Element Fibonacci Series:");

        // Initialize the first and second elements of the Fibonacci series
        int firstElement = 0, secondElement = 1;

        // Iterate through the Fibonacci series for the given number of elements
        for (int i = 0; i < numberOfElements; i++) {
            // Print the current element of the Fibonacci series
            System.out.print(firstElement + " ");

            // Calculate the next element of the Fibonacci series by adding the previous two elements
            int sum = firstElement + secondElement;

            // Update the first and second elements for the next iteration
            firstElement = secondElement;
            secondElement = sum;
        }

        // Close the Scanner object to release resources
        scanner.close();
    }
}
