import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Ask for user input for their height and weight
        Scanner scanner = new Scanner(System.in);

        // Ask for user their height in meters
        System.out.println("Lütfen boyunuzu (metre cinsinde) giriniz: ");
        double height = scanner.nextDouble();

        // Ask for user their weight in kilograms
        System.out.println("Lütfen kilonuzu giriniz: ");
        double weight = scanner.nextDouble();

        // Calculate the BMI
        double bmi = weight / (height * height);

        // Print the BMI
        System.out.println("Vücut Kitle İndeksiniz: " + bmi);

    }

}

