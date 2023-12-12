import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int number;

        Scanner scanner = new Scanner(System.in);

        // Prompt user for number
        System.out.println("Please enter a number:");
        number = scanner.nextInt();

        // Display the result
        System.out.println("Powers of 4:");
        for (int i = 4; i <= number; i *= 4) {
            System.out.println(i);
        }

        System.out.println("Powers of 5:");
        for (int i = 5; i <= number; i *= 5) {
            System.out.println(i);
        }

        scanner.close();
    }
}