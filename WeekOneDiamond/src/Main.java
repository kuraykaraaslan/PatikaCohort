import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Prompt user for a step for the pattern
        System.out.print("Enter a step for the pattern: ");
        int step = scanner.nextInt();

        // Display the result
        for (int i = 1; i <= step; i++) {
            for (int j = 1; j <= step - i; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        for (int i = step - 1; i >= 1; i--) {
            for (int j = 1; j <= step - i; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        // Close the scanner
        scanner.close();
    }
}
