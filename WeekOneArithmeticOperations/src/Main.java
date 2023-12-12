import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Get user input for a, b, c
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int a = scanner.nextInt();
        System.out.print("Enter another number: ");
        int b = scanner.nextInt();
        System.out.print("Enter another number: ");
        int c = scanner.nextInt();

        // Print the result
        int result =  a+b*c-b;
        System.out.println("Result: " + result);

    }
}