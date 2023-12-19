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


        // find the repeated number
        int repeatedNumber = 0;

        for (int i = 0; i < count; i++) {
            boolean isRepeated = false;

            for (int j = 0; j < count; j++) {
                if (i != j && numbers[i] == numbers[j]) {
                    isRepeated = true;
                    break;
                }
            }

            if (isRepeated) {
                repeatedNumber = numbers[i];
                break;
            }
        }

        System.out.println("Repeated number is: " + repeatedNumber);
    }

}

