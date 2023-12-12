import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Prompt user for a number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int powerOfTwo = 0;
        int powerOfFour = 0;
        int powerOfFive = 0;

        // Check if the number is a power of 2, 4, or 5
        while (true)
        {
            // Check if number is greater than 2 raised to the powerOfTwo
            if (number > Math.pow(2, powerOfTwo))
            {
                // Check if number is not equal to 2 raised to the powerOfTwo + 1
                // Determine if the number is indeed a power of two
                if (number != Math.pow(2, powerOfTwo + 1))
                {
                    break;
                }
                else
                {
                    powerOfTwo++;
                }
            }
            else if (number > Math.pow(4, powerOfFour))
            {
                // Check if number is not equal to 4 raised to the powerOfFour + 1
                // Determine if the number is indeed a power of four
                if (number != Math.pow(4, powerOfFour + 1))
                {
                    break;
                }
                else
                {
                    powerOfFour++;
                }
            }
            else if (number > Math.pow(5, powerOfFive))
            {
                // Check if number is not equal to 5 raised to the powerOfFive + 1
                // Determine if the number is indeed a power of five
                if (number != Math.pow(5, powerOfFive + 1))
                {
                    break;
                }
                else
                {
                    powerOfFive++;
                }
            }
            else
            {
                break;
            }
        }

        // Print the result
        System.out.println("The number " + number + " is " + powerOfTwo + " power of two");
        System.out.println("The number " + number + " is " + powerOfFour + " power of four");
        System.out.println("The number " + number + " is " + powerOfFive + " power of five");
    }
}
