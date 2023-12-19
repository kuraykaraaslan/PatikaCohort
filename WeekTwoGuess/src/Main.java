import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int number = rand.nextInt(100);

        Scanner input = new Scanner(System.in);
        int right = 0;
        int selected;
        int[] wrong = new int[5];
        boolean isWin = false;
        boolean isWrong = false;

        System.out.println("***** Welcome to the Number Guessing Game *****");

        while (right < 5) {
            System.out.print("Please enter your guess: ");
            selected = input.nextInt();

            if (selected < 0 || selected > 99) {
                System.out.println("Please enter a value between 0 and 100.");
                if (isWrong) {
                    right++;
                    System.out.println("Too many incorrect entries. Remaining attempts: " + (5 - right));
                } else {
                    isWrong = true;
                    System.out.println("Your attempts will be penalized for further incorrect entries.");
                }
                continue;
            }

            if (selected == number) {
                System.out.println("Congratulations, you guessed it right! The correct number is: " + number);
                isWin = true;
                break;
            } else {
                System.out.println("Incorrect guess!");
                if (selected > number) {
                    System.out.println(selected + " is greater than the hidden number.");
                } else {
                    System.out.println(selected + " is smaller than the hidden number.");
                }

                wrong[right++] = selected;
                System.out.println("Remaining attempts: " + (5 - right));
                System.out.println("Remaining Guess Range: " + (selected > number ? "0-" + (selected - 1) : (selected + 1) + "-100"));
            }
        }

        if (!isWin) {
            System.out.println("You lost!");
            if (!isWrong) {
                System.out.println("Your guesses: " + Arrays.toString(Arrays.copyOf(wrong, right)));
            }
        }

        System.out.println("The game has ended. Thank you!");
    }
}
