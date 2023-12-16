import java.util.Scanner;

public class Main {
    static Scanner scanner;

    static void addition() {
        int number, result = 0;
        while (true) {
            System.out.print("Number: ");
            number = scanner.nextInt();

            if (number == 0) {
                break;
            }
            result += number;
        }
        System.out.println("Result: " + result);
    }

    static void subtraction() {
        System.out.print("How many numbers will you enter: ");
        int counter = scanner.nextInt();
        int number, result = 0;

        for (int i = 1; i <= counter; i++) {
            System.out.print(i + ". number: ");
            number = scanner.nextInt();

            if (i == 1) {
                result += number;
                continue;
            }
            result -= number;
        }

        System.out.println("Result: " + result);
    }

    static void multiplication() {
        int number, result = 1;

        while (true) {
            System.out.print("Number: ");
            number = scanner.nextInt();

            if (number == 1)
                break;

            if (number == 0) {
                result = 0;
                break;
            }
            result *= number;
        }

        System.out.println("Result: " + result);
    }

    static void division() {
        System.out.print("How many numbers will you enter: ");
        int counter = scanner.nextInt();
        double number, result = 0.0;

        for (int i = 1; i <= counter; i++) {
            System.out.print(i + ". number: ");
            number = scanner.nextDouble();

            if (i != 1 && number == 0) {
                System.out.println("You cannot enter 0 as divisor.");
                continue;
            }
            if (i == 1) {
                result = number;
                continue;
            }
            result /= number;
        }

        System.out.println("Result: " + result);
    }

    static void power() {
        System.out.print("Enter the base value: ");
        int base = scanner.nextInt();
        System.out.print("Enter the exponent value: ");
        int exponent = scanner.nextInt();
        int result = 1;

        for (int i = 1; i <= exponent; i++) {
            result *= base;
        }

        System.out.println("Result: " + result);
    }

    static void factorial() {
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        int result = 1;

        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        System.out.println("Result: " + result);
    }

    static void modulus() {
        System.out.print("Enter the dividend: ");
        int dividend = scanner.nextInt();
        System.out.print("Enter the divisor: ");
        int divisor = scanner.nextInt();
        int result = dividend % divisor;
        System.out.println("Result: " + result);
    }

    static void rectangle() {
        System.out.print("Enter the length of the rectangle: ");
        int length = scanner.nextInt();
        System.out.print("Enter the width of the rectangle: ");
        int width = scanner.nextInt();
        int area = length * width;
        int perimeter = 2 * (length + width);
        System.out.println("Rectangle Area: " + area);
        System.out.println("Rectangle Perimeter: " + perimeter);
    }

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int select;
        String menu = "1- Addition\n"
                + "2- Subtraction\n"
                + "3- Multiplication\n"
                + "4- Division\n"
                + "5- Power Calculation\n"
                + "6- Factorial Calculation\n"
                + "7- Modulus\n"
                + "8- Rectangle Area and Perimeter Calculation\n"
                + "0- Exit";

        do {
            System.out.println(menu);
            System.out.print("Please select an operation: ");
            select = scanner.nextInt();

            switch (select) {
                case 1:
                    addition();
                    break;
                case 2:
                    subtraction();
                    break;
                case 3:
                    multiplication();
                    break;
                case 4:
                    division();
                    break;
                case 5:
                    power();
                    break;
                case 6:
                    factorial();
                    break;
                case 7:
                    modulus();
                    break;
                case 8:
                    rectangle();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("You entered an incorrect value, please try again.");
            }
        } while (select != 0);
    }
}
