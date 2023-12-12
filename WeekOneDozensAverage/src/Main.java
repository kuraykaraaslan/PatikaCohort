import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a number
        System.out.print("Enter a number: ");
        int limit = scanner.nextInt();

        // Variables to store the total and count of divisible numbers
        int total = 0;
        int count = 0;

        // Iterate from 0 up to the limit
        for (int i = 0; i <= limit; i++) {
            // Find numbers divisible by both 3 and 4
            if (i % 3 == 0 && i % 4 == 0) {
                total += i;
                count++;
            }
        }

        // If there are divisible numbers, calculate and print the average
        if (count > 0) {
            double average = (double) total / count;
            System.out.println("Average of numbers divisible by 3 and 4: " + average);
        } else {
            System.out.println("No numbers divisible by 3 and 4 found.");
        }

        scanner.close();
    }
}