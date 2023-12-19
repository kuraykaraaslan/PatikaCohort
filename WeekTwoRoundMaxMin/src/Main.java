import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Get array elements from the user
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the count of numbers: ");
        int count = scanner.nextInt();

        int[] numbers = new int[count];

        for (int i = 0; i < count; i++) {
            System.out.println("Enter the number: ");
            numbers[i] = scanner.nextInt();
        }

        // Get a number from the user
        System.out.print("Enter a number to find the closest smaller and larger numbers: ");
        int targetNumber = scanner.nextInt();

        // Sort the array
        Arrays.sort(numbers);

        // create a new array and add the target number to it
        int[] newNumbers = new int[count + 1];
        newNumbers[0] = targetNumber;

        // copy the numbers array to the newNumbers array
        for (int i = 0; i < count; i++) {
            newNumbers[i + 1] = numbers[i];
        }

        // Sort the newNumbers array
        Arrays.sort(newNumbers);

        // Find the index of the target number
        int index = 0;

        for (int i = 0; i < newNumbers.length; i++) {
            if (newNumbers[i] == targetNumber) {
                index = i;
                break;
            }
        }

        // Print the closest smaller and larger numbers
        if (index == 0) {
            System.out.println("Minimum number is the target number");
            System.out.println("The closest larger number is " + newNumbers[index + 1]);
        } else if (index == newNumbers.length - 1) {
            System.out.println("Maximum number is the target number");
            System.out.println("The closest smaller number is " + newNumbers[index - 1]);
        } else {
            System.out.println("The closest smaller number is " + newNumbers[index - 1]);
            System.out.println("Minimum number is the target number");
        }

    }
}
