import java.util.Arrays;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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

        // Sort the array
        Arrays.sort(numbers);

        // Print the array
        System.out.println("Sorted array: " + Arrays.toString(numbers));
    }
}
