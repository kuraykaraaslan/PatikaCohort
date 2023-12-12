import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Ask from user input for Two Numbers
        System.out.println("Enter the first number: ");
        int firstNumber = scanner.nextInt();
        System.out.println("Enter the second number: ");
        int secondNumber = scanner.nextInt();

        //Ask from user input for Operation
        System.out.println("Enter the operation: ");
        System.out.println("1-Addition");
        System.out.println("2-Subtraction");
        System.out.println("3-Multiplication");
        System.out.println("4-Division");
        int operation = scanner.nextInt();

        //Calculate the result
        double result = 0;

        switch (operation) {
            case 1:
                result = firstNumber + secondNumber;
                break;
            case 2:
                result = firstNumber - secondNumber;
                break;
            case 3:
                result = firstNumber * secondNumber;
                break;
            case 4:
                result = firstNumber / (double) secondNumber;
                break;
            default:
                System.out.println("Invalid operation");
                break;
        }

        //Print the result
        System.out.println("Result: " + result);
    }
}

