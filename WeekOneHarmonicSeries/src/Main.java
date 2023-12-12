import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get a number from the user
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Calculate the harmonic series
        double harmonicSeries = 0;

        for (int i = 1; i <= number; i++) {
            harmonicSeries += 1.0 / i;
        }

        // Print the harmonic series
        System.out.println("Harmonic series of " + number + " is: " + harmonicSeries);

        // Close the scanner
        scanner.close();
    }
}