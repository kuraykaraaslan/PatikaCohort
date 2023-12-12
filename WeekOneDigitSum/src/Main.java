import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get a number from the user
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        String numberString = Integer.toString(number);

        int sum = 0;

        for (int i = 0; i < numberString.length(); i++) {
            sum += Character.getNumericValue(numberString.charAt(i));
        }

        // Print the result
        System.out.println("The sum of digits is " + sum);

    }

}