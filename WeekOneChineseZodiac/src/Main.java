import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Prompt user for birth year
        System.out.print("Enter birth year: ");
        int birthYear = scanner.nextInt();

        // Divide birth year by 12 and get remainder
        int remainder = birthYear % 12;

        // Switch statement to determine zodiac sign
        String zodiacSign = "";

        String[] zodiacSigns = {"Monkey", "Rooster", "Dog", "Pig", "Rat", "Ox", "Tiger", "Rabbit", "Dragon", "Snake", "Horse", "Sheep"};

        zodiacSign = zodiacSigns[remainder];

        // Print zodiac sign
        System.out.println("Your Chinese Zodiac sign is " + zodiacSign + ".");

        // Close scanner
        scanner.close();

    }
}





