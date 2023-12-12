import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Prompt user for a number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int powerOfTwo = 0;

        // Check if the number is a power of 2
        while (true)
        {
            // Check if number is greater than 2 raised to the powerOfTwo
            if (number > (2 ^ powerOfTwo))
            {
                // Check if number is not equal to 2 raised to the powerOfTwo + 1
                // Determine if the number is indeed a power of two
                if (number != (2 ^ (powerOfTwo + 1)))
                {
                    break;
                }
                else
                {
                    powerOfTwo++;
                }

            }
            else
            {
                break;
            }
        }

        // Print the result
        System.out.println("The number " + number + " is " + powerOfTwo + " power of two");
    }
}

