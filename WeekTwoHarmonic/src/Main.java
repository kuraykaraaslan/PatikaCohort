import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the count of numbers: ");
        int count = scanner.nextInt();

        int[] numbers = new int[count];

        for (int i = 0; i < count; i++) {
            System.out.println("Enter the number: ");
            numbers[i] = scanner.nextInt();
        }

        double harmonicSeries = 1.0;
        for (int i = 2; i <= count; i++) {
            harmonicSeries += 1.0 / i;
        }

        System.out.println("Harmonic average: " + count / harmonicSeries);

        scanner.close();

    }

}