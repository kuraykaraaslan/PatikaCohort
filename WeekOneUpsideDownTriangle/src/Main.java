import java.util.Scanner;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Prompt user for a step for the pattern
        System.out.print("Enter a step for the pattern: ");
        int step = scanner.nextInt();

        // Display the result
        for (int i = step; i > 0; i--) {
            int diff = step - i;

            for (int j = 0; j < diff; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }

            for (int j = 0; j < i - 1; j++) {
                System.out.print("*");
            }

            System.out.println();

        }

        // Close the scanner
        scanner.close();
    }
}
